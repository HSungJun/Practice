//프로모션 및 캐스팅

public class Exam_03 {
	public static void main(String[] args) {
		
		byte b = 10;
		char ch = 'A';
		int i = 100;
		long l = 1000L;
		
		/*1*/ b= (byte)i;
		/*2*/ ch = (char)b;
		/*3*/ short s = (short)ch;
	// 4번의 경우 프로모션
		/*4*/ float f = (float)l;
	// 5번의 경우 프로모션
		/*5*/ i = (int)ch;
	
	}
}
