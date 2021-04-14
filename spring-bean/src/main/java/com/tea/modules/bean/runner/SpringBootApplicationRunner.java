package com.tea.modules.bean.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * com.tea.modules.bean.runner
 *
 * @author xiejiemin
 * @create 2021/3/8
 */
@Component
@Slf4j
public class SpringBootApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Spring Boot application running with args:", Arrays.toString(args.getSourceArgs()));
    }
}
