public class AddBinary {
    public String addBinary(String a, String b) {
// //  Built-in function
//         return Integer.toBinaryString(Integer.parseInt(a, 2)+Integer.parseInt(b, 2));

//  直接string到string
        if((a==null||a=="")&&(b==null||b=="")) return "";

        int m = a.length();
        int n = b.length();
        if(m<n) return addBinary(b,a);

        StringBuilder sb = new StringBuilder();
        int i = m-1;
        int j = n-1;
        int carry = 0;
        while(i>=0){
            carry += a.charAt(i--)=='1'?1:0;
            if(j>=0) carry+=b.charAt(j)=='1'?1:0;
            j--;
            int cur = carry%2;
            sb.append(cur);
            carry/=2;
        }

        if(carry==1) sb.append(1);
        return sb.reverse().toString();

// string-->Integer-->String
        // long res = 0;
        // int tmp = 0;
        // for(int i=a.length()-1;i>=0;i--){
        //     res += (a.charAt(i)-'0')*Math.pow(2,tmp++);
        // }
        // tmp = 0;
        // for(int i=b.length()-1;i>=0;i--){
        //     res += (b.charAt(i)-'0')*Math.pow(2,tmp++);
        // }
        // StringBuilder sb = new StringBuilder();
        // if(res==0) return "0";
        // while(res>0){
        //     sb.append(res%2);
        //     res /=2;
        // }
        // return sb.reverse().toString();
    }
}
