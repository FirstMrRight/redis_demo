package com.tea.repeat;


import com.tea.modules.enums.DeleteEnum;
import com.tea.modules.model.User;

import java.util.Date;

/**
 * com.tea.repeat <br>
 * 重复性的代码，请别再复制粘贴了!
 *
 * @author jaymin
 * @since 2021/5/13
 */
public class RepeatCodeDemonstration {

    /**
     * 每次新增数据，都要设置这几个必要的属性值.造成大量的setter泛滥.
     * @param user 用户
     */
    public void register(User user) {
        String userId = "textUserId";
        Date now = new Date();
        user.setCreateUser(userId);
        user.setUpdateUser(userId);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setHasDelete(DeleteEnum.NO_DELETE.getIsDelete());
        save(user);
    }

    /**
     * 使用封装让代码复用性更加强.
     * @param user
     */
    public void registerWithReuse(User user){
        String userId = "textUserId";
        user.initialize(userId);
        save(user);
    }

    private void save(User user) {
        // save data
    }
}
