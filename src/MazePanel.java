/**
 * Created by Andrea on 29/05/2016.
 */
import java.awt.*;
import javax.swing.*;

public class MazePanel extends JPanel {

    private Maze m;
    Color[] colours = {Color.BLACK , Color.WHITE, Color.RED, Color.BLUE };

    public MazePanel(Maze maze){
        this.m = maze;
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int size = m.maze.length;

        int sqsize = this.getWidth() / size ;

        for(int i=0 ; i<size ; i++)
        {
            for(int j=0; j<size ; j++){
                g.setColor( colours [ m.maze[i][j] ] );
                g.fillRect(i*sqsize, j*sqsize, sqsize, sqsize);
            }
        }
    }

    public int[][] getMaze() {
        return m.maze;
    }

    public void setMaze(Maze m) {
        this.m = m;
    }
}
