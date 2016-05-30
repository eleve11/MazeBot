/**
 * Created by Andrea on 29/05/2016.
 */
import java.awt.*;
import javax.swing.*;

public class MazePanel extends JPanel {

    int size = Maze.size;
    Color[] colours = {Color.BLACK , Color.WHITE, Color.RED, Color.BLUE };

    public MazePanel(){
        Maze.generate();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int sqsize = this.getWidth() / size ;

        for(int i=0 ; i<size ; i++)
        {
            for(int j=0; j<size ; j++){
                g.setColor( colours [ Maze.maze[i][j] ] );
                g.fillRect(i*sqsize, j*sqsize, sqsize, sqsize);
            }
        }
    }

}
