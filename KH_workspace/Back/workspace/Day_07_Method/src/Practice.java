
public class Practice {

	//�� ������ ���ڷ� ���޹޾� ������ ����� ��ȯ�ϴ� Minus �޼���
	public static int minus(int num1, int num2) {
		int result = (num1 - num2);
		return result;
	}


	//�� ������ ���ڷ� ���޹޾� �������� ����� �Ǽ��� ��ȯ�ϴ� divide �޼���
	public static int divide(int num1, int num2) {
		int result = (num1/num2);
		return result;
	}



	//�� ������ ���ڷ� ���޹޾� �� ū���� ��ȯ�ϴ� bigger �ż���
	//�� ���� ���ٸ� 0�� ��ȯ
	public static int bigger (int num1, int num2) {
		int result = 0;
		if(num1<num2) {
			result = num2;
		}else if (num1 == num2) {
			result = 0;
		}else if (num1 > num2) {
			result = num1;
		}return result;
	}

	// "���"�� ���ڷ� �����ϸ� Apple, "����" �� ���ڷ� �����ϸ� Strawberry�� ��ȯ�ϴ�
	// Translate �޼��� ���� �ٸ����� none


	public static String translate(String a) {
		// �޼ҵ� ����
		if(a.equals("����")) {
			a = "Strawberry";
		}else if (a.equals("���")) {
			a = "Apple";
		}else { a= "none";}
		return a;
		
	}// ==�� ������� �ʴ� ������ ���ڿ� �̱� ���� > �ּҰ��ƴ� ���ڸ� ���Ұű� ������ equals ��� 
	// == �� ��½� true �� ������ ������ ���ڿ��� ����� ���� ������ ���Ŀ��� �� ���ڿ��� �ּҸ� ����. 
	// ��� �ּҰ� ���� ������ true ���
	//(���� ���ڿ� ����� shared string pool)

	//�Է¹������� ����(day4 exam6)�� ��� n�� �Է¹޾� �Է¹޾ƾ��ϱ⶧���� �����ϰ� ������
	//Day_04 Teachers_code Method or Daay_07 Calculator�� Method �� ����
	
	
	public static void main(String[] args) {
		System.out.println(minus(10,2));
		System.out.println(divide(10,2));
		System.out.println(bigger(10,5));
		System.out.println(translate("����"));
		System.out.println(translate("���"));
		System.out.println(translate("����"));
		

	}
}
