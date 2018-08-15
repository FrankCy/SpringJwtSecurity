package com.cy.test.impl;

import com.cy.test.service.UserService;
import org.json.simple.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test.impl
 * @email: cy880708@163.com
 * @date: 2018/8/15 下午2:48
 * @mofified By:
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String initUserInfo() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("nickName", "昵称");
        jsonObject.put("sex", 1);
        return jsonObject.toString();
    }
}
