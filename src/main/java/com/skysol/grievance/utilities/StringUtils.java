package com.skysol.grievance.utilities;

public class StringUtils {
	
	public static boolean isValidString(String string){
		if(string.isEmpty() || string.equals(null)){
			return false;
		}else{
			if(string.equals("")){
				return false;
			}else{
				return true;
			}
		}
	}
}
