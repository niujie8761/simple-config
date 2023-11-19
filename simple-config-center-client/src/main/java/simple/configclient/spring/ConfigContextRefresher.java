package simple.configclient.spring;

import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import simple.configclient.client.ConfigService;
import simple.configclient.client.listener.ConfigFileChangedListener;
import simple.configclient.client.pojo.ConfigFile;
import javax.annotation.Resource;

/**
 * 自动刷新配置
 *
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
public class ConfigContextRefresher implements ApplicationListener<ApplicationReadyEvent>, ApplicationContextAware {

    @Resource
    private ConfigCenterProperties configCenterProperties;

    @Resource
    private ConfigService configService;

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        registerListeners();
    }

    /**
     * 对配置文件注册对应的监听器
     */
    private void registerListeners() {
        configService.addListener(configCenterProperties.getFileId(), new ConfigFileChangedListener() {
            @Override
            public void onFileChanged(ConfigFile configFile) {
                applicationContext.publishEvent(new RefreshEvent(this, null, "refresh config"));
            }
        });
    }

    public static void main(String[] args) {
        //创建一个configService, 传入配置中心服务端地址
        ConfigService configService = new ConfigService("localhost:8888");
        // 从服务端获取配置文件的内容，文件的id是新增配置文件时候自动生成
        ConfigFile config = configService.getConfig("f656a18f-4fef-40ec-8af3-3cd125c5d9da");
        // 对某个配置文件进行监听
        configService.addListener("f656a18f-4fef-40ec-8af3-3cd125c5d9da", new ConfigFileChangedListener() {
            @Override
            public void onFileChanged(ConfigFile configFile) {
                System.out.printf("fileId=%s配置文件有变动，最新内容为:%s%n", configFile.getFileId(), configFile.getContent());
            }
        });
    }
}
