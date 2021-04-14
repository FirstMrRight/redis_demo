package com.tea.modules.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * com.jay.company.file.web
 *
 * @author xiejiemin
 * @create 2020/9/29
 */
@RestController
@RequestMapping("/mail")
public class StrategyController {
    @Autowired
    private MailStrategyContext mailStrategy;

    @PostMapping("/{bussinessCode}/send")
    public void sendMail(@PathVariable(value = "bussinessCode") String bussinessCode,
                         @RequestParam(value = "message") String message) {
        mailStrategy.send(bussinessCode, message);
    }
}
