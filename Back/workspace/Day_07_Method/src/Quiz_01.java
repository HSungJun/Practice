
public class Quiz_01 {

	public static int countA(String A, char C) {
		int count=0;
		for(int i =0; i < A.length(); i++ ) {
//			char C = 'A';
//			if(C == 'A') {
			if(A.charAt(i) == C) {
			// char c 선언 및 if 문을 if(A.charAt(i)=='A') 로 해도 출력 가능
				count += 1;
				//count++;	
			}
		}
		return count;
	}



	public static void main(String[] args) {

		//	String str = "A423890utwjiogrs436q89u0taiwrogs24679u0qyWJIPOR62749-UYwoprhjNS24	906uyWJHIR15	79TY3qhuti-50uiaetophj351978YTQUoieg-50Q73IUYAPOETH2469Y-0hqipNR-270uY4WJPO2	47809yhguobwr-307qu965jaeopt24y08HQUIOR2490-hipwrn2460	9uYIGH8jn50j89h5i3g359hu0j-b3h59-uqbj3hbu90-3b8h03vbh789315vg7843f8673478q89y24h28904QY08924utw09Y2WH%rS09h8wh90wuHW90usrUJH890WRIsH8i)yYH89ZAWY892HQ3A2T9Q78AGQ289YA280yh90y3q9-u023qu93507j635790ujw35hj908e5h083ieosjny9ehjitosjh9rtsn0k-jnmyr0-m0-=out,d,td0-=uio-964uy5ws098y3q89tyg724	g78129	341	g73598190	H34T90G8Y429-uha3etnu9-naet9hnaethwairug4BWG7139	801	Y3590-4U180-=y4290-UHwrhbipfibnhgfnklxgbn.vcndjliegqf9u-35y90-u35y5y09u8jh0jsneiopzbtnszomlsg;noflm,m0op[dhk-0i67359u07-q2y80qq248y0h24h8nhiaozwrsmikhbnozemkxnfbvnm,opn9okpyjr90-i6j4u90-y3528091y4y18021g79TQHQ9guniJINHZMIOPJNGXFOPKMNGFHKOPFG90HTWJ90Uy805y89524908u725y9u20y64j9046yihwhisnodgjgfiokjpfhdg9yi0j6490u3y8358yh9hj4itohitjk9op0rdjtyij90659i-6349u06j094shishijopgfhijgh490uy382989hh89h8H864904HU90H089h8347tg28y929u0642w9uj0yophrejsodpnfh";
		String str = "BBB";

		int count = countA(str, 'A');
		System.err.println("알파벳의 갯수 : " + count);

	}
}	
