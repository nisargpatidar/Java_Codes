import java.util.Scanner;

public class Part1 {

  public static void main(String args[]) {

    //Declare all the necessary variables
    int size = 20;

    QueueOfIntegers obj = new QueueOfIntegers(size);

    char choiceOfUser = ' ';



    //Printed the menu for the user to play with the Queue

        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
    System.out.print("Welcome to play with Queue: \n");
    System.out.print("Press 1 to check it's empty() \n");
    System.out.print("Press 2 to add() \n");
    System.out.print("Press 3 to offer() \n");
    System.out.print("Press 4 to peek() \n");
    System.out.print("Press 5 to check the element() \n");
    System.out.print("Press 6 to remove() \n");
    System.out.print("Press 7 to poll() \n");
    System.out.print("Press 8 to print() \n");
    System.out.print("Press q to exit.\n");


    //Kept the user in the loop until the user select q to exit

    while(choiceOfUser != 'q')
      {
        choiceOfUser = sc.next().charAt(0);

        //Implemented switch case to call the respective function according to the user's need
        switch(choiceOfUser) {
            //1 to check if it's empty
          case '1':
            if(obj.empty() == false)
               System.out.println("Queue is not empty.");
            else
              System.out.println("Queue is empty.");
            break;
            //2 to add()
          case '2':
            obj.add();
            break;
            //3 to offer()
          case '3':
            obj.offer();
            break;
            //4 to peek()
          case '4':
            System.out.println(obj.peek());
            break;
            //5 to element()
          case '5':
            System.out.println(obj.element());
            break;
            //6 to remove()
          case '6':
            System.out.println(obj.remove());
            break;
            //7 to poll()
          case '7':
            System.out.println(obj.poll());
            break;
            //8 to print the current state of the queue
          case '8':
            obj.print();
            break;
            //q to exit the loop and program
          case 'q':
            System.out.println("Thanks for playing with us!");
            return;
            //Default case, if the user enter anything invalid
          default:
            System.out.print("Unknown character");
            break;
        }

        //At last ask the user for another input 
        System.out.println("Please select another choice: ");
      }
  }

}



class QueueOfIntegers {

  //Declare all variables in class
  public static int[] elements;
  public int front, rear, capacity;

  //Set the default constructor
  public QueueOfIntegers() {
    front = rear = 0;
    capacity = 16;
    elements = new int[capacity];
  }

  //Set the constructor with specific size
  public QueueOfIntegers(int size) {
    capacity = size;
    elements = new int[capacity];
  }

  //Check if the Queue is empty or not?
  public boolean empty() {
    if (rear == 0)
      return true;
    else
      return false;
  }

  //It will add the element to the Queue, if failed then it will throw an exception.
  public boolean add() {
    Scanner sc = new Scanner(System.in); // System.in is a standard input stream
    System.out.print("Please enter a number to add in the Queue: ");
    int a = sc.nextInt();


    //Try to add the element at the rear
    try {
      elements[rear] = a;
      rear++;

      //Was causing the issue so commented out the close
      //sc.close()
      return true;
    } 
    //If it failed than it will throw an exception
    catch (ArithmeticException e) {
      e.printStackTrace();
      return false;
    }
  }


  //It will add the element to the Queue, if Queue not full
  public boolean offer() {
    Scanner sc = new Scanner(System.in); // System.in is a standard input stream
    System.out.print("Please enter a number to add in the Queue: ");
    int a = sc.nextInt();

    //Check if the Queue is full or not
    if (capacity == rear) {
      //Was causing the issue so commented out the close
      // sc.close(); close is the issue
      return false;
    }

    //If not full than it will add to the Queue
    else {
      elements[rear] = a;
      rear++;

      //Was causing the issue so commented out the close
      // sc.close();
      return true;
    }
  }
  
  
  //It will print the head element of the queue
  public int peek() {

    //Will check if the Queus is empty or not
    if (rear == 0) {
      System.out.print("\nQueue is empty\n");
      return -1;
    }
    //If not then it will print the head element of the queue
    System.out.print("Head Element of the queue: ");
    return elements[front];
  }
  

  //It will print the head element of the queue
  public int element() {

    //Will try to print the head of the Queue
    try {
      System.out.print("Head Element of the queue: ");
      return  elements[front];
    } 
    //If failed than it will throw an exception
    catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }


  //It will remove the head element of the Queue
  public int remove() {

    //Will try to remove and return the head element of the Queue
    try {
      for (int i = 0; i < rear - 1; i++) {
        elements[i] = elements[i + 1];
      }
      if (rear < capacity)
        elements[rear] = 0;

      rear--;

      return elements[rear];
    }

    //If it failed than it will throw an exception
    catch (Exception e) {
      System.out.println(e.toString());
      return -1;
    }
  }

  
  //It will remove the head element of the Queue, if Queue is not empty
  public int poll() {

    //It will check if the Queue is empty or not
    if (rear == 0) {
      System.out.print("\nQueue is empty\n");
      return -1;
    }

    //It will remove and return the head element of the Queue
    else {
      for (int i = 0; i < rear - 1; i++) {
        elements[i] = elements[i + 1];
      }

      if (rear < capacity)
        elements[rear] = 0;

      rear--;
    }

    return elements[rear];
  }


//It will just print the current state of the Queue
  public void print() {

    if(rear != 0) {
      System.out.println("The Queue is as follows: ");
      for (int i = 0; i < rear; i++) {
        System.out.println(elements[i]);
      }
    }
  }
}