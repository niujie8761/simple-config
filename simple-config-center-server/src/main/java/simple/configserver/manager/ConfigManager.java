package simple.configserver.manager;

import org.springframework.stereotype.Component;
import simple.configserver.pojo.ConfigFile;
import simple.configserver.storage.ConfigFileStorage;
import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@Component
public class ConfigManager {

    @Resource
    private ConfigFileStorage configFileStorage;


    public String save(String name, String extension, String content) {

        ConfigFile configFile = new ConfigFile();
        configFile.setFileId(UUID.randomUUID().toString());
        configFile.setName(name);
        configFile.setExtension(extension);
        configFile.setContent(content);
        configFile.setLastUpdateTimestamp(System.currentTimeMillis());

        configFileStorage.save(configFile);

        return configFile.getFileId();
    }

    public void update(String fileId, String name, String extension, String content) {
        ConfigFile configFile = new ConfigFile();
        configFile.setFileId(fileId);
        configFile.setName(name);
        configFile.setExtension(extension);
        configFile.setContent(content);
        configFile.setLastUpdateTimestamp(System.currentTimeMillis());

        configFileStorage.update(configFile);
    }

    public void delete(String fileId) {
        configFileStorage.delete(fileId);
    }

    public ConfigFile selectByFileId(String fileId) {
        return configFileStorage.selectByFileId(fileId);
    }

    public List<ConfigFile> selectAll() {
        return configFileStorage.selectAll();
    }

}
