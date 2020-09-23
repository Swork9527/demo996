package com.kwz.DateTest;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * @Author keweizhong
 * @Date 2020/8/18 19:29
 */
public class LocalDateTimeTest {
    @Test
    public void test() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 8, 18, 19, 31, 56);
        System.out.println(dateTime);

        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime plusHours = dateTime1.plusHours(8);

        String format = dateTime1.format(DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss"));
        String format1 = plusHours.format(DateTimeFormatter.ofPattern("yyyy-M-d HH:mm:ss"));
        System.out.println(format);
        System.out.println(format1);

    }
}
