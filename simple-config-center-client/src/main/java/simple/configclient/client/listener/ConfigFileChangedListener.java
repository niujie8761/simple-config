package simple.configclient.client.listener;

import simple.configclient.client.pojo.ConfigFile;

/**
 * 文件内容变化监听器，当文件内容有变动的话，就会回调
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
public interface ConfigFileChangedListener {

    /**
     * 文件修改之后会回调
     *
     * @param configFile
     */
    void onFileChanged(ConfigFile configFile);
}
