
public class Quiz_03A {
	public static void main(String[] args) {

		//1~ 45사이 난수를 중첩되지 않게 7개 뽑아서 출력하세요
		//오늘의 추천로또 번호 만들기


		int[] nums = new int[45];
		for(int i =0; i<nums.length; i++) {
			nums[i] = i+1;
		}// nums[i]의 범위 지정 후 i값을 1부터 시작하도록 설정

		for(int i = 0; i<nums.length*10; i++) {
			int x = (int)(Math.random()*45);
			int y = (int)(Math.random()*45);

			//int x 와 y를 랜덤하게 설정	

			int tmp = nums[x];
			nums[x] = nums[y];
			nums[y] = tmp;
			//tmp를 이용 x,y,tmp값을 겹치지않도록 명령

		}


		System.out.println("추천 로또번호 : " +"\t"+
				nums[0] + "\t"+
				nums[1] + "\t"+
				nums[2] + "\t"+
				nums[3] + "\t"+
				nums[4] + "\t"+
				nums[5] + "\t");
		System.out.println("보너스 번호 : \t" + nums[6]);

		/*		int[] lotto = new int [7];
		// 7개를 뽑으니까 7개로 지정. 난수는 반복문 내부에 위치

		for(int i = 0; i<lotto.length; i++) {
			double ran	= Math.random();
			lotto[i] = (int)(ran*45) +1;			
		}
		 */		

	}
}
