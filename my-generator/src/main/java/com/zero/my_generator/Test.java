package com.zero.my_generator;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) throws ParseException {
		// System.out.println(Math.abs(Period.between(LocalDate.of(2018, 1, 28),
		// LocalDate.of(2019, 1, 31)).getDays()));

		ExecutorService pool = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10000; i++) {
			pool.execute(new Runnable() {
				@Override
				public void run() {
					long sum = 1;
					for (int j = 1000; j < Integer.MAX_VALUE; j++) {
						sum += j;
					}
					System.out.println(Thread.currentThread() + ": " + sum);
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			});
		}

		// System.out.println("0".substring(0, 0));
		// System.out.println(Objects.equals(null, "s"));

		// String phone = "13721022142".trim();
		// System.out.println(phone.length());
		//
		// for (char ch : phone.toCharArray())
		// System.out.println((int) ch + " ===" + ch);
		//
		// System.out.println(Character.isWhitespace((char)160));

		//
		// System.out.println(Pattern.compile("^\\d{11}$").matcher(phone).matches());
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// System.out.println(format.parse("2018-12-26").after(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())));
		// System.out.println(Arrays.toString("4020000.20".split("\\.")));
		// System.out.println(financeFormat(4020000));

		// Integer i = 48;
		// Integer j = 48;
		// System.out.println(i ==j);
		//
		// Integer x = 128;
		// Integer y = 128;
		// System.out.println(x ==y);
		//
		// System.out.println(3843275 + 8874010 + 15802636 + 18884785 + 152346572);
		testIterator();

	}

	public static void testIterator() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		System.out.println("first: " + list);
		list.set(2, "2re");
		System.out.println("second: " + list);
		ListIterator<String> iterator = list.listIterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			if (next.equals("2re")) {
				iterator.set("haha");
			}
		}
		System.out.println("thrid: " + list);
	}

	public static String financeFormat(double d) {
		String rs = "";
		BigDecimal bd = BigDecimal.valueOf(d);
		int t = 1000, remainder;
		if (d < t) {
			return Double.toString(d);
		} else {
			// System.out.println(bd.toString());
			String[] split = bd.toString().split("\\.");
			// System.out.println(Arrays.toString(split));
			// bd.divideAndRemainder(divisor)
			// String array = val.split(".");
			int temp = Integer.valueOf(split[0]);
			do {
				remainder = (Integer.valueOf(temp) % t);
				temp = Integer.valueOf(temp) / t;
				rs = "," + StringUtils.padding(Integer.toString(remainder), 3, StringUtils.LEFT_PAD, "0") + rs;
			} while (temp >= t);
			rs = temp + rs;
			// if (!pcg_fun.isEmpty(array[1]))
			// rs = rs + "." + array[1];
		}
		return rs;

	}
}
