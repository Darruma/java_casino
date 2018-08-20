



package blackjack;


public class Bet {
    private int betAmount;
    public Bet(int newBetAmount)
    {
        betAmount = newBetAmount;
    }
    
    public void SetBetAmount(int newAmount)
    {
        betAmount = newAmount;
    }
    
    public int GetBetAmount(){
        return this.betAmount;
    }
    
    
}










