package Array;

public class Insert_Element {
    public static void insert(int[] arr,int pos,int element){
        for(int i=arr.length-1;i>pos ;i--){
            arr[i]=arr[i-1];
        }
        arr[pos]=element;
        System.out.println("Array element inserted...");

    }
    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5,6,7,8,9};
        int pos=3;
        int element=4;
        insert(arr, pos, element);
        System.out.println("After Inserted Array is :...");
        for(int n :arr){
            System.out.println(arr[n]);
        }
    }
}
