package com.zyh.utils;

import com.mysql.cj.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * 获取配置文件中的信息值
 * </p>
 * <p>
 * * @author zyh
 * * @since 2024-07-06
 */
public class GetPropertiesValue {

    public Map<String, String> getProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = MyBatisPlus.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        System.out.println(properties);

        Map<String, String> map = new HashMap<>();

        // 遍历配置文件中的键值对并写入map中方便返回取值
        properties.keys().asIterator().forEachRemaining(key -> {
            System.out.println(key);
            // 获取键值对
            String keyName = key.toString();
            // 处理数据库字段
            if (key.toString().contains("spring.datasource.url")) {
                map.put("url", properties.getProperty(keyName));
            } else if (key.toString().contains("spring.datasource.driver-class-name")) {
                map.put("driverName", properties.getProperty(keyName));
            } else if (key.toString().contains("spring.datasource.username")) {
                map.put("username", properties.getProperty(keyName));
            } else if (key.toString().contains("spring.datasource.password")) {
                map.put("password", properties.getProperty(keyName));
            } else {
                // 处理数据库字段之外的值
                map.put(keyName.toUpperCase().replace(".", "_"), properties.getProperty(keyName));
            }
        });

        return map;
    }
}
