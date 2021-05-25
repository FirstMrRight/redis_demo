package com.tea.modules.redis;

import com.google.common.collect.Maps;
import com.tea.modules.data.redis.util.RedisUtils;
import com.tea.modules.model.po.Student;
import com.tea.modules.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

    @Test
    public void testHashMget(){
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("id1",2);
        hashMap.put("id2",22);
        hashMap.put("id3",222);
        RedisUtils.putAll("user",hashMap);
        Collection<Object> fields = new ArrayList<>();
        fields.add("id1");
        fields.add("id2");
        List<Object> userList = RedisUtils.hMultiGet("user", fields);
        userList.stream().forEach(user-> System.out.println(JacksonUtils.toJsonString(user)));
    }

}
