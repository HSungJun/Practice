import java.io.File;

import it.sauronsoftware.ftp4j.FTPClient;

public class FTP {
	public static void main(String[] args) {

		FTPClient client = new FTPClient();

		try {
			client.connect("192.168.50.50",21);
		}catch (Exception e) {
			System.out.println("���񽺿� ������ �� �����ϴ�.");
			e.printStackTrace(); // �����߻�Ȯ�ΰ���
		}

		try {
			client.login("java", "1234");
		}catch(Exception e) {
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
			e.printStackTrace();
		}

		try {
		String[] names = client.listNames();
			for(int i=1; i<names.length; i++) {
				System.out.println(names[i]);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		try {							// ctrl shift o
			client.download("download.txt", new File("D:\\202301 ����Ʈ �� ����\\download\\�ٿ��.txt"));
		}catch(Exception e) {
			e.printStackTrace();	
		}

		try {
			client.disconnect(true);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

