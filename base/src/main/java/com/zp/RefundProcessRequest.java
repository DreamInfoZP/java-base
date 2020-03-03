package com.zp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@42pay.com
 * @date RefundProcessRequest.java v1.0  2019/12/30 9:13 上午
 */

@Data
public class RefundProcessRequest implements Serializable {

    /**
     * 商家邮箱
     */
    private String merchant_email;

    /**
     * 商家密钥
     */
    private String secret_key;

    /**
     * 退款金额 部分或者全部
     */
    private BigDecimal refund_amount;

    /**
     * 退款原因
     */
    private String refund_reason;

    /**
     * 退款成功的交易id
     */
    private String transaction_id;

    /**
     * 已付款订单
     */
    private String order_id;
}
