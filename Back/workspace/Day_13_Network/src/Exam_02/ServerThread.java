package Exam_02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

class ReadThread extends Thread{
	public void run() {
		while(true) {
			try {
				String msg = ServerThread.dis.readUTF();
				System.out.println("Ŭ���̾�Ʈ�κ��� �޼��� : " +msg);
			}catch(Exception e) {
				
			}
			
		}
	}
}



public class ServerThread {
	public static DataInputStream dis;
	public static void main(String[] args) throws Exception {

		ServerSocket server = new ServerSocket(17772);

		Socket socket = server.accept();
		// �������� �ν��Ͻ��� ��ī�带 �ν� > ���� return
		System.out.println(socket.getInetAddress() + "�� ���� ����");

		OutputStream os = socket.getOutputStream(); // socket�� os�� ����
		DataOutputStream dos = new DataOutputStream(os); // os�� dos �� ���׷��̵�
		//���������� �����
		InputStream is = socket.getInputStream();
		dis = new DataInputStream(is);
		
		Scanner sc = new Scanner(System.in);
		new ReadThread().start();
		while (true) {
			System.out.println("Ŭ���̾�Ʈ���� ���� �޼���");
			dos.writeUTF(sc.nextLine()); // �����͸� Ʈ���� �Ǿ��
			dos.flush(); // �����͸� ���� Ʈ�� ��� (��ƹ�����) (�����͸� ������)
//			JOptionpane.show
			
			
		}
	}
}
// Server - ��Ʈ��ũ �󿡼� ���񽺸� �����ϴ� ���
// Client - �����Ǵ� ���񽺸� �̿��ϴ� ��
// IP�ּ� - ��Ʈ��ũ �󿡼� ��� �ĺ��ϴ� ���� �ּҰ�
// port��ȣ - �Ѵ��� ��� �ȿ��� ���񽺸� �ĺ��ϴ� ���� �ּҰ� (�ߺ� �Ұ���)
// 		0~65535 �� ���� ���/ 0~1024 : Well Known ��Ʈ�� ����� �ָ���. 
// socket - ��Ʈ��ũ ���α׷� �󿡼� ��ż����� ���� �ܸ��� ����(������ �����μ� �ν��Ͻ����·� ����) 
// ServerSocket - 1:n ����� �����ϴ� ���� Ư����, Socket�� ���������� ���� Socket������ �ʿ�. 
//		ServerSocket�� �� ������ ���� 
// Stream - ���α׷����� �����͸� �ְ�ޱ� ���� Open�ϴ� �ٸ� (���)
//		output, input �� ������.