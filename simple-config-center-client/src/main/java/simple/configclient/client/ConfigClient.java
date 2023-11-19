package simple.configclient.client;

import org.springframework.web.client.RestTemplate;
import simple.configclient.client.pojo.ConfigFile;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
public class ConfigClient {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String serverAddr;

    public ConfigClient(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public ConfigFile getConfig(String fileId) {
        return restTemplate.getForObject("http://" + serverAddr + "/v1/config/" + fileId, ConfigFile.class);
    }

}
