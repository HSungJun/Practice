// byte		1byte	8bit	-128 ~ 127
// short	2byte	16bit	-32,768 ~ 32,767
// char		2byte	16bit	0 ~ 65535(유니코드)
// int		4byte	32bit	-2,147,483,648 ~ 2,147,483,647
// long		8bit	64bit	-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807

// float	4byte	32bit	1.4E-45 ~ 3.4028235E38 (10^-38 ~ 10^38)
// double	8byte	64bit	4.9E-324 ~ 1.7976931348623157E308 (10^-308~ 10^308)

// boolean	1byte	8bit	true / false
// String 
//위 두가지는 형변환이 불가능


// void 					값을 가지지 않는 특수데이터


public class Exam_01 {
	public static void main(String[] args) {
	
		
	//Data type promotion - 프로모션 예제
		//큰 변수 안에 작은 변수값 대입
		
		byte a = 10;
		short b = a;
		
	}
}
