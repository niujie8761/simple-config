package simple.configclient.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/19
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping
    public String get() {
       return userService.getUsername();
    }
}
