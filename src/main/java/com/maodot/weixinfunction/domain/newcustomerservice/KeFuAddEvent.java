package com.maodot.weixinfunction.domain.newcustomerservice;

import org.springframework.context.ApplicationEvent;

/**
 * 添加客服
 * @author maodot
 */
public class KeFuAddEvent extends ApplicationEvent {

    private String account;
    private String nickname;
    private String password;

    public KeFuAddEvent(Object source, String account, String nickname, String password) {
        super(source);
        this.account = account;
        this.nickname = nickname;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }
}
