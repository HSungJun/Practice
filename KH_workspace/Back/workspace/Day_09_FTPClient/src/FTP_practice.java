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
					System.out.println("���񽺿� ������ �� �����ϴ�.");
					System.exit(0);
					e.printStackTrace(); // �����߻�Ȯ�ΰ���
				}

				try {
					System.out.println("ID �Է� : ");
					String ID = sc.nextLine();

					System.out.println("PW �Է� : ");
					String PW = sc.nextLine();
					client.login(ID,PW);
					System.out.println("Login Success!");
				}catch(Exception e) {
					System.out.println("�α��ο� �����Ͽ����ϴ�.");
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
						System.out.println("���ε� ���� ���� ������ Ȯ���ڱ��� �Է��ϼ���.");
						System.out.print(" >> ");
						String filename = sc.nextLine();
						try {							
							client.upload(new File ("D:\\202301 ����Ʈ �� ����\\upload\\" + filename));
							System.out.println(filename + "���ε� �Ϸ�");
						}catch(Exception e) {
							e.printStackTrace();	
						}

					}else if (menu == 2) {
						try {
							String[] names = client.listNames();

							for(int i=0; i<names.length; i++) {
								System.out.println(names[i]);
							}
							System.out.println("�ٿ�ε� �� ������ Ȯ���ڱ��� �Է��� �ּ���.");

							String downfile = sc.nextLine();
							client.download(downfile , new File("D:\\202301 ����Ʈ �� ����\\download\\"+ downfile));
							System.out.println(downfile + "�ٿ�ε� �Ϸ�.");
						}catch(Exception e) {
							e.printStackTrace();
						}

					}else if (menu == 3) {
						try {
							client.disconnect(true);
						}catch (Exception e) {
							e.printStackTrace();
						}System.out.println("������ �����մϴ�.");
						continue here;


					}else if (menu ==4) {
						try {

							String[] names = client.listNames();
							for(int i=1; i<names.length; i++) {
								System.out.println(names[i]);
							}
							System.out.println("������ ������ Ȯ���ڱ��� �Է����ּ���.");
							System.out.print("�������� �̸� :" );
							String delfile = sc.nextLine();
							client.deleteFile(delfile);

						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}else if (sel == 2) {
				System.out.println("�ý����� �����մϴ�.");
				System.exit(0);
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���ڸ� �Է��ϼ���.");
			}
		}
	}
}

