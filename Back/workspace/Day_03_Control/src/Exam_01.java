import java.util.Scanner;

// byte		1byte	8bit	-128 ~ 127
// short	2byte	16bit	-32,768 ~ 32,767
// char		2byte	16bit	0 ~ 65535(�����ڵ�)
// int		4byte	32bit	-2,147,483,648 ~ 2,147,483,647
// long		8bit	64bit	-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

// float	4byte	32bit	1.4E-45 ~ 3.4028235E38 (10^-38 ~ 10^38)
// double	8byte	64bit	4.9E-324 ~ 1.7976931348623157E308 (10^-308~ 10^308)

// boolean	1byte	8bit	true / false
// String 
//�� �ΰ����� ����ȯ�� �Ұ���

// void 					���� ������ �ʴ� Ư��������
		


		//System.out.println(3/2); // > 1.5 ������ 1�� ��� 
		
// (�帧)��� > ���� �ݺ� ���� �帧����
// �ڵ�� ��>�Ʒ� �帧 > ����� ���� �帧 ����,����
		
	//���ǹ� (�б⹮)  if ������ ����� ���� ���� ����. if�� ����� ���� �� ��� ���� 
	
	//if (���ǹ�(boolean�� ������ ���Ŀ������ true or false)) 
	//    {���๮;} �� ����

public class Exam_01 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����� �����ϴ� ������ �����Դϱ�?");
		System.out.println("1. ���  2. ���� 3. ����");
		System.out.println(">> ");
		int menu = Integer.parseInt(sc.nextLine());
		
//		if (menu == 1) {
//			System.out.println("����� ����� Apple �Դϴ�. ");
//		}
//		//menu ��� ���� 1 �� ���� >������� �Է�(������ 1���̶��) > true or false
//		//else if > ���Ӽ� ���� > if���� �� �� ���� ��� > �׷��� ������
//		else if (menu == 2) {
//			System.out.println("����� ����� Mango �Դϴ�. ");
//		//else if�� ����ϴ� ��� > ����� ���� ���� ���
//		//if�� �ΰ��� ������� �ϴ� ��쵵 ������
//		}else if (menu ==3) {
//			System.out.println("����� ����� Strawberry �Դϴ�. ");
//		}else {
//			System.out.println("�޴��� �ٽ� Ȯ���� �ּ���. ");
		}//else�� �� ������ ���� �ƴҰ�� ��� �Ұ�ȣ x �߰�ȣ �� ���
	
		//if�� �ȿ� if�� ���� {���ο�} ��ø ����� ���� 
	
		//if�� ���� ������� �Է°��� Ȯ�� �� ���� if������ �����ϵ��� ����
//		if(menu ==1||menu==2||menu==3) {�޴� 123 or else ����}
		

}
