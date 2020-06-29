package com.qfedu.dcy.utils;

import org.springframework.util.DigestUtils;

public class StringUtil {
    /**
     * 判断字符串为空返回true
     * @param str
     * @return true 表示为空 false 表示不为空
     */
    public static boolean isEmpty(String str){
        return null==str|| "".equals(str);
    }

    /**
     * 对字符串进行md5加密
     * @param origin
     * @return
     */
    public static String MD5Encode(String origin){
        return DigestUtils.md5DigestAsHex(origin.getBytes());
    }
}
