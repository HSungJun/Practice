import java.util.Scanner;

public class Calculator {
	
	public static int validNum(String str) {
		Scanner sc = new Scanner(System.in);
		int result;
		while(true) {
			try {
				//System.out.print("ù ��° �� : ");
				System.out.print(str);
				result = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.print("���ڸ� �Է����ּ���. : ");
			}
		}
		return result;
	}
	public static void main(String[] args) {


		//������ �ٱ����� ��������

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(" === ���� ���α׷� === ");
			System.out.print("������ �Է�(+,-,*,/,q[����]) : ");
			String oper = sc.nextLine();
			if(oper.equals("q")) {

				System.out.println("���⸦ �����մϴ�.");
				System.exit(0);

			}else if(oper.equals("+") || oper.equals("-") ||
					oper.equals("*") || oper.equals("/")) { 

				
				
				int num1 = validNum("ù��° ���� �Է��ϼ��� : ");
				
				
				int num2 = validNum("�ι�° ���� �Է��ϼ��� : ");
				
				
//				while(true) {
//					try {
//						System.out.print("ù ��° �� : ");
//						num1 = Integer.parseInt(sc.nextLine());
//						break;
//					} catch (Exception e) {
//						System.out.println("���ڸ� �Է����ּ���.");
//					}
//				}
//
//					while(true) {
//						try {
//
//							System.out.print("�� ��° �� : ");
//							num2 = Integer.parseInt(sc.nextLine());
//							break;
//						} catch (Exception e) {
//							System.out.println("���ڸ� �Է����ּ���.");
//						}
//						//continue;
//						// continue�� ����Ͽ� �ݺ����� �ʱ� ��ġ�� ����
//						//������ �Էºκ����� ���ư��� �ʰ� �ϱ� ���� �߰��� while������ �ٽ� ����
//						//while �� ������ ������ continue�� �ʿ����
//						//while ���� ������ ���� break �� �̿��Ͽ� Ż�����־�� ��
//						//�Է��� ���������� �Ͽ��ٸ� break �۵� > ���� �߻��� �ٽ� �Է��ϵ��� ��
//
//					}
					System.out.println(" === �� �� === ");

					switch(oper) {
					case "+":
						System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
						break;
					case "-":
						System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
						break;
					case "*":
						System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
						break;
					case "/":
						System.out.println(num1 + " / " + num2 + " = " + (num1/(double)num2));
						break;
					}

			}else {
						System.out.println("�����ڸ� �ٽ� �Է����ּ���.");
					}
				}

			}
		}