package com.cy.test.controller;

import com.cy.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test.controller
 * @email: cy880708@163.com
 * @date: 2018/8/15 下午2:28
 * @mofified By:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return userService.initUserInfo();
    }

}

