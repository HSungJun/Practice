package exams;
import java.awt.Robot;

public class Exam_02 {
	public static void main(String[] args) throws Exception {
		
		Robot r = new Robot();
		
		for(int i = 0; i<100; i++) {
			int x = (int)(Math.random()*(500-200+1)+200);
			int y = (int)(Math.random()*(500-200+1)+200);
			
			r.mouseMove(x,y);
			r.delay(50);
	
		}
		
	}
}
