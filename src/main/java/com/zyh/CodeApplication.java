package com.zyh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;


/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.zyh.code.mapper")
public class CodeApplication {
    public static void main(String[] args) {
        File file = new File("");
        String absolutePath = file.getAbsolutePath();
        String path = absolutePath + "\\src\\main\\java";
        System.out.println(path);

        SpringApplication.run(CodeApplication.class, args);
    }
}