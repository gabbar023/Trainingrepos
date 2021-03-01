package com.rakuten.training.functional;

@FunctionalInterface
public interface TwoElementPredicate<E> 
{
	public boolean isFirstBetterThanSecond(E s1,E s2);
	
}
