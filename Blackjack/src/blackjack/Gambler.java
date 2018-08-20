package blackjack;


import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Gambler {
    private String name;
    private int balance;           //gives the attributes
    ArrayList<Hand> handArray = new ArrayList<Hand>();
    private Boolean isStay;
    Bet bet;
    
    public Gambler(String newName,int newBalance, ArrayList<Hand> newHandArray)
    {
        name = newName;
        balance = newBalance;         //gives attributes for the constructor
        handArray = newHandArray;
            
    }
    
   public int  GetBalance()                //gets and sets
    { 
        return balance;
    }
   
   public String GetName()
   {
       return name;
   }
   public void SetBalance(int newBalance)
   {
       balance = newBalance;
   }
   public  ArrayList<Hand>  getHands()
   {
       return this.handArray;
   }
   
   public Boolean GetStayBoolean()
   {
       return isStay;
   }
    public void SetStayBoolean(Boolean newIsStay)
   {
    isStay = newIsStay;
       
   }
    
    public void CreateBet()
    {
         int money = 0;
        while (money > this.balance   )
        {
         money = Integer.parseInt(JOptionPane.showInputDialog(null,this.name + " ,how much do you want to bet on the game! You've got \n" + this.balance + " pounds."));
       
        }
         bet = new Bet(money);
        
    }
    public Bet getBet(){
        return this.bet;
    }
   
}


























































































































































































