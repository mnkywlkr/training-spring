package de.hska.lkit.demo.redis.controller;

import org.springframework.core.NamedThreadLocal;

/**
 * 
 * SimpleSecurity: Utility-Klasse für Session Informationen
 *  Einfache Utility-Klasse, die den Login-Status pro Zugriff verwaltet.
 *  Die Klasse wird durch einen Interzeptor initialisiert und zurückgesetzt.
 */
public abstract class SimpleSecurity {
	private static final ThreadLocal<UserInfo> user = new NamedThreadLocal<UserInfo>("microblog-id");

	private static class UserInfo {
		String name;
		String uid;
	}

	public static void setUser(String name, String uid) {
		UserInfo userInfo = new UserInfo();
		userInfo.name = name;
		userInfo.uid = uid;
		user.set(userInfo);
	}

	public static boolean isUserSignedIn(String name) {
		UserInfo userInfo = user.get();
		return userInfo != null && userInfo.name.equals(name);
	}

public static boolean isSignedIn() { 
	UserInfo userInfo = user.get();
return userInfo != null; 
}
public static String printHello() {
	
	return "hello";
	}

public static String getName() {
	UserInfo userInfo = user.get();
	return userInfo.name;
	}

public static String getUid() { 
	UserInfo userInfo = user.get();
	return userInfo.uid;
	}
}