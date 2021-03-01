package com.rakuten.training.basics;

public class ChemicalEle
{	int atomicno;
	String symbol,name;
	static boolean[] alkali=new boolean[120];
	
	static{
	alkali[3]=true;
	
	alkali[11]=true;
	alkali[19]=true;
	alkali[37]=true;
	alkali[55]=true;
	alkali[87]=true;
	}
	public ChemicalEle(int x,String symbol,String name)
	{
		this.atomicno=x;
		this.symbol=symbol;
		this.name=name;
			
	}
	public int getAtomicno() {
		return atomicno;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getName() {
		return name;
	}
	public boolean isAlkali()
	{
		return alkali[atomicno];
	}
		
}