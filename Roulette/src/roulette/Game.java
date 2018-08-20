package roulette;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Game {
    private ArrayList<String> playersName = new ArrayList<String>();
    private ArrayList<Player> players = new ArrayList<Player>(); // Creates arraylists for players,playerBets,playerNames.
    private ArrayList<Bet> playerBets = new ArrayList<Bet>();
    Board board = new Board();     // creates new object for board and wheel
  
 
    
    public Game() {      
    	
    }
    
    

    void addPlayers() {
       
       
        int playerAmount = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount of players playing"));  
        
        for (int x = 1; x < playerAmount + 1; ++x) {   // Runs for the amount of people playing
            String tempName = JOptionPane.showInputDialog(null, ("Enter Player " + x + "'s name"));
            Player player = new Player(tempName, 1000);
            players.add(player); 
            String y =  player.getName();          // Adds players to the player list and adds their name to a list.
            playersName.add(y);
        }
        JOptionPane.showMessageDialog(null,"The players are "  + playersName); // Prints out player names
             
    }
    
    void StartRound()
    {
         JOptionPane.showMessageDialog(null,"You are now going to enter your bets!");
        for (int z = 0;z < players.size();z++)  // Gets bet input from each player.
        {
             Player temp =  (Player) players.get(z); 
           
          ArrayList<Bet> tempBet = temp.CreateBet(temp); //Creates an array list of bets for each player and adds their bets
          
          for (int a = 0; a < tempBet.size(); a++)
        		  {
        	  		playerBets.add((Bet) tempBet.get(a));  //Puts the contents of the arraylist of bets into an arraylist of all the bets
        		  }
          
          
        }
        board.GetArrayListPlayers(players);
        board.GetArrayListBets(playerBets); //Gets the playerbets list
        board.CreateBins(); // Creates all the bins
        board.CheckForWin(); // Checks if the players win
       
        
        
     
        
        
        }
    
    
            
    
 
   
}
    