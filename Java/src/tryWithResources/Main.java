package tryWithResources;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\tryWithResources.txt", true))) {
			Scanner sc = new Scanner(System.in);

			while(true) {
				System.out.println("문자열을 입력 후 엔터를 치세요. (공백이면 종료, 특수문자는 Exception 발생)");
				String str = sc.nextLine();
				if(str.equals(""))
					break;
				
				if(!Pattern.matches("^[ㄱ-ㅎ가-힣a-zA-Z0-9]*$", str))
					throw new SpecialLettersException("특수문자는 입력 불가");
				
				writer.write(str);
				writer.newLine();
				
				System.out.println();
			}
			
			System.out.println("종료되었습니다.");
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
