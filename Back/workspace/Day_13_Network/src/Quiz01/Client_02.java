package Quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_02 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Socket client = new Socket("192.168.50.6", 11232);

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		while (true) {
			
			String id = sc.nextLine();
			dos.writeUTF(id); 
			dos.flush();
			
			String name = sc.nextLine();
			dos.writeUTF(name); 
			dos.flush();
			
			String phone = sc.nextLine();
			dos.writeUTF(phone); 
			dos.flush();
			
			String str = dis.readUTF();
			if (str.equals("ack")) {
				System.out.println("저장 완료");
			}else {
				System.out.println("저장 실패");
			}
			
		}
	}
}
