package com.skysol.grievance.utilities;

public class StringUtils {
	
	public static boolean isValidString(String string){
		if(string != null && !string.equals("")){
			return true;
		}else{
			return false;
		}
	}
}
