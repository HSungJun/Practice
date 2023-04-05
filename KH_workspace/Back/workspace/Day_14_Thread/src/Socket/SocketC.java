package Socket;

import java.io.DataInputStream;
import java.net.Socket;

public class SocketC extends Thread{

	
	private Socket sock;

	public SocketC(Socket sock) {
		this.sock = sock;

	}

	public void run() {
		try {
			System.out.println(sock.getInetAddress() + "로부터 연결");
			DataInputStream dis = new DataInputStream(sock.getInputStream());

			while (true) {
				String msg = dis.readUTF();
				System.out.println(sock.getInetAddress() + ";" + msg);
			}
		} catch (Exception e) {
			System.out.println(sock.getInetAddress() + "접속해제");
		}
	}
}
