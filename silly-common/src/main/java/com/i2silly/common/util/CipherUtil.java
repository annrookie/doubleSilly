package com.i2silly.common.util;

import com.i2silly.common.constant.ComConstant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * <h3>DoubleSilly</h3>
 * <P>加解密工具类</p>
 *
 * @author i2silly
 * @date 2020/01/09
 */
public class CipherUtil {

    /**
     * base 64 加密
     *
     * @param str 字符串
     * @return 加密后字符串
     */
    public static String base64Encrypt(String str) {
        if (null == str || str.length() < 1) {
            return ComConstant.EMPTY_STR;
        }
        return base64Encrypt(str.getBytes());
    }

    /**
     * base64加密
     *
     * @param bytes byte字节数组
     * @return 加密后字符串
     */
    public static String base64Encrypt(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * base64 解密
     *
     * @param str 加密后字符串
     * @return 解密后字符串
     */
    public static String base64Decrypt(String str) {
        if (null == str || str.length() < 1) {
            return ComConstant.EMPTY_STR;
        }
        return new String(Base64.getDecoder().decode(str));
    }

    /**
     * 生产md5加密
     *
     * @param password 需加密的密码
     * @return 加密后的字符串
     */
    public static String md5Encrypt(String password) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
