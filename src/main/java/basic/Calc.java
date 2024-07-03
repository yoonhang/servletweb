package basic;
//비지니스 로직을 처리하는 클래스
public class Calc {
	public int calc(int num1,int num2,String opr) {
		System.out.println("메소드호출");
		int result = 0;
		switch(opr) {
			case "+":
				result = num1+num2;
				break;
			case "-":
				result = num1-num2;
				break;
			case "*":
				result = num1*num2;
				break;
			case "/":
				if(num2==0) {
					System.out.println("0으로 나눌 수 없습니다.");
				}
				result = num1/num2;
				break;
		}
		return result;
	}
}
