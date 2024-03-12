public class RemoveInvalidParentheses {
        // https://leetcode.com/problems/remove-invalid-parentheses/solutions/75032/share-my-java-bfs-solution/

        public List<String> removeInvalidParentheses(String s) {
            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();    
            List<String> res = new ArrayList<>();
            if(s==null) return res;
    
            queue.add(s);
            visited.add(s);
    
            boolean foundInCurLevel = false;
            while(!queue.isEmpty()) {
                String curStr = queue.poll();
                if(isValid(curStr)) {
                    res.add(curStr);
                    foundInCurLevel = true;
                }
    
                if(foundInCurLevel) continue;
                // remove possible char and start next iteration
                for(int i=0;i<curStr.length();i++) {
                    if(curStr.charAt(i)!='(' && curStr.charAt(i)!=')') continue;
                    String nextStr = curStr.substring(0, i) + curStr.substring(i+1);
                    if(!visited.contains(nextStr)) {
                        queue.add(nextStr);
                        visited.add(nextStr);
                    }
                }
            }
    
            return res;
        }
    
        private boolean isValid(String s) {
            int cnt = 0;
            for(char c:s.toCharArray()) {
                if(c=='(') {
                    cnt++;
                }
                if(c==')') {
                    if(cnt==0) return false;
                    cnt--;
                }
            }
            return cnt==0;
        }
}