
public class Ex07LottoApp {
	
	static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		
		//selectMenu(); // 메소드 호출 : 메서드를 실행하는 명령
		
		//String selection = selectMenu();
		//System.out.println(selection);
		
		String selection = "";
		// selection.equals("9") : selection이 "9"이면 true 아니면 false
		while ( selection.equals("9") == false ) { //9라면 반복문 종료
			
			selection = selectMenu(); // 실행 후 selection에는 
			                          // 사용자가 입력한 번호가 들어있습니다.
			switch (selection) {
			case "1": 
				int[] numbers;
				while (true) {
					numbers = selectBasicNumbers(); //기본 번호 뽑기
					boolean valid = checkMean(numbers);
					if (valid) {
						break;
					}
				}
//				do {
//					numbers = selectBasicNumbers(); //기본 번호 뽑기
//				} while (checkMean(numbers) == false);
				
				//출력
				showNumbers(numbers);				
				break;
			case "9":
				System.out.println("행운을 빕니다.");
				System.out.println("프로그램을 종료합니다.");
				break;
			default: // 1또는 9가 아니라면
				System.out.println("지원하지 않는 명령입니다.");
				break;
			} // end of switch - case			
		} // end of while		
	} // end of main

	static boolean checkMean(int[] numbers) {
		//평균 검사 : 20 ~ 26 -> 출력 / 아니면 -> 번호 뽑기
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum = sum + numbers[i];
		}
		int mean = sum / numbers.length;
		
		if (mean >= 20 && mean <= 26) {
			return true;
		} else {
			return false;
		}		
		//return (mean >= 20 && mean <= 26);
	}
	
	static void showNumbers(int[] numbers) {
		System.out.print("당첨 예상 번호 : ");
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("[%2d]", numbers[i]);
		}
		System.out.println();
	}
	
	static String selectMenu() {
		System.out.println(); // 단순 줄바꿈
		System.out.println("******************************");
		System.out.println("* 1. 당첨 예상 번호 뽑기.");
		System.out.println("* 9. 종료.");
		System.out.println("******************************");
		System.out.print("작업 번호 : ");
		//입력코드
		String selection = scanner.nextLine();
		System.out.println(); // 단순 줄바꿈
		return selection;
	}
	
	static int[] selectBasicNumbers() {
		//기본 번호 뽑기(1 ~ 45, Random, 중복X, 6개)
		int[] numbers = new int[6]; // 정수 6개를 저장하는 배열
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {//중복된 경우
					i--; // 또는 i = -1;
					break;
				}
			}
		}
		return numbers; //호출한 곳으로 번호 반환
	}
}