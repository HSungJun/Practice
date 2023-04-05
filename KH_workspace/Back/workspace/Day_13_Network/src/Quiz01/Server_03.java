package Quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server_03 {
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(13579);
		Socket socket = server.accept();
		Manager manager = new Manager();

		System.out.println(socket.getInetAddress() + "로부터 연결");

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		Scanner sc = new Scanner(System.in);

		while (true) {

			int sel = dis.readInt();

			if (sel == 1) {
				System.out.println("연락처 신규 등록 선택");

//				String inputId = (" id를 입력해주세요. ");
//				dos.writeUTF(inputId); 
//				dos.flush();
				String id = dis.readUTF();
				System.out.println("입력된 id: " + id);
				dos.writeUTF(id);
				dos.flush();

				String name = dis.readUTF();
				System.out.println("입력된 이름 : " + name);
				dos.writeUTF(name);
				dos.flush();

				String phone = dis.readUTF();
				System.out.println("입력된 번호 : " + phone);
				dos.writeUTF(phone);
				dos.flush();

				manager.addContact(new Contact(id, name, phone));

				int contact = manager.getContactSize();
				System.out.println("저장된 Contact 갯수 : " + contact);
				dos.writeInt(contact);
				dos.flush();
			} else if (sel == 2) {
				System.out.println("연락처 목록 확인 선택");

//				String repeat = ("연락처 목록 확인");
//				dos.writeUTF(repeat);
//				dos.flush();

				ArrayList<Contact> getcontact = manager.getContact();
//				String listBar = ("Id\t이름\t번호");
//				dos.writeUTF(listBar);
//				dos.flush();
				
				int contactSize = getcontact.size();
					dos.writeInt(contactSize);
					dos.flush();
				
				for (Contact c : getcontact) {
					String contact = (c.getId() + 
							"\t" + c.getName() + 
							"\t" + c.getPhone());
					dos.writeUTF(contact);
					dos.flush();
				}
			} else if (sel == 3) {
				System.out.println("연락처 검색 선택");

				ArrayList<Contact> getcontacts = manager.getContact();

//				String callname = ("이름을 입력해 주세요");
//				dos.writeUTF(callname);
//				dos.flush();
				String name = dis.readUTF();
				
				String first = "";

				for (Contact c : getcontacts) {
					if (c.getName().contains(name)) {

						first += (c.getId() + "\t" + c.getName() + "\t" + c.getPhone() +"\n");
					}
				}
				dos.writeUTF(first);
				dos.flush();
			} else if (sel == 4) {
				System.out.println("연락처 삭제 선택");

				String name = dis.readUTF();

				int remove = manager.removeContact(name);
				if (remove == -1) {
					dos.writeUTF("nak");

				}else {
					dos.writeUTF("ack");
				}
				dos.flush();
			}
		}
	}
}
