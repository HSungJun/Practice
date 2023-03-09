package Socket;

import java.net.ServerSocket;
import java.net.Socket;



public class SocketS {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		
		try {
			server = new ServerSocket(11111);
		}catch(Exception e) {
			System.out.println("서버를 구동할 수 없습니다.");
			System.exit(0);
		}
		System.out.println("서버를 가동했습니다.");
	
	while(true) {
		Socket sock = null;
		try {
			sock=server.accept();
			SocketC ct = new SocketC(sock);
			ct.start();
		}catch (Exception e) {
			System.out.println(sock.getInetAddress()+"로부터");
		}
		
	}
	
	
	
	
	}
}
