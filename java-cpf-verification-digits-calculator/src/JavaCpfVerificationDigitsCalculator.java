import java.util.Locale;
import java.util.Scanner;

public class JavaCpfVerificationDigitsCalculator {
	public static String getUserCpfInput() {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Digite os 9 primeiros dígitos do seu CPF: ");
		return sc.next();
	}
	
	public static String getFirstControlDigit(String inputCpf) {
		String firstControlDigit;
		
		short sum = 0;
		byte multiplier = 10;
		int currentDigit;
		
		for(int i = 0; i < inputCpf.length(); i++) {
			currentDigit = Integer.valueOf(Character.toString(inputCpf.charAt(i)));
			sum += multiplier * currentDigit;
			
			if (multiplier > 1) {
				multiplier--;
			}
		}
		
		int rest = sum % 11;
		if(1 >= rest) {
			firstControlDigit = String.valueOf('0');
		} else {
			firstControlDigit = String.valueOf(11 - rest);
		}
		
		return firstControlDigit;
	}
	
	public static String getSecondControlDigit(String temporaryCpf) {
		String secondControlDigit;
		
		short sum = 0;
		byte multiplier = 11;
		int currentDigit;
		
		for(int i = 0; i < temporaryCpf.length(); i++) {
			currentDigit = Integer.valueOf(Character.toString(temporaryCpf.charAt(i)));
			sum += multiplier * currentDigit;
			
			if (multiplier > 1) {
				multiplier--;
			}
		}
	
		int rest = sum % 11;
		if(1 >= rest) {
			secondControlDigit = String.valueOf('0');
		} else {
			secondControlDigit = String.valueOf(11 - rest);
		}
		
		return secondControlDigit;
	}
	
	public static void main(String[] args) {
		String inputCpf = getUserCpfInput();
		
		String firstControlDigit = getFirstControlDigit(inputCpf);
		String secondControlDigit = getSecondControlDigit(inputCpf+firstControlDigit);
		
		String outputCpf = inputCpf + firstControlDigit + secondControlDigit;
	
		System.out.println(outputCpf);
    }	
}
