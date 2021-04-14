package com.tea.modules.bean.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * com.tea.modules.bean.runner
 *
 * @author xiejiemin
 * @create 2021/3/8
 */
@Component
@Slf4j
public class SpringBootCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("SpringBoot running with args:", args);
    }
}
