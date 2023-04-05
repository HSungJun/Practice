
public class Star {
	public static void main(String[] args) {

		String st = "☆☆☆☆☆";

		for(int i =0; i<5; i++) {		// i가 0일때 o 0 하나출력, i 1일때 o 0,1 두개출력, i 2일때 o 0,1,2 세개출력
			for(int o=0; o<=i; o++) {	
				System.out.print(st);		
				}
			System.out.println();
		}	
	
	
	}
}