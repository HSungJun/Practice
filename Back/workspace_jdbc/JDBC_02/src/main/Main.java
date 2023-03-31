package main;

import java.util.List;
import java.util.Scanner;

import DTO.MoviesDTO;
import MoviesDAO.MoviesDAO;

public class Main {
	public static void main(String[] args) {

		// netflix ��ȭ ���� ���α׷�
		// ���̺� �̸� : movies
		// id 1001 ~ ���� 1�������ϴ� �� Ű
		// title ���ڿ� �ִ� 50����Ʈ
		// genre ���ڿ� 20����Ʈ
		// ��� not null

		// refactoring = �ϼ��� ������ �ڵ带 mvc �������� ����

		MoviesDAO dao = new MoviesDAO();
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("�������");
			System.exit(0);
		}

		try {
			System.out.println("<< Index >>");
			System.out.println("1. �α���");
			System.out.println("2. ȸ������");
			System.out.print("0. ���� >>");
			String menu = sc.nextLine();
			
			if ( menu.equals("1")) {
				
			} else if(menu.equals("2")) {
				
				System.out.println("<< ȸ������ >>");
				
				System.out.print("����� ID �Է� : ");
				String id = sc.nextLine();
				
				System.out.print("pW �Է� :");
				String pw = sc.nextLine();
				
				System.out.print("�̸� �Է� :");
				String name = sc.nextLine();
				
				System.out.print("����ó �Է� :");
				String phone = sc.nextLine();
				
			
				
				
			
			} else if (menu.equals("0")) {
				
			} else {
				
			}
			
			
			
			
			
			
			
			
			
//			while (true) {
//				System.out.println();
//				System.out.println("<<netflix ��ȭ���� ���α׷�>>");
//				System.out.println("1. �ű� ��ȭ ���"); // C
//				System.out.println("2. ��ȭ ��� ���"); // R
//				System.out.println("3. ��ȭ ���� ����"); // U -- ID�� �������� ��� ���� ����
//				System.out.println("4. ��ȭ ���� ����"); // D -- ID�� �������� ����
//				System.out.println("5. ��ȭ ���� �˻�"); // �������� �˻�
//				System.out.println("0. ���α׷� ����");
//				System.out.print(">> : ");
//
//				if (menu.equals("1")) {
//					System.out.print("�űԵ���� ��ȭ�̸� : ");
//					String title = sc.nextLine();
//
//					System.out.print("�űԿ�ȭ�� �帣 �̸�: ");
//					String genre = sc.nextLine();
//
//					// insert �� callen
//					// main �� caller �μ� ���� �����߻��� main���� ���޵�.
//					// main������ ���� ������ ������ ����. main���� �������� �ҽ� �ü���� �����Ǿ� ���α׷� ����.
//					// > try catch �� ���� ó��
//					int result = dao.insert(title, genre);
//					if (result > 0) {
//						System.out.println("�Է¿Ϸ�");
//					}
//
//				} else if (menu.equals("2")) {
//
//					List<MoviesDTO> result = dao.selectAll();
//
//					System.out.println("Id\tTitle\tGenre");
//					for (MoviesDTO dto : result) {
//						System.out.println(dto.getId()+"\t" +dto.getTitle()+"\t" +dto.getGenre());
//					}
//
//				} else if (menu.equals("3")) {
//					
//					
//					/*
//					System.out.print("������ ��ȭ ��ȣ �Է� : ");
//					int id = Integer.parseInt(sc.nextLine());
//					
//					boolean isIdExist = dao.isIdExist(id);
//					if(!isIdExist) { // = isIdExist == false !�� ����Ͽ� �������� ���
//					System.out.println("ID : ["+id+"] ��ȭ�� ã�� �� �����ϴ�.")
//					continue;
//					}
//					
//					System.out.print("������ ��ȭ ���� �Է� : ");
//					String title = sc.nextLine();
//
//					System.out.print("������ ��ȭ �帣 �Է� : ");
//					String genre = sc.nextLine();
//					
//					MoviesDTO dto = new MoviesDTO(id,title,genre);
//					int resultup = dao.update(dto);
//					
//					if (resultup > 0) {
//						System.out.println("����Ϸ�");
//					}
//
//					*/
//					System.out.print("������ ��ȭ ��ȣ �Է� : ");
//					int id = Integer.parseInt(sc.nextLine());
//					
//					boolean result = dao.isIdExist(id);
//					if(result == false) {
//						System.out.println("������ ��� ID Ȯ�κҰ�");
//						continue;
//					}
//					
//					System.out.print("������ ��ȭ ���� �Է� : ");
//					String title = sc.nextLine();
//
//					System.out.print("������ ��ȭ �帣 �Է� : ");
//					String genre = sc.nextLine();
//
//					MoviesDTO dto = new MoviesDTO(id,title,genre);
//					int resultup = dao.update(dto);
//
//					if (resultup > 0) {
//						System.out.println("����Ϸ�");
//					}
//
//				} else if (menu.equals("4")) {
//
//					System.out.print("������ ��ȭ id : ");
//					int id = Integer.parseInt(sc.nextLine());
//
//					int result = dao.delete(id);
//
//					if (result > 0) {
//						System.out.println("��������");
//					}
//
//				} else if (menu.equals("5")) {
//
//					System.out.print("�˻��� ��ȭ ������ �Է��ϼ��� : ");
//					String searchTitle = sc.nextLine();
//					List<MoviesDTO> result = dao.search(searchTitle);
//					
//					System.out.println("Id\tTitle\tGenre");
//					for (MoviesDTO dto : result) {
//						System.out.println(dto.getId()+"\t" +dto.getTitle()+"\t" +dto.getGenre());
//					
//					}
//					
//					
//					
//				} else if (menu.equals("0")) {
//					System.out.println("�ý��� ����");
//					System.exit(0);
//				} else {
//					System.out.println("�߸� �Է��ϼ̽��ϴ�. �޴��� �ٽ� ����ּ���.");
//				}
//				//
//			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ɼ����� �����߻�");
		}
	}
}