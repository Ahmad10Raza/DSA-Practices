
public class Insert_Element_Main {
    public static void main(String[] args) {
      int[] array = {2, 3, 4, 5};
      
      // Inserting 6 at the beginning
      int index = 0;
      int newItem = 6;
      int n = array.length + 1;   
      int[] newArray = new int[n]; 
      
      for (int i=n-1; i>index; i--) {
        newArray[i] = array[i-1];
      }
      newArray[index] = newItem;
  
      for (int j=0; j<n-1; j++) {
        newArray[j+1] = array[j];
      }
  
      System.out.println("After insertion:");
      for (int k=0; k<n; k++) {
        System.out.println(newArray[k]);
      }
    }
  }
  