package com.zero.my_generator;

import java.util.Objects;

public class StringUtils {

	/**
	 * 左填充
	 */
	public static final int LEFT_PAD = 1;
	/**
	 * 右填充
	 */
	public static final int RIGHT_PAD = 2;

	/**
	 * 按指定方式、填充材料，填充指定字符串至指定长度；指定长度小于源目标字符串长度时直接返回源目标字符串
	 * 
	 * @param arg
	 *            源字符串：不能为null
	 * @param length
	 *            长度
	 * @param type
	 *            填充方式：LEFT_PAD-左填充，RIGHT_PAD-右填充
	 * @param filler
	 *            填充材料，未指定或为空字符串，默认使用“0”填充
	 * @throws NullPointerException
	 *             - arg为null时抛出
	 * @return 目标字符串
	 */
	public static String padding(String arg, int length, int type, String filler) {
		Objects.requireNonNull(arg);

		if (type < LEFT_PAD || LEFT_PAD > RIGHT_PAD)
			throw new IllegalArgumentException("type超出范围");
		if (length < arg.length())
			return arg;

		String fillerCopy = filler;
		if (isEmpty(fillerCopy))
			fillerCopy = "0";
		StringBuilder builder = new StringBuilder(arg);
		int len = arg.length(), leng = fillerCopy.length();

		if (type == LEFT_PAD) {
			while ((len + leng) <= length) {
				builder = builder.insert(0, fillerCopy);
				len += leng;
			}
			if (len < length)
				builder = builder.insert(0, fillerCopy.substring(0, length - len));
		} else if (type == RIGHT_PAD) {
			while ((len + leng) <= length) {
				builder = builder.append(fillerCopy);
				len += leng;
			}
			if (len < length)
				builder = builder.append(fillerCopy.substring(0, length - len));
		}
		return builder.toString();

	}

	// public static String removeBlank(String str) {
	// if (Objects.isNull(str))
	// return null;
	//
	// String s =str;
	// char[] charArray = s.toCharArray();
	// for (char c : charArray) {
	// if (org.apache.commons.lang.StringUtils.isBlank(str))
	// }
	// }

	public static boolean isEmpty(String str) {
		return null == str || str.isEmpty();
	}
	
	public static boolean isNotEmpty(String str) {
		return isEmpty(str) == false;
	}

//	public static String requireNonEmpty(String obj, String message) {
//		if (org.apache.commons.lang.StringUtils.isBlank(obj))
//			throw new NullPointerException(message);
//		return obj;
//	}

	public static void main(String[] args) {
		System.out.println(padding("1", 3, RIGHT_PAD, "q00"));
	}
}
