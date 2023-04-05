package Quiz03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_ServerFile {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		Socket client = new Socket ("localhost", 45000);
		
		InputStream is = client.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		OutputStream os = client.getOutputStream(); 
		DataOutputStream dos = new DataOutputStream(os);
		
		int a = dis.readInt();
		
		System.out.println("파일 갯수 "+a);
		
		
		for (int i = 0; i<a; i++) {
			System.out.println(dis.readUTF());
		}
		
		System.out.print("받을파일은? :");
		dos.writeUTF(sc.nextLine());
		
		File dst = new File("d:/abc/abc.txt");
		FileOutputStream fos = new FileOutputStream(dst);
		
	    int	size = dis.readInt();
	    System.out.println(size);
	    byte[] newFile = new byte[size];
		
	    dis.readFully(newFile);
	    fos.write(newFile);			//fis 사용 후 파일작성
	    fos.flush();
	    
		
		
		
	}
}
