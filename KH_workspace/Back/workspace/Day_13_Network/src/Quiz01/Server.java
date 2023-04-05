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

		System.out.println(socket.getInetAddress() + "로부터 연결");

		OutputStream os = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		while (true) {

			String id =dis.readUTF();
			System.out.println("입력된 id: " + id);
			String name = dis.readUTF();
			System.out.println("입력된 이름 : " + name);
			String phone = dis.readUTF();
			System.out.println("입력된 번호 : " + phone);

			
			manager.addContact(new Contact(id, name, phone));
			
			int contact = manager.getContactSize();
			System.out.println("저장된 Contact 갯수는 : " + contact + " 개 입니다.");

			dos.writeUTF("ack");

		}

	}
}
