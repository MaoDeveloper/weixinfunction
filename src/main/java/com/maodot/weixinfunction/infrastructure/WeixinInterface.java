package com.maodot.weixinfunction.infrastructure;

/**
 * 存储微信接口
 * @author maodot
 */
public class WeixinInterface {

    /**
     * GET , 获取access_token 接口
     */
    public static final String ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token";

    /**
     * GET , 获取微信服务器ip
     */
    public static final String WEIXIN_SERVER_IP = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

    /**
     * POST , 客服帐号管理 - 添加客服帐号
     */
    public static final String KF_ACCOUNT_ADD = "https://api.weixin.qq.com/customservice/kfaccount/add";
    public static final String KF_ACCOUNT_UPDATE = "https://api.weixin.qq.com/customservice/kfaccount/update";
    public static final String KF_ACCOUNT_DELETE = "https://api.weixin.qq.com/customservice/kfaccount/del";
    public static final String KF_ACCOUNT_UPLOAD_HEAD_IMG = "https://api.weixin.qq.com/customservice/kfaccount/uploadheadimg";
    public static final String KF_ACCOUNT_LIST = "https://api.weixin.qq.com/customservice/kfaccount/getkflist";
    public static final String KF_MESSAGE_SEND = "https://api.weixin.qq.com/cgi-bin/message/custom/send";
    public static final String KF_MESSAGE_CUSTOM_TYPING = "https://api.weixin.qq.com/cgi-bin/message/custom/typing";

    public static final String ACCOUNT_USER_INFO = "https://api.weixin.qq.com/cgi-bin/user/info";
}
