package simple.configserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@ConfigurationProperties("config")
@Data
public class ConfigServerProperties {

    /**
     * 存储类型 ，memory:基于内存存储 file:文件系统存储
     */
    private String storeType = "file";
}
