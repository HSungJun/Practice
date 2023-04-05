package Quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client_03 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		Socket client = new Socket("localhost", 13579);
		Manager manager = new Manager();

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		OutputStream os = client.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		while (true) {

			System.out.println("<<����ó ���� ���α׷�>>");
			System.out.println("1. ����ó �ű� ���");
			System.out.println("2. ����ó ��� Ȯ��");
			System.out.println("3. ����ó �˻� (�̸�)");
			System.out.println("4. ����ó ���� (ID)");
			System.out.print(">>");

			int command = Integer.parseInt(sc.nextLine());

			dos.writeInt(command);

			if (command == 1) {
				System.out.println("����ó �ű� ��� ����");
				// id �Է�, �̸� �Է�, ��ȣ �Է�

				System.out.print("id �Է� : ");
				String id = sc.nextLine();
				dos.writeUTF(id);
				dos.flush();
				
				System.out.println(dis.readUTF());

				System.out.print("name �Է� : ");
				String name = sc.nextLine();
				dos.writeUTF(name);
				dos.flush();

				System.out.println(dis.readUTF());
				
				System.out.print("phone �Է� : ");
				String phone = sc.nextLine();
				dos.writeUTF(phone);
				dos.flush();
				System.out.println(dis.readUTF());
				
				int size = dis.readInt();
				System.out.println(size);

//				int size = manager.getContact().size();
//				System.out.println("����� ����ó ���� : " + size);

			} else if (command == 2) {

				System.out.println("Id\t�̸�\t��ȣ");

//				System.out.println(dis.readUTF());
				
				int contactSize = dis.readInt();
		
				
//				System.out.println(contactSize);
//				for (int i = 0; i < contactSize; i++) {
//					System.out.print(dis.readUTF());
//					System.out.println();
//				}

			} else if (command == 3) {
				System.out.println("����ó �˻� (�̸�)");

				

				String name = sc.nextLine();
				dos.writeUTF(name);
				dos.flush();

				System.out.println("Id\t�̸�\t��ȣ");
				System.out.println(dis.readUTF());

			} else if (command == 4) {
				
				System.out.print("����ó ���� �̸� : ");

				String name = sc.nextLine();
				dos.writeUTF(name);
				dos.flush();

				String condition = dis.readUTF();
				if (condition.equals("ack")) {
					System.out.println("���� ����");
				} else if(condition.equals("nak")) {
					System.out.println("���� ����");
				} else {
					System.err.println("����");
				}
			}
		}
	}
}
