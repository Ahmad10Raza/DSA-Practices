package Array;

public class Remove_Duplicate {
    public static int rmDuplicate(int arr[],int n){
        if(n==0 || n==1){
            return n;
        }
        int len=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=arr[i+1]){
                arr[len++]=arr[i];
            }
            arr[len++]=arr[n-1];
        }
        System.out.println("the Array and length is "+arr + len);

        return len;
    }
    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,4,5,1,2,3,9};
        rmDuplicate(arr, arr.length);
    }
}
