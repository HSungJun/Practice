package main;

import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) {
		
		//to_char(sysdate, 'YYYYMMDD HH:MI:SS');
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd hh:mm:ss");
		
		
		String result = sdf.format(System.currentTimeMillis());

		System.out.println(result);
		
		
		
	}

}
