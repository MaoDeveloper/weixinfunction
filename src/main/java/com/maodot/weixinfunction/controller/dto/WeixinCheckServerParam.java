package com.maodot.weixinfunction.controller.dto;

/**
 * 参数类
 * 微信验证应用服务器携带的参数
 * @author MAODOT
 */
public class WeixinCheckServerParam {

    private String signature;
    private String timestamp;
    private String nonce;
    private String echostr;

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }

    public boolean checkAllParamHasReceive(){
        if (signature == null || signature.isEmpty() ||
                timestamp == null || timestamp.isEmpty() ||
                nonce == null || nonce.isEmpty() ||
                echostr == null || echostr.isEmpty()){
            return false;
        }
        return true;
    }
}
