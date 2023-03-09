import java.util.Scanner;

public class Exam_03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[3];

		int i = 0;
		/*		for(i=0; 1<arr.length; i++) {
			arr[i] = i+1;
			System.out.println(((char)(i+120))+": ");
			arr[i] = Integer.parseInt(sc.nextLine());
		}
		 */
		for(i=0; 1<arr.length; i++) {
			System.out.println("arr["+ i +"] : ");
			arr[i] = Integer.parseInt(sc.nextLine());

			for(i=0; 1<arr.length; i++) {
				System.out.println("arr["+ i +"] : "+ arr[i]);



				//		System.out.print("x: ");
				//		x = Integer.parseInt(sc.nextLine());
				//
				//		System.out.print("y: ");
				//		y = Integer.parseInt(sc.nextLine());
				//		
				//		System.out.print("z: ");
				//		z = Integer.parseInt(sc.nextLine());
				//		
				//		
				//		System.out.println("입력된 값은 ");
				//		System.out.println("x :  "+x);
				//		System.out.println("y :  "+y);
				//		System.out.println("z :  "+z);


			}
		}
	}
}

