import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;

public class FTP_practice {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();





here:		while(true) {
			System.out.println("=== FTP Client Program ===");
			System.out.println("1. Connect FTP Server");
			System.out.println("2. Exit Program");
			System.out.print(">>>>");

			int sel = Integer.parseInt(sc.nextLine());
			if(sel == 1) {
				System.out.println("input url");
				System.out.print(">>>> ");
				try {
					client.connect(sc.nextLine(),21);
				}catch (Exception e) {
					System.out.println("서비스에 접속할 수 없습니다.");
					System.exit(0);
					e.printStackTrace(); // 오류발생확인가능
				}

				try {
					System.out.println("ID 입력 : ");
					String ID = sc.nextLine();

					System.out.println("PW 입력 : ");
					String PW = sc.nextLine();
					client.login(ID,PW);
					System.out.println("Login Success!");
				}catch(Exception e) {
					System.out.println("로그인에 실패하였습니다.");
					System.exit(0);
					e.printStackTrace();
				}

				while(true) {
					System.out.println("===== File =====");
					System.out.println("1. Upload File");
					System.out.println("2. Download File");
					System.out.println("3. Disconnect FTP Server");
					System.out.println("4. Delete File");
					System.out.println();

					int menu = Integer.parseInt(sc.nextLine());

					if(menu == 1) {
						System.out.println("업로드 폴더 내부 파일을 확장자까지 입력하세요.");
						System.out.print(" >> ");
						String filename = sc.nextLine();
						try {							
							client.upload(new File ("D:\\202301 스마트 웹 과정\\upload\\" + filename));
							System.out.println(filename + "업로드 완료");
						}catch(Exception e) {
							e.printStackTrace();	
						}

					}else if (menu == 2) {
						try {
							String[] names = client.listNames();

							for(int i=0; i<names.length; i++) {
								System.out.println(names[i]);
							}
							System.out.println("다운로드 할 파일을 확장자까지 입력해 주세요.");

							String downfile = sc.nextLine();
							client.download(downfile , new File("D:\\202301 스마트 웹 과정\\download\\"+ downfile));
							System.out.println(downfile + "다운로드 완료.");
						}catch(Exception e) {
							e.printStackTrace();
						}

					}else if (menu == 3) {
						try {
							client.disconnect(true);
						}catch (Exception e) {
							e.printStackTrace();
						}System.out.println("연결을 종료합니다.");
						continue here;


					}else if (menu ==4) {
						try {

							String[] names = client.listNames();
							for(int i=1; i<names.length; i++) {
								System.out.println(names[i]);
							}
							System.out.println("삭제할 파일은 확장자까지 입력해주세요.");
							System.out.print("삭제파일 이름 :" );
							String delfile = sc.nextLine();
							client.deleteFile(delfile);

						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}else if (sel == 2) {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}else {
				System.out.println("잘못 입력하셨습니다. 숫자를 입력하세요.");
			}
		}
	}
}

