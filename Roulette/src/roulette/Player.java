package roulette;
import javax.swing.UIManager;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Player {
	
    String name;
    int balance;
    int betChoice;
    int betMoney;
    Bet evenOrOddBet;
    Bet colorBet;
    Bet columnBet;
    String color;
    String column;
    String row;
    Bet numberBet;
    ArrayList<Bet> playerBets = new ArrayList<Bet>();
    Object[] options = {"Bet on a number","Bet on a color","Bet on a column","Bet on a street","Bet on even or odd ", "Cancel" };
   
    public Player(String newName, int newBalance) {
        this.name = newName;
        this.balance = newBalance;
    }

    public String getName() {
        return this.name;
    }
     public int getBalance() {
        return this.balance;
    }
     
    public void SetBalance(int newBalance)
    {
    	balance = newBalance;
    }

    public ArrayList<Bet> CreateBet(Player temp) {
         UIManager UI=new UIManager();
    
    
    	 JOptionPane.showMessageDialog(null, "It is " + temp.getName() + "'s turn to BET!","Player : " + temp.getName(), 0); 
       return ChooseBet(temp,BetChoices());
       
        
       
        
		  
           
   
    }
    int GetMoneyInput(Player tempPlayer)
    {

  	  betMoney = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount you want to bet " + tempPlayer.getName() + ". Remember you only have $" + tempPlayer.getBalance() ));
       
       while (betMoney > tempPlayer.getBalance() || betMoney < -1 )
       {
           betMoney = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the amount you want to bet " + tempPlayer.getName() + ". Remember you only have $" + tempPlayer.getBalance() ));     
      }
       return betMoney;
   
    }
   
    


    
    int BetChoices()
    {
    	
    	betChoice = JOptionPane.showOptionDialog(null, "Choose A Bet Type", "Choose a bet ",  JOptionPane.YES_NO_CANCEL_OPTION,  JOptionPane.PLAIN_MESSAGE, null, options, null);
    	System.out.println(betChoice);
    	if(betChoice == 5)
    	{
    	
    	}
    	else
    	{
    		options = RemoveFromArray(options,betChoice);		
    	}
    	
    	return betChoice;
   
    	
    	
    }
    
    Object[] RemoveFromArray(Object[] array,int index)
    {	
    	List<Object> tempList = new ArrayList<Object>();
        tempList.addAll(Arrays.asList(array));
        Object newObj = new Object();
        newObj = "";
        tempList.remove(index);
    	tempList.add(index,newObj);
    	
    	return tempList.toArray();	
    	
    	
    }
    
    ArrayList<Bet> ChooseBet(Player temp, int g)
    
    {
    if(g == 0)
    {
    	betMoney = GetMoneyInput(temp);
    	temp.balance = temp.balance - betMoney;
    	
    	int betNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number you want to bet on!"));
    	while (betNumber < 0 || betNumber > 36)
    	{
    		 betNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number you want to bet on!"));
    	}
    	Outcome newOutcome = new Outcome("",betNumber,null,null,"");
    	int odds;
    	odds = 35;
    	
    	
    	numberBet = new Bet(betMoney,temp,newOutcome,odds);
    	playerBets.add(numberBet);
    	
    	int restart = JOptionPane.showConfirmDialog(null, "Do you want to continue betting");
    	if(restart == 0 )
    	{
    		
    		 ChooseBet(temp,BetChoices());
    	}
    	
    
    }
    if(g == 1){
    	  betMoney = GetMoneyInput(temp);
    	  temp.balance = temp.balance - betMoney;
    	String betColor = JOptionPane.showInputDialog("Please enter the color you want to bet on. 'BLACK' or 'RED'. ");
    	
    	while (betColor.equals("RED") == false && betColor.equals("BLACK") == false)
    	{
    		betColor = JOptionPane.showInputDialog("Please enter the color you want to bet on. 'BLACK' or 'RED'");
    	}
    	
    	Outcome newOutcome = new Outcome(betColor,-1,null,null,"");
    	int odds;
    	odds = 2;
    	 colorBet = new Bet(betMoney,temp,newOutcome,odds);
    	 playerBets.add(colorBet);
    	 int restart = JOptionPane.showConfirmDialog(null, "Do you want to continue betting");
     	if(restart == 0 )
     	{
     		
     		 ChooseBet(temp,BetChoices());
     	}
     	
    	 
    	
  
    }
     if (g == 2 )
    {	 	
    	  betMoney = GetMoneyInput(temp);
    	   	 temp.balance = temp.balance - betMoney;
    	 String column = (JOptionPane.showInputDialog(null,"Enter the column you want to bet on.Enter it in the format 'Starting number' hyphen 'Ending number'. e.g 1-12"));
    	 String[] columnList = column.split("-");
    	 ArrayList columnArrayList = new ArrayList<String>(Arrays.asList(columnList));
    	 ArrayList<Integer> columnArrayListInt = new ArrayList<Integer>(columnArrayList);
    	 System.out.println(columnArrayListInt);
    	 
    	 
    	 Outcome tempOutcome = new Outcome("",-1,columnArrayListInt,null,"");
    
         int odds;
         
     	 odds = 3;
     	 columnBet = new Bet(betMoney,temp,tempOutcome,odds);
     	 
     	 
  
   	 
   	 
    }
     if(g == 3)
    {
    	
    	betMoney = GetMoneyInput(temp);
   	 temp.balance = temp.balance - betMoney;
    }
     if (g == 4)
     {
        betMoney = GetMoneyInput(temp);
    	temp.balance = temp.balance - betMoney;
        String betEvenOrOdd = JOptionPane.showInputDialog("Please enter what you want to bet on.'EVEN' or 'ODD'");
    	
    	while (betEvenOrOdd.equals("EVEN") == false && betEvenOrOdd.equals("ODD") == false)
    	{
    		betEvenOrOdd = JOptionPane.showInputDialog("Please enter what you want to bet on.'EVEN' or 'ODD'");
    	}
    	
         Outcome tempOutcome = new Outcome("",-1,null,null,betEvenOrOdd);
    
         int odds;
         
     	 odds = 2;
     	 evenOrOddBet = new Bet(betMoney,temp,tempOutcome,odds);
         playerBets.add(evenOrOddBet);
          int restart = JOptionPane.showConfirmDialog(null, "Do you want to continue betting");
     	if(restart == 0 )
     	{
     		
     		 ChooseBet(temp,BetChoices());
     	}
     	
     	 
     	 
     }
    
   return playerBets;
    }
}
    
   
   
   

    
