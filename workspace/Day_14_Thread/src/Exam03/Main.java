package Exam03;

import javax.swing.JOptionPane;

class Countdown extends Thread {
	public static int score = 0;
	public static int i = 10;

	public void run() {
		for (; i > 0; i--) {
			System.out.println(i);
			score++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		System.err.println("최종 버틴시간 : "+score);
		System.out.println();
		System.out.println("Game Over");
		System.exit(0);
	}
}

public class Main {
	public static void main(String[] args) throws Exception {

		String[] quiz = new String[] { 
				"public static void main(String[] ar)", 
				"Scanner sc = new Scanner(System.in)",
				"DataOutputStream dos = new DataOutputStram(os)" };
		new Countdown().start();
		while (true) {
			int index = (int) (Math.random() * 3);
			String msg = JOptionPane.showInputDialog("메세지 입력");

			if (msg.equals(quiz[index])) {
				System.out.println("Success : time + 5");
				Countdown.i += 5;
			} else {
				System.out.println("Typo : time -3 ");
				Countdown.i -= 3;
			}
			System.out.println("현재 남은시간 : " +Countdown.i);
		}
	}
}
