/**
 * JFrame holding the maze panels and buttons.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeFrame extends JFrame
{
    private Maze maze;

    //Construct using maze size
    public MazeFrame(String title, int size){
        super(title);
        this.maze = new Maze(size);
    }

    //Initialise components
    public void init()
    {
        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());

        //add maze
        final MazePanel p = new MazePanel(maze);
        pane.add(p,BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout());

       //add solve button
        JButton solve = new JButton("Solve");
        south.add(solve);

        // Start Solving
        solve.addActionListener( new ActionListener() {
            //solve on separate thread not to clash with the UI
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread( new Runnable(){ public void run(){ maze.solve(p); } } ).start();
            }
        });

        // Random Maze generator Button
        JButton reset = new JButton("Random Maze");
        south.add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maze.generate();
                p.repaint();
            }
        });

        pane.add(south, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,550);
        setVisible(true);
    }
}