package exams;
import java.util.Scanner;

import Custom.TV;

public class Exam_01 {
	public static void main(String[] args) {
		
		TV lg = new TV();
		//TV �ν��Ͻ��� heap�޸𸮿� ������ �ּҸ� lg��� ������ ��.
		//lg.~ �� ��� �ʵ带 ���� ��� �� �� ����.
		
		lg.setChannel(10);
		lg.setBrand("LG");
		lg.setPrice(1200000);
		lg.setWeight(7);
		
		System.out.println(lg.getWeight()+"kg");
		
//		heap �޸𸮿� TV���� and �ּҸ� ���� �Ŀ� samsung���� �� �ּҸ� ������ ���
//Ŭ������ ����� �����ڷ������� �����Ҽ��ִ�.
//TV�� �ּҸ� ������ ���� ������ ����� ��.
		
//		new TV(); > ������ ��Ƶξ�� �Ѵ�.
		
//		new �� ���� heap�޸𸮿� ����
//		new �� ���ؼ� ������� TV �� (��ü)Instance ��� �� / TV instance�� ������
//		new �� heap �޸𸮿� TV�� �����ϰ� �� �ּҸ� new ��ġ�� return & ����

		
//		samsung �̶�� ���� ã�ư��ڴ� > .
//		Ctrl+Space �� Ȯ�� TV class �� ������ brand Price ���� ������ �������ִ�
		
//		Scanner sc = new Scanner(System.in);
//		Scanner Ŭ����(���赵) heap �Ÿ� �� Scanner�� �ּҸ� sc ��� ������ ���� 
//		String str = sc.nextLine();

		
		
		
		
	}
}
