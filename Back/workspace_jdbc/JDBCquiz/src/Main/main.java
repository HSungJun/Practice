package Main;

import java.util.List;
import java.util.Scanner;

import Commons.EncryptionUnits;
import DAO.MemberDAO;
import DAO.MessageDAO;
import DTO.MemberDTO;
import DTO.MessageDTO;

public class main {
	public static void main(String[] args) {

		/*
		 * �Խ��� model view �и� / ���� �ڿ��� �ݵ�� close / dbcp ���� ȸ������ �н����� sha256 / ���̺��� 1:1��
		 * maping�ϴ� DAO DTO �ۼ� / ��翹�� main�� ���� �����ȳ� �޼��� ���
		 * 
		 * �α��� - ȸ������ - ���� ȸ������ - ���̵� �н����� �̸� ����ó
		 * 
		 * 1. �ű� �޼��� ��� ( �ۼ��� > �޼��� �����Է�) 2. �޼��� ��� ��� (�۹�ȣ, �ۼ���, �۳���, �ۼ��� (MM/dd) 3.
		 * �޼��� ���� (seq ���� ����) 4. �޼��� ���� (seq ���� �����ϵ�, writer �� message �� ��������) 5. �޼��� �˻�
		 * (writer �Ǵ� message �� �˻��� ���Դ��) 6. �� ���� ���� 0. �ý��� ����
		 * 
		 */

		MemberDAO mdao = new MemberDAO();

		String LoginId = null;
		try (Scanner sc = new Scanner(System.in);) {
			while (true) {
				try {
					System.out.println("<<< �Խ��� �α��� >>>");
					System.out.println("1. �α���");
					System.out.println("2. ȸ������");
					System.out.println("0. ������");

					String menu = sc.nextLine();

					if (menu.equals("1")) {
						System.out.println("�α���");

						System.out.print("ID : ");
						String id = sc.nextLine();

						System.out.print("PW : ");
						String pw = EncryptionUnits.sha256(sc.nextLine());

						boolean result = mdao.login(id, pw);
						if (result) {
							System.out.println(id + " �� �α��� ����");
							LoginId = id;
							break;
						} else {
							System.out.println(" �α��� ���� ");
						}

					} else if (menu.equals("2")) {

						System.out.println("ȸ������");
						String id = "";
						while (true) {
							System.out.print("ID�Է� : ");
							id = sc.nextLine();

							boolean result = mdao.idOverlap(id);
							if (result == false) {
								System.out.println("�ߺ� ����");
								break;
							} else if (result == true) {
								System.out.println("ID �������");
							}
						}

						System.out.print("��й�ȣ �Է� : ");
						String pw = sc.nextLine();

						pw = EncryptionUnits.sha256(pw);

						System.out.print("�̸� �Է� : ");
						String name = sc.nextLine();

						System.out.println("����ó �Է� : ");
						String contact = sc.nextLine();

						int result = mdao.insert(new MemberDTO(id, pw, name, contact, null));
						if (result > 0) {
							System.out.println("���ԿϷ�");
						}

					} else if (menu.equals("0")) {
						System.out.println("�ý��� ����");
						System.exit(0);
					} else {
						System.out.println("���õ� �޴� �� �ԷºҰ�");
					}

				} catch (Exception e) {
					System.out.println("�α��ΰ��� ó���� ���� �߻�");
				}
			}

			// ======== �α��� �Ϸ� ===========

			MessageDAO dao = new MessageDAO();
			while (true) {

				try {
					System.out.println("<<<< �Խ��� >>>>");
					System.out.println("1. �ű� �޼��� ���");
					System.out.println("2. �޼��� ��� ���");
					System.out.println("3. �޼��� ���� (seq�� �˻�)");
					System.out.println("4. �޼��� ���� (seq�� �˻�)");
					System.out.println("5. �޼��� �˻� (writer, message ����˻�)");
					System.out.println("6. ������ ����");
					System.out.println("0. �ý��� ����");

					String menu = sc.nextLine();

					if (menu.equals("1")) {
						System.out.println("�ű� �޼��� �Է�");

						System.out.print("�ۼ��� �� : ");
						String writer = sc.nextLine();

						System.out.print("���� �޼��� : ");
						String message = sc.nextLine();

						int result = dao.insert(writer, message);
						if (result > 0) {
							System.out.println("�ۼ��� " + writer + "�� �޼��� �Է� �Ϸ�");
						}

					} else if (menu.equals("2")) {
						System.out.println("�Էµ� ��ü �޼��� ���");

						List<MessageDTO> result = dao.messageList();
						System.out.println("�۹�ȣ \t �ۼ���\t ����\t�ۼ���");
						for (MessageDTO dto : result) {
							System.out.println(dto.getSeq() + "\t" + dto.getWriter() + "\t" + dto.getMessage() + "\t"
									+ dto.getFormedDate());
						}

					} else if (menu.equals("3")) {
						System.out.println("�޼��� ����");
						
						System.out.println("������ seq ��ȣ : ");
						int seq = Integer.parseInt(sc.nextLine());
						
						int result = dao.delete(seq);
						if (result > 0) {
							System.out.println("�����Ϸ�");
						}else {
							System.out.println("������ �޼����� ã�� ����.");
						}
						
					} else if (menu.equals("4")) {
						System.out.println("�޼��� ����");
						
						System.out.print("������ �޼����� seq : ");
						int seq = Integer.parseInt(sc.nextLine());
						
						boolean seqExist = dao.seqExist(seq);
						if(!seqExist) {
							System.out.println("�ش� "+seq+"�� �������� �ʽ��ϴ�.");
							continue;
						}
						
						System.out.print("������ "+seq+"�� �ۼ��ڸ� : ");
						String writer = sc.nextLine();
						
						System.out.print("������ "+seq+ "�� ���� : ");
						String message = sc.nextLine();
						
						MessageDTO dto = new MessageDTO(seq,writer,message,null);
						int result = dao.update(dto);
						if(result > 0) {
							System.out.println("���� �Ϸ�");
						} else {
							System.out.println("���� �Ұ�");
						}
						
					} else if (menu.equals("5")) {
						System.out.println("�޼��� �˻� ()");
						String target = sc.nextLine();
						
						List<MessageDTO> result = dao.search(target);						
						System.out.println("�ۼ���\t�޼��� ����");
						for(MessageDTO dto : result) {
							System.out.println(dto.getWriter() + "\t" + dto.getMessage());
							}
						
					} else if (menu.equals("6")) {
						System.out.println("�� ���� ���");
						
						
						MemberDAO mdao2 = new MemberDAO();
						List<MemberDTO> result = mdao2.info(LoginId);
						System.out.println("id\tname\tcontact\t�ۼ���");
						for(MemberDTO dto : result) {
							System.out.println(dto.getId() + "\t" + dto.getName()
							+"\t"+dto.getContact()+"\t"+ dto.getReg_date());
							}
						
						
					} else if (menu.equals("0")) {
						System.out.println("�ý�������");
						System.exit(0);

					} else {
						System.out.println("�޴� �ٽ� ��������");
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("�Խ��� ����");
				}
			}
		}
	}

}