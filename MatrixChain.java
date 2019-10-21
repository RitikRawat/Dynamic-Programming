package Dynamic;

public class MatrixChain
{
    int MatrixChainN(int p[],int i,int j) // Naive
    {
        if(i==j)
            return 0;
        int minCost = Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int cost = MatrixChainN(p,i,k) + MatrixChainN(p,k+1,j) + p[i-1]*p[k]*p[j];
            if(minCost>cost)
               minCost = cost;
        }
        return minCost;
    }
    int MatrixChainR(int[] p) // Recursive
    {
        int length = p.length -1;
        int[][] lookup = new int[length+1][length+1];
        for (int i=1;i<length+1;i++)
        {
            for (int j=1;j<length+1;j++)
                lookup[i][j] = Integer.MAX_VALUE;
        }
        for(int i=0;i<length+1;i++)
        {
            lookup[i][0]=0;
            lookup[0][i]=0;
            lookup[i][i]=0;
        }
         return MatrixChainRR(p,0,length,lookup);
    }
    int MatrixChainRR(int[]p,int i,int j,int[][] lookup)
    {
        if(lookup[i][j]<Integer.MAX_VALUE)
            return lookup[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int cost = MatrixChainRR(p,i,k,lookup) + MatrixChainRR(p,k+1,j,lookup) + p[i-1]*p[k]*p[j];
            if(minCost>cost)
                minCost=cost;
        }

        return minCost;
    }
    int MatrixChainI(int[] p) // Iterative
    {
        int length = p.length -1;
        int[][] lookup = new int[length+1][length+1];

        for(int i=0;i<length+1;i++)
        {
            lookup[i][0]=0;
            lookup[0][i]=0;
            lookup[i][i]=0;
        }
         for(int L =2;L<length+1;L++)
         {
             for(int i=1;i<length-L+2;i++)
             {
                 int j = i+L-1;
                 if(j==length+1)
                     continue;
                 for(int k =i;k<j;k++)
                 {
                     int cost = lookup[i][k] + lookup[k+1][j] + p[i-1]*p[k]*p[j];
                     if(cost<lookup[i][j])
                         lookup[i][j] = cost;
                 }
             }
         }

         return lookup[1][length];
    }
}
