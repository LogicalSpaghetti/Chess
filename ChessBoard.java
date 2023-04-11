import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
  
import java.awt.event.*;  
import java.awt.image.BufferedImage;  
import java.io.*;  
import javax.imageio.ImageIO;  

public class ChessBoard {
    /* AWT Components declaration */   
    private Frame frame1;  
    private Label label1;  
    private Label statusLabel;  
    private Panel panel1;
    //maybe not supposed to be void?
    public void JavaImageDemo ()  
 {  
      showFrame();  
   }
   private void showFrame()  
   {  
      frame1 = new Frame("Java AWT Examples");  
      frame1.setSize(400,400);  
      frame1.setLayout(new GridLayout(3, 1));  
      frame1.addWindowListener(new WindowAdapter()   
     {  
         public void windowClosing(WindowEvent windowEvent)  
         {  
            System.exit(0);  
         }          
      });      
      label1 = new Label();  
      label1.setAlignment(Label.CENTER);  
      statusLabel = new Label();          
      statusLabel.setAlignment(Label.CENTER);  
      statusLabel.setSize(350,100);  
      panel1 = new Panel();  
      panel1.setLayout(new FlowLayout());  
      frame1.add(label1);  
      frame1.add(panel1);  
      frame1.add(statusLabel);  
      frame1.setVisible(true);    
   }  
   
    //used to test if the arrays are working properly
    public static void print2D(char mat[][])
    {
        // Loop through all rows
        for (char[] row : mat)
 
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
    class ImgComp extends Component   
   {  
      BufferedImage ig;  
      public void paint(Graphics p)   
     {  
         p.drawImage(ig, 0, 0, null);  
      }  
      public ImgComp(String filepath)   
     {  
         try   
        {  
            ig = ImageIO.read(new File(filepath));  
         }   
         catch (IOException ex)   
        {  
            ex.printStackTrace();  
         }  
      }  
      /* Sets the size of the image */  
      public Dimension getPreferredSize()  
      {  
         if (ig == null)   
         {  
            return new Dimension(120,200);  
         }   
         else   
         {  
            return new Dimension(ig.getWidth(), ig.getHeight());  
         }  
      }  
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
        frame.setMinimumSize(new Dimension(frameWidth, frameHeight));
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
        //other data contained in Forsyth–Edwards Notation, the standard for single position chess notation
        char[] gameStates = {
            //Turn
            'w', ' ',
            //Can castle
            'K', 'Q', 'k', 'q', ' ',
            //En Passant
            '-', ' ',
            //Halfmove clock
            '0', ' ',
            //Fullmove clock
            '0'
            };
        //used to test if the arrays are working properly
        print2D(piecePositions);
        System.out.println(gameStates);

        JavaImageDemo obj = new JavaImageDemo ();  
      obj.showImageDemo();
    }
}