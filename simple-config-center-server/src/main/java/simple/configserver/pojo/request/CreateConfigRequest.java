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
public class CreateConfigRequest {

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件后缀名
     */
    private String extension;

    /**
     * 文件的内容
     */
    private String content;
}
