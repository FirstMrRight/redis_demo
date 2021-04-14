package com.tea.modules.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.common.collect.Lists;
import com.tea.modules.model.Student;
import com.tea.modules.model.User;
import com.tea.modules.util.Builder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author jaymin
 * 2021/2/16 22:55
 */
public class BuilderTest {

    @Test
    public void testBuilder() {
        User user = Builder.of(User::new).with(User::setAge, 18).build();
    }
}
