
package roulette;

import java.util.ArrayList;

public class Outcome {
    
	private String color;
	private int number;
	private ArrayList column;
	private ArrayList row;
        private String evenOrOdd;
	
    public Outcome(String newColor , int betNumber,ArrayList newColumn,ArrayList newRow,String newEvenOrOdd)
    {
        color = newColor;
        column = newColumn;
        row = newRow;
        number = betNumber;
        evenOrOdd = newEvenOrOdd;
    }
    
    String GetOutcomeColor()
    {
    	return this.color;
    }
     String GetOutcomeEvenOrOdd()
    {
    	return this.evenOrOdd;
    }
    int GetOutcomeNumber()
    {
    	
    	return this.number;
    }
}
