package com.marco.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {

    /**
     * MD5加密，字母小写
     *
     * @param str null则返回null
     * @return
     */
    public static String encodeByMD5WithLowerCase(String str) {
        return str == null ? null : encodeByMD5WithUpperCase(str).toLowerCase();
    }

    /**
     * MD5加密，字母大写
     *
     * @param str null则返回null
     * @return
     */
    public static String encodeByMD5WithUpperCase(String str) {
        if (str == null) {
            return null;
        }
        MessageDigest md = null;
        byte[] bytes = null;
        try {
            md = MessageDigest.getInstance("MD5");
            bytes = md.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        return byteArray2String(bytes);
    }

    /**
     * 通过位运算，将字节数组转换为十六进制
     *
     * @param byteArray
     * @return
     */
    private static String byteArray2String(byte[] byteArray) {
        StringBuffer sb = new StringBuffer();
        for (byte mByte : byteArray) {
            sb.append(byte2HexString(mByte));
        }
        return sb.toString();
    }

    /**
     * 通过位运算，将字节转换为十六进制
     *
     * @param mByte
     * @return
     */
    private static String byte2HexString(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
