package net.classnotfound.demo.kalkulathor.operation;

public class Time implements Operation {

	@Override
	public long calculate(long a, long b) {
		return a*b;
	}

}
