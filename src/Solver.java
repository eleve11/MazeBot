/**
 * Created by Andrea on 29/05/2016.
 */
public class Solver
{
    MazePanel p;
    int size;

    public Solver(MazePanel p){
        this.p = p;
        size = p.getMaze().length;
    }

    private boolean isEntry(int i,int j){
        return (j < 0) ;
    }

    private boolean isWall(int i, int j){
        return (p.getMaze()[i][j] == Maze.WALL);
    }

    private boolean isVisited(int i,int j){
        return (p.getMaze()[i][j] == Maze.VISITED || p.getMaze()[i][j] == Maze.DEAD_END);
    }

    private boolean isExit(int i, int j){
        return (i==size);
    }

    private void visit(int i, int j){
        p.getMaze()[i][j] = Maze.VISITED;
        p.repaint();
    }

    private void failed(int i,int j){
        p.getMaze()[i][j] = Maze.DEAD_END;
        p.repaint();
    }

    public boolean solve(int i, int j){

        if(i<0 || j<0) return false;

        //sleep to show animation
        try { Thread.sleep(Maze.SLEEPTIME) ; }
        catch (InterruptedException e) { }

        // In this case a path is found
        if ( isExit(i,j) ) {
            return true;
        }

        // In any of these cases, no path is found
        if(   isEntry(i,j) ||
                isWall(i,j)  ||
                isVisited(i,j)
                )
        { return false; }

        // Mark the current cell as visited
        visit(i,j);

        // Recursively explore the neighbouring squares
        if ( solve(i+1,j) ||     //try left
                solve(i,j+1) ||  //try down
                solve(i-1,j) ||  //try right
                solve(i,j-1) )   //try up
        {  return true ; }
        else { failed(i,j); }

        return false ;
    }
}

