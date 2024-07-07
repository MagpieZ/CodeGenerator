package com.zyh.utils;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;


/**
 * @author
 * @create
 */
public class MyBatisPlus {
    public static void main(String[] args) throws IOException {
        // 配置文档
        // https://blog.csdn.net/wmj20001225/article/details/132595714

        // 获取配置文件
        GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
        Map<String, String> properties = getPropertiesValue.getProperties();
        // 获取数据库连接信息
        String url = properties.get("url");
        String username = properties.get("username");
        String password = properties.get("password");

        // 获取当前文件的绝对路径
        File file = new File("");
        String absoluteFile = file.getAbsolutePath();

//        FastAutoGenerator.create(url, username, password)
//                .globalConfig(builder -> {
//                    builder.author("zyh") // 设置作者
//                            .fileOverride() // 覆盖已生成文件
//                            .disableOpenDir() //禁止打开输出目录
//                            .outputDir(absoluteFile + "\\src\\main\\java"); // 指定输出目录
//                })
//                .packageConfig(builder -> {
//                    builder.parent("com.zyh.code") // 设置父包名
//                            .moduleName(null) // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, absoluteFile + "\\src\\main\\resources\\mapper\\")); // 设置mapperXml生成路径
//                })
//                .strategyConfig(builder -> {
//                    builder.entityBuilder().enableLombok(); //启动lombok
//                    builder.entityBuilder().enableTableFieldAnnotation(); //启用字段注解
//                    builder.addTablePrefix("t_", "c_"); //表前缀过滤
//                    builder.mapperBuilder().enableMapperAnnotation().build(); //启用@mapper注释
//                    builder.controllerBuilder().enableHyphenStyle().enableRestStyle(); //启用驼峰转连字符样式
//                    builder.addInclude("t_account"); // 设置需要生成的表名
//                })
//                .execute();
    }
}
