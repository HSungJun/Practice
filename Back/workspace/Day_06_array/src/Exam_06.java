
public class Exam_06 {
	public static void main(String[] args) {


		//		System.out.println((int)(Math.random()*5+1));
		//		System.out.println((int)(Math.random()*5+1));
		//		System.out.println((int)(Math.random()*5+1));
		// �ߺ� �߻�		

		//1,2,3,4,5 �� �ڼ����鼭 ���� �տ��� 3������ ���.
		
		
		int[] nums= new int [] {1,2,3,4,5};

		for(int i = 0; i < nums.length*10; i++) {
			// nums.length*10 �� ��� �ϴ��� tmp�� ����� ������ �� ������ ��� ���� ����
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
