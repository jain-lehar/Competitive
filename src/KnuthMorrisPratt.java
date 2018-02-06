public class KnuthMorrisPratt {

    private int M;
    private String pattern;
    private int dfa[][];
    private static final int R = 256;

    public KnuthMorrisPratt(String pattern){
        this.pattern = pattern;
        M = pattern.length();
        dfa = new int[R][M];
        dfa[pattern.charAt(0)][0] = 1;
        for(int x=0,j=1;j<M;j++){
            for(int c=0;c<R;c++){
                dfa[c][j] = dfa[c][x];
            }
            dfa[pattern.charAt(j)][j] = j+1;
            x = dfa[pattern.charAt(j)][x];
        }
    }

    public int search(String txt){
        int i,j,N = txt.length();
        for(i=0,j=0;j<M&&i<N;i++){
            j = dfa[txt.charAt(i)][j];
        }
        if(j==M) return i-M;
        else return N;
    }
}
