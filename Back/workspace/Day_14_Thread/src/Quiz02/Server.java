package Quiz02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket server = null;
	try {
		server = new ServerSocket(45000);
	}catch (Exception e) {
		System.exit(0);
		
	}
	 System.out.println("������ �����߽��ϴ�.");	
	 while(true) {
		 Socket sock = null;
		 try {
			 sock = server.accept();
			 System.out.println(sock.getInetAddress()+"�� ���� ����");
			 
			 DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			 
			 File root = new File("D:\\202301 ����Ʈ �� ����\\FTP\\mysong.mp3");

			 FileInputStream fis = new FileInputStream(root);
			 DataInputStream dis = new DataInputStream(fis);
			 
			 byte[] fileContents = new byte[(int)root.length()];
			 
			 
			 dis.readFully(fileContents);
			 
			 dos.writeInt((int)root.length());
			 dos.flush();
			 
			 dos.write(fileContents);
			 dos.flush();
			 
			 
		 }catch(Exception e) {
			 
		 }
		 
	 
	 }
	}
}
