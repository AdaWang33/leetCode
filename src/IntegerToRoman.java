public class IntegerToRoman {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        StringBuilder[] indexSt = new StringBuilder[10];
        indexSt[0] = new StringBuilder("");
        for (int i = 1; i < 10; i++) {
            indexSt[i] = new StringBuilder();
//            if (i < 4 && i > 0) {
//                indexSt[i].append('0' * i);
////                System.out.println(indexSt[i]);
//            } else if (i == 4) indexSt[i].append('1');
//            else if (4 < i && i < 9) {
//                indexSt[i].append('1');
//                indexSt[i].append('0' * (i - 5));
//            } else if (i == 9) indexSt[i].append("12");
        }
        indexSt[1].append("0");
        indexSt[2].append("00");
        indexSt[3].append("000");
        indexSt[4].append("01");
        indexSt[5].append("1");
        indexSt[6].append("10");
        indexSt[7].append("100");
        indexSt[8].append("1000");
        indexSt[9].append("02");


        String symbol[][] = {
                {"I", "V", "X"},
                {"X", "L", "C"},
                {"C", "D", "M"},
                {"M"}
        };

        String str = Integer.toString(num);
        for (int i = 0; i < str.length(); i++) {
            for(int j=0;j<indexSt[Character.getNumericValue(str.charAt(i))].length();j++){
                result.append(symbol[str.length()-i-1][Character.getNumericValue(indexSt[Character.getNumericValue(str.charAt(i))].charAt(j))]);
            }
        }
        String ans = result.toString();
        return ans;
    }
}