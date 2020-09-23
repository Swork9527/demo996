package com.kwz.DateTest;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Random;

/**
 * @Author keweizhong
 * @Date 2020/8/18 19:45
 */
public class InstantTest {
    public static final String allChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";
    @Test
    public void test() {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(Long.MAX_VALUE);

        System.out.println(generateStr(16));
    }

    public static String generateStr(int len){
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i <len ; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return  sb.toString();
    }
}
