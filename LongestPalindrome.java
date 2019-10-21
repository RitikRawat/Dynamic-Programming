package Dynamic;

public class LongestPalindrome // Naive
{
    int LongestPalindromeN(char[] str,int i,int j)
    {
        if(i==j)
            return 1;
        int length =0;
        if(str[i] == str[j])
            length+= 2 + LongestPalindromeN(str,i+1,j-1);
        else
            length+= Math.max(LongestPalindromeN(str,i,j-1),LongestPalindromeN(str,i+1,j));

            return length;
    }
    int LongestPalindromeR(char[] str) // Recursive
    {
        int length = str.length;
        int[][] lookup = new int[length][length];
        for(int i=0;i<length;i++)
            lookup[i][i]=1;


        return LongestPalindromeRR(str,0,length-1,lookup);
    }
    int LongestPalindromeRR(char[] str, int i, int j,int[][] lookup)
    {
        if(lookup[i][j]>0)
            return lookup[i][j];

        if(str[i] == str[j])
            lookup[i][j]= 2+ LongestPalindromeRR(str,i+1,j-1,lookup);
        else
            lookup[i][j] = Math.max(LongestPalindromeRR(str,i+1,j,lookup),LongestPalindromeRR(str,i,j-1,lookup));

        return lookup[i][j];
    }
    int LongestPalindromeI(char[] str) // Iterative
    {
        int length = str.length;
        int[][] lookup = new int[length][length];
        for(int i=0;i<length;i++)
            lookup[i][i]=1;

        for(int L = 2;L<=length;L++)
        {
            for(int i =0;i<length-L+1;i++)
            {
                int j = i+length-1;
                if(str[i]==str[j])
                    lookup[i][j]+=2;
                else
                    lookup[i][j] = Math.max(lookup[i][j-1],lookup[i+1][j]);
            }
        }

        return lookup[0][length-1];
    }


}
