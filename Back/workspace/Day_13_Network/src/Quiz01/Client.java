package Quiz01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		Socket client = new Socket("192.168.50.6", 25501);
		
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
			
		OutputStream os = client.getOutputStream(); 
		DataOutputStream dos = new DataOutputStream(os);
		
		while(true) {
			System.out.println("+, -, * �� �Է�");
			String ClientMsg = sc.nextLine();
			dos.writeUTF(ClientMsg); 
			dos.flush();

			System.out.println("ù��° ���� �Է�");
			int N1 = Integer.parseInt(sc.nextLine());
			dos.writeInt(N1); 
			dos.flush();
		
			System.out.println("�ι��� ���� �Է�");
			int N2 = Integer.parseInt(sc.nextLine());
			dos.writeInt(N2); 
			dos.flush();
			
			int OperatorMsg = dis.readInt();
			System.out.println("�������� �� ������ :"+OperatorMsg +" �Դϴ�.");
			
			 
			
			
		}
		
	}
}
