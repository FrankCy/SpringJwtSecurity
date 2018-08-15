package com.cy.test.pojo;

import org.springframework.data.annotation.Id;

/**
 * @version 1.0
 * @description：
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test.pojo
 * @email: cy880708@163.com
 * @date: 2018/8/15 下午3:22
 * @mofified By:
 */
public class User {

    @Id
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
