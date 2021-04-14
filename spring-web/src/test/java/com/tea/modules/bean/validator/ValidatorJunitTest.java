package com.tea.modules.bean.validator;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

/**
 * com.tea.modules.bean.validator
 *
 * @author xiejiemin
 * @since 2021/3/31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ValidatorJunitTest {
    @Autowired
    private ValidatorTest validatorTest;

    @Test
    public void test(){
        validatorTest.test();
    }
}
