import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
public class ChessBoard {
    
    //used to test if the arrays are saving properly
    public static void print2D(char mat[][])
    {
        // Loop through all rows
        for (char[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Board");
        frame.setLayout(new GridLayout(8, 8));
        //loops 8 times
        for (int i = 0; i < 8; i++) {
            //loops 8 times
            for (int j = 0; j < 8; j++) {
                //creates a JPanel
                JPanel panel = new JPanel();
                //changes color with each new tile, but doesn't switch every 8th
                if ((i + j) % 2 == 0) {
                    panel.setBackground(Color.WHITE);
                } else {
                    panel.setBackground(Color.BLACK);
                }
                //creates a new panel
                frame.add(panel);
            }
        }
        //Creates a frame centered in the middle of the screen
        int frameWidth = 600;
        int frameHeight = 600;
        //plus 30 is to account for the bar on top of the window
        frameHeight += 30;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int locX = (int)((screenSize.getWidth()-frameWidth)/2);
        int locY = (int)(((screenSize.getHeight()-frameHeight)/2)-32);
        //Dimension insets = (Dimension)(screenSize.getInsets());
        frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(locX, locY);
        frame.setMinimumSize(new Dimension(100, 100));
        //startingPosition
        char[][] piecePositions = {
            {'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r'}, 
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'}, 
            {'0', '0', '0', '0', '0', '0', '0', '0'}, 
            {'0', '0', '0', '0', '0', '0', '0', '0'}, 
            {'0', '0', '0', '0', '0', '0', '0', '0'}, 
            {'0', '0', '0', '0', '0', '0', '0', '0'}, 
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'}, 
            {'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R'}
        };
        char[][] gameStates = {
            //Turn
            {'w'},
            //Can castle
            {'K', 'Q', 'k', 'q'},
            //En Passant
            {'-'},
            //Halfmove clock
            {'0'},
            //Fullmove clock
            {'0'}
        };
        //used to test if the arrays are saving properly
        print2D(piecePositions);
        print2D(gameStates);
    }
}