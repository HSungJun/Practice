
public class Exam02 {
	public static void main(String[] args) {
		
//		Math.random(); // random = �Ű������� ���� return ���� double
	
		String str = "Hello World";
		
		int length = str.length();
		
		char a = str.charAt(3); 
		int b = str.charAt(3); // (index)�� ��ġ�� char
		// (str)������ ����Ű�� ���ڿ��� (n(=0���� ����))��° ���ڸ� (int or char)�ۼ��� �Ű������� ��ȯ�Ѵ�
		System.out.println(a);
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(3));
		System.out.println(b);
		

		System.out.println();
		String str1 = "l";
		// ��ġ�ϴ� ���� ������ ��ġ(n��°) ��� > ������ -1
		System.out.println(str.indexOf("A")); // -1 ���
		System.out.println(str.indexOf(str1)); // ������� l �� ��ġ�� 2 ���
		
		System.out.println();
		str.startsWith(str1);
//		public boolean startsWith(String prefix) {
//	        return startsWith(prefix, 0);
//	    } prefix = ���λ� > �Ű����� boolean �̱⋚���� true false �� ����
		
		// ���ڿ��� �Ű������� ���޵� ("���ڿ�")�� �����ϴ��� true or false Ȯ��
		System.out.println(str.startsWith("H"));
		System.out.println(str.startsWith("e"));
		System.out.println(str.endsWith("d"));
		// startsWith �� endsWith�� �ݴ밳��
		System.out.println();
		
		System.out.println(str.equals("d"));
		System.out.println(str.equals("Hello World"));
		// ���� ���ڿ����� true false ���
		
		System.out.println();
		System.out.println(str.contains(str1));
		System.out.println(str.contains("s"));
		// ���ڿ� ���ο� (���ڿ� Ȥ�� ����)�� ���ԵǾ��ִ���.
		
		System.out.println();
		String [] arr = str.split(" ");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		
		
		
		
	}
}
