/**
 * Created by Andrea on 29/05/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeFrame extends JFrame
{
    private Maze maze;

    public MazeFrame(String title, int size){
        super(title);
        this.maze = new Maze(size);
    }

    public void init(){
        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());

        final MazePanel p = new MazePanel(maze);

        pane.add(p,BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout());

        // Start Solving
        JButton solve = new JButton("Solve");
        south.add(solve);
        solve.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread( new Runnable(){ public void run(){ maze.solve(p); } } ).start();
            }
        });

        // Random Maze generator
        JButton reset = new JButton("Random Maze");
        south.add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maze = new Maze(maze.maze.length);
                p.setMaze(maze);
                p.repaint();
            }
        });

        pane.add(south, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,550);
        setVisible(true);
    }
}