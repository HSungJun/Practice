
public class Exam_05 {
	public static void main(String[] args) {


//sorting 알고리즘 (정렬 알고리즘)
//bubble sort
		int[] arr = new int[] {15,24,35,99,86,34,13,27,46,66};

		
		System.out.println("정렬 전");
		for(int i=0; i<arr.length; i++) {
		System.out.print(arr[i]+" ");
		}
		
		//정렬시 for 문에 length -1 의 이유는 4개의 보기를 정렬할 때에 3번의 왕복을 하기 때문
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1;  j++){
				if(arr[j]>arr[j+1]) {
					int tmp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=tmp;
				}
			}
		}
		System.out.println();
		System.out.println("============");
		System.out.println("정렬후");
		for(int i=0; i<arr.length; i++) {
		System.out.print(arr[i]+" ");
		}
	}
}
