package simple.configclient.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/19
 */
@Service
@RefreshScope
public class UserService {

    @Value("${sanyou.username}")
    private String username;

    public String getUsername() {

        return username;
    }
}
