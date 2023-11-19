package simple.configclient.spring;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@Component
@ConfigurationProperties(prefix = "spring.cloud.client.config")
@Data
public class ConfigCenterProperties {

    /**
     * 配置中心的地址
     */
    private String serverAddr;

    /**
     * 配置文件的id
     */
    private String fileId;

}
