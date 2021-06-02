package com.tea.modules.model.po;

import lombok.Data;

/**
 * com.tea.modules.model.po <br>
 * 用于演示lombok插件使用不当可能会出现的问题
 *
 * @author jaymin
 * @since 2021/6/2
 */
@Data
public class Personal {
    /**
     * Java语言的规范:切记别出现首字母小写第二个字母大写的情况
     */
    private String iPhone;
    private String name;
    private String userName;
}
