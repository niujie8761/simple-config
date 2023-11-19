package simple.configclient.spring;

import org.springframework.boot.env.PropertySourceLoader;
import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.core.env.CompositePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.stereotype.Component;
import simple.configclient.client.ConfigService;
import simple.configclient.client.pojo.ConfigFile;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@Component
public class ConfigCenterPropertySourceLocator implements PropertySourceLocator {

    private final List<PropertySourceLoader> propertySourceLoaderList = SpringFactoriesLoader.loadFactories(PropertySourceLoader.class, Thread.currentThread().getContextClassLoader());

    @Resource
    private ConfigService configService;

    @Resource
    private ConfigCenterProperties configCenterProperties;

    @Override
    public PropertySource<?> locate(Environment environment) {
        CompositePropertySource composite = new CompositePropertySource("sanyou");

        try {
            loadConfig(composite, configCenterProperties.getFileId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return composite;
    }

    private void loadConfig(CompositePropertySource composite, String fileId) throws IOException {

        ConfigFile configFile = configService.getConfig(fileId);

        if (configFile == null) {
            throw new RuntimeException(fileId + "未找到对应的配置文件");
        }

        for (PropertySourceLoader propertySourceLoader : propertySourceLoaderList) {

            if (Arrays.asList(propertySourceLoader.getFileExtensions()).contains(configFile.getExtension())) {
                List<PropertySource<?>> propertySourceList = propertySourceLoader.load(configFile.getFileId(), new ByteArrayResource(configFile.getContent().getBytes(StandardCharsets.ISO_8859_1)));
                for (PropertySource<?> propertySource : propertySourceList) {
                    composite.addFirstPropertySource(propertySource);
                }
            }
        }
    }
}
