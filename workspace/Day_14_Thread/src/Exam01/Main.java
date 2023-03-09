package Exam01;

//step1 thread 상속받는 Worker 클래스 작성
class Worker extends Thread {
	// 추상메서드 없음, 기본(매개변수를 가지지않는)생성자 있음. super(); 가지고있음.

	// step2 좌측 초록화살표 overriding
	public void run() {
		// step3 병렬처리 소스코드 run 내부 구현
		for (int i = 0; i <= 10; i++) {
			System.out.println("두번째 for : " + i);
		}
	}
}

class Worker2 extends Thread {
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("세번째 for : " + i);
		}
	}
}

public class Main {
	public static void main(String[] args) {

		// Thread - Java에서 병렬처리 기법으로 사용되는 클래스
		// Process를 진행시키는 일처리의 단위 (일꾼)

		// Thread 사용법
		// Step1. Thread 클래스를 상속받는 사용자 정의 클래스를 작성한다.
		// Step2. Thread 클래스로부터 상속받는 public void run 메서드를 overriding 한다.
		// Step3. 병렬처리하고자 하는 소스코드를 run 내부에 구현한다.
		// Step4. 제작완료된 클래스를 인스턴스화 한다.
		// Step5. 만들어진 인스턴스로부터

		Worker w = new Worker();
		Worker2 ww = new Worker2();
		w.start();
		ww.start();
		// 인스턴스화 후 run을 콜하기 위해선 .start();
		// 쓰레드가 2개이상이 될때 멀티쓰레드 프로세스라고 명명

		for (int i = 0; i <= 10; i++) {
			System.out.println("첫번째 for : " + i);
		}

	}
}
