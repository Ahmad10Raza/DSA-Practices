public class RotateArray_Kth 
{
    public  static void rightRotate(int arr[],int n){
        int temp=arr[n-1];
        for(int i =n-1;i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=temp;
    } 
    public static void Array_Rotate(int arr[],int n,int k){
        for(int i=1;i<=k;i++){
            rightRotate(arr, n);
        }
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6};
        int n=arr.length-1;
        int k=2;
        Array_Rotate(arr, n, k);
        System.out.println("After Roating Array :...");
        for(int e :arr){
            System.out.println(arr[e]);
        }
    }
}
