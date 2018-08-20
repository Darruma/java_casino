package blackjack;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Game {
    
    Dealer Dealer1;
      String fullString = "";
    ArrayList<Gambler> gamblers = new ArrayList<>(); // Creates Global variables
    ArrayList<Card> newList = new ArrayList<>();
    public ImageIcon dealerImage;
    String[] buttonsHitOrStay = {"Hit","Stay"};
    int fullValue;
     int answer;
     String fullDealerString = "";
    Table table;  
     Card tempAce;
     Hand tempDHand;
     ImageIcon saunders;
    public Game()
    {
    	java.net.URL dealerPath = getClass().getResource("Dealer2.gif");
        dealerImage = new ImageIcon(dealerPath);
        
        saunders  = new ImageIcon(getClass().getResource("Saunders Picture.jpg"));
       
        Hand emptyDHand =  new Hand();  
        Dealer1 = new Dealer("Ben Dover",emptyDHand);  //Creates a dealer with an empty hand
        JOptionPane.showMessageDialog(null, "Welcome to Blackjack", "BlackJack", 0, dealerImage);
        
        int amountOfDecks = Integer.parseInt(JOptionPane.showInputDialog(null,"How many decks do you want to be created?")); // Asks how many decks you want to play with
        Shoe shoe = new Shoe();        //new show created
    
       newList = shoe.CreateBigCardArray(amountOfDecks);  // creates array for all cards in all decks to be added to AKA shoe
       
      for (Card x: newList)        
      {
   	   System.out.println(x.getName());
      }
      
      
       int amountOfPlayers = Integer.parseInt(JOptionPane.showInputDialog(null,"How many players are playing mate!")); //brings up tab to ask how many players will play
       for ( int y = 0;y < amountOfPlayers;y++)  //for every player that's playing, create an object based off gambler.
       {
         Gambler tempGambler = CreatePlayer(y);
         gamblers.add(tempGambler);
                   
       }
       table = new Table(gamblers,Dealer1);
       
       
       
      
    }
    
    Gambler CreatePlayer(int num)     //creates each player
    {
    	String name = JOptionPane.showInputDialog(null,"Player " + (num + 1) + " Please enter your name!");    //asks to input a name
        ArrayList<Hand> emptyHand = new ArrayList<Hand>();      //gives the player a hand
        Hand tempEmptyHand = new Hand();
        emptyHand.add(tempEmptyHand);
        Gambler gambler = new Gambler(name,1000,emptyHand );                          //creates a Gambler with the name the user input and the hand they were given
        gambler.SetStayBoolean(Boolean.FALSE);
        if(gambler.GetName().equals("Jack"))
        {
            JOptionPane.showMessageDialog(null, "Welcome Jack, We have been expecting you! \n Nice suit!", null, 0, saunders);
        }
        return gambler; //returns gambler
        
    }
    
    
    
    void FirstRound() //begins the game
    {
        CreateBets();
        tempDHand = Dealer1.getHand();       //the dealer is given a hand
        tempDHand.DrawCard(newList);              //dealer draws twice
        tempDHand.DrawCard(newList);
      JOptionPane.showMessageDialog(null, " The dealer's first card is : " + tempDHand.GetHandList().get(0).getName());  //shows the first card the dealer drew
        
        System.out.println(gamblers.size());
       for (int y = 0;y < gamblers.size();y++)                //for every gambler
       {
          Gambler tempGambler = (Gambler) gamblers.get(y);        
         
          Hand tempHand = (Hand )tempGambler.getHands().get(0);
          tempHand.DrawCard(newList);                 //draws two cards for each gambler
          tempHand.DrawCard(newList);                 
             ListCards(tempGambler); 
              System.out.println(tempHand.GetHandList().get(0).getName().charAt(0) );
              System.out.println(tempHand.GetHandList().get(1).getName().charAt(0));
              
            if(Character.toString(tempHand.GetHandList().get(0).getName().charAt(0)).equals(Character.toString(tempHand.GetHandList().get(1).getName().charAt(0)))   )
                    {
                   if( 2 * tempGambler.getBet().GetBetAmount() <  tempGambler.GetBalance())
                 {
                    int SplitOrNot = JOptionPane.showConfirmDialog(null,"Do you want to split, " + tempGambler.GetName() );
                     
                     if(SplitOrNot == 0)
                     {
                    	 ListCards(tempGambler);
                    Hand newHand = tempGambler.getHands().get(0);
                    newHand.GetHandList().remove(0);
                    System.out.print(tempHand.GetHandList().get(0).getName());
                    System.out.print(tempHand.GetHandList().get(1).getName());
                    tempHand.GetHandList().remove(1);
                    tempGambler.getHands().add(newHand);
                    ListCards(tempGambler);
                    
                     }
                    
                     
            }
            
                    }
       
       }
       
       HitOrStay();
      
       
    }
    
    void CreateBets()
    {
        System.out.println("Jet fuel cant melt steel beams");
        for (Gambler gamb : gamblers)
        {
            System.out.println("Jet fuel cant melt steel beams");
            gamb.CreateBet();
        }
    }
    
  
    void ListCards(Gambler tempGambler)
    {
         fullValue = 0;
         fullString = "";
        for (Hand hand : tempGambler.getHands())
        {
            
            for (Card j: hand.GetHandList() )
                 {       
                     fullString += j.getName()  + "(" + j.getValue() + ")" + "\n";
                     //joins cards together for JOption pane                   
                     fullValue += j.getValue();
                 }       
            JOptionPane.showMessageDialog(null,tempGambler.GetName() + " This is your hand : " + "\n" + fullString + "\n" + "The value of your hand is " + fullValue );          
        }
    }
    
    void HitOrStay()
    {
      
        for (Gambler gamb: gamblers)           
        {
           for (Hand hand : gamb.getHands())
            while(gamb.GetStayBoolean() == Boolean.FALSE && hand.GetHandAmount() < 21  )
            {               
           ListCards(gamb);            
            answer = JOptionPane.showOptionDialog(null, gamb.GetName() + ", Do you want to hit or stay?" + "\n", "BlackJack", 0, 0, null, buttonsHitOrStay, null);                   
           if(answer == 0)
            {
                boolean hasAce = false;
                hand.DrawCard(newList);
               
                answer = 2;
                for(Card card : hand.GetHandList())
                {
                    if (card.getValue() == 11){                                            
                        hasAce = true;
                        
                         if(hand.GetHandAmount() > 21 && hasAce == true)
                           {
                             card.setValue(1);
                            }
                    }
                }  
                ListCards(gamb);
            }
















             else if (answer == 1)
             {
                gamb.SetStayBoolean(Boolean.TRUE);
                ListCards(gamb);
                
                break;
             }
            
            }
        }
        Dealer1.Play(newList);
              
       
        PrintDealersCards(tempDHand);
        FinishRound();
        
    }
    
    
    void FinishRound()
    {
    	 table.CheckEverything();
    }
    
    void PrintDealersCards(Hand tempHand)
    {
    	 for (int dealerNum = 0; dealerNum < tempHand.GetHandList().size(); dealerNum++)
         {
          fullDealerString += tempHand.GetHandList().get(dealerNum).getName() + "\n";
         }
        JOptionPane.showMessageDialog(null, " The dealer's cards are : " + fullDealerString );  
    }
    
    
    
}




























































