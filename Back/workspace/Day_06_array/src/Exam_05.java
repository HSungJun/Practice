
public class Exam_05 {
	public static void main(String[] args) {


//sorting �˰��� (���� �˰���)
//bubble sort
		int[] arr = new int[] {15,24,35,99,86,34,13,27,46,66};

		
		System.out.println("���� ��");
		for(int i=0; i<arr.length; i++) {
		System.out.print(arr[i]+" ");
		}
		
		//���Ľ� for ���� length -1 �� ������ 4���� ���⸦ ������ ���� 3���� �պ��� �ϱ� ����
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
		System.out.println("������");
		for(int i=0; i<arr.length; i++) {
		System.out.print(arr[i]+" ");
		}
	}
}
