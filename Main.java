import java.util.*; // importing scanner //

class Main {

  // Problem: String Compression

  // Given an array of characters with repeats, compress it in place. The length after compression should be less than or equal to the original array.
  // Example:
  // Input: ['a', 'a', 'b', 'c', 'c', 'c']
  // Output: ['a', '2', 'b', 'c', '3']

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("String Compression\n\nPlease enter a string of characters: ");
    String s = input.nextLine(); // extracting user's input //
    String[] arrOfchar = new String[s.length()]; // creating an array of characters with the length of a string //
    for(int i = 0; i < s.length(); i++) {
      arrOfchar[i] = s.substring(i, i+1); // adding each character to an array //
    }
    // Sorting each character in alphabetical order //
    String temp = "";
    for (int i = 0; i < arrOfchar.length; i++) {
      for (int j = i + 1; j < arrOfchar.length; j++) { // going one character by one through the whole array of characters //
        if (arrOfchar[i].compareTo(arrOfchar[j]) > 0) { // if a certain character is before the other character in an alphabetical order, then temporarily hold the character to be swaped //
          temp = arrOfchar[i];
          arrOfchar[i] = arrOfchar[j];
          arrOfchar[j] = temp;
        }
      }
    }
    System.out.println("\nString Compression: " + Arrays.toString(compression(arrOfchar))); // printing compression method //
  }

  public static String[] compression(String[] arr) {

    int count = 1; // start with 1 //
    String result = ""; // will be used to build a string of char and numbers //

    for(int i = 0; i < arr.length-1; i++) { // going through each character //
      if(arr[i].equals(arr[i+1])) { // if neighbour characters are the same //
        count++; // increase the count variable //
      }
      else { // otherwise... //
        result += String.valueOf(arr[i]) + "," + count + ","; // add to a string the number of times the character appeared in the array //
        count = 1; // set count variable back to one to keep track of the remaining characters //
      }
    }

    result += String.valueOf(arr[arr.length-1]) + "," + count; // this line of code is for the last character in the array //

    String[] compressed = null; // transferring string to string[] //
    compressed = result.split(","); 

    return compressed; // returning new array //
  }

}