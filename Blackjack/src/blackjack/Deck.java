

package blackjack;
import java.util.ArrayList;




public class Deck {
    ArrayList<Card> cardList = new  ArrayList<Card>();
    ArrayList<String> suitList = new ArrayList<String>();            //creates lists for the cards
   
    public Deck()
    {
               
    	suitList.add("Diamonds");
    	suitList.add("Hearts");
    	suitList.add("Spades");      //adds names to the suitlist
    	suitList.add("Clubs");
        
         for(int x=2; x < 11; x++)    //for numbers from one to ten
    	 {
    		 
    	        Card card = new Card(x + " Of Spades",x);  //creates a number for each suit of card and adds it to the list
    	        Card card2 = new Card(x + " Of Clubs",x);    //also gives it the value based on what the number is
    	        Card card3 = new Card(x + " Of Hearts",x);
    	        Card card4 = new Card(x + " Of Diamonds",x);      
    	        cardList.add(card);
    	        cardList.add(card2);
    	        cardList.add(card3);
    	        cardList.add(card4);       //adds cards to the list
    	        
    	        
    	 }
    	
    	for (int t = 0; t < 4;t++)        //for the amount of face cards and ace (4)
    		
    	{
    		Card cardAce = new Card("Ace Of " +  (String) suitList.get(t),11);      //assigns name and the correct value for each face
    		Card cardKing = new Card("King Of " +  (String) suitList.get(t),10);
    		Card cardQueen = new Card("Queen Of " +  (String) suitList.get(t),10);
    		Card cardJacks = new Card("Jack Of " +  (String) suitList.get(t),10);
    		cardList.add(cardAce);
	        cardList.add(cardKing);
	        cardList.add(cardQueen); //adds the cards to the deck
	        cardList.add(cardJacks);	
    		
    	}
   }
    public ArrayList<Card> getCards() 
    {
        return cardList;
    }
    
    
}


















