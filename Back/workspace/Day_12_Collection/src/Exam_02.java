import java.util.ArrayList;
import java.util.Scanner;


class A extends Object {
	
}


public class Exam_02 {
	public static void main(String[] args) {
	
		
		A a= new A();
		//a.
		//Java�� ����� �ֻ�ܿ� Object�� �׻� �پ��ִ�.
		
		
		
		
		ArrayList<String> arr = new ArrayList();
//		ArrayList arr = new ArrayList();
	//������
	//add �� ���� ()���� �����͵��� ��ü�� �ν�
	//�ڹ� �� Object �ֻ�� �ڷ��� / ��� Ÿ�Կ� ���� �������� ����
	
	
	Object o = new Scanner(System.in);
	o = new Integer(10); // Auto Boxing �ڵ���ȯ
	
	
	arr.add("Hello");
	arr.add("World");
	arr.add("Collection");
	
	for(int i=0; i<arr.size(); i++) {
	System.out.println(arr.get(i));
	}
	
	
	//fir rich�� // �����ʿ� collection �� �����Ѵٴ� �����Ͽ� ���
	//�ݺ��� Ƚ���� ���Ǹ� �� �� ����. ������ �迭(�Ǵ� collection)�� ���� �ݺ�
	// for ( : ) : ������ collection ���� �����Ͱ� ������ �Է�
	// �ڽ��� ������ �ִ� ��ҿ��� �ݺ��� ������ �������� ����.
	// ������ ������ �����͸� ���� ���������� ������ �Է�
	// ���� ��Ұ� �����ҽÿ� ��� �ݺ� 
	for( String str : arr ) {
		System.out.println(str);
	}
		
		
		
//	arr.add(10);
	
//	System.out.println(((String)arr.get(2)).length());
	
//	System.out.println(arr.get(0));
//	System.out.println(arr.get(1));
//	System.out.println(arr.get(2));
	
//	arr.remove(0);
//	
//	arr.add(1,"Java");
//	
//	
//	System.out.println(arr.get(0));
//	System.out.println(arr.get(1));
//	System.out.println(arr.get(2));
//
//	System.out.println(arr.size());
	
	//�迭�� ��� arr[i] = 10; ������ ��ȣ�� �̿��Ͽ�����, ArrayList�� .add(i)�� �̿��Ѵ�.
	
	
	}
}
