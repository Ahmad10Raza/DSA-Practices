public class Last_Occurance_Of_Element {
    public static int last_occurance(int arr[], int key, int i){
        if(i==arr.length){
            return -1;
        }
        int idx=last_occurance(arr,key,i+1);
        if(idx==-1 && arr[i]==key){
            return i;
        }
        
        return idx;
    }

    
    public static void main(String args[]){
        int[] arr={1,2,8,3,4,4,5,6,7,8};
        int key=8;
        int idx=last_occurance(arr,key,0);
        System.out.println(idx);
    }
}