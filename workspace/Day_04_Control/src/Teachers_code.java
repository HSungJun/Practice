import java.util.Scanner;

public class Teachers_code {
	
	public static int validNum() {
		Scanner sc = new Scanner(System.in);
		int result;
		while(true) {
			try {
				//System.out.print("첫 번째 수 : ");
				result = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.print("숫자만 입력해주세요. : ");
			}
		}
		return result;
	}
	public static void main(String[] args) {


		//변수를 바깥으로 꺼내놓음

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(" === 계산기 프로그램 === ");
			System.out.print("연산자 입력(+,-,*,/,q[종료]) : ");
			String oper = sc.nextLine();
			if(oper.equals("q")) {

				System.out.println("계산기를 종료합니다.");
				System.exit(0);

			}else if(oper.equals("+") || oper.equals("-") ||
					oper.equals("*") || oper.equals("/")) { 

				
				System.out.print("첫번째 수를 입력하세요 : ");
				int num1 = validNum();
				
				System.out.print("두번째 수를 입력하세요 : ");
				int num2 = validNum();
				
				
//				while(true) {
//					try {
//						System.out.print("첫 번째 수 : ");
//						num1 = Integer.parseInt(sc.nextLine());
//						break;
//					} catch (Exception e) {
//						System.out.println("숫자만 입력해주세요.");
//					}
//				}
//
//					while(true) {
//						try {
//
//							System.out.print("두 번째 수 : ");
//							num2 = Integer.parseInt(sc.nextLine());
//							break;
//						} catch (Exception e) {
//							System.out.println("숫자만 입력해주세요.");
//						}
//						//continue;
//						// continue를 사용하여 반복문의 초기 위치로 복귀
//						//연산자 입력부분으로 돌아가지 않게 하기 위해 중간에 while문으로 다시 묶음
//						//while 로 묶었기 때문에 continue가 필요없음
//						//while 문을 나가기 위해 break 를 이용하여 탈출해주어야 함
//						//입력을 정상적으로 하였다면 break 작동 > 예외 발생시 다시 입력하도록 함
//
//					}
					System.out.println(" === 결 과 === ");

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
						System.out.println("연산자를 다시 입력해주세요.");
					}
				}

			}
		}
