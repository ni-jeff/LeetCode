//solution1 recursion
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean firstMatch=!s.isEmpty()&&(s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');
        if(p.length()>=2&&p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||(firstMatch&&(isMatch(s.substring(1),p)));
        }
        else{
            return firstMatch&&isMatch(s.substring(1),p.substring(1));
        }
    }
}
//solution2 dp
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // M[i][j] represents if the 1st i characters in s can match the 1st j characters in p
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // initialization: 
		// 1. M[0][0] = true, since empty string matches empty pattern
        dp[0][0] = true;
        // 2. M[i][0] = false(which is default value of the boolean array) since empty pattern cannot match non-empty string
		// 3. M[0][j]: what pattern matches empty string ""? It should be #*#*#*#*..., or (#*)* if allow me to represent regex using regex :P, 
		// and for this case we need to check manually: 
        // as we can see, the length of pattern should be even && the character at the even position should be *, 
		// thus for odd length, M[0][j] = false which is default. So we can just skip the odd position, i.e. j starts from 2, the interval of j is also 2. 
		// and notice that the length of repeat sub-pattern #* is only 2, we can just make use of M[0][j - 2] rather than scanning j length each time 
		// for checking if it matches #*#*#*#*.
        for (int j = 2; j < dp[0].length; j += 2) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }
        // Induction rule is very similar to edit distance, where we also consider from the end. And it is based on what character in the pattern we meet.
        // 1. if p.charAt(j) == s.charAt(i), M[i][j] = M[i - 1][j - 1]
		//    ######a(i)
		//    ####a(j)
        // 2. if p.charAt(j) == '.', M[i][j] = M[i - 1][j - 1]
        // 	  #######a(i)
        //    ####.(j)
        // 3. if p.charAt(j) == '*':
        //    1. if p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i), then b* is counted as empty. M[i][j] = M[i][j - 2]
        //       #####a(i)
        //       ####b*(j)
        //    2.if p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i):
        //       ######a(i)
        //       ####.*(j)
		//
		// 	  	 #####a(i)
        //    	 ###a*(j)
        //      2.1 if p.charAt(j - 1) is counted as empty, then M[i][j] = M[i][j - 2]
        //      2.2 if counted as one, then M[i][j] = M[i - 1][j - 2]
        //      2.3 if counted as multiple, then M[i][j] = M[i - 1][j]
                
		// recap:
		// M[i][j] = M[i - 1][j - 1]
		// M[i][j] = M[i - 1][j - 1]
		// M[i][j] = M[i][j - 2]
		// M[i][j] = M[i][j - 2]
        // M[i][j] = M[i - 1][j - 2]
        // M[i][j] = M[i - 1][j]
		// Observation: from above, we can see to get M[i][j], we need to know previous elements in M, i.e. we need to compute them first. 
		// which determines i goes from 1 to m - 1, j goes from 1 to n + 1
		
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}