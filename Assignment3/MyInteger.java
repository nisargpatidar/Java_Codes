/*
Design a class named MyInteger. The class contains:


• 
• 
• 
• 
• 
• 
• 
• 

Draw the UML diagram for the class. Implement the class. Write a client program that tests all methods in the class.
*/

public class MyInteger {
  // An int data field named value that stores the int value represented by this
  // object.
  public int value;

//Default Constructor, to intialize the value to 0.
public MyInteger(){
	value = 0;
}

  // A constructor that creates a MyInteger object for the specified int value.
  public MyInteger(int valuePassed) {
    value = valuePassed;
  }

  // A get method that returns the int value.
  public int getValue() {
    return value;
  }

  // Method isEven() that return true if the value is even
  public boolean isEven() {
    return ((value % 2) == 0);
  }

  // Method isOdd() that return true if the value is odd
  public boolean isOdd() {
    return ((value % 2) == 1);
  }

  // Method isPrime() that return true if the value is prime
  // Code found on https://www.javatpoint.com/prime-number-program-in-java
  public boolean isPrime() {
    if (value <= 1) {
      return false;
    }
    for (int i = 2; i < Math.sqrt(value); i++) {
      if ((value % i) == 0) {
        return false;
      }
    }
    return true;
  }


  // Static Method isEven(int) that return true if the value is even
  public static boolean isEven(int valuePassed) {
    return ((valuePassed % 2) == 0);
  }

  // Static Method isOdd(int) that return true if the value is odd
  public static boolean isOdd(int valuePassed) {
    return ((valuePassed % 2) == 1);
  }

  // Static Method isPrime(int) that return true if the value is prime
  // Code found on https://www.javatpoint.com/prime-number-program-in-java
  public static boolean isPrime(int valuePassed) {
    if (valuePassed <= 1) {
      return false;
    }
    for (int i = 2; i < Math.sqrt(valuePassed); i++) {
      if ((valuePassed % i) == 0) {
        return false;
      }
    }
    return true;
  }

  
  // Static Method isEven(MyInteger) that return true if the value is even
  public static boolean isEven(MyInteger valuePassed) {
    return ((valuePassed.getValue() % 2) == 0);
  }

  // Static Method isOdd(MyInteger) that return true if the value is odd
  public static boolean isOdd(MyInteger valuePassed) {
    return ((valuePassed.getValue() % 2) == 1);
  }

  // Static Method isPrime(MyInteger) that return true if the value is prime
  // Code found on https://www.javatpoint.com/prime-number-program-in-java
  public static boolean isPrime(MyInteger valuePassed) {
    if (valuePassed.getValue() <= 1) {
      return false;
    }
    for (int i = 2; i < Math.sqrt(valuePassed.getValue()); i++) {
      if ((valuePassed.getValue() % i) == 0) {
        return false;
      }
    }
    return true;
  }


  //Methods equals(int) that return true if the value in the object is equal to the specified value.
  public boolean equals(int valuePassed){
    return (value == valuePassed);
  }

  //Methods equals(MyInteger) that return true if the value in the object is equal to the specified value.
  public boolean equals(MyInteger valuePassed){
    return (value == valuePassed.getValue());
  }


  //A static method parseInt(char[]) that converts an array of numeric characters to an int value.
  //Code taken from https://stackoverflow.com/questions/2683324/java-char-array-to-int
  public static int parseInt(char[] arrayPassed){
    int result = 0;
    int length = arrayPassed.length - 1;
    
    for (int i = 0; i <= length; i++)
    {
         int digit = arrayPassed[i] - '0'; //we don't want to cast by using (int)
         result *= 10;
         result += digit;
    }
    return result;
}

  //A static method parseInt(String) that converts a string into an int value.
  //Code taken from https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
  public static int parseInt(String stringPassed){
    int i = 0;
    int num = 0;
    boolean isNeg = false;

    // Check for negative sign; if it's there, set the isNeg flag
    if (stringPassed.charAt(0) == '-') {
        isNeg = true;
        i = 1;
    }

    // Process each character of the string;
    while( i < stringPassed.length()) {
        num *= 10;
        num += stringPassed.charAt(i++) - '0'; // Minus the ASCII code of '0' to get the value of the charAt(i++).
    }

    if (isNeg)
        num = -num;
    return num;
  }
}