/**
 * Data Structure that allow union-find algorithm
 * (commonly used in Dijkstra's algorithm)
 *
 * Represent up to n Disjoint sets which can
 * union(a,b) to compute set union between 2 disjoint sets
 * and find(elem) to find the belonging set [root]
 *
 * Each set is a tree when we union 2 sets the smaller one
 * gets added to the bigger and form a bigger tree
 */
public class DisjointSets
{
    private int[] s;

    /*
        Constructor with size
        populate array with empty indicators
     */
    public DisjointSets(int numElements)
        {
            s = new int[numElements];
            for(int i=0; i<s.length; i++)
                s[i] = -1; //negative values mean root and depth
        }

        /*
            union of set that has root1 with set that has root 2
            represent 2 elements in the same set by having the same root

            one of the root becomes root of other tree
         */
        public void union(int root1, int root2)
        {
            //greater height (negatives represent depth so smaller is deeper) has priority
            if (s[root2]<s[root1]) {
                s[root1] = root2; //element points to new root
            } else {
                //if same height tree goes deeper
                if (s[root1]==s[root2])
                    s[root1]--;
                s[root2] = root1; //element point to new root
            }
        }

        /*
            find the set given an element
         */
        public int find(int x)
        {
            if (s[x]<0) //a root
                return x;
            else
                return s[x] = find(s[x]);
        }
}
