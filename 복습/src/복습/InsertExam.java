package ����;

public class InsertExam {
	public static void main(String[] args) {
		
		/*
		 0. ������ team
		 	�н����� team
		 	���� : resource, connect
		  
		 1. ����Ŭ�� ���̺� �����ϱ�
			���̺�� - team_contact
			id ��Ű ���� 1001 ~ ����
			name (���ڿ�)(30) not null
			age ���� not null
			contact ���ڿ�(11) not null
			update_date timestamp default sysdate not null
			
			�������� : team_contact_seq
		 
		 2. TeamDTO ����
		 3. TeamDAO ����
		 	-DB ������ DBCP�� ����� ��
		 	-�ڿ������� try resources ���
		 	
		 	
		 4. InsertExam���� ���� ������ ������ �Է��ϴ� �ڵ� �ۼ��� ��
		 	(�޴� ���ų� Scanner�� �Է��� �ʿ� ����)
		 
		 5. SelectExam���� �Էµ� ��� ���� ������ ����� ��
		 
		*/
		try {
		TeamDAO dao = new TeamDAO();
		//���� �����Է�.
		int result = dao.insert("�輺��",22,"01062079268");
		if(result > 0) {
			System.out.println("ù��° �Է� �Ϸ�");
		};
		
		int result2 = dao.insert("����ȭ", 28, "01041228264");
		if(result2>0) {
			System.out.println("�ι�° �Է� �Ϸ�");
		};
		
		int result3 = dao.insert("������", 28, "01071503677");
		if(result3>0) {
			System.out.println("����° �Է� �Ϸ�");
		};
		
		int result4 = dao.insert("�̰���", 32, "01024849975");
		if(result4>0) {
			System.out.println("�׹�° �Է� �Ϸ�");
		};
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("������ ���� �߻�");
		}
	}
}
