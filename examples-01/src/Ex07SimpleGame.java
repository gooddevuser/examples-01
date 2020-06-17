import java.awt.GraphicsEnvironment;

public class Ex07SimpleGame {

	static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		// 가위(1) 바위(2) 보(3) 게임
		// 1. 컴퓨터의 선택 - Random (1 or 2 or 3)
		// 2. 사용자 입력 (1 or 2 or 3)
		// 3. 비교
		// 4. 결과 출력
		// 5. 메뉴를 통해서 반복
		String selection = "";
		while (selection.equals("9") == false) {
			selection = selectMenu();
			switch (selection) {
			case "1":
				int com = (int) (Math.random() * 3) + 1; // 1 or 2 or 3
				System.out.print("가위(1) or 바위(2) or 보(3) : ");
				int you = scanner.nextInt();//enter는 buffer에 남겨짐
				//scanner.nextLine(); // enter 제거
				int result = getResult(you, com);
				showResult(com, you, result);
				break;
			case "9":
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("선택 오류");
				break;
			}
		}
	}

	static String selectMenu() {
		System.out.println(); // 단순 줄바꿈
		System.out.println("******************************");
		System.out.println("* 1. 게임 하기.");
		System.out.println("* 9. 종료.");
		System.out.println("******************************");
		System.out.print("작업 번호 : ");
		// 입력코드
		String selection = scanner.next();
		System.out.println(); // 단순 줄바꿈
		return selection;
	}

	static void showResult(int com, int you, int result) {
		System.out.printf("[COM : %d][YOU : %d] --> ", com, you);
		switch (result) {
		case 0:
			System.out.println("YOU LOSE !!!");
			break;
		case 1:
			System.out.println("YOU WIN !!!");
			break;
		case 2:
			System.out.println("DRAW !!!");
			break;
		}
	}

	static int getResult(int you, int com) {
		int result = 0; // 0: lose, 1: win, 2: draw
		if (you == 1 && com == 3 || you == 2 && com == 1 || you == 3 && com == 2) {
			result = 1;
		} else if (you == com) {
			result = 2;
		}

		return result;
	}

}
