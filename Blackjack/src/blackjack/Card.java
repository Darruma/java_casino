

package blackjack;


public class Card {
    private int Value;
    private String Name;
  
    public Card(String newName, int newValue){   
        this.Name = newName;
        this.Value = newValue; 
    }
    public void setName(String newName){
        this.Name = newName; 
    }
    public void setValue(int newValue){
        this.Value = newValue; 
    }
    public String getName(){
        return this.Name;
    }
    public int getValue(){
        return this.Value;
    }
    }




































































