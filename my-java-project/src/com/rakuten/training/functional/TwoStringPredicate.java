package com.rakuten.training.functional;

@FunctionalInterface
public interface TwoStringPredicate
{
		boolean isFirstBetterThanSecond(String s1,String s2);
		
}
