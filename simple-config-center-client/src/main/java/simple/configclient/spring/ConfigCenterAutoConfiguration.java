package simple.configclient.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import simple.configclient.client.ConfigService;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@Configuration
public class ConfigCenterAutoConfiguration {

    @Bean
    public ConfigCenterProperties configCenterProperties() {
        return new ConfigCenterProperties();
    }

    @Bean
    public ConfigService configService(ConfigCenterProperties configCenterProperties) {
        return new ConfigService(configCenterProperties.getServerAddr());
    }

    @Bean
    public ConfigContextRefresher configContextRefresher() {
        return new ConfigContextRefresher();
    }

}
