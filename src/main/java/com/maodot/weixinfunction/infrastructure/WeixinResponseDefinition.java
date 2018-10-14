package com.maodot.weixinfunction.infrastructure;

/**
 * 微信返回码及信息
 * @author maodot
 */
public enum WeixinResponseDefinition {

    /**
     * 繁忙
     */
    BUSY(-1 , "系统繁忙，此时请开发者稍候再试"),
    SUCCESS(0 , "请求成功"),
    APP_SECRET_ERROR(40001 , "AppSecret错误或者AppSecret不属于这个公众号，请开发者确认AppSecret的正确性"),
    CHECK_GRANT_TYPE(40002 , "请确保grant_type字段值为client_credential"),
    IP_WHITE_LIST_NOT_EXIST(40164 , "调用接口的IP地址不在白名单中，请在接口IP白名单中进行设置。（小程序及小游戏调用不要求IP地址在白名单内。）")
    ;

    WeixinResponseDefinition(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public static String getName(int code) {
        for (WeixinResponseDefinition d : WeixinResponseDefinition.values()) {
            if (d.getCode() == code) {
                return d.getMsg();
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
