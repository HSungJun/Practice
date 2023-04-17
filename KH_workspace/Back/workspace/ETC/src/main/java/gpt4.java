import java.util.Random;

public class gpt4 {
	public static void main(String[] args) {
		        Random random = new Random();
		        int[] numbers = new int[6];
		        
		        for (int i = 0; i < 6; i++) {
		            numbers[i] = random.nextInt(45) + 1;
		            
		            for (int j = 0; j < i; j++) {
		                if (numbers[i] == numbers[j]) {
		                    i--;
		                    break;
		                }
		            }
		        }
		        
		        for (int i = 0; i < 6; i++) {
		            System.out.print(numbers[i] + " ");
		        }
		    }
	}
