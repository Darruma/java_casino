

package blackjack;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Table {
    
    private ArrayList<Gambler> gamblerList = new ArrayList<Gambler>();
    private Dealer theDealer;
    private ImageIcon youLoseImage;
    public Table(ArrayList<Gambler> newGamblerList, Dealer newTheDealer)
    {
        java.net.URL youLoseImagepath = getClass().getResource("youlose.png");
        youLoseImage = new ImageIcon(youLoseImagepath);
        gamblerList = newGamblerList;
        theDealer = newTheDealer;
    }
    
    void CheckEverything()
    {
    	for (Gambler gambler : gamblerList)
    	{
    		for (Hand hand : gambler.getHands())
    		{
             if(hand.GetHandAmount() > 21 || hand.GetHandAmount()  <= theDealer.getHand().GetHandAmount()  &&  theDealer.getHand().GetHandAmount() < 21)
                 {
             Bet tempBet = gambler.getBet();
            gambler.SetBalance(gambler.GetBalance() - tempBet.GetBetAmount());
            JOptionPane.showMessageDialog(null,"YOU LOSE! " + gambler.GetName() +  ". Your balance is " + (gambler.GetBalance()));


            PrintDealersCards(theDealer.getHand());
             
                }
            if(hand.GetHandAmount()  > theDealer.getHand().GetHandAmount() && hand.GetHandAmount() <= 21)
            {
                Bet tempBet = gambler.getBet();
              
                gambler.SetBalance(gambler.GetBalance() + (tempBet.GetBetAmount() * 2));
                
                  JOptionPane.showMessageDialog(null,"You won, " + gambler.GetName() + ". You won " + tempBet.GetBetAmount() * 2 + " pounds." + "Your new balance is " + gambler.GetBalance(),null,0,youLoseImage);
            }
            
            
            
    		}
            
         }
        
    
}
    
    void PrintDealersCards(Hand tempHand)
    {
    	 String fullDealerString = null;
		for (int dealerNum = 0; dealerNum < tempHand.GetHandList().size(); dealerNum++)
         {
          fullDealerString += tempHand.GetHandList().get(dealerNum).getName() + "\n";
         }
        JOptionPane.showMessageDialog(null, " The dealer's cards are : " + fullDealerString );  
    }
}








































































