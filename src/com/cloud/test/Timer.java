package com.cloud.test;

public class Timer {
	private final long milliSeconds;
	Timer() {
		this.milliSeconds = System.currentTimeMillis();
	}
	public double runTime() {
		return (System.currentTimeMillis() - this.milliSeconds) / 1000.0;
	}
}
