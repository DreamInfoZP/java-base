package com.zp;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import sun.tools.jstat.JStatLogger;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date JSONLog.java v1.0  2020/2/19 4:09 下午
 */
@Slf4j
public class JSONLogTest {

    public static void main(String[] args) {
        String json = "{\"id\":\"auth_g1TZ3320200706n4M51502601\",\"object\":\"authorize\",\"live_mode\":false,\"api_version\":\"V2\",\"status\":\"AUTHORIZED\",\"amount\":0.1,\"currency\":\"AED\",\"threeDSecure\":false,\"save_card\":false,\"transaction\":{\"authorization_id\":\"234219\",\"timezone\":\"UTC+03:00\",\"created\":\"1581750393616\",\"expiry\":{\"period\":30,\"type\":\"MINUTE\"},\"asynchronous\":false},\"reference\":{\"track\":\"tck_q8XM3420200706Qg431502421\",\"payment\":\"3415200706024213210\",\"gateway\":\"123456789\",\"acquirer\":\"004603234219\",\"transaction\":\"101202002110002\",\"order\":\"101202002110002\"},\"response\":{\"code\":\"001\",\"message\":\"Authorized\"},\"acquirer\":{\"response\":{\"code\":\"00\",\"message\":\"Approved\"}},\"card\":{\"object\":\"card\",\"first_six\":\"511111\",\"last_four\":\"1118\"},\"receipt\":{\"id\":\"203415200706022904\",\"email\":true,\"sms\":true},\"customer\":{\"id\":\"cus_Ky523420200706m6Y11502468\",\"first_name\":\"qian\",\"email\":\"qian.wang@topay.ae\",\"phone\":{\"country_code\":\"971\",\"number\":\"505950120\"}},\"source\":{\"object\":\"token\",\"type\":\"CARD_PRESENT\",\"payment_type\":\"CREDIT_CARD\",\"payment_method\":\"MASTERCARD\",\"channel\":\"INTERNET\",\"id\":\"tok_CbIBY1311012Zv6B527862\"},\"redirect\":{\"status\":\"CANCELLED\",\"url\":\"https://www.test2pay.ae/return\"},\"auto\":{\"status\":\"SCHEDULED\",\"type\":\"VOID\",\"time\":168},\"description\":\"\"}";
        log.info("json factory {}", JSON.toJSONString(json));
        log.info("json not factory {}", JSON.toJSONString(json, true));
    }
}
