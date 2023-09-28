public class Largest_String {
    public static void main(String[] args){
        String fruits[] = {"Apple", "Banana", "Mango", "Kiwi", "Pineapple"};
        String lagest=fruits[0];
        for(int i=1; i<fruits.length; i++){
            if(fruits[i].length() > lagest.length()){
                lagest = fruits[i];
            }
        }
        System.out.println(lagest);

        // Another way
        String largest = fruits[0];
        for(int i=0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i]) < 0)
                largest = fruits[i];
        }
        System.out.println(largest);
    }
}