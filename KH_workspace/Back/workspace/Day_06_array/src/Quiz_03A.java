
public class Quiz_03A {
	public static void main(String[] args) {

		//1~ 45���� ������ ��ø���� �ʰ� 7�� �̾Ƽ� ����ϼ���
		//������ ��õ�ζ� ��ȣ �����


		int[] nums = new int[45];
		for(int i =0; i<nums.length; i++) {
			nums[i] = i+1;
		}// nums[i]�� ���� ���� �� i���� 1���� �����ϵ��� ����

		for(int i = 0; i<nums.length*10; i++) {
			int x = (int)(Math.random()*45);
			int y = (int)(Math.random()*45);

			//int x �� y�� �����ϰ� ����	

			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
			//tmp�� �̿� x,y,tmp���� ��ġ���ʵ��� ���

		}


		System.out.println("��õ �ζǹ�ȣ : " +"\t"+
				nums[0] + "\t"+
				nums[1] + "\t"+
				nums[2] + "\t"+
				nums[3] + "\t"+
				nums[4] + "\t"+
				nums[5] + "\t");
		System.out.println("���ʽ� ��ȣ : \t" + nums[6]);

		/*		int[] lotto = new int [7];
		// 7���� �����ϱ� 7���� ����. ������ �ݺ��� ���ο� ��ġ

		for(int i = 0; i<lotto.length; i++) {
			double ran	= Math.random();
			lotto[i] = (int)(ran*45) +1;			
		}
		 */		

	}
}
