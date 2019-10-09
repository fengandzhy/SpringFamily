package org.zhouhy.springboot;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		String relativelyPath=System.getProperty("user.dir");
		System.out.println(relativelyPath);
		Date sr = new Date();
		long res1 = sr.getTime();
		System.out.println(res1);
	}

}
