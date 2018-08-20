



package blackjack;


import java.util.ArrayList;
import java.util.Random;




public class Hand {
    
    ArrayList<Card> handsList = new ArrayList<Card>();
    int handAmount;
    public Hand()
    {
        
    }
    
    void DrawCard(ArrayList<Card> bigCardList)
    {
       
       
        Random rand = new Random(); //random number      
        
       int randomNumber = rand.nextInt(bigCardList.size());   //random number assigned
       
        
        Card randomCard = (Card) bigCardList.get(randomNumber);    //gets the card under the element chosen by random number
       bigCardList.remove(randomNumber);    //removes from the array list
        handsList.add(randomCard);   //adds to the hand that is asking for a card
        
                
     }
    
    public ArrayList<Card> GetHandList()
    {
     return this.handsList;   
    }
    
    public int GetHandAmount()
    {
        handAmount = 0;
        for (Card card : handsList)
        {
            
            handAmount += card.getValue();
        }
        System.out.println(handAmount);
     
        return handAmount;
       
        
   
    
    
}












