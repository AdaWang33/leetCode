import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */

public class AccountsMerge {
    List<List<String>> res = new ArrayList<>();
    HashMap<String, String> name = new HashMap<>();
    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Set<String>> union = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // initialize
        for (List<String> account : accounts) {
            for (int i=1;i<account.size();i++) {
                parent.put(account.get(i), account.get(i));
                name.put(account.get(i), account.get(0));
            }
        }

        // do joining by parent (path compression)
        for (List<String> account : accounts) {
            String curPar = findParent(account.get(1));
            for (int i=2;i<account.size();i++) {
                parent.put(findParent(account.get(i)), curPar);
            }
        }

        // iterate and form union by common parent
        for (List<String> account : accounts) {
            String curPar = findParent(account.get(1));
            for(int i=1; i<account.size(); i++) {
                Set<String> unionSet = union.getOrDefault(curPar, new HashSet<>());
                unionSet.add(account.get(i));
                union.put(curPar, unionSet);
            }
        }

        for (String key : union.keySet()) {
            List<String> acc = new ArrayList<>(union.get(key));
            Collections.sort(acc, (a,b)-> a.compareTo(b));
            acc.add(0, name.get(key));
            res.add(acc);
        }
        return res;
    }

    private String findParent(String str) {
        return parent.get(str) == str ? str : findParent(parent.get(str));
    }
    // List<List<String>> res = new ArrayList<>();
    // Map<String, String> name = new HashMap<>();
    // Map<String, String> parent = new HashMap<>();
    // Map<String, Set<String>> union = new HashMap<>();

    // public List<List<String>> accountsMerge(List<List<String>> accounts) {
    //     for(List<String> account: accounts){
    //         for(int i=1;i<account.size();i++){
    //             parent.put(account.get(i), account.get(i));
    //             name.put(account.get(i), account.get(0));
    //         }
    //     }

    //     for(List<String> account: accounts){
    //         String par = findParent(account.get(1));
    //         for(int i=2;i<account.size();i++){
    //             parent.put(findParent(account.get(i)), par);
    //         }
    //     }

    //     for(List<String> account: accounts){
    //         String par = findParent(account.get(1));
    //         for(int i=1;i<account.size();i++){
    //             union.putIfAbsent(par, new HashSet<>());
    //             union.get(par).add(account.get(i));
    //         }
    //     }

    //     for(String par:union.keySet()){
    //         List<String> curUnion = new ArrayList<>(union.get(par));
    //         Collections.sort(curUnion, (a,b)-> a.compareTo(b));
    //         curUnion.add(0, name.get(par));
    //         res.add(curUnion);
    //     }

    //     return res;
    // }

    // public String findParent(String cur){
    //     return parent.get(cur) == cur ? cur : findParent(parent.get(cur));
    // }
}
