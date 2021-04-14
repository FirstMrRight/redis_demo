package com.tea.modules.introduction;

import lombok.extern.slf4j.Slf4j;

/**
 * @author jaymin
 * 2021/2/12 23:16
 */
@Slf4j
public class TeaProcessor implements CustomizeProcessor {

    @Override
    public void enhance() {
        log.info("This is a customize method.");
    }
}
