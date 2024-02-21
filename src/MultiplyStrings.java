public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] products = new int[num1.length() + num2.length()];

        for (int i=num1.length()-1;i>=0;i--) {
            for(int j=num2.length()-1;j>=0;j--) {
                products[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

        int carry = 0;
        for(int i=products.length-1;i>=0;i--) {
            int cur = (products[i]+carry)%10;
            carry = (products[i]+carry)/10;
            products[i] = cur;
        }

        StringBuilder sb = new StringBuilder();
        boolean digitSeen = false;
        for(int p:products) {
            if(digitSeen || p!=0){
                sb.append(p);
                digitSeen = true;
            }
        }
        return sb.length()==0 ? "0" : sb.toString();
        
    }
}
