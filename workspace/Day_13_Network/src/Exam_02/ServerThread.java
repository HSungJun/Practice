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
				System.out.println("클라이언트로부터 메세지 : " +msg);
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
		// 서버소켓 인스턴스가 랜카드를 인식 > 소켓 return
		System.out.println(socket.getInetAddress() + "로 부터 연결");

		OutputStream os = socket.getOutputStream(); // socket을 os에 연결
		DataOutputStream dos = new DataOutputStream(os); // os를 dos 로 업그레이드
		//프로토콜을 맞춘다
		InputStream is = socket.getInputStream();
		dis = new DataInputStream(is);
		
		Scanner sc = new Scanner(System.in);
		new ReadThread().start();
		while (true) {
			System.out.println("클라이언트에게 보낼 메세지");
			dos.writeUTF(sc.nextLine()); // 데이터를 트럭에 실어라
			dos.flush(); // 데이터를 실은 트럭 출발 (쏟아버리다) (데이터를 보내라)
//			JOptionpane.show
			
			
		}
	}
}
// Server - 네트워크 상에서 서비스를 제공하는 장비
// Client - 제공되는 서비스를 이용하는 고객
// IP주소 - 네트워크 상에서 장비를 식별하는 고유 주소값
// port번호 - 한대의 장비 안에서 서비스를 식별하는 고유 주소값 (중복 불가능)
// 		0~65535 번 까지 사용/ 0~1024 : Well Known 포트로 사용을 멀리함. 
// socket - 네트워크 프로그램 상에서 통신수행을 위한 단말기 역할(논리적인 것으로서 인스턴스형태로 제작) 
// ServerSocket - 1:n 통신을 수행하는 서버 특성상, Socket을 무제한으로 찍어내는 Socket공장이 필요. 
//		ServerSocket이 그 역할을 수행 
// Stream - 프로그램들이 데이터를 주고받기 위해 Open하는 다리 (통로)
//		output, input 이 존재함.