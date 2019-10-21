package Dynamic;

public class RodCut
{
    int RodCutN(int p[],int length) //Naive
    {
        if(length==0)
            return 0;
        int q=0;
        for(int i = 1;i<length;i++)
        {
            q = Math.max(q, p[i] + RodCutN(p,length-i));
        }
        return q;
    }
    int RodCutR(int p[]) //Recursive
    {
        int length = p.length;
        int[] lookup = new int[length];
        for(int i=0;i<length;i++)
            lookup[i] = Integer.MAX_VALUE;

        return RodCutRR(p,length,lookup);
    }
    int RodCutRR(int[] p, int length, int[] lookup)
    {
        if(lookup[length]>Integer.MIN_VALUE)
            return lookup[length];
        if(length==0)
            return 0;

        int q=0;
        for(int i=1;i<length;i++)
        {
            q = Math.max(q,p[length] + RodCutRR(p,length-i,lookup));
        }
        lookup[length] = q;
        return q;
    }
    int RodCutI(int[] p) //Iterative
    {
        int length = p.length;
        int[] lookup = new int[length];
        for(int i=0;i<length;i++)
            lookup[i] = Integer.MIN_VALUE;

        for(int i=1;i<length;i++)
        {
            int q=0;
            for(int j=1;j<=i;j++)
            {
                q = Math.max(q, p[j] + lookup[i-j]);
            }
            lookup[i] = q;
        }

        return lookup[length];
    }
}
