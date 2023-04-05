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

		System.out.println(socket.getInetAddress() + "�κ��� ����");

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		Scanner sc = new Scanner(System.in);

		while (true) {

			int sel = dis.readInt();

			if (sel == 1) {
				System.out.println("����ó �ű� ��� ����");

//				String inputId = (" id�� �Է����ּ���. ");
//				dos.writeUTF(inputId); 
//				dos.flush();
				String id = dis.readUTF();
				System.out.println("�Էµ� id: " + id);
				dos.writeUTF(id);
				dos.flush();

				String name = dis.readUTF();
				System.out.println("�Էµ� �̸� : " + name);
				dos.writeUTF(name);
				dos.flush();

				String phone = dis.readUTF();
				System.out.println("�Էµ� ��ȣ : " + phone);
				dos.writeUTF(phone);
				dos.flush();

				manager.addContact(new Contact(id, name, phone));

				int contact = manager.getContactSize();
				System.out.println("����� Contact ���� : " + contact);
				dos.writeInt(contact);
				dos.flush();
			} else if (sel == 2) {
				System.out.println("����ó ��� Ȯ�� ����");

//				String repeat = ("����ó ��� Ȯ��");
//				dos.writeUTF(repeat);
//				dos.flush();

				ArrayList<Contact> getcontact = manager.getContact();
//				String listBar = ("Id\t�̸�\t��ȣ");
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
				System.out.println("����ó �˻� ����");

				ArrayList<Contact> getcontacts = manager.getContact();

//				String callname = ("�̸��� �Է��� �ּ���");
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
				System.out.println("����ó ���� ����");

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
