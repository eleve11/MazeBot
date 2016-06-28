/**
 * Solver class.
 *
 * Solve a MazePanel by backtracking
 */
public class Solver
{
    MazePanel p;
    int size;

    //Construct using a maze panel
    public Solver(MazePanel p){
        this.p = p;
        size = p.getMaze().length;
    }

    //checks if a cell is entry
    private boolean isEntry(int i,int j){
        return (j < 0) ;
    }

    //check if a cell is a wall
    private boolean isWall(int i, int j){
        return (p.getMaze()[i][j] == Maze.WALL);
    }

    //check if the cell has already been visited
    private boolean isVisited(int i,int j){
        return (p.getMaze()[i][j] == Maze.VISITED || p.getMaze()[i][j] == Maze.DEAD_END);
    }

    //check if the exit is found
    private boolean isExit(int i, int j){
        return (i==size);
    }

    //visit a cell
    private void visit(int i, int j){
        p.getMaze()[i][j] = Maze.VISITED;
        p.repaint();
    }

    //color a cell that leads to a dead end
    private void failed(int i,int j){
        p.getMaze()[i][j] = Maze.DEAD_END;
        p.repaint();
    }

    /*
        Solve the maze by trying L,D,R,U
        pass the starting cell as argument.

        It will backtrack paths from cell i,j to the end
     */
    public boolean solve(int i, int j){

        //out of bounds
        if(i<0 || j<0) return false;

        //sleep to show animation while repainting
        try { Thread.sleep(Maze.SLEEPTIME) ; }
        catch (InterruptedException e) { }

        // In this case a path is found
        if ( isExit(i,j) ) {
            return true;
        }

        // In any of these cases, no path is found
        if(     isEntry(i,j) ||
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

