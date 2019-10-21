package Dynamic;

public class EditDistance
{
    int EditDistanceN(char[] A,char[] B,int i,int j) // Naive
    {
        int cost =0;
        if(i==0)
            cost = j;
        if(j==0)
            cost = i;
        if(A[i]==A[j])
            cost = EditDistanceN(A,B,i-1,j-1);
        else
            cost = 1+ Math.min(Math.min(EditDistanceN(A,B,i,j-1),EditDistanceN(A,B,i-1,j)),EditDistanceN(A,B,i-1,j-1));

        return cost;
    }
    int EditDistanceR(char[] A, char[] B) // Recursive
    {
        int lengthA = A.length;
        int lengthB = B.length;
        int[][] lookup = new int[lengthA+1][lengthB +1];
        for(int i=0;i<lengthA+1;i++)
            for(int j=0;j<lengthB+1;j++)
                lookup[i][j] = Integer.MAX_VALUE;

        return EditDistanceRR(A,B,lengthA,lengthB,lookup);
    }
    int EditDistanceRR(char[] A, char[] B,int i, int j,int[][] lookup)
    {
        if(lookup[i][j]<Integer.MAX_VALUE)
            return lookup[i][j];

        if(i==0)
            lookup[i][j] = j;
        if(j==0)
            lookup[i][j] = i;


        if(A[i]==B[j])
            lookup[i][j] = lookup[i-1][j-1];
        else
            lookup[i][j] =1 + Math.min(Math.min(lookup[i][j-1],lookup[i-1][j]),lookup[i-1][j-1]);

        return lookup[i][j];
    }
    int EditDistanceI(char[] A,char[] B) // Iterative
    {
        int lengthA = A.length;
        int lengthB = B.length;
        int[][] lookup = new int[lengthA+1][lengthB +1];
        for(int i=0;i<lengthA;i++)
            for(int j=0;j<lengthB;j++)
            {
                if(i==0)
                    lookup[i][j] = j;
                if(j==0)
                    lookup[i][j] = i;


                if(A[i]==B[j])
                    lookup[i][j] = lookup[i-1][j-1];
                else
                    lookup[i][j] =1 + Math.min(Math.min(lookup[i][j-1],lookup[i-1][j]),lookup[i-1][j-1]);
            }

        return lookup[lengthA][lengthB];
    }
}
