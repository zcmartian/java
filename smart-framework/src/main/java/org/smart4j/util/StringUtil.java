package org.smart4j.util;

/**
 * Created by marszhou on 15/12/20.
 */
public class StringUtil {
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
            return str.isEmpty();
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String[] splitString(String input, String split) {
        String[] result = new String[]{};
        if (isNotEmpty(input)) {
            result = input.split(split);
        }
        return result;
    }
}
