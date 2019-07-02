
public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder  result = new StringBuilder();
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] chars= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        while(num!=0){
            for(int i =0; i<nums.length;i++){
                if(num>=nums[i]){
                    result.append(chars[i]);
                    num-=nums[i];
                    break;
                }
            }
        }
        return result.toString();

    }
}



/**
 * StringBuilder result = new StringBuilder();
 *         StringBuilder[] indexSt = new StringBuilder[10];
 *         indexSt[0] = new StringBuilder("");
 *         for (int i = 1; i < 10; i++) {
 *             indexSt[i] = new StringBuilder();
 *         }
 *         indexSt[1].append("0");
 *         indexSt[2].append("00");
 *         indexSt[3].append("000");
 *         indexSt[4].append("01");
 *         indexSt[5].append("1");
 *         indexSt[6].append("10");
 *         indexSt[7].append("100");
 *         indexSt[8].append("1000");
 *         indexSt[9].append("02");
 *
 *
 *         String symbol[][] = {
 *                 {"I", "V", "X"},
 *                 {"X", "L", "C"},
 *                 {"C", "D", "M"},
 *                 {"M"}
 *         };
 *
 *         String str = Integer.toString(num);
 *         for (int i = 0; i < str.length(); i++) {
 *             for(int j=0;j<indexSt[Character.getNumericValue(str.charAt(i))].length();j++){
 *                 result.append(symbol[str.length()-i-1][Character.getNumericValue(indexSt[Character.getNumericValue(str.charAt(i))].charAt(j))]);
 *             }
 *         }
 *         String ans = result.toString();
 *         return ans;
 */