package Exam_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

class WriteThread extends Thread {
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
		System.out.println("������ ���� �޼��� : ");
		ClientThread.dos.writeUTF(sc.nextLine());
		ClientThread.dos.flush();
			}catch(Exception e) {
				break;
			}
		}
	}
}




public class ClientThread {
	public static DataOutputStream dos;
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("192.168.50.6", 25262);

		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		OutputStream os = client.getOutputStream();
		
		ClientThread.dos = new DataOutputStream(os);
		
		Scanner sc = new Scanner(System.in);
		new WriteThread().start();
		
		while (true) {
			String msg = dis.readUTF();
			System.out.println("���������� �޼��� : "+msg);
//			JOptionPane.showMessageDialog(null, msg);

//			String strs = JOptionPane.showInputDialog("Ŭ���̾�Ʈ���� ���� �޼���");
//			dos.writeUTF(strs);
//			dos.flush();

		}

	}
}
