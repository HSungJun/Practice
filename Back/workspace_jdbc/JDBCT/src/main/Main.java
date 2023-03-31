package main;

import java.util.List;
import java.util.Scanner;

import commons.EncryptionUnits;
import dao.MembersDAO;
import dao.MoviesDAO;
import dto.MembersDTO;
import dto.MoviesDTO;

public class Main {
	public static void main(String[] args) {

		// �α��� �� ȸ������
		// 1. Members ���̺� ����
		// - id ���ڿ� 20 byte ��Ű ����
		// - pw ���ڿ� 20 byte ����� �� ����
		// - name ���ڿ� 20 byte ����� �� ����
		// - contact ���ڿ� 20 byte
		// - reg_date timestamp default sysdate ����� �� ����

		MembersDAO MembersDAO = new MembersDAO();

		try (Scanner sc = new Scanner(System.in);) {

			while (true) {
				try {
					System.out.println("<< Index >>");
					System.out.println("1. �α���");
					System.out.println("2. ȸ������");
					System.out.println("3. ȸ��������");
					System.out.println("0. ����");
					String menu = sc.nextLine();

					if (menu.equals("1")) {
						System.out.println("<< �α��� >>");

						System.out.print("ID : ");
						String id = sc.nextLine();

						// �ܹ��� ��ȣȭ�� ����
						// SHA - 256

						System.out.print("PW : ");
						String pw = EncryptionUnits.sha256(sc.nextLine());

						boolean result = MembersDAO.isLoginOK(id, pw);
						if (result) {
							System.out.println(id + " �� ȯ���մϴ�.");
							break;
						} else {
							System.out.println("ID �Ǵ� PW�� �ٽ� Ȯ�����ּ���.");
						}

					} else if (menu.equals("2")) {

						System.out.println("<< ȸ������ >>");

						String id = "";
						while (true) {
							System.out.print("ID �� �Է����ּ��� : ");
							id = sc.nextLine();

							boolean result = MembersDAO.idOverlapCheck(id);
							if (result == false) {
								System.out.println("id �ߺ� ����.");
								break;
							} else if (result == true) {
								System.out.println("�̹� �����ϴ� id �Դϴ�.");
							}
						}

						System.out.print("PW �� �Է����ּ��� : ");
						String pw = sc.nextLine();

						pw = EncryptionUnits.sha256(pw);

						System.out.print("�̸��� �Է����ּ��� : ");
						String name = sc.nextLine();

						System.out.print("����ó�� �Է����ּ��� : ");
						String contact = sc.nextLine();

						int result = MembersDAO.insert(new MembersDTO(id, pw, name, contact, null));
						if (result > 0) {
							System.out.println("���� �Ϸ�");
						}

					} else if (menu.equals("3")) {
						List<MembersDTO> list = MembersDAO.selectAll();

						for (MembersDTO dto : list) {

							// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd (E) hh:mm:ss.SSS");
							// String formedDate = sdf.format(dto.getReg_date());

							System.out.println(dto.getId() + "\t" + dto.getFormedDate());
						}

					} else if (menu.equals("0")) {
						System.out.println("�ý����� �����մϴ�.");
						System.exit(0);
					} else {
						System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			// PreparedStatement �� ����� �ڵ尡 �� ���� �����ϴ��� Ȯ��
			// ���⼭���� ���α׷� ��ü ����
			MoviesDAO dao = new MoviesDAO();
			while (true) {
				System.out.println("<< Netflix ��ȭ ���� ���α׷� >>");
				System.out.println("1. �ű� ��ȭ ���"); // C
				System.out.println("2. ��ȭ ��� ���"); // R
				System.out.println("3. ��ȭ ���� ����"); // U -- ID�� �������� ��� ���� ����
				System.out.println("4. ��ȭ ���� ����"); // D -- ID�� �������� ����
				System.out.println("5. ��ȭ ���� �˻�"); // �������� �˻�
				System.out.println("0. ���α׷� ����");
				System.out.print(">> ");
				String menu = sc.nextLine();

				try {
					if (menu.equals("1")) {
						System.out.print("�ű� ��ȭ ���� : ");
						String title = sc.nextLine();

						System.out.print("�ű� ��ȭ �帣 : ");
						String genre = sc.nextLine();

						int result = dao.insert(title, genre);
						if (result > 0) {
							System.out.println("�Է� �Ϸ�");
						}
					} else if (menu.equals("2")) {
						List<MoviesDTO> result = dao.selectAll();
						System.out.println("ID\tTitle\tGenre");
						for (MoviesDTO dto : result) {
							System.out.println(dto.getId() + "\t" + dto.getTitle() + "\t" + dto.getGenre());
						}
					} else if (menu.equals("3")) {
						System.out.print("������ ����� ID : ");
						int id = Integer.parseInt(sc.nextLine());

						// if(exisnt)�� �����ϰ� else {cotinue;} �ص� �Ȱ����ǰ��� ?
						// �Ȱ��� ����� �ϴ°��� �ñ��߾�� �����մϴ� ~ ��

						// false : �ش� ID�� ����
						// true : �ش� ID�� ����
						boolean isIdExist = dao.isIdExist(id);

						if (!isIdExist) {// �ش� ID�� ��� false�� ��ȯ�Ǿ��� ��, !(not) ��ȣ�� �������� true�� ����� if�� ����
							System.out.println("ID : [" + id + "] ��ȭ�� ã�� �� �����ϴ�.");
							continue;
						}

						System.out.print("�ű� ��ȭ ���� : ");
						String title = sc.nextLine();

						System.out.print("�ű� ��ȭ �帣 : ");
						String genre = sc.nextLine();

						MoviesDTO dto = new MoviesDTO(id, title, genre);
						int result = dao.update(dto);

						if (result > 0) {
							System.out.println("���� �Ϸ�");
						}

					} else if (menu.equals("4")) {
						System.out.print("���� �� ��ȭ�� ID : ");
						int id = Integer.parseInt(sc.nextLine());

						int result = dao.delete(id);
						if (result > 0) {
							System.out.println("���� �Ϸ�");
						} else {
							System.out.println("������ ID�� ã�� �� �����ϴ�.");
						}
					} else if (menu.equals("5")) {

						System.out.print("�˻��� ��ȭ�� ���� : ");
						String target = sc.nextLine();

						List<MoviesDTO> result = dao.searchByTitle(target);
						System.out.println("ID\tTitle\tGenre");
						for (MoviesDTO dto : result) {
							System.out.println(dto.getId() + "\t" + dto.getTitle() + "\t" + dto.getGenre());
						}

					} else if (menu.equals("0")) {
						System.out.println("�ý����� �����մϴ�.");
						System.exit(0);
					} else {
						System.out.println("�޴��� �ٽ� Ȯ�����ּ���.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("��� ���� �� ������ �߻��߽��ϴ�.");
				}
			}

		}
	}
}
