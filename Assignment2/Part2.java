import java.util.Scanner;

public class Part2 {

   public static void main(String args[]) {

     Scanner sc = new Scanner(System.in); // System.in is a standard input stream

     int size;  

    System.out.print("Enter the number of elements you want to store: ");  
    //reading the number of elements user want us to store  
    size = sc.nextInt();  
     
     //Created an array with some integers order to play with
    int[] arr = new int[size];

    System.out.println("Enter the elements of the array: ");  
    for(int i = 0; i < size; i++)  
      {  
        //reading array elements from the user   
        arr[i]=sc.nextInt();  
      }  
           

     System.out.print("Please enter the key to find from the array: ");
     //Key to find the element
    int key = sc.nextInt();


     //We sort the array here so that it's ready for the binary search
    Sorting obj1 = new Sorting();
     obj1.sortingTheArray(arr);

     //We print the array to show to the user, after it's been sorted
     System.out.println("The Array after sorted, it is as follows:");
     for(int i = 0; i < arr.length; i++)
       System.out.println(arr[i]);
     
     //Get the last array number till which we need to search
    int last = arr.length - 1;
    BinarySearchExample obj = new BinarySearchExample();
    //Call the function to begin the search
     obj.binarySearch(arr,0,last,key);
  }
 
}


class Sorting {
  public void sortingTheArray(int arr[]){
     
    int tempValue = 0;
    
        //Sorted the array in ascending order using nested for loops, we just check two element and then we swap it if needed.
    for (int i = 0; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) {
                tempValue = arr[i];
                arr[i] = arr[j];
                arr[j] = tempValue;
        }
      }
    }
  }
};

class BinarySearchExample { 
  public void binarySearch(int arr[], int first, int last, int key) {

    //Get the middle value and we will see if it's in the first half or the second half
    int mid = (first + last) / 2;
    
    //The process will keep on going until we found the key or we have searched through the array
    while (first <= last) {
      
      //if it's in first half we will start with reasiging the first to mid + 1
      if (arr[mid] < key) {
        first = mid + 1;
      } else if (arr[mid] == key) {
        System.out.println("Element is found at index: " + mid);
        break;
      } 
        
      //or else we will begin with last = mid - 1
      else {
        last = mid - 1;
      }

      //Then we get the middle point of the first and last
      mid = (first + last) / 2;
    }
    
    //If the first gets larger than last then we know we haven't found the element.
    if (first > last) {
      System.out.println("Element is not found!");
    }
  }

}