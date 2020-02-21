import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if(s==null||s.length()==0) return s;

        Stack<int[]> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') stk.push(new int[]{i,0});
            else if(c==')'){
                if(!stk.isEmpty()&&stk.peek()[1]==0){
                    stk.pop();
                }else{
                    stk.push(new int[]{i,1});
                }
            }
        }
        if(stk.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(!stk.isEmpty()&&stk.peek()[0]==i){
                stk.pop();
            }else sb.append(s.charAt(i));

        }

        return sb.reverse().toString();
    }
}
