package Quiz03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread {
	public void run() {
		while(true) {
			
		}
	}
}





public class ServerFile {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		try {
			server = new ServerSocket(13579);
		}catch (Exception e) {
			System.out.println("��������");
		}
		System.out.println("���� ����");
		
		while(true) {
			Socket sock = null;
			try {
			DataOutputStream dos = new DataOutputStream(sock.getOutputStream());
			DataInputStream dis = new DataInputStream(sock.getInputStream());
			
			File root = new File("D:\\202301 ����Ʈ �� ����\\FTP");
			File[] fileList = root.listFiles();
			
			for(File f : fileList) {
				dos.writeUTF(f.getName());
				dos.flush();
			}
		
			String targetName = dis.readUTF();
			System.out.println(sock.getInetAddress()+ "���� ������ ���� : " + targetName);
			
			File target = new File(root.getAbsoluteFile()+"/"+targetName);
			DataInputStream fileDis = new DataInputStream(new FileInputStream(target));
			byte[] fileContents = new byte[(int)target.length()];
			fileDis.readFully(fileContents);
			
			dos.writeInt((int) target.length());
			
	
			}catch(Exception e) {
				
			}
		}
	}
}
