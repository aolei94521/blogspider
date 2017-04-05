package com.aolei.spider.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Administrator on 2017/4/5.
 */
public class NumberUtils {

    public static final Long LONG_ZERO = Long.valueOf(0L);

    public static final Long LONG_ONE = Long.valueOf(1L);

    public static final Long LONG_MINUS_ONE = Long.valueOf(-1L);

    public static final Integer INTEGER_ZERO = Integer.valueOf(0);

    public static final Integer INTEGER_ONE = Integer.valueOf(1);

    public static final Integer INTEGER_MINUS_ONE = Integer.valueOf(-1);

    public static final Short SHORT_ZERO = Short.valueOf((short)0);

    public static final Short SHORT_ONE = Short.valueOf((short)1);

    public static final Short SHORT_MINUS_ONE = Short.valueOf((short)-1);

    public static final Byte BYTE_ZERO = Byte.valueOf((byte)0);

    public static final Byte BYTE_ONE = Byte.valueOf((byte)1);

    public static final Byte BYTE_MINUS_ONE = Byte.valueOf((byte)-1);

    public static final Double DOUBLE_ZERO = Double.valueOf(0.0D);

    public static final Double DOUBLE_ONE = Double.valueOf(1.0D);

    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0D);

    public static final Float FLOAT_ZERO = Float.valueOf(0.0F);

    public static final Float FLOAT_ONE = Float.valueOf(1.0F);

    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0F);

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int defaultValue) {
        if (str == null)
            return defaultValue;
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
        }
        return defaultValue;
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long defaultValue) {
        if (str == null)
            return defaultValue;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException nfe) {
        }
        return defaultValue;
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0F);
    }

    public static float toFloat(String str, float defaultValue) {
        if (str == null)
            return defaultValue;
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
        }
        return defaultValue;
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0D);
    }

    public static double toDouble(String str, double defaultValue) {
        if (str == null)
            return defaultValue;
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
        }
        return defaultValue;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte)0);
    }

    public static byte toByte(String str, byte defaultValue) {
        if (str == null)
            return defaultValue;
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException nfe) {
        }
        return defaultValue;
    }

    public static short toShort(String str) {
        return toShort(str, (short)0);
    }

    public static short toShort(String str, short defaultValue) {
        if (str == null)
            return defaultValue;
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException nfe) {
        }
        return defaultValue;
    }


    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int i = str.length() - 1; i >= 0; --i) {
            if (str.charAt(i) != '0') {
                return false;
            }
        }
        return (str.length() > 0);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }

        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    public static BigInteger createBigInteger(String str) {
        if (str == null) {
            return null;
        }
        return new BigInteger(str);
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }

        if (StringUtils.isEmpty(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(str);
    }

    public static long min(long[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        long min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static int min(int[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        int min = array[0];
        for (int j = 1; j < array.length; ++j) {
            if (array[j] < min) {
                min = array[j];
            }
        }

        return min;
    }

    public static short min(short[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        short min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static byte min(byte[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        byte min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static double min(double[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        double min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (Double.isNaN(array[i])) {
                return (0.0D / 0.0D);
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static float min(float[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        float min = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (Float.isNaN(array[i])) {
                return (0.0F / 0.0F);
            }
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }

    public static long max(long[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        long max = array[0];
        for (int j = 1; j < array.length; ++j) {
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static int max(int[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        int max = array[0];
        for (int j = 1; j < array.length; ++j) {
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static short max(short[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        short max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static byte max(byte[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        byte max = array[0];
        for (int i = 1; i < array.length; ++i) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public static double max(double[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        double max = array[0];
        for (int j = 1; j < array.length; ++j) {
            if (Double.isNaN(array[j])) {
                return (0.0D / 0.0D);
            }
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static float max(float[] array) {
        if (array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        float max = array[0];
        for (int j = 1; j < array.length; ++j) {
            if (Float.isNaN(array[j])) {
                return (0.0F / 0.0F);
            }
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }

    public static long min(long a, long b, long c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static int min(int a, int b, int c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static short min(short a, short b, short c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static byte min(byte a, byte b, byte c) {
        if (b < a) {
            a = b;
        }
        if (c < a) {
            a = c;
        }
        return a;
    }

    public static double min(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }

    public static float min(float a, float b, float c) {
        return Math.min(Math.min(a, b), c);
    }

    public static long max(long a, long b, long c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static int max(int a, int b, int c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static short max(short a, short b, short c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static byte max(byte a, byte b, byte c) {
        if (b > a) {
            a = b;
        }
        if (c > a) {
            a = c;
        }
        return a;
    }

    public static double max(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }

    public static float max(float a, float b, float c) {
        return Math.max(Math.max(a, b), c);
    }

    public static boolean isDigits(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (!(Character.isDigit(str.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] chars = str.toCharArray();
        int sz = chars.length;
        boolean hasExp = false;
        boolean hasDecPoint = false;
        boolean allowSigns = false;
        boolean foundDigit = false;

        int start = (chars[0] == '-') ? 1 : 0;
        if ((sz > start + 1) && (chars[start] == '0') && (chars[(start + 1)] == 'x')) {
            int i = start + 2;
            if (i == sz) {
                return false;
            }

            for (; i < chars.length; ++i) {
                if ((((chars[i] < '0') || (chars[i] > '9'))) && (((chars[i] < 'a') || (chars[i] > 'f')))
                        && (((chars[i] < 'A') || (chars[i] > 'F')))) {
                    return false;
                }
            }
            return true;
        }
        --sz;

        int i = start;

        while ((i < sz) || ((i < sz + 1) && (allowSigns) && (!(foundDigit)))) {
            if ((chars[i] >= '0') && (chars[i] <= '9')) {
                foundDigit = true;
                allowSigns = false;
            } else if (chars[i] == '.') {
                if ((hasDecPoint) || (hasExp)) {
                    return false;
                }
                hasDecPoint = true;
            } else if ((chars[i] == 'e') || (chars[i] == 'E')) {
                if (hasExp) {
                    return false;
                }
                if (!(foundDigit)) {
                    return false;
                }
                hasExp = true;
                allowSigns = true;
            } else if ((chars[i] == '+') || (chars[i] == '-')) {
                if (!(allowSigns)) {
                    return false;
                }
                allowSigns = false;
                foundDigit = false;
            } else {
                return false;
            }
            ++i;
        }
        if (i < chars.length) {
            if ((chars[i] >= '0') && (chars[i] <= '9')) {
                return true;
            }
            if ((chars[i] == 'e') || (chars[i] == 'E')) {
                return false;
            }
            if (chars[i] == '.') {
                if ((hasDecPoint) || (hasExp)) {
                    return false;
                }

                return foundDigit;
            }
            if ((!(allowSigns))
                    && (((chars[i] == 'd') || (chars[i] == 'D') || (chars[i] == 'f') || (chars[i] == 'F')))) {
                return foundDigit;
            }
            if ((chars[i] == 'l') || (chars[i] == 'L')) {
                return ((foundDigit) && (!(hasExp)) && (!(hasDecPoint)));
            }

            return false;
        }

        return ((!(allowSigns)) && (foundDigit));
    }

}
