
public class Exam_06 {
	public static void main(String[] args) {


		//		System.out.println((int)(Math.random()*5+1));
		//		System.out.println((int)(Math.random()*5+1));
		//		System.out.println((int)(Math.random()*5+1));
		// 중복 발생		

		//1,2,3,4,5 를 뒤섞으면서 그중 앞에서 3가지를 출력.
		
		
		int[] nums= new int [] {1,2,3,4,5};

		for(int i = 0; i < nums.length*10; i++) {
			// nums.length*10 의 경우 하단의 tmp가 충분한 변경을 할 정도면 어느 수든 가능
			int x = (int)(Math.random()*5);
			int y = (int)(Math.random()*5);

			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
		}
		System.out.println(nums[0]);
		System.out.println(nums[1]);
		System.out.println(nums[2]);
	}
}
