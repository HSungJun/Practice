
public class Quiz_01 {
	
	public static int myRand(int min, int max) {
		return (int)(Math.random() * (max - min +1) + min);
		
		
//		num1 = (int)(Math.random());
//		num2 = (int)(Math.random());
//		
//		int[] arr1 = new int[num1];
//		int[] arr2 = new int[num2];
//		
//		for(int i = 0; i<arr1.length*10; i++) {
//			int x = (int)(Math.random()*num1);
//			int y = (int)(Math.random()*num1);
//			
//		for(int a = 0; i<arr2.length*10; i++) {
//			int b = (int)(Math.random()*num1);
//			int c = (int)(Math.random()*num1);
		
			
			
//		return result;
	}
	
	public static void main(String[] args) {
	
		for(int i=0; i<20; i++) {
		System.out.print(myRand(0,9)+"\t");
		System.out.print(myRand(1,10)+"\t");
		System.out.print(myRand(20,35)+"\t");
		System.out.println(myRand(0,1)+"\t");
		
		}
		
		
		
		
}
}
