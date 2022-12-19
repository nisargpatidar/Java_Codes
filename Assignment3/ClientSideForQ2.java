public class ClientSideForQ2 extends MyInteger{
  public static void main(String[] args) {

//Just testing all methods created in MyInteger file
    MyInteger a = new MyInteger(19);
    System.out.println(a.getValue());
	System.out.println(a.isEven());
	System.out.println(a.isOdd());
	System.out.println(a.isPrime());
	System.out.println(isEven(20));
	System.out.println(isOdd(21));
	System.out.println(isPrime(22));
	System.out.println(isEven(a));
	System.out.println(isOdd(a));
	System.out.println(isPrime(a));
	System.out.println(a.equals(12));
	System.out.println(a.equals(a));
	char[] temp = {'1','2'};
	System.out.println(parseInt(temp));
	System.out.println(parseInt("123"));

  }

}