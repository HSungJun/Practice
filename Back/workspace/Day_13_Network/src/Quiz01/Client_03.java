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

			System.out.println("<<연락처 관리 프로그램>>");
			System.out.println("1. 연락처 신규 등록");
			System.out.println("2. 연락처 목록 확인");
			System.out.println("3. 연락처 검색 (이름)");
			System.out.println("4. 연락처 삭제 (ID)");
			System.out.print(">>");

			int command = Integer.parseInt(sc.nextLine());

			dos.writeInt(command);

			if (command == 1) {
				System.out.println("연락처 신규 등록 선택");
				// id 입력, 이름 입력, 번호 입력

				System.out.print("id 입력 : ");
				String id = sc.nextLine();
				dos.writeUTF(id);
				dos.flush();
				
				System.out.println(dis.readUTF());

				System.out.print("name 입력 : ");
				String name = sc.nextLine();
				dos.writeUTF(name);
				dos.flush();

				System.out.println(dis.readUTF());
				
				System.out.print("phone 입력 : ");
				String phone = sc.nextLine();
				dos.writeUTF(phone);
				dos.flush();
				System.out.println(dis.readUTF());
				
				int size = dis.readInt();
				System.out.println(size);

//				int size = manager.getContact().size();
//				System.out.println("저장된 연락처 갯수 : " + size);

			} else if (command == 2) {

				System.out.println("Id\t이름\t번호");

//				System.out.println(dis.readUTF());
				
				int contactSize = dis.readInt();
		
				
//				System.out.println(contactSize);
//				for (int i = 0; i < contactSize; i++) {
//					System.out.print(dis.readUTF());
//					System.out.println();
//				}

			} else if (command == 3) {
				System.out.println("연락처 검색 (이름)");

				

				String name = sc.nextLine();
				dos.writeUTF(name);
				dos.flush();

				System.out.println("Id\t이름\t번호");
				System.out.println(dis.readUTF());

			} else if (command == 4) {
				
				System.out.print("연락처 삭제 이름 : ");

				String name = sc.nextLine();
				dos.writeUTF(name);
				dos.flush();

				String condition = dis.readUTF();
				if (condition.equals("ack")) {
					System.out.println("삭제 성공");
				} else if(condition.equals("nak")) {
					System.out.println("삭제 실패");
				} else {
					System.err.println("에러");
				}
			}
		}
	}
}
