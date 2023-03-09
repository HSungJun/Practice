package Exam02;

class TargetPlus extends Thread {
	public void run() {
		while (true) {
			Main.target++;
		}
	}
}

class TargetMinus extends Thread {
	public void run() {
		while (true) {
			Main.target--;
		}
	}
}

public class Main {

	public static int target = 0; // 전역변수와 같은 느낌
	// static 은 class에 . 찍어야 가능

	public static void main(String[] args) {

		new TargetPlus().start();
		new TargetMinus().start();

		while (true) {
			System.out.println(target);
		}

	}
}
