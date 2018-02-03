public class Levenshtain {
    public static int levenDist(String s, String t){
        int n = s.length();
        int m = t.length();

        if(n==0) return m;
        if(m==0) return n;

        int[][] d = new int[n+1][m+1];
        for(int i=0; i<=m; ++i) d[0][i] = i;
        for(int j=0; j<=n; ++j) d[j][0] = j;


        for(int i=1; i<=n; ++i){
            for(int j=1; j<=m; ++j){
                int cost = 0;
                if(s.charAt(i-1) != t.charAt(j-1)) cost+=2;
                d[i][j] = Math.min(d[i-1][j]+1, Math.min(d[i][j-1]+1, d[i-1][j-1]+cost));
                }
        }
        return d[n][m];
    }

    public static void main(String[] shit){
        String a = "intention";
        String b = "execution";

        System.out.println("The Levenshtain distance between " + a + " and " + b + " is " + levenDist(a,b));
    }
}
