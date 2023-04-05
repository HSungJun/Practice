package 복습;

public class InsertExam {
	public static void main(String[] args) {
		
		/*
		 0. 계정명 team
		 	패스워드 team
		 	권한 : resource, connect
		  
		 1. 오라클에 테이블 생성하기
			테이블명 - team_contact
			id 주키 숫자 1001 ~ 무한
			name (문자열)(30) not null
			age 숫자 not null
			contact 문자열(11) not null
			update_date timestamp default sysdate not null
			
			시퀀스명 : team_contact_seq
		 
		 2. TeamDTO 생성
		 3. TeamDAO 생성
		 	-DB 연결은 DBCP를 사용할 것
		 	-자원관리는 try resources 사용
		 	
		 	
		 4. InsertExam에서 팀원 전원의 정보를 입력하는 코드 작성할 것
		 	(메뉴 띄우거나 Scanner로 입력할 필요 없음)
		 
		 5. SelectExam에서 입력된 모든 팀원 정보를 출력할 것
		 
		*/
		try {
		TeamDAO dao = new TeamDAO();
		//팀원 정보입력.
		int result = dao.insert("김성하",22,"01062079268");
		if(result > 0) {
			System.out.println("첫번째 입력 완료");
		};
		
		int result2 = dao.insert("이주화", 28, "01041228264");
		if(result2>0) {
			System.out.println("두번째 입력 완료");
		};
		
		int result3 = dao.insert("지세영", 28, "01071503677");
		if(result3>0) {
			System.out.println("세번째 입력 완료");
		};
		
		int result4 = dao.insert("이건희", 32, "01024849975");
		if(result4>0) {
			System.out.println("네번째 입력 완료");
		};
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("실행중 오류 발생");
		}
	}
}
