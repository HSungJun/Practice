import java.io.File;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;

public class FTPTool {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FTPClient client = new FTPClient();




		try {
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
				System.out.println("ID 입력 : ");
				String ID = ("java");
				while(true) {
					int pw = 0;
					String PW;
					
					for(pw = 0; pw < 10000; pw++) {
						
					try {
						System.out.println("PW 입력 : ");
						
						PW = Integer.toString(pw);

						client.login(ID,PW);
						System.out.println("Login Success!");
						break;
					}catch(Exception e) {
							System.out.println(pw +"만큼 로그인에 실패하였습니다.");
							continue;
						}
					}
					break;
				}

				
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
						}catch(Exception e) {
							e.printStackTrace();	
						}

					}else if (menu == 2) {
						try {
							String[] names = client.listNames();
							for(int i=1; i<names.length; i++) {
								System.out.println(names[i]);
							}
							System.out.println("다운로드 할 파일을 확장자까지 입력해 주세요.");

							String downfile = sc.nextLine();
							if (downfile == "back") {
							}
							client.download(downfile , new File("D:\\202301 스마트 웹 과정\\download\\"+ downfile));

						}catch(Exception e) {
							e.printStackTrace();
						}

					}else if (menu == 3) {
						try {
							client.disconnect(true);
						}catch (Exception e) {
							e.printStackTrace();
						}System.out.println("연결을 종료합니다.");
					}else if (menu ==4) {
						try {

							String[] names = client.listNames();
							for(int i=1; i<names.length; i++) {
								System.out.println(names[i]);
							}
							System.out.println("삭제할 파일은 확장자까지 입력해주세요.");

						}catch (Exception e) {
							e.printStackTrace();
						}
					}
					String delfile = sc.nextLine();
					client.deleteFile(delfile);

				}else if (sel == 2) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}else {
					System.out.println("잘못 입력하셨습니다. 숫자를 입력하세요.");
				}


			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				System.exit(0);
			}





		}
	}
