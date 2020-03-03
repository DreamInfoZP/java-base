package com.zp;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@42pay.com
 * @date RefundProcessRequest.java v1.0  2019/12/30 9:13 上午
 */

@Data
public class RefundProcess implements Serializable {

    /**
     * 商家邮箱
     */
    private String merchantEmail;

    /**
     * 商家密钥
     */
    private String secretKey;

    /**
     * 退款金额 部分或者全部
     */
    private BigDecimal refundAmount;

    /**
     * 退款原因
     */
    private String refundReason;

    /**
     * 退款成功的交易id
     */
    private String transactionId;

    /**
     * 已付款订单
     */
    private String orderId;
}
