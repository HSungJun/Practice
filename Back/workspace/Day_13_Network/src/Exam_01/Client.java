package Exam_01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception {
		
		Socket client = new Socket("192.168.50.6", 25262);
		
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
			
		OutputStream os = client.getOutputStream(); 
		DataOutputStream dos = new DataOutputStream(os);
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String msg = dis.readUTF();
			JOptionPane.showMessageDialog(null, msg);
					
			String strs = JOptionPane.showInputDialog("클라이언트에게 보낼 메세지");
			dos.writeUTF(strs);
			dos.flush();
			
			
		}
		
		
	}
}
