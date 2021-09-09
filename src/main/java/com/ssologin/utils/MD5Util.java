package com.ssologin.utils;


import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util{
	/**
	 * 使用md5的算法进行加密
	 */
	/*
	 * // private static final String HEX_NUMS_STR = "1a2b3c4d"; // // private
	 * static final Integer SALT_LENGTH = 12;
	 * 
	 * // encrypt decryption // public static String getMd5str(String str) { //
	 * //第一次Md5加密获取初始密文 // String firstM =
	 * DigestUtils.md5DigestAsHex(str.getBytes()); // //截取初始密文片段 // String subStr =
	 * firstM.substring(5,16); // //设置盐值 // String salt = "1a2b3c4d"; //
	 * //拼成新的字符串并再次进行Md5加密 // String newStr = firstM+subStr+salt; // return
	 * DigestUtils.md5DigestAsHex(newStr.getBytes()); // }
	 */
	/**
	 * 使用shiro内置的MD5加密盐加密
	 * @param password
	 * @param username
	 * @return
	 */
	public static String getMd5StrSalt(String password,String username) {
		String encrypt = new SimpleHash("MD5",password,username,1024).toHex();
		return encrypt;
	}
}