public class Total_Occurance_Of_Elements {
    public static int totalOccurance(int[] arr, int idx, int data) {
        if (idx == arr.length)
        {
            return 0;
        }
        int recAns = totalOccurance(arr, idx + 1, data);
        if (arr[idx] == data){
            System.out.println("Found at :" + idx);
            recAns++;
        }
        return recAns;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 2, 2, 2, 2, 2, 2 };
        System.out.println("Total Occurance:" + totalOccurance(arr, 0, 2));
    }
}