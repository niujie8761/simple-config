package simple.configserver.controller;

import org.springframework.web.bind.annotation.*;
import simple.configserver.manager.ConfigManager;
import simple.configserver.pojo.ConfigFile;
import simple.configserver.pojo.request.CreateConfigRequest;
import simple.configserver.pojo.request.UpdateConfigRequest;
import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@RestController
@RequestMapping("/v1/config")
public class ConfigController {

    @Resource
    private ConfigManager configManager;

    @PostMapping
    public String create(@RequestBody CreateConfigRequest createConfigRequest) {
        return configManager.save(createConfigRequest.getName(), createConfigRequest.getExtension(), createConfigRequest.getContent());
    }

    @PutMapping
    public void update(@RequestBody UpdateConfigRequest updateConfigRequest) {
        configManager.update(updateConfigRequest.getFileId(), updateConfigRequest.getName(), updateConfigRequest.getExtension(), updateConfigRequest.getContent());
    }

    @DeleteMapping("/{fileId}")
    public void delete(@PathVariable("fileId") String fileId) {
        configManager.delete(fileId);
    }

    @GetMapping("/{fileId}")
    public ConfigFile select(@PathVariable("fileId") String fileId) {
        return configManager.selectByFileId(fileId);
    }

    @GetMapping("/all")
    public List<ConfigFile> selectAll() {
        return configManager.selectAll();
    }

}
