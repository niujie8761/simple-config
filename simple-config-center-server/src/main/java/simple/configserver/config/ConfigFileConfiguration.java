package simple.configserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import simple.configserver.storage.ConfigFileStorage;
import simple.configserver.storage.FileSystemConfigFileStorage;
import simple.configserver.storage.InMemoryConfigFileStorage;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@Configuration
@EnableConfigurationProperties(ConfigServerProperties.class)
@Slf4j
public class ConfigFileConfiguration {

    @Autowired
    private ConfigServerProperties configServerProperties;

    @Bean
    @ConditionalOnMissingBean
    public ConfigFileStorage configFileStorage() {
        String storeType = configServerProperties.getStoreType().toLowerCase();
        log.info("storeType {}", storeType);
        if ("file".equals(storeType)) {
            return new FileSystemConfigFileStorage();
        }

        if ("memory".equals(storeType)) {
            return new InMemoryConfigFileStorage();
        }

        throw new RuntimeException("storeType=" + storeType + "无对应的ConfigFileStorage实现");
    }
}
