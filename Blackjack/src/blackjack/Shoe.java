



package blackjack;
import java.util.ArrayList;




public class Shoe {
    ArrayList<Card> finalCardList = new ArrayList<Card>(); //creates final cards list
    public Shoe()
    {
    
    }

 ArrayList<Card> CreateBigCardArray(int amountOfDecks)   //being passed the amount of cards the players wanted to use
{
	 	for(int x = 0; x < amountOfDecks;x++)        //for the amount of decks asked for
	 {
	 	System.out.println("Doing stuff");
		 Deck deck = new Deck();                                   //creates a new deck
		 ArrayList<Card> tempCardArray = deck.getCards();          
		 
		 for(int y = 0; y < tempCardArray.size();y++)               //for every card
		 {

			 Card tempCard = (Card) tempCardArray.get(y);
			 finalCardList.add(tempCard);            //add to the final card array

	}
} 




return finalCardList;   //return the final array
	}
    
}












