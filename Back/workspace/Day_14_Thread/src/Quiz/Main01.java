package Quiz;

class Plus extends Thread {
	public void run() {
		for (int i = 0; i<=100; i++) {
			System.out.print("+");
		}
	}
}

class Minus extends Thread {
	public void run() {
		for (int i = 0; i<=100; i++) {
			System.out.print("-");
		}
	}
}

class Mply extends Thread {
	public void run() {
		for (int i = 0; i<=100; i++) {
			System.out.print("*");
		}
	}
}

public class Main01 {
	public static void main(String[] args) {
		
		Plus p = new Plus();
		Minus m = new Minus();
		Mply M = new Mply();
		p.start();
		m.start();
		M.start();
		
		
		
	}
}
