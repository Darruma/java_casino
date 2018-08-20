
package blackjack;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Dealer  {
    
    String name;        //gives attributes
    Hand dealerHand;
    public Dealer(String newName,Hand newdealerHand)   //constructor for the dealer
    {
        name = newName;
        dealerHand = newdealerHand;       //gives attributes into the constructor
        System.out.println(dealerHand);
    }
    public String GetName()
   {
       return name;
   }
    public Hand getHand()
   {
       return this.dealerHand;
   }    
    void Play(ArrayList<Card> cardList)
    {
      if (dealerHand.GetHandAmount() < 17 )
      {
       dealerHand.DrawCard(cardList);
        System.out.print("Mr Ben , just drew a card");
      }
      else{         
          JOptionPane.showMessageDialog(null, "The dealer has drew his Cards" );
      }
        
    }
    
    
}












