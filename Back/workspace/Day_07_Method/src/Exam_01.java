
import java.util.Scanner;

/*Method - �μ��� ���޹޾� �۾� �� ����� ��ȯ�ϴ� �ڵ�
class, mai

*/
public class Exam_01 { // ȸ���
	//Method - ���� �߰�
	//public static (��������) (���Ǻ� �̸�)(��������)(������1,������2...)
	//�������� ������a = ������1 (���) ������2;
	//	return ������a; 
	
	
	//return data type �ǵ������� �������� �ڷ��� > Method �� ���۸��
	//Method ���Ǻ�(Definition)
	public static /*�ϴ� ��*/ int plus(int num1, int num2){
		int result = num1 + num2; 
		return result; 
		//Method�� �ݵ� �κ����� ���ư���.
		
	}
	//���ڰ� ��ġ�� ������ ������ ���ƾ� �޾� �۵�
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	//main�� ���α׷��� ������ / ���� - ��ó����
		
		int result = plus(10,5);
		System.out.println(result);
		
		
		sc.nextLine();
		// String�� ����
//		 public String nextLine() {
//		        modCount++;
//		        if (hasNextPattern == linePattern())
//		            return getCachedResult();
//		        clearCaches();
//		���ڰ��� �����Ƿ� �Ű�����(�κ��� �������) 
		
		
		Math.random();
		// == double �� ����
//		 public static double random() {
//		        return RandomNumberGeneratorHolder.randomNumberGenerator.nextDouble();
//		    }
		//double random()
		
		
		int kor = Integer.parseInt(sc.nextLine());
		//Stting �� �Ű������μ� ���� ������ nextLine�� ����  parseInt��  
		// int ������ ����
		
		// public static int parseInt(String s) throws NumberFormatException {
		//     return parseInt(s,10);
		//    }
		//sc.nextLine
		//parseInt�� ���ڰ� > sc.nextLine() > �� ���ڰ�
		//int parseInt(String str)
		
		
		
		
		// plus(x,y) << Method call (�ż��� ȣ���)
		//plus Method�� ���Ѵ�. ()�� (���ڰ� �Ǵ� �μ���)(parameter, argument)���� ǥ���Ѵ�.
		//Method�� ���޵Ǿ����� ���� �޴� ������ �Ű����� ��� �Ѵ�
		//��� �� ()�϶��� if ���� ����� �ƴ��̻� ���� Method call
		/*
		System.out.println(result);		ȣ���
		sc.nextLine();					���Ǻδ� JRE �ý��� ���ο� ����
		Integer.parseInt(); 			
		Math.random();					
		
		������ ���� plus >>> ��������� Method
		������ ���� Ÿ�� JRE System Library �� ����Ǿ��ִ� Method >>> Standard ���� Method
		 */



		
		
		
	}
}