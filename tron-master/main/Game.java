package main;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import view.Picture;
import view.TronMapTwoPlayer;

public class Game implements Runnable {
  
	// true if the instructions page is in the frame
	private boolean instructOn = false;
	// true if the high scores are displayed in the frame
	private boolean scoresOn = false;
	
	public void run() {
	   
      // Top-level frame
      final JFrame frame = new JFrame("Tron");
      frame.setBackground(Color.BLACK);
      frame.setPreferredSize(new Dimension(600,400));
      frame.setLocation(400, 100);
      frame.setResizable(false);
      
      /**
       * 
       *  Main Menu
       * 
       */
      // main menu panel
      final JPanel mainMenu = new JPanel();
      mainMenu.setLayout(new BorderLayout());
      mainMenu.setBackground(Color.BLACK);
      
      // main menu screen image
  	 @SuppressWarnings("serial")
      final JComponent pict = new JComponent() {
    	  public void paintComponent(Graphics gc) {
    		  super.paintComponent(gc);
    		  Picture.draw(gc, "image/tron0_0.jpg", 0, 0);
    	  }
      };
      // panel for main menu buttons
      final JPanel topMenu = new JPanel();
      topMenu.setLayout(new GridLayout(1,3));
      topMenu.setBackground(Color.BLACK);
      
      // buttons for main menu
	  final JButton play = new JButton(new ImageIcon("image/play_before.png"));
	  topMenu.add(play);
	  final JButton quit = new JButton(
			  new ImageIcon("image/quit_before.png"));
	  topMenu.add(quit);
	  
	  // adds components to the main menu panel
	  mainMenu.add(pict, BorderLayout.CENTER);
	  mainMenu.add(topMenu, BorderLayout.SOUTH);
	  
	  // adds main menu panel to the frame
	  frame.add(mainMenu);
	  
	  /**
	   * 
	   *  Menu from 'Play'
	   * 
	   */
	  // play menu panel that replaces the main menu panel
	  final JPanel playMenu = new JPanel();
	  playMenu.setLayout(new BorderLayout());
	  playMenu.setBackground(Color.BLACK);
	  
	  // game type buttons
	  final JPanel playMenuUpper = new JPanel();
	  playMenuUpper.setLayout(new GridLayout(2, 1));
	  playMenuUpper.setBackground(Color.BLACK);
	 
	  // panel that holds the buttons for each game type
	  final JPanel modes = new JPanel();
	  modes.setLayout(new GridLayout(1,3));
	  modes.setBackground(Color.BLACK);
	  
	  // buttons for playMenuUpper
	  final JButton twoPlayer = new JButton(new ImageIcon("image/two_player.png"));
	  modes.add(twoPlayer);
	  
	  // an image to be displayed by playMenuUpper
	 @SuppressWarnings("serial")
	  final JComponent menuPict = new JComponent() {
		 public void paintComponent(Graphics gc) {
			 super.paintComponent(gc);
			 Picture.draw(gc, "image/play_menu.jpg", 0, 0);
		 }
	  };
	  
	  // adds panels to playMenuUpper
	  playMenuUpper.add(modes);
	  playMenuUpper.add(menuPict);
	  
	  // main menu buttons
	  final JPanel bottomMenu = new JPanel();
	  bottomMenu.setBackground(Color.BLACK);
	  
	  // buttons for bottomMenu
	  final JButton back = new JButton(new ImageIcon("image/main_menu.png"));
	  bottomMenu.add(back);
	  
	  // adds bottomMenu and playMenuUpper to playMenu
	  playMenu.add(playMenuUpper, BorderLayout.CENTER);	  
	  playMenu.add(bottomMenu, BorderLayout.SOUTH);
	  
	
      
      /**
       * 
       *  Two-player Level Menu
       * 
       */
	  // panel that holds the buttons and labels for two-player mode
	  final JPanel twoMenu = new JPanel();
	  twoMenu.setLayout(new GridLayout(1,4));
	  twoMenu.setBackground(Color.BLACK);
	  
	  // panel that holds the scores for each player
	  final JPanel scoresTwo = new JPanel();
	  scoresTwo.setLayout(new GridLayout(2,1));
	  scoresTwo.setBackground(Color.BLACK);
	  
	  // the score labels for each player
	  final JLabel scoreTwo1 = new JLabel("   Player 1: 0");
	  scoreTwo1.setForeground(Color.WHITE);
	  scoreTwo1.setBackground(Color.BLACK);
	  scoresTwo.add(scoreTwo1);
	  final JLabel scoreTwo2 = new JLabel("   Player 2: 0");
	  scoreTwo2.setForeground(Color.WHITE);
	  scoreTwo2.setBackground(Color.BLACK);
	  scoresTwo.add(scoreTwo2);
	  twoMenu.add(scoresTwo);
	  
	  // the reset and main menu buttons for two-player mode
	  final JButton resetTwo = new JButton(new ImageIcon("image/restart.png"));
	  twoMenu.add(resetTwo);
	  final JButton exitTwo = new JButton(new ImageIcon("image/play_before.png"));
	  twoMenu.add(exitTwo);
	  
	  // the two-player level
      final TronMapTwoPlayer levelTwoPlayer = 
    		  new TronMapTwoPlayer(scoreTwo1, scoreTwo2, 2);
      levelTwoPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE));
	 
      
      /**
       *						    										
       *  Adding action listeners 					
       *						  										    
       */
	  play.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  frame.remove(mainMenu);
			  frame.add(playMenu);
			  frame.update(frame.getGraphics());
			  playMenu.revalidate();
		  }
	  });
	  
	  
	  quit.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  System.exit(1);
		  }
	  });
	  
	  back.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  frame.remove(playMenu);
			  frame.add(mainMenu);
			  frame.update(frame.getGraphics());
		  }
	  });
	  
	  twoPlayer.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  frame.remove(playMenu);
			  frame.setLayout(new BorderLayout());
			  frame.add(levelTwoPlayer, BorderLayout.CENTER);
			  frame.add(twoMenu, BorderLayout.SOUTH);
			  frame.update(frame.getGraphics());
			  levelTwoPlayer.requestFocusInWindow();
			  levelTwoPlayer.revalidate();
			  levelTwoPlayer.reset();
		  }
	  });
	  
	  resetTwo.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  levelTwoPlayer.reset();
		  }
	  });
	  
	  exitTwo.addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  frame.remove(levelTwoPlayer);
			  frame.remove(twoMenu);
			  frame.add(playMenu);
			  frame.update(frame.getGraphics());
			  playMenu.revalidate();
			  levelTwoPlayer.restartGame();
		  }
	  });
	  
	  
      // put the frame on the screen
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      // start the game running
      levelTwoPlayer.reset();
   }
   
   /*
    * Get the game started!
    */
   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Game());
   }
}
