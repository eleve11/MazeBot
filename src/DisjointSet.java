/**
 * Created by Andrea on 29/05/2016.
 */
public class DisjointSet
{
    private int[] s;

    public DisjointSet(int numElements)
        {
            s = new int[numElements];
            for(int i=0; i<s.length; i++)
                s[i] = -1;
        }

        public void union(int root1, int root2)
        {
            if (s[root2]<s[root1]) {
                s[root1] = root2;
            } else {
                if (s[root1]==s[root2])
                    s[root1]--;
                s[root2] = root1;
            }
        }

        public int find(int x)
        {
            if (s[x]<0)
                return x;
            else
                return s[x] = find(s[x]);
        }
}
