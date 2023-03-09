package Quiz02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws Exception{
		
		Socket client = new Socket("192.168.50.65", 45000);
		
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		//data- 는 네트워크와 연결
		OutputStream os = client.getOutputStream(); 
		
//		FileInputStream fis = new FileInputStream()
		
		//file- 는 하드디스크와 연결
		
		System.out.println(dis.readInt());
		
		byte[] newFile = new byte[6844464];
		
		dis.readFully(newFile);
		
		File dst = new File("d:/abc/abc.mp3");
		FileOutputStream fos = new FileOutputStream(dst);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.write(newFile);
		dos.flush();
				
				
	}
}
