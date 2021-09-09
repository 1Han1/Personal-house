package com.ssologin.utils;

import java.util.UUID;

public class UuidUtil {

	public static String getUUID() {
		String id = null;
		UUID uuid = UUID.randomUUID();
		id = uuid.toString();
//		// 去掉随机id的短横线
//		id = id.replace("-", "");
//		// 将随机id换成数字
//		int num = id.hashCode();
//		// 取绝对值
//		num = num < 0 ? -num : num;
		
//		id = String.valueOf(num);
		return id;
	}
}
