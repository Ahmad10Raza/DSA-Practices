public class Remove_Duplicate_Main {
    //function to remove duplicates
public static int[] removeDuplicates(int[] arr) 
{ 
    // Return, if array is empty 
    // or contains a single element 
    if (arr.length < 2) 
        return arr; 
  
    int j = 0;    
    int i = 1; 
  
    // Similarly loop the array starting from 
    // second element 
    while (i < arr.length)  
    { 
        // If the current element is not a duplicate 
        if (arr[i] != arr[j]) 
        { 
            j++; 
            arr[j] = arr[i];  
        } 
        i++; 
    }
  
    // Create a copy of array till j index 
    int[] temp = new int[j+1]; 
    for (int k=0; k<temp.length; k++) 
        temp[k] = arr[k]; 
  
    return temp; 
}

// Driver program to test above 
public static void main(String[] args) 
{ 
    int[] array = {1, 2, 5, 1, 7, 2, 4, 2}; 
    int[] arrayWithoutDuplicates = removeDuplicates(array); 
  
    System.out.println("Array Without Duplicates : "); 
    
    for (int i = 0; i < arrayWithoutDuplicates.length; i++) 
    { 
        System.out.print(arrayWithoutDuplicates[i]+"\t"); 
    } 
    
}

}
