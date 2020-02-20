public class AddStrings {
    public String addStrings(String num1, String num2) {
        if((num1==null||num1.length()==0)&&(num2==null||num2.length()==0)) return "";
        if(num1==null||num1.length()==0) return num2;
        if(num2==null||num2.length()==0) return num1;

        int m = num1.length();
        int n = num2.length();
        if(m<n) return addStrings(num2, num1);

        StringBuilder sb = new StringBuilder();
        int i = m-1;
        int j = n-1;

        int carry = 0;
        while(i>=0){
            carry+=(num1.charAt(i)-'0');
            if(j>=0) carry+=(num2.charAt(j)-'0');
            j--;
            int cur = carry%10;
            sb.append(cur);
            carry/=10;
            i--;
        }

        if(carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }
}
