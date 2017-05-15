package com.example.user.utils.sys;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * 校验器：利用正则表达式校验邮箱、手机号等
 * 
 * @author liujiduo
 * 
 */
public class Validator {
	/**
	 * 正则表达式：验证用户名
	 */
	public static final String REGEX_USERNAME = "^[a-zA-Z]\\w{5,17}$";

	/**
	 * 正则表达式：验证密码
	 */
	public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";

	/**
	 * 正则表达式：验证手机号  .matches("^[1][3578]\\d{9}")
	 */
//	public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";//
	public static final String REGEX_MOBILE = "^(13[0-9]|15[012356789]|17[03678]|18[0-9]|14[57])[0-9]{8}$";
	/**
	 * 正则表达式：验证邮箱
	 */
	public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

	/**
	 * 正则表达式：验证汉字
	 */
	public static final String REGEX_CHINESE = "^[\u4e00-\u9fa5],{0,}$";

	/**
	 * 正则表达式：验证身份证
	 */
	public static final String REGEX_ID_CARD = "(^\\d{18}$)|(^\\d{15}$)";

	/**
	 * 正则表达式：验证URL
	 */
	public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	/**
	 * 正则表达式：验证IP地址
	 */
	public static final String REGEX_IP_ADDR = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";

	/**
	 * 校验用户名
	 * 
	 * @param username
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isUsername(String username) {
		return Pattern.matches(REGEX_USERNAME, username);
	}

	/**
	 * 校验密码
	 * 
	 * @param password
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isPassword(String password) {
		return Pattern.matches(REGEX_PASSWORD, password);
	}

	/**
	 * 校验手机号
	 * 
	 * @param mobile
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isMobile(String mobile) {
		return Pattern.matches(REGEX_MOBILE, mobile);
	}

	/**
	 * 校验邮箱
	 * 
	 * @param email
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isEmail(String email) {
		return Pattern.matches(REGEX_EMAIL, email);
	}

	/**
	 * 校验汉字
	 * 
	 * @param chinese
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isChinese(String chinese) {
		return Pattern.matches(REGEX_CHINESE, chinese);
	}

	/**
	 * 校验身份证
	 * 
	 * @param idCard
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isIDCard(String idCard) {
		return Pattern.matches(REGEX_ID_CARD, idCard);
	}

	/**
	 * 校验URL
	 *
	 * @param url
	 * @return 校验通过返回true，否则返回false
	 */
	public static boolean isUrl(String url) {
		return Pattern.matches(REGEX_URL, url);
	}

	/**
	 * 校验IP地址
	 * 
	 * @param ipAddr
	 * @return
	 */
	public static boolean isIPAddr(String ipAddr) {
		return Pattern.matches(REGEX_IP_ADDR, ipAddr);
	}

	public static void main(String[] args) {
		String username = "fdsdfsdj";
		System.out.println(Validator.isUsername(username));
		System.out.println(Validator.isChinese(username));
	}
	public static boolean check(String str, String regex) {
		if (str == null) {
			return false;
		}
		return str.matches(regex);
	}

	public static boolean isEmailStr(String email) {
		String regex = "^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		return check(email, regex);
	}

	public static boolean isMobileStr(String cellphone) {
		// String regex =
		// "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9])|177)\\d{8}$";
		String regex = "^1\\d{10}$";
		return check(cellphone, regex);
	}

	public static boolean isTelphone(String telephone) {
		String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
		return check(telephone, regex);
	}

	// 校验银行卡
	public static boolean checkCreditCard(String number) {
		if (TextUtils.isEmpty(number)) {
			return false;
		}
		number = number.replaceAll(" ", "");

		int s1 = 0, s2 = 0;
		String reverse = new StringBuffer(number).reverse().toString();
		for (int i = 0; i < reverse.length(); i++) {
			int digit = Character.digit(reverse.charAt(i), 10);
			if (i % 2 == 0) {// this is for odd digits, they are 1-indexed in
				// the algorithm
				s1 += digit;
			} else {// add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
				s2 += 2 * digit;
				if (digit >= 5) {
					s2 -= 9;
				}
			}
		}
		return (s1 + s2) % 10 == 0;
	}

	/**
	 * 隐藏手机号
	 */
	public static String hideMobile(String mobile) {
		String hideMobile = mobile.substring(0, 3) + "****"
				+ mobile.substring(7, mobile.length());
		return hideMobile;
	}

	// 校验身份证
	public static boolean valideIdCard(String idCard) {

		String idCardPattern = "^\\d{17}(\\d|X|x)$"; // 前17位为数字，最后一位为数字或X
		// 验证格式
		if (idCard == null)
			return false;
		if (!idCard.matches(idCardPattern)) {
			return false;
		}
		idCard = idCard.toUpperCase();
		/*
		 * 11 北京市 12 天津市 13 河北省 14 山西省 15 内蒙古自治区 21 辽宁省 22 吉林省 23 黑龙江省 31 上海市 32
		 * 江苏省 33 浙江省 34 安徽省 35 福建省 36 江西省 37 山东省 41 河南省 42 湖北省 43 湖南省 44 广东省 45
		 * 广西壮族自治区 46 海南省 50 重庆市 51 四川省 52 贵州省 53 云南省 54 西藏自治区 61 陕西省 62 甘肃省 63
		 * 青海省 64 宁夏回族自治区 65 新疆维吾尔自治区 71 台湾省 81 香港特别行政区 82 澳门特别行政区
		 */
		String provinces = "11, 12, 13, 14, 15, 21, 22, 23, 31, 32, 33, 34, 35, 36, 37, 41, 42, 43, 44, 45, 46, 50, 51, 52, 53, 54, 61, 62, 63, 64, 65, 71, 81, 82";

		// 验证省级代码
		if (!provinces.contains(idCard.substring(0, 2))) {
			return false;
		}
		// 验证年月日
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			Date birthday = df.parse(idCard.substring(6, 14));
			Date min = df.parse("19000101");
			Date max = df.parse(df.format(new Date()));
			if (birthday.before(min) || birthday.after(max)) {
				return false;
			}
		} catch (ParseException e) {
			return false;
		}

		// 验证校验位
		/*
		 * 关于身份证号码最后一位的校验码的算法如下： 　 ∑(a[i]*W[i]) mod 11 ( i = 2, 3, ..., 18 ) 　
		 * 　"*" ： 表示乘号 　　i： 表示身份证号码每一位的序号，从右至左，最左侧为18，最右侧为1。 　　a[i]： 表示身份证号码第 i
		 * 位上的号码 　　W[i]： 表示第 i 位上的权值 W[i] = 2^(i-1) mod 11 　　设：R = ∑(a[i]*W[i])
		 * mod 11 ( i = 2, 3, ..., 18 ) 　　C = 身份证号码的校验码 　　则R和C之间的对应关系如下表： 　　　R：0
		 * 1 2 3 4 5 6 7 8 9 10 　　　C：1 0 X 9 8 7 6 5 4 3 2 　　由此看出 X 就是 10，罗马数字中的
		 * 10 就是X，所以在新标准的身份证号码中可能含有非数字的字母X。
		 */
		char residues[] = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3',
				'2' };
		long sum = 0;
		for (int i = 0; i < 17; i++) {
			sum += Integer.valueOf(idCard.substring(i, i + 1))
					* (Math.pow(2, (18 - 1 - i)) % 11);
		}
		return idCard.charAt(17) == residues[(int) (sum % 11)];

	}
}
