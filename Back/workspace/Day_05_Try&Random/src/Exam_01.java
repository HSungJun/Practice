


public class Exam_01 {
	public static void main(String[] args) {
		
		try {
		
		// paseInt �� ���ڿ������� ����"��" �ν�
		// ���� �� ��ü�� �� ��� ����
		int num = Integer.parseInt("123");
		// java.lang.NumberFormatException �̶�� ���� �߻� > ���� �߻����ڸ��� ���α׷�����
		System.out.println("�м��� ���ڴ� : " + num );
		
		
//���� ���� (Throws exception)
//���� ó�� - try { }catch (Exception e) {}	
//try���� ����(����) �߻��� catch �κ����� �̵��Ͽ� �����ڰ� �����ְ��� �ϴ� ��� ����		
//���� �̹߻��� �ڵ� ������ �����ϸ� catch�� �ǳ� ��		
		}catch (Exception e) {
			System.out.println("�м��Ϸ��� �����Ͱ� ������ ���°� �ƴմϴ�.");
		} 
		System.out.println("���α׷� ���� ����.");
	}
}
