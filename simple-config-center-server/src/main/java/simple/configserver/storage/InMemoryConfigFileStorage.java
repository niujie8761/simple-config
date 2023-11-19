package simple.configserver.storage;

import simple.configserver.pojo.ConfigFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
public class InMemoryConfigFileStorage implements ConfigFileStorage{

    private final Map<String, ConfigFile> configFileMap = new ConcurrentHashMap<>();

    @Override
    public void save(ConfigFile configFile) {
        configFileMap.put(configFile.getFileId(), configFile);
    }

    @Override
    public void update(ConfigFile configFile) {
        configFileMap.put(configFile.getFileId(), configFile);
    }

    @Override
    public void delete(String fileId) {
        configFileMap.remove(fileId);
    }

    @Override
    public ConfigFile selectByFileId(String fileId) {
        return configFileMap.get(fileId);
    }

    @Override
    public List<ConfigFile> selectAll() {
        return new ArrayList<>(configFileMap.values());
    }
}
