package com.org.util;

public class Utility {
	private static final String TRUNCATE_KEY="...(truncated)...";
	public static String truncate(String input,int length){
		if(input.length()<=TRUNCATE_KEY.length()){
		return input;
		}else if(length >= TRUNCATE_KEY.length() && length-1 !=input.length()){
			int leftcharacters= input.length() - length;
			String prefix=input.substring(0, leftcharacters/2);
			String suffix=input.substring(input.length()-leftcharacters/2, input.length());
			String result=prefix+TRUNCATE_KEY+suffix;
			return result;
		}else{
			return input;
		}
	}
}
