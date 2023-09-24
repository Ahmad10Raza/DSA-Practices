public class First_Occuranance_Of_Element {
    public static int first_occurance(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        int idx=first_occurance(arr,key,i+1);
        return idx;
    }
    public static void main(String args[]){
        int[] arr={1,2,8,3,4,4,5,6,7,8};
        int key=8;
        int idx=first_occurance(arr,key,0);
        System.out.print(idx);
    }
}