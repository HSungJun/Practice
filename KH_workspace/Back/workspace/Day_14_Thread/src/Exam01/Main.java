package Exam01;

//step1 thread ��ӹ޴� Worker Ŭ���� �ۼ�
class Worker extends Thread {
	// �߻�޼��� ����, �⺻(�Ű������� �������ʴ�)������ ����. super(); ����������.

	// step2 ���� �ʷ�ȭ��ǥ overriding
	public void run() {
		// step3 ����ó�� �ҽ��ڵ� run ���� ����
		for (int i = 0; i <= 10; i++) {
			System.out.println("�ι�° for : " + i);
		}
	}
}

class Worker2 extends Thread {
	public void run() {
		for (int i = 0; i <= 10; i++) {
			System.out.println("����° for : " + i);
		}
	}
}

public class Main {
	public static void main(String[] args) {

		// Thread - Java���� ����ó�� ������� ���Ǵ� Ŭ����
		// Process�� �����Ű�� ��ó���� ���� (�ϲ�)

		// Thread ����
		// Step1. Thread Ŭ������ ��ӹ޴� ����� ���� Ŭ������ �ۼ��Ѵ�.
		// Step2. Thread Ŭ�����κ��� ��ӹ޴� public void run �޼��带 overriding �Ѵ�.
		// Step3. ����ó���ϰ��� �ϴ� �ҽ��ڵ带 run ���ο� �����Ѵ�.
		// Step4. ���ۿϷ�� Ŭ������ �ν��Ͻ�ȭ �Ѵ�.
		// Step5. ������� �ν��Ͻ��κ���

		Worker w = new Worker();
		Worker2 ww = new Worker2();
		w.start();
		ww.start();
		// �ν��Ͻ�ȭ �� run�� ���ϱ� ���ؼ� .start();
		// �����尡 2���̻��� �ɶ� ��Ƽ������ ���μ������ ���

		for (int i = 0; i <= 10; i++) {
			System.out.println("ù��° for : " + i);
		}

	}
}
