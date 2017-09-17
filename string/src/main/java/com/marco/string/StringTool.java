package com.marco.string;

public class StringTool {
    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * 判断字符串是""或null
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 判断字符串非""或null
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断字符串是" "，""或null
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断字符串非" "，""或null
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    /**
     * 去掉字符串头和尾的" "，null原样返回
     *
     * @param str
     * @return
     */
    public static String trimBlank(String str) {
        return str == null ? null : str.trim();
    }

    /**
     * 去掉字符串头和尾的" "，""返回null，null原样返回
     *
     * @param str
     * @return
     */
    public static String trimBlank2Null(String str) {
        String result = trimBlank(str);
        return isEmpty(result) ? null : result;
    }

    /**
     * 去掉字符串头和尾的" "，""原样返回，null返回""
     *
     * @param str
     * @return
     */
    public static String trimBlank2Empty(String str) {
        String result = trimBlank2Null(str);
        return result == null ? EMPTY_STRING : result;
    }

    /**
     * 比较两个字符串的值是否相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean equals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }
}
