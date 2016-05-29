import java.util.Random;

/**
 * Created by Andrea on 29/05/2016.
 */
public class Maze
{
    //define cell values
    public final static int WALL = 0; //wall as default value
    public final static int SPACE = 1;
    public final static int VISITED = 2;
    public final static int DEAD_END = 3;

    public static int[][] maze;
    static int size;
    static int sleeptime;
    static int entry, exit;

    static Random random = new Random();


    public static void main(String[] args){
        //size = Integer.parseInt(args[0]);
        //sleeptime = Integer.parseInt(args[1]);
        size = 6;
        sleeptime = 10;
        final MazeFrame f = new MazeFrame("Maze solver");
        f.init();
    }

    /*
     * generate a random maze
     */
    static void generate(){
        DisjointSet dj = new DisjointSet(size*size);

        maze = new int[size][size];

        // clear a path in and out of the maze
        entry = 0;
        exit = size -1;
        maze[entry][0] = SPACE;
        maze[entry][1] = SPACE;
        maze[exit][size-1] = SPACE;
        maze[exit][size-2] = SPACE;

        path((exit)*(exit)-1,dj);
    }

    private static void path(int index, DisjointSet dj)
    {
        //until there is a path
        while(dj.find(entry+1) != dj.find(index))
        {
            //loop cells
            for (int i=1; i< size-1; i+=2){
                for (int j=1; j < size-1; j+=2){

                    int find0 = dj.find(i*size + j);
                    int find2, find1;

                    //random direction
                    //default finds
                    find2 = i*size + j;
                    find1 = find2;
                    int r = random.nextInt(4);
                    //test random edge
                    switch(r){
                        case 0:
                            if(i-2>=0) {
                                find2 = (i - 2) * size + j;
                                find1 = (i - 1) * size + j;
                            }else r=-1;
                            break;
                        case 1:
                            if(i+2<size-1) {
                                find2 = (i + 2) * size + j;
                                find1 = (i + 1) * size + j;
                            }else r=-1;
                            break;
                        case 2:
                            if(j-2>=0) {
                                find2 = i * size + j - 2;
                                find1 = i * size + j - 1;
                            }else r=-1;
                            break;
                        case 3:
                            if(j+2 < size-1) {
                                find2 = i * size + j + 2;
                                find1 = i * size + j + 1;
                            }else r=-1;
                            break;
                    }
                    find2 = dj.find(find2);
                    find1 = dj.find(find1);


                    //randomly remove wall if is not part of same path
                    if ((find0 != find2 && find0!=find1) && Math.random() > 0.5) {
                        dj.union(find0, find2);
                        dj.union(find0,find1);

                         maze[i][j] = SPACE;

                        switch(r){
                            case 0:
                                maze[i-1][j] = SPACE;
                                maze[i-2][j] = SPACE;
                                break;
                            case 1:
                                maze[i+1][j] = SPACE;
                                maze[i+2][j] = SPACE;
                                break;
                            case 2:
                                maze[i][j-1] = SPACE;
                                maze[i][j-2] = SPACE;
                                break;
                            case 3:
                                maze[i][j+1] = SPACE;
                                maze[i][j+2] = SPACE;
                                break;
                        }
                    }
                }
            }
        }
    }

}
