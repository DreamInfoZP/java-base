package com.zp;

import javax.sound.midi.SoundbankResource;
import java.math.BigDecimal;

import java.lang.reflect.Field;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@42pay.com
 * @date TestReflect.java v1.0  2019/12/30 4:18 下午
 */
public class TestReflect {

    public static void main(String[] args) {
//        RefundProcess refundProcess = new RefundProcess();
//        refundProcess.setMerchantEmail("1234dsa");
//        refundProcess.setSecretKey("sdasd");
//        refundProcess.setRefundAmount(new BigDecimal("0"));
//        refundProcess.setRefundReason("43fdsfsd");
//        refundProcess.setTransactionId("65754efdsf");
//        refundProcess.setOrderId("48776876976");
//
//        RefundProcessRequest request = new RefundProcessRequest();
//        requestConvert(refundProcess, request);
//
//        System.out.println(request);

        RefundProcessRequest request = new RefundProcessRequest();
        request.setMerchant_email("sfasfda");
        request.setSecret_key("erwew");
        request.setRefund_amount(new BigDecimal("0"));
        request.setRefund_reason("sdfsfds");
        request.setTransaction_id("sdfgsdgf");
        request.setOrder_id("sdfgsdgf");

        RefundProcess refundProcess = new RefundProcess();
        requestConvert(request,refundProcess);
        System.out.println(refundProcess);


    }

    public static void requestConvert(Object source, Object target) {
        Field[] s = source.getClass().getDeclaredFields();
        Field[] t = target.getClass().getDeclaredFields();
        Field newField;
        for (Field s1 : s) {
            for (Field t1 : t) {
                try {
                    if (s1.getName().toLowerCase().equals(t1.getName().replaceAll("_", "")) || s1.getName().replaceAll("_", "").equals(t1.getName().toLowerCase())) {
                        System.out.println(s1.getName() + "  " + t1.getName().replace("_", ""));
                        newField = target.getClass().getDeclaredField(t1.getName());
                        newField.setAccessible(true);
                        s1.setAccessible(true);
                        newField.set(target, s1.get(source));

                    }
                } catch (Exception e) {
                    System.out.println("bean convert exception");
                }
            }
        }
    }
}
