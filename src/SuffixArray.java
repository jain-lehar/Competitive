import java.util.Arrays;

public class SuffixArray {

    public int[] buildSuffixArray(String text){

        int n = text.length();
        Suffix suffixes[] = new Suffix[n];
        for(int i=0;i<n;i++){
            suffixes[i].index = i;
            suffixes[i].rank[0] = text.charAt(i)-'a';
            suffixes[i].rank[1] = ((i+1)<n)?text.charAt(i+1)-'a':-1;
        }
        Arrays.sort(suffixes);
        int ind[] = new int[n];
        for(int k=4;k<2*n;k*=2){
            int rank=0;
            int prevRank = suffixes[0].rank[0];
            suffixes[0].rank[0] = rank;
            ind[suffixes[0].index] = 0;
            for(int i=1;i<n;i++){
                if(suffixes[i].rank[0]==prevRank&&suffixes[i].rank[1]==suffixes[i-1].rank[1]){
                    suffixes[i].rank[0] = rank;
                }
                else {
                    prevRank = suffixes[i].rank[0];
                    suffixes[i].rank[0] = ++rank;
                }
                ind[suffixes[i].index] = i;
            }
            for(int i=0;i<n;i++){
                int nextIndex = suffixes[i].index+k/2;
                suffixes[i].rank[1] = (nextIndex < n)? suffixes[ind[nextIndex]].rank[0]: -1;
            }
            Arrays.sort(suffixes);
        }
        int[] suffixArray = new int[n];
        for(int i=0;i<n;i++)
            suffixArray[i] = suffixes[i].index;
        return suffixArray;
    }

    class Suffix implements Comparable<Suffix>{

        int index;
        int rank[] = new int[2];
        @Override
        public int compareTo(Suffix o) {
            return (this.rank[0]==o.rank[0])?this.rank[1]-o.rank[1]:this.rank[0]-o.rank[0];
        }
    }
}
