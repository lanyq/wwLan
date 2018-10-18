package com.thread;

import org.apache.log4j.Logger;

import com.entity.Token;
import com.util.TokenUtil;
import com.util.WeixinUtil;

/**
* 类名: TokenThread </br>
* 描述: 定时获取微信access_token的线程 </br>
* 开发人员：leon </br>
* 创建时间：  Oct 6, 2018 </br>
* 发布版本：V1.0  </br>
 */
public class TokenThread implements Runnable {
    private static Logger log = Logger.getLogger(TokenThread.class);
    // 第三方用户唯一凭证
    public static String appid = "wxe4f4d28e266b2da0";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "a2b1e8f703a2627fea4b9c74ff97d846";
    public static Token accessToken = null;

    public void run() {
        while (true) {
            try {
                accessToken = WeixinUtil.getAccessToken(appid,appsecret);
                if (null != accessToken) {
                    //调用存储到数据库
                    TokenUtil.saveToken(accessToken);
                    log.info(accessToken.getAccessToken()+"获取access_token成功，有效时长{}秒 token:{}"+ accessToken.getExpiresIn());
                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpiresIn() - 200)*1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }
}