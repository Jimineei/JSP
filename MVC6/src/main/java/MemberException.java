
public class MemberException {



	public static void main(String[] args) {

		

		// 예외 처리 : 개발자가 예상하지 못하는 상황(에러)를 처리

		

		int a = 10;

	// 	int b = 0 	컴파일에러 : 문법 오류(빨간줄)

	//	int b = 0;

		int b = 2;



		if(b != 0) {

		int c = a/b; // 예외상황 : 0으로 나눌 수 없음

		System.out.println(" C : " +c);

		}else {

			System.out.println("에러발생!!!");



	}

		

		System.out.println("정상 종료");

		

		int[] arr = new int[5];

	

		System.out.println(arr[6]);

		

		

		// 	* 자바에서는 에러/예외를 객체로 관리한다

		

		// 			   Throwable 객체

		// 			  /			  	 \

		//Error 	 객체 		// Exception 객체 

		// 								|

		// 						ArrayIndexOutOfBoundsException

		// 						ClassNotFoundException

		

		// * 예외처리 방법

		// 1) try ~ catch 구문

		try {

			// 예외가 발생 할 수도 있는 코드 작성 (DB연결, 외부 시스템과 연결)

		}

		catch (NullPointerException e) {

				System.out.println(" null값 접근 에러");

				// + 처리동작

			}

		 

		catch (ArrayIndexOutOfBoundsException e) {

				System.out.println(" 배열 범위 예외 발생");

		}

		catch (Exception e) {

			// 예외처리 =>예외메세지 출력 

			System.out.println(" 예외 발생!! ");

			e.getMessage();

			e.printStackTrace();

		}

		

		// + try~catch~finally 구문

		try {

			//	예외가 발생 할수 있고, 하지 않는 구문

			

		} catch (Exception e) {

			// 예외 처리(출력)

		} 

			

		 finally {

			// 예외 여부에 상관없이 반드시 실행해야하는 구문

			 // => DB연결 해제(자원해제)

		}

		

		// try - with 구문

		//try ( 자원해제가 필요한 객체) {

			

		//} catch (Exception e) {

			// TODO: handle exception

	//	} 

		

		

		// 2) throws 구문 해당 메서드를 실행할때 예외처리를 강제

		

		//public void method() throws Exception {

			// 예외처리가 필요한 구문

	//	}

		

		// * 예외 처리를 수행

		//try {

		//	method(); // 실행

		//} catch (Exception e) {

			// TODO: handle exception

		//}

}

}