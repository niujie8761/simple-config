package simple.configserver.pojo.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName
 * @Author niujie
 * @Version
 * @Description
 * @CreateTime 2023/11/18
 */
@Data
@Accessors(chain = true)
public class UpdateConfigRequest extends CreateConfigRequest{

    /**
     * 文件名
     */
    private String fileId;

}
