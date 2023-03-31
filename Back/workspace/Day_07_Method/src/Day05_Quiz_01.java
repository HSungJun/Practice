
public class Day05_Quiz_01 {
	public static void main(String[] args) {
	
		double ran = Math.random();
		System.out.println("0~9까지의 랜덤 수 : "+(int)(ran*10));
		System.out.println("1~10까지의 랜덤 수 : "+(int)((ran*10)+1));
		System.out.println("20~35까지의 랜덤 수 : "+(int)(ran*16)+20);
		
		System.out.println("0 또는 1 : "+(int)(ran*2));
		
		
		
}
}
