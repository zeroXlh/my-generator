package com.zero.my_generator;

import java.time.LocalDateTime;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TimerDemo {
	public static void main(String[] args) {
		Timer timer = new Timer("my timer");

		MyTimerTask task = new MyTimerTask();

		timer.scheduleAtFixedRate(task, 0, TimeUnit.SECONDS.toMillis(10));
		
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());

	}
}

class MyTimerTask extends TimerTask {
	MyQueue myQueue = new MyQueue();

	MyExecutor s = new MyExecutor();

	@Override
	public void run() {
		myQueue.add(new Runnable() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread() + ": Runnable " + System.currentTimeMillis());
			}
		});

		s.s(myQueue);
	}

}

class MyExecutor {
	ExecutorService executorService = Executors.newFixedThreadPool(20);

	public void execute(Runnable runnable) {
		executorService.execute(runnable);
	}

	public void s(MyQueue myQueue) {
		while (!myQueue.isEmpty())
			executorService.execute(myQueue.poll());
	}
}

class MyQueue {
	private Queue<Runnable> queue = new ConcurrentLinkedQueue<>();

	public boolean add(Runnable runnable) {
		return queue.add(runnable);
	}

	public Runnable poll() {
		return queue.poll();
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
