/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start

import java.util.Map;
import java.util.HashMap;


class Solution {
    public String intToRoman(int roman) {
       
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9 , 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++) {
            while(roman >= values[i]) {
                roman -= values[i];
                sb.append(map.get(values[i]));
            }
        }
        return sb.toString();
        
    
    }

    public String intToRoman2(int num) {
        
        
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};
        
        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
        
    

    }
}
// @lc code=end

