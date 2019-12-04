package com.test.springbootlogin.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {


    /**
     * 获取字段MD5加密后的数据
     * @param payPassword
     * @return
     * @throws Exception
     */
    public static String getMd5Str(String payPassword) throws Exception {
        //暂定MD5加密，还不知道他们的卡扣加密方式，以后再改逻辑
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new Exception("加密密码失败");
        }
        // 计算md5函数
        md.update((payPassword).getBytes());
        // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
        // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
        //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
        return new BigInteger(1, md.digest()).toString(16);
    }
}
