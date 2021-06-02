package com.tea.modules.lombok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tea.modules.model.po.AppleComputer;
import com.tea.modules.model.po.Personal;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * com.tea.modules.lombok<br>
 * <p>Lombok 是一种 Java实用工具，可用来帮助开发人员消除 Java 平时所需要编写的繁杂代码，<br>
 * 例如:getter、setter、toString、equals、hashcode等方法.</p>
 * 常用注解:  <br>
 * <p>
 * <p>@Getter: 自动生成访问器方法</p>    <br>
 * <p>@Setter: 自动生成setter方法  </p>    <br>
 * <p>@ToString: 自动生成toString()</p>    <br>
 * <p>@Builder：使对象可以自由地链式调用,最好搭配@NoArgsConstructor和@AllArgsConstructor</p>    <br>
 * <p>@Data: 等效于 {@code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode}.final字段不生效</p>    <br>
 * <p>@NoArgsConstructor: 无参构造器</p>    <br>
 * <p>@Slf4j:简化log操作,在类上标注之后可以直接log.info()</p>    <br>
 * <p>@RequiredArgsConstructor: 生成带有必需参数的构造函数。必需的参数是final字段和具有约束的字段(@NonNull</p>    <br>
 * </p> <br>
 * java文件在javac编译期间会先对源代码进行分析，生成抽象语法树（AST）.<br>
 * lombok根据自己的注解处理器,动态地修改AST，增加了新的节点,最终通过分析和生成了字节码<br>
 * 自从JDK6起，javac就支持“JSR 269 Pluggable Annotation Processing API”规范，<br>
 * 只要程序实现了该API，就能在javac运行的时候得到调用。
 *
 * @author jaymin
 * @since 2021/4/20
 */
@Slf4j
public class LombokDemo {
    /**
     * lombok工具的使用以及需要避免的坑
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
//        singleAlphabetHump();
        equalsAndHashcodeBug();
    }

    /**
     * <h1>lombok的第一个坑</h1>
     * 单字母驼峰会被Lombok改造成全小写模式:<br>
     * iPhone -> iphone
     *
     * @throws Exception
     */
    private static void singleAlphabetHump() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Personal personal = new Personal();
        personal.setIPhone("我是一台手机");
        // {"name":null,"userName":null,"iphone":"我是一台手机"}
        System.out.println(objectMapper.writeValueAsString(personal));
        // 注意这里的iPhone字段
        String json = "\n" + "{\"name\":null,\"userName\":null,\"iPhone\":\"我是一台手机\"}";
        Personal readValue = null;
        try {
            readValue = objectMapper.readValue(json, Personal.class);
        } catch (JsonProcessingException e) {
            log.error("jackson 解析异常:" + e.getMessage());
        }
        System.out.println(readValue.getIPhone());
    }

    /**
     * <h2>lombok的第二个坑</h2>
     * 对于有继承关系的对象，需要进行equals和hashcode的覆写
     */
    private static void equalsAndHashcodeBug() {
        AppleComputer appleComputerA = new AppleComputer(1, "mac", 1L, "red");
        AppleComputer appleComputerB = new AppleComputer(2, "mac air", 1L, "red");
        System.out.println(Objects.equals(appleComputerA, appleComputerB));
    }
}
