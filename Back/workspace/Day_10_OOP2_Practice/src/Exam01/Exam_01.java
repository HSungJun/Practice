package Exam01;

public class Exam_01 {
	public static void main(String[] args) {

//		Movie avatar = new Movie("�ƹ�Ÿ2","SF/�׼�",9.0);
//		Movie movie2 = new Movie("����","���",8.42);

//		Movie[] movies; // Stack �� movies ��� ������ �������
		
		Movie[] movies = new Movie[2];
		//[2] �� �������ν� �迭(���� �ΰ�)�� �����. (�迭 : '������' Ÿ���� ������ �������� ����)
		//Movie[] movies = new Movie; �� ��� movies ��� �ν��Ͻ��� �����.
		//movie�� ���� �ΰ� ����> movie�� Instance �� ������ �� ����.
		
//		movies[0] = new Movie("�ƹ�Ÿ2", "SF/�׼�", 8.82); 
//		movies[1] = new Movie("����","���",8.42);
		
		movies[1].setScore(10);
//		System.out.println(movies[0]);  > �ּ� ���
//		System.out.println(movies[0].getTitle()+movies[0].getGenre()+movies[0].getScore());

		for(int i = 0; i< movies.length; i++) {
			System.out.println(movies[i].getTitle()+"\t"+movies[i].getGenre()+"\t"+movies[i].getScore());
		}		
		
		
//		Movie[] movies = new Movie[]{new Movie("�ƹ�Ÿ2", "SF/�׼�", 8.82)
//		,new Movie("����","���",8.42)
//		}; ������ new Movie()�� ������ Instance �� ��.
		
		
		
		
		
		
		
//		System.out.println("��ȭ�̸� : " + avatar.getTitle()+ "  "+
//				"�帣 : " + avatar.getGenre()+ "  "+
//				"���� : "+ avatar.getScore());
	}
}


