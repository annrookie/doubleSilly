package com.i2silly.common.util;

import com.i2silly.common.constant.CharsetEnum;
import com.i2silly.common.constant.CipherEnum;
import com.i2silly.common.constant.CodeResultEnum;
import com.i2silly.common.constant.ComConstant;
import com.i2silly.common.exception.UtilException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
        return encrypt(password, CipherEnum.MD5);
    }

    /**
     * sha1 算法加密
     *
     * @param password 密码
     * @return 加密后字符串
     */
    public static String sha1Encrypt(String password) {
        return encrypt(password, CipherEnum.SHA);
    }

    /**
     * sha224 算法加密
     *
     * @param password 密码
     * @return 加密后字符串
     */
    public static String sha224Encrypt(String password) {
        return encrypt(password, CipherEnum.SHA224);
    }

    /**
     * sha256 算法加密
     *
     * @param password 密码
     * @return 加密后字符串
     */
    public static String sha256Encrypt(String password) {
        return encrypt(password, CipherEnum.SHA256);
    }

    /**
     * sha384 算法加密
     *
     * @param password 密码
     * @return 加密后字符串
     */
    public static String sha384Encrypt(String password) {
        return encrypt(password, CipherEnum.SHA384);
    }

    /**
     * sha512 算法加密
     *
     * @param password 密码
     * @return 加密后字符串
     */
    public static String sha512Encrypt(String password) {
        return encrypt(password, CipherEnum.SHA512);
    }

    /**
     * 加密算法，MD5与sha
     *
     * @param bytes  加密byte数组
     * @param method 加密方式
     * @return 加密后字符串
     */
    public static String encrypt(byte[] bytes, CipherEnum method) {
        if (null == bytes) {
            return ComConstant.EMPTY_STR;
        }
        if (method == null) {
            throw new UtilException(CodeResultEnum.NO_SUCH_ALGORITHM);
        }
        try {
            MessageDigest md = MessageDigest.getInstance(method.getVal());
            switch (method) {
                case MD5:
                    md.update(bytes);
                    return new BigInteger(1, md.digest()).toString(16);
                case SHA:
                case SHA224:
                case SHA256:
                case SHA384:
                case SHA512:
                    byte[] digest = md.digest(bytes);
                    BigInteger no = new BigInteger(1, digest);
                    StringBuilder hashText = new StringBuilder(no.toString(16));
                    int min = 16;
                    if (method == CipherEnum.SHA224) {
                        min *= 2;
                    } else if (method == CipherEnum.SHA256) {
                        min *= 4;
                    } else if (method == CipherEnum.SHA384) {
                        min *= 6;
                    } else if (method == CipherEnum.SHA512) {
                        min *= 8;
                    }
                    while (hashText.length() < min) {
                        hashText.insert(0, "0");
                    }
                    return hashText.toString();
                default:
                    return ComConstant.EMPTY_STR;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new UtilException(CodeResultEnum.NO_SUCH_ALGORITHM);
        }
    }

    /**
     * md5和sha算法合集
     *
     * @param password 密码
     * @param method   算法方法
     * @return 加密后的字符串
     */
    public static String encrypt(String password, CipherEnum method) {
        if (password == null || password.length() < 1) {
            return ComConstant.EMPTY_STR;
        }
        try {
            return encrypt(password.getBytes(CharsetEnum.UTF8_.getText()), method);
        } catch (UnsupportedEncodingException e) {
            throw new UtilException(CodeResultEnum.UNSUPPORTED_ENCODING);
        }
    }

    /**
     * hmac算法集合
     *
     * @param password 密码
     * @param key      key
     * @return 字符串
     */
    public static String hmacEncrypt(String password, String key, CipherEnum method) {
        if (password == null || password.length() < 1) {
            return ComConstant.EMPTY_STR;
        }
        if (key == null) {
            throw new UtilException(CodeResultEnum.INVALID_KEY);
        }
        if (method == null) {
            throw new UtilException(CodeResultEnum.NO_SUCH_ALGORITHM);
        }
        try {
            // 通过 加密算法 创建密匙
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CharsetEnum.UTF8_.getText()), method.getVal());
            // 初始化算法
            Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
            mac.init(secretKeySpec);
            // 加密
            byte[] bytes = mac.doFinal(password.getBytes(CharsetEnum.UTF8_.getText()));
            String s = new BigInteger(1, bytes).toString(16);
            int min;
            switch (method) {
                case MD5:
                    min = 32;
                    break;
                case HMACSHA1:
                    min = 40;
                    break;
                case HMACSHA224:
                    min = 56;
                    break;
                case HMACSHA256:
                    min = 64;
                    break;
                case HMACSHA384:
                    min = 96;
                    break;
                case HMACSHA512:
                    min = 128;
                    break;
                default:
                    min = 16;
            }
            return s.length() >= min ? s : "0" + s;
        } catch (NoSuchAlgorithmException e) {
            throw new UtilException(CodeResultEnum.NO_SUCH_ALGORITHM);
        } catch (InvalidKeyException e) {
            throw new UtilException(CodeResultEnum.INVALID_KEY);
        } catch (UnsupportedEncodingException e) {
            throw new UtilException(CodeResultEnum.UNSUPPORTED_ENCODING);
        }
    }

    /**
     * hmacMd5 算法
     *
     * @param password 密码
     * @param key      密匙
     * @return 加密后字符串
     */
    public static String hmacMd5Encrypt(String password, String key) {
        return hmacEncrypt(password, key, CipherEnum.HMACMD5);
    }

    /**
     * hmacSha1 算法
     *
     * @param password 密码
     * @param key      密匙
     * @return 加密后字符串
     */
    public static String hmacSha1Encrypt(String password, String key) {
        return hmacEncrypt(password, key, CipherEnum.SHA);
    }

    /**
     * hmacSha224 算法
     *
     * @param password 密码
     * @param key      密匙
     * @return 加密后字符串
     */
    public static String hmacSha224Encrypt(String password, String key) {
        return hmacEncrypt(password, key, CipherEnum.HMACSHA224);
    }

    /**
     * hmacSha256 算法
     *
     * @param password 密码
     * @param key      密匙
     * @return 加密后字符串
     */
    public static String hmacSha256Encrypt(String password, String key) {
        return hmacEncrypt(password, key, CipherEnum.HMACSHA256);
    }

    /**
     * hmacSha384 算法
     *
     * @param password 密码
     * @param key      密匙
     * @return 加密后字符串
     */
    public static String hmacSha384Encrypt(String password, String key) {
        return hmacEncrypt(password, key, CipherEnum.HMACSHA384);
    }

    /**
     * hmacSha512 算法
     *
     * @param password 密码
     * @param key      密匙
     * @return 加密后字符串
     */
    public static String hmacSha512Encrypt(String password, String key) {
        return hmacEncrypt(password, key, CipherEnum.HMACSHA512);
    }

    /**
     * url加密
     *
     * @param str     字符串
     * @param charset 编码格式
     * @return 加密后的字符串
     */
    public static String urlEncode(String str, CharsetEnum charset) {
        try {
            return URLEncoder.encode(str, charset.getText());
        } catch (UnsupportedEncodingException e) {
            throw new UtilException(CodeResultEnum.UNSUPPORTED_ENCODING);
        }
    }

    /**
     * url加密，默认utf-8
     *
     * @param str 字符串
     * @return 加密后字符串
     */
    public static String urlEncode(String str) {
        return urlEncode(str, CharsetEnum.UTF8_);
    }

    /**
     * url 解码
     *
     * @param str     字符串
     * @param charset 编码格式
     * @return 解码后的字符串
     */
    public static String urlDecode(String str, CharsetEnum charset) {
        try {
            return URLDecoder.decode(str, charset.getText());
        } catch (UnsupportedEncodingException e) {
            throw new UtilException(CodeResultEnum.UNSUPPORTED_ENCODING);
        }
    }

    /**
     * url 解码
     *
     * @param str 字符串
     * @return 解码后的字符串
     */
    public static String urlDecode(String str) {
        return urlDecode(str, CharsetEnum.UTF8_);
    }
}
