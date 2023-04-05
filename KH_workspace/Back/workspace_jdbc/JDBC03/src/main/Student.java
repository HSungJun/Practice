package main;

import java.util.List;
import java.util.Scanner;

import DAO.StudentDAO;
import DTO.StudentDTO;

public class Student {
	public static void main(String[] args) {

		
//		�α��� ȸ������
//		Member ���̺� ����
//		id ���ڿ� 20byte
//		pw ���ڿ� 20byte
//		name ���ڿ� 20
//		contact ���ڿ� 20
//		reg date 
//		
//		
//		
		
		
		StudentDAO dao = new StudentDAO();
		Scanner sc = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (Exception e) {
			System.out.println("�������");
			System.exit(0);
		}

		try {
			while (true) {
				System.out.println(" = �л����� ���α׷� = ");
				System.out.println("1. �л����� �Է�");
				System.out.println("2. �л���� Ȯ��");
				System.out.println("3. �л����� ���� (�й��˻�)");
				System.out.println("4. �л����� ���� (�й��˻�)");
				System.out.println("5. �л����� �˻� (�̸��˻�)");
				System.out.println("0.�ý��� ����");
				System.out.print("�Է� :  ");

				int menu = Integer.parseInt(sc.nextLine());

				if (menu == 1) {
					System.out.print("�ű� �л� �̸� : ");
					String name = sc.nextLine();
					
					System.out.print("�ű� �л� ���� ���� : ");
					int kor = Integer.parseInt(sc.nextLine());
					
					System.out.print("�ű� �л� ���� ���� : ");
					int eng = Integer.parseInt(sc.nextLine());
					
					System.out.print("�ű� �л� ���� ���� : ");
					int math = Integer.parseInt(sc.nextLine());
					
					int result = dao.addStudent(name, kor, eng, math);
					if (result > 0) {
						System.out.println("�Է� �Ϸ�");
					}
					
				} else if (menu == 2) {
					List<StudentDTO> result = dao.searchAll();
					
					System.out.println("�й�\t�̸�\t����\t����\t����");
					for (StudentDTO dto : result) {
						System.out.println(dto.getId()+"\t"+ dto.getName()+"\t"+
								dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath());
					}
					
				} else if (menu == 3) {
					System.out.print("�����ϰ��� �ϴ� �л��� �й� �Է� : ");
					int id = Integer.parseInt(sc.nextLine());
					
					boolean result = dao.isIdExist(id);
					if(result == false) {
						System.out.println("������ ["+id+"] Ȯ�κҰ�");
						continue;
					}
					
					System.out.print("�����ϰ��� �ϴ� �л��� �̸� �Է� : ");
					String upName =  sc.nextLine();
						
					System.out.print("��� �л��� �������� �Է� : ");
					int upKor = Integer.parseInt(sc.nextLine());
					
					System.out.print("��� �л��� �������� �Է� : ");
					int upEng = Integer.parseInt(sc.nextLine());
					
					
					System.out.print("��� �л��� �������� �Է� : ");
					int upMath = Integer.parseInt(sc.nextLine());
					
					StudentDTO dto = new StudentDTO(id,upName,upKor,upEng,upMath);
					int upResult= dao.updateStudent(dto);
					
					if (upResult > 0) {
						System.out.println("���� �Ϸ�");
						
					}
					
					
				} else if (menu == 4) {
					System.out.print("������ �л� �й� �Է� : ");
					int id = Integer.parseInt(sc.nextLine());
					
					int result = dao.deleteStudent(id);
					
					if (result > 0) {
						System.out.println("���� ����");
					}
					
				} else if (menu == 5) {
					System.out.print("�˻��� �л� �̸� : ");
					String search = sc.nextLine();
					List<StudentDTO> result = dao.searchName(search);
					
					System.out.println("�й�\t�̸�\t����\t����\t����");
					for (StudentDTO dto : result) {
						System.out.println(dto.getId()+"\t"+ dto.getName()+"\t"+
								dto.getKor()+"\t"+dto.getEng()+"\t"+dto.getMath());
					}
					
					
				} else if (menu == 0) {
					System.out.println("�ý����� �����մϴ�.");
					System.exit(0);
				} else {
					System.out.println("�޴��� �ٽ� ������ �ּ���.");
				}

			}

		} catch (Exception e) {
			System.out.println("������ ���� �߻�");
			e.printStackTrace();
		}

	}
}
