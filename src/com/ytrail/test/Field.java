package com.ytrail.test;

public class Field {

	public int antIndex;
	public boolean hasAnt = false;
	public boolean hasWheat = false;

	public String toString() {
		String s;
		
		if (hasAnt)
			s = "A";
		else
			s = " ";
		
		if (hasWheat)
			s += "W";
		else
			s += " ";
		
		return s;
	}
}
