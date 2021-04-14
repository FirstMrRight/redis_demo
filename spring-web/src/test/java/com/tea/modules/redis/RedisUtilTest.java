package com.tea.modules.redis;

import com.tea.modules.data.redis.util.RedisUtils;
import com.tea.modules.model.Student;
import com.tea.modules.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * com.tea.modules.redis
 *
 * @author xiejiemin
 * @create 2021/2/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisUtilTest {

    @Test
    public void testJson(){
        RedisUtils.setEx("object", Student.builder().age(11).name("json").build(),1L, TimeUnit.SECONDS);
        Student student = RedisUtils.get("object",Student::new);
        log.info(JacksonUtils.toJsonString(student));
    }
}
