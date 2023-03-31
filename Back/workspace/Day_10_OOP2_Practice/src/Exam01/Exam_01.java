package Exam01;

public class Exam_01 {
	public static void main(String[] args) {

//		Movie avatar = new Movie("아바타2","SF/액션",9.0);
//		Movie movie2 = new Movie("영웅","드라마",8.42);

//		Movie[] movies; // Stack 에 movies 라는 변수만 만든상태
		
		Movie[] movies = new Movie[2];
		//[2] 를 붙임으로써 배열(변수 두개)을 만든것. (배열 : '동일한' 타입을 가지는 변수들의 집합)
		//Movie[] movies = new Movie; 의 경우 movies 라는 인스턴스를 만든것.
		//movie형 변수 두개 생성> movie형 Instance 만 저장할 수 있음.
		
//		movies[0] = new Movie("아바타2", "SF/액션", 8.82); 
//		movies[1] = new Movie("영웅","드라마",8.42);
		
		movies[1].setScore(10);
//		System.out.println(movies[0]);  > 주소 출력
//		System.out.println(movies[0].getTitle()+movies[0].getGenre()+movies[0].getScore());

		for(int i = 0; i< movies.length; i++) {
			System.out.println(movies[i].getTitle()+"\t"+movies[i].getGenre()+"\t"+movies[i].getScore());
		}		
		
		
//		Movie[] movies = new Movie[]{new Movie("아바타2", "SF/액션", 8.82)
//		,new Movie("영웅","드라마",8.42)
//		}; 식으로 new Movie()가 각각의 Instance 가 됨.
		
		
		
		
		
		
		
//		System.out.println("영화이름 : " + avatar.getTitle()+ "  "+
//				"장르 : " + avatar.getGenre()+ "  "+
//				"평점 : "+ avatar.getScore());
	}
}


