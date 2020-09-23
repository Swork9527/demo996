package com.kwz;

import com.kwz.entity.Student;
import com.kwz.mapper.StudentDao;
import com.kwz.mapper.StudentServiceImpl;
import lombok.NonNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

/**
 * @Author keweizhong
 * @Date 2020/8/18 20:41
 */
@SpringBootTest
public class IServiceTest {
    public static final String allChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Autowired
    StudentServiceImpl studentDao;

    @Autowired
    StudentDao studentDao2;

    /**
     * 功能：生成自定义长度的随机字符串
     *
     * @param len 生成的字符串的长度
     * @return 长度为len的随机字符串
     */
    public static String generateStr(@NonNull int len) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }
        return sb.toString();
    }

    @Test
    public void saveBatchTest() {


        System.out.println(generateStr(9));

        for (int i = 0; i < 100; i++) {
            ArrayList<Student> list = new ArrayList<>();
            for (int j = 0; j < 100; j++) {

                Student student = new Student();

                student.setStudentName(generateStr(12));
                student.setCreateTime(LocalDateTime.now());
                student.setEmail(generateStr(8) + "@gmail.com");
                student.setAge(new Random().nextInt(9) + 18);

                list.add(student);
            }
            studentDao.saveBatch(list);
        }

    }

    @Test
    public void saveTest() {
        Student student = new Student();

        student.setStudentName(generateStr(12));
        student.setCreateTime(LocalDateTime.now());
        student.setEmail(generateStr(8) + "@gmail.com");
        student.setAge(new Random().nextInt(9) + 18);
        studentDao.save(student);
    }

    @Test
    public void test() {
        System.out.println(studentDao2.selectOneById(1156));
    }

}
