/**
 * Created by Andrea on 29/05/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeFrame extends JFrame {

    public MazeFrame(String title){
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,550);

        init();
        setVisible(true);
    }

    private void init(){
        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());

        final MazePanel p = new MazePanel();

        pane.add(p,BorderLayout.CENTER);

        JPanel south = new JPanel();
        south.setLayout(new GridLayout());

        JButton reset = new JButton("Random Maze");
        south.add(reset);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Maze.generate();
                p.repaint();
            }
        });

        pane.add(south, BorderLayout.SOUTH);
    }
}