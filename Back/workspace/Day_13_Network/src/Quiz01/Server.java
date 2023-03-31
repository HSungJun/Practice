package Quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(13579);
		Socket socket = server.accept();
		Manager manager = new Manager();

		System.out.println(socket.getInetAddress() + "�κ��� ����");

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		while (true) {

			String id =dis.readUTF();
			System.out.println("�Էµ� id: " + id);
			String name = dis.readUTF();
			System.out.println("�Էµ� �̸� : " + name);
			String phone = dis.readUTF();
			System.out.println("�Էµ� ��ȣ : " + phone);

			
			manager.addContact(new Contact(id, name, phone));
			
			int contact = manager.getContactSize();
			System.out.println("����� Contact ������ : " + contact + " �� �Դϴ�.");

			dos.writeUTF("ack");

		}

	}
}
