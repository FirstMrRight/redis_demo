package com.tea.controller;

import org.apache.commons.lang3.StringUtils;

/**
 * com.tea.controller<br>
 * 有效地消除控制语句
 *
 * @author jaymin
 * @since 2021/5/15
 */
public class ControllerStatementDemonstration {

    public void activateAccount(String id) {
        if (StringUtils.isNotEmpty(id)) {
            if (isValid(id)) {
                this.activate(id);
            }
        }
    }

    public void activateUserAccount(String id) {
        if (StringUtils.isBlank(id)) {
            return;
        }
        if (isValid(id)) {
            this.activate(id);
        }
    }



    private void activate(String id) {
        // activate
    }

    private boolean isValid(String id) {
        return true;
    }
}
