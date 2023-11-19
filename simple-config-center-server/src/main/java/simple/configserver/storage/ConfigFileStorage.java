package simple.configserver.storage;

import simple.configserver.pojo.ConfigFile;

import java.util.List;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
public interface ConfigFileStorage {

    /**
     * 保存
     *
     * @param configFile
     */
    void save(ConfigFile configFile);

    /**
     * 修改
     *
     * @param configFile
     */
    void update(ConfigFile configFile);

    /**
     * 删除文件
     *
     * @param fileId
     */
    void delete(String fileId);

    /**
     * 通过文件id查找
     *
     * @param fileId
     * @return
     */
    ConfigFile selectByFileId(String fileId);

    /**
     * 查找所有
     *
     * @return
     */
    List<ConfigFile> selectAll();
}
