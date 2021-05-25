package com.tea.modules.common;

import com.tea.modules.model.po.User;
import com.tea.modules.util.Builder;
import org.junit.Test;

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
