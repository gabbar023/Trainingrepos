package com.rakuten.training.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;


class lambda 
{
	
	
	public static int eChecker(String s1,String s2)
	{
		if(s1.contains("e") && !s2.contains("e"))
			return -1;
		else if(!s1.contains("e") && s2.contains("e"))
	return 1;
		else
			return 0;
	}
	
}

public class lambdaexp 
{
	public static void main(String[] args) 
	{
		String s[]= {"one","Two","Three","Four"};
		ArrayList<String> l=new ArrayList();
		
		l.add("two");
		l.add("1");
		l.add("three");
		
		Arrays.sort(s,(s1,s2)->{return (s1.length()-s2.length());});
		Collections.sort(l, (s1,s2)->{return (s1.length()-s2.length());});
		Arrays.sort(s,lambda::eChecker);
		System.out.println(s[0]+s[1]+s[2]);
		
		//if not static then create obj regerence
		//lambda obj=new lambda();
		//Arrays.sort(s,obj::eChecker);
		
		String longer=betterString("deepak","agarwal",(s1,s2)->s1.length()>s2.length());
		System.out.println(longer);
		
		List<String> ll=lambdaexp.firstmatch(l,s1-> s1.length()< 4);
		System.out.println(ll.toString());
		
		List<String> tlist=lambdaexp.match(l,s1 -> s1+"!");
		System.out.println(tlist.toString());
			
	}
	//Function FunctionalInterface
	public static <T> List<T> match(List<T> str, Function<T,T> matchfunc)
	{	List<T> l=new ArrayList<T>();
		for(T possible:str)
		{
			T tvalue=matchfunc.apply(possible);
			l.add(tvalue);
		}
		return l;
		
	}
	
	//Predicate Func Interface
	public static <T> List<T> firstmatch(List<T> str, Predicate<T> matchfunc)
	{	List<T> l=new ArrayList<T>();
		for(T possible:str)
		{
			if(matchfunc.test(possible))
			{
				l.add(possible);
			}
		}
		return l;
		
	}
	public static String betterString(String s1, String s2, TwoStringPredicate decider)
	{
		if(decider.isFirstBetterThanSecond(s1, s2))
			return s1;
		else 
			return s2;
		
	}
	public static <E> E BetterElement(E s1,E s2,TwoElementPredicate<E> decider)
	{
		if(decider.isFirstBetterThanSecond(s1, s2))
			return s1;
		else
			return s2;
		
	}
	
	
	
}
