package com.example.youtubeexplorer.helperclasses;

import android.content.Context;
import android.widget.Toast;

public class Utils {
	
	private static boolean debugON = true;

	private static boolean toastON = true;

	public static void printMe(Object object){
		if(debugON){

			if(object.toString().length() > 4000) {
				for(int i=0;i<object.toString().length();i+=4000){
					if(i+4000<object.toString().length())
						System.out.println("TAG"+i+" "+object.toString().substring(i, i+4000));
					else
						System.out.println("TAG"+i+" "+object.toString().substring(i, object.toString().length()));
				}
			} else
				System.out.println("TAG0 "+object);
		}
	}

	public static void toastMe(Context context, String message, int duration){
		if(toastON){
			if(duration==0)
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			else
				Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	}

}
