
package roulette;


public class Bet {
    private int betAmount;
    private Outcome outcome;
    private Player player;
    private int Odds;
    
    public Bet( int newBetAmount,Player newPlayer,Outcome newOutcome,int newOdds)
    {
        betAmount = newBetAmount;
        player = newPlayer;
        outcome = newOutcome;
        Odds = newOdds;
        
    }
    
    
    
    public int GetBetAmount()
    {
     return betAmount;
    }

    public int GetOddAmount()
    {
     return Odds;
    }
    
    
   public Outcome GetOutcome()
    {
     return this.outcome;
  }
    
    
  public  Player GetPlayer()
    { 
    	return player;
    }
    
}
