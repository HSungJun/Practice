package Custom;
/* Class -������� �ϴ� ����� ���赵
 * 		Member Field, Member Method, Constructor


*/
public class Temp {			//static�� ������ ���� ��Ī�� ����
	public int a; 			//Instance Member Field > Temp Class�� �̿��Ͽ� Instance�� �����ؾ� a �� �����ϴ°��̱� ����
	public static int b;	//Class Member Field / �������� > main�� ������ �� ���������� �ڸ��� �����ϱ� ����
	
	// temp Instance �� a �� �Բ� ����
	// static ������ main�� ���۵��ڸ��� RAM�� data������ ���� 
	// static class Member Field�� �ϳ��� ����. a�� instance���� ���� ����(Exam_04 > t1,t2,t3...)
	
	//static 
	
	public void func1() {
		//non static�� func1�� call �ҽ� Temp instance�� �����Ǳ⶧���� a������ ����. b�� �׻� �ֱ⿡ �� �� ��밡��
	}
	public static void func2() {
		//a = 1; static�� �ִ°� ������𼭵� ����� �� ������ a��� ������ �޸𸮻� �׻����������ʱ� ������ ������ ����. 
		// static ��ҿ��� non-static ��Ҹ� ����� �� ����.
	}
	
}
