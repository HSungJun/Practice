
public class Quiz_01 {
	public static void main(String[] args) {
	
		byte b = 10;
		short s= 20;
		char c = 'A';
		int i;
		float f;
		long l = 100L;
		
		s=b;
		c=(char)b;
		s=(short)c;
		c=(char)s;// char의 경우 (아스키코드)유니코드 사용 > 숫자 65 입력시 A출력
		i=(int)100L;
		l=500;
		f=l;
		f=(float)5.11;
		//f=5.11f; 로 수정가능
		
	//casting 을 사용한 오류 제거 > 데이터 손실발생
		System.out.println(c);
		
		
		
		
}
}
