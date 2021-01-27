package com.example.backend.kuaidi100Utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * 　　* @description: 读取配置文件工具类
 * 　　* @param ${tags}
 * 　　* @return ${return_type}
 * 　　* @throws
 * 　　* @author liutao
 * 　　* @date 2020/12/21 16:01
 *
 */
public class PropertiesReader {

    //创建Properties对象
    private static Properties property = new Properties();
    //在静态块中加载资源
    static {
        try  {
            InputStream in = PropertiesReader.class.getResourceAsStream("/application.properties");
            property.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取字符串类型的值
     * @param key
     * @return
     */
    public static String get(String key) {
        return property.getProperty(key);
    }

}

