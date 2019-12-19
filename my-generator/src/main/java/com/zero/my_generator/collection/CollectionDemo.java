package com.zero.my_generator.collection;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionDemo {
	public static void main(String[] args) {
		Map<String, User> map = new ConcurrentHashMap<>();
		for (int i = 1; i < 6; i++) {
			User user = new User(new char[] { (char) ('a' + i), 'z' }.toString(), i + 10);
			map.put(Integer.toString(i), user);
		}
		System.out.println(map);
		Collection<User> values = map.values();
		for (User user : values) {
			user.setAge(0);
		}
		System.out.println(map);
	}
}

class User {
	private String name;
	private int age;

	public User() {
		super();
	}

	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
