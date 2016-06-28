/**
 * Swing component represent the panel containing the maze.
 */
import java.awt.*;
import javax.swing.*;

public class MazePanel extends JPanel {

    private Maze m;
    //color constants
    protected Color[] colours = {Color.BLACK , Color.WHITE, Color.RED, Color.BLUE };

    //Construct using a maze
    public MazePanel(Maze maze){
        this.m = maze;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int size = m.maze.length;
        //cell size
        int sqsize = this.getWidth() / size ;

        //color cells
        for(int i=0 ; i<size ; i++) {
            for(int j=0; j<size ; j++)
            {
                g.setColor( colours [ m.maze[i][j] ] );
                g.fillRect(i*sqsize, j*sqsize, sqsize, sqsize);
            }
        }
    }

    public int[][] getMaze() {
        return m.maze;
    }
}
