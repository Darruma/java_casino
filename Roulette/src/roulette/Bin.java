
package roulette;


 
public class Bin {
    
	private String color;
	private int number;
	public Bin(int newNumber,String newColor)
    {
        number = newNumber;
        color = newColor;
        
        
    }
	
	int GetNumberOfBin()
	{
		return this.number;
	}
	
	String GetColor()
	{
		return this.color;
	}
}
