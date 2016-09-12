/*
Ali Jilani
January 18th, 2013
MineSweeper by AJ Studios
*/
   import java.awt.*; 
   import java.awt.event.*;
   import javax.swing.*;
   import javax.swing.ImageIcon;
   import java.util.Random;
   import java.util.Stack;
   import java.awt.Point;  

    public class MinesweeperAliJilani extends JFrame implements ActionListener
   {
   
   //Creating the box arrays fro front and back
      JButton [][] boxNotClicked = new JButton[9][9]; //The button array that is seen by the user
      JButton [][] boxClicked = new JButton[9][9]; //The button array that actually contains all the values for minesweeper
      int [][] boxNumTracker = new int [9][9]; //An Int array used to assign values to blocks
      JButton temp;
      Random rand = new Random();
      Random rand2 = new Random();
      JFrame frame = new JFrame();//Game over screen when user clicks on a mine
      Font ggFont = new Font("Dialog", Font.PLAIN, 100);
      int mineClicked; //int to help keep track of which mine is clicked
      int mineClicked2; // '' ''
      ImageIcon mine = new ImageIcon("Mina.png"); // Import a 'mine' image
      Point punto=new Point() ;
      Stack<Object> pila = new Stack<Object>();
       
   	
   
   
   //constructor for the Minesweeper game, all settings and actual game engine
       public MinesweeperAliJilani (String title)
                         
      {
      
         super( title );
      	
      
         for(int i=0; i<9; i++) //due to 2d array a nested loop is required to
         {
            for(int j=0; j<9; j++) //set the properties of all the buttons
            {
                                                                                                                                                                                                                                                                                 
               String boxLocation = i + " " + j;
               boxNotClicked[i][j] = new JButton(""); //make the button seen by the user blank
               boxNotClicked[i][j].setPreferredSize(new Dimension(50, 50));
               boxNotClicked[i][j].setActionCommand( boxLocation );   // set the  command so when the button is clicked it switches with
               boxNotClicked[i][j].addActionListener( this );
               boxNotClicked[i][j].setVisible( true );
               boxClicked[i][j] = new JButton("Click");
               boxClicked[i][j].setPreferredSize(new Dimension(50, 50));
               boxClicked[i][j].setVisible( true );
             
               setLayout( new FlowLayout() ); //set the flow layout to properly lay the buttons on the screen
               //add( boxNotClicked[i][j] );       
            
            }
         }
      
         for(int i=0; i<9; i++)// add all the buttons after the properties have been assigned
         {
            for(int j=0; j<9; j++)
            {
               add( boxNotClicked[i][j] );
            }
         }
      	
         JLabel gg = new JLabel("Mina"); //The words for the gameover screen
         gg.setVisible(true);
         gg.setFont(ggFont); //set the font for the gameover screen
         gg.setHorizontalAlignment(SwingConstants.CENTER); // center it in the frame
         gg.setPreferredSize(new Dimension(900,80));
         frame.add(gg); // add the frame to the game
         frame.setSize(600,500);
      	
      	
      	
         for(int r=0; r<9; r++)// for loop to make the value of all the boxNumTracker valued at 0
         {
            for(int e=0; e<9; e++)
            {
               boxNumTracker[r][e] = 0;
            }
         }
      
         for(int z=0; z<10; z++)// Make 10 random buttons mines
         {
            int randNum2 = rand2.nextInt(8);
            int randNum = rand.nextInt (8);
            boxNumTracker[ randNum ][ randNum2 ] = -1; //give a mine a value of -1 in the paralell int array
         }
      	
      	
         for(int q=0; q<9; q++)// Set the int array which is parallel, set the ints around the mine (-1) with values
         {
            for(int w=0; w<9; w++)
            {
               if (boxNumTracker[q][w] == -1) //finding a mine and then changing adding +1 to all the ints around it
               {
               
               //Each 'if' deals with one of the potential 8 blocks/ints around a mine.
               
                  if (q - 1 >= 0 && w - 1 >= 0 && boxNumTracker[q-1][w-1] != -1)
                  {	
                     boxNumTracker[q-1][w-1] = boxNumTracker[q-1][w-1] + 1;
                  }
               
                  if (q - 1 >= 0 && w >= 0 && boxNumTracker[q-1][w] != -1)
                  {
                     boxNumTracker[q-1][w] =	boxNumTracker[q-1][w] + 1;
                  }
               
                  if (q - 1 >= 0 && w + 1 >= 0 && w + 1 <= 8 && boxNumTracker[q-1][w+1] != -1)
                  {
                     boxNumTracker[q-1][w+1]= boxNumTracker[q-1][w+1] + 1;	
                  }
               
                  if (q >= 0 && w - 1 >= 0 && boxNumTracker[q][w-1] != -1)
                  {
                     boxNumTracker[q][w-1] = boxNumTracker[q][w-1] + 1;
                  }
               
                  if (q >= 0 && w + 1 >= 0 && w + 1 <= 8 && boxNumTracker[q][w+1] != -1)
                  {
                     boxNumTracker[q][w+1] = boxNumTracker[q][w+1] + 1;
                  }
               
                  if (q + 1 >= 0 && w - 1 >= 0 && q + 1 <= 8 && boxNumTracker[q+1][w-1] != -1)
                  {
                     boxNumTracker[q+1][w-1] = boxNumTracker[q+1][w-1] + 1;
                  }
               
                  if (q + 1 >= 0 && w >= 0 && q + 1 <= 8 && boxNumTracker[q+1][w] != -1)
                  {
                     boxNumTracker[q+1][w] = boxNumTracker[q+1][w] + 1;
                  }
               
                  if (q + 1 >=0 && w + 1 >= 0 && q + 1 <= 8 && boxNumTracker[q+1][w+1]!= -1)
                  {
                     boxNumTracker[q+1][w+1] = boxNumTracker[q+1][w+1] + 1;
                  }
               
               }
            }
         }
      	
         for (int x=0; x<9; x++)
         {
            for (int y=0; y<9; y++)
            {
               boxClicked[x][y].setText(Integer.toString(boxNumTracker[x][y])); // merge the int array with the button array that the user does not see
            }
         }
            
          
      
         setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
      }
      public void abre(JButton b,int i, int j){
         boxClicked[i][j] = new JButton("Click");
         if (boxNumTracker[i][j] == 10){
               boxClicked[i][j].setVisible( true );
            }
      }
      public void mete(int i, int j){
      double x,y;
      x= (double)i; 
      y=(double)j; 
      punto = new Point(i,j);
      pila.push(punto);
   }
   public Point saca(){
      punto = new Point(); 
       punto = (Point) pila.pop();
   return punto;
   }
   public void recursion(int i , int j, int[][] a){
      if(((i>=0)&&(j>=0))&&((i<10)&&(j<10))){
         if (a[i][j]==0){
            mete(i,j);
            a[i][j]=10;
            if(a[i][j]==10)boxNotClicked[x][y] = boxClicked[x][y]; 
         }if(a[i-1][j-1]==0){
                           mete(i-1,j-1);

         }if(a[i-1][j]==0){
                           mete(i-1,j);
                           
         }if (a[i-1][j+1]==0){
                           mete(i-1,j+1);
                           
         }if (a[i][j+1]==0){
                           mete(i,j+1);
         }if(a[i+1][j+1]==0){
                           mete(i+1,j+1);
         }if(a[i+1][j]==0){
                           mete(i+1,j);
         }if(a[i+1][j-1]==0){
                           mete(i+1,j-1);
         }if(a[i][j-1]==0){
                           mete(i,j-1);
         }
      }
      Point guarda = new Point();
      guarda=saca();
      if(a[(int)guarda.getX()][(int)guarda.getY()]!=10){ 
         recursion((int)guarda.getX(),(int)guarda.getY(),a);
      }else if(!pila.isEmpty()){
         recursion((int)guarda.getX(),(int)guarda.getY(),a);
      }else{
         return; 
      }  
         
           
   }

   
       public void actionPerformed( ActionEvent evt) //listen for a button to be clicked
      {
         int i , j = 0;
         for(int x=0; x<9; x++)
         {
            for(int y=0; y<9; y++)
            {
               //boxNotClicked[x][y] = boxClicked[x][y];
               String checkLocation = x + " " + y;
               if ( evt.getActionCommand().equals( checkLocation ) ) // finds the button the user clicked
               {
                  
                  
                  boxNotClicked[x][y].setVisible(false);
                  //frame.setVisible(true);
                  if(boxNumTracker[x][y] == -1) // if the user clicked a mine, bring up the gg screen
                  {
                     boxClicked[x][y].setVisible(true);
                     frame.setVisible(true);
                     //recursion(x,y,boxNumTracker);
                  evt.getActionCommand();
                  }
               
                  boxNotClicked[x][y] = boxClicked[x][y]; // otherwise switch that button with the 'valued button in the parrallel array
                  
               
               }
               
            }
         
         }
      	
      
      
      
         int q, w;
         for(q=0; q<9; q++) 
         {
            for(w=0; w<9; w++) 
            {
            
            
               boxNotClicked[q][w].setVisible(true); //readd the button after changing it's value
               add ( boxNotClicked[q][w]);
               //if (boxNumTracker[i][j] == 10){
               //boxClicked[i][j].setVisible( true );
               //}            				
            
            }
         }
      
      
      
         repaint();
      
      }
   
   //The game builder, loads the previous class
       public static void main ( String[] args )
      {
         MinesweeperAliJilani game  = new MinesweeperAliJilani( "Click a Button" ) ;
      
         game.setSize( 520, 550); //Set the size of the board so that the buttons fit nicely
         game.setResizable(false); // dont allow the user to resize the game
         game.setVisible( true ); 
      	
      	     
      }
   }