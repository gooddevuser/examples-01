
public class Ex06Method3 {

	public static void main(String[] args) {
		
		int result = sum(10, 20);		
		System.out.println(result);
		
		result = sum(10, 20 ,30);
		System.out.println(result);
			
	}	
	static int sum(int n1, int n2) {
		
		int result = n1 + n2;
		
		//함수를 종료하고(return) result의 값을 호출한 곳으로 반환
		return result; 
	}	
	static int sum(int n1, int n2, int n3) {
		
		int result = n1 + n2 + n3;
		
		//함수를 종료하고(return) result의 값을 호출한 곳으로 반환
		return result; 
	}
	

}
