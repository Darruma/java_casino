package blackjack;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;  // Imports libraries



public class Main {
    public static void main(String[] args) {
        
        
          Font sans = new Font(Font.MONOSPACED,Font.PLAIN,25);
        UIManager.put("OptionPane.messageFont", sans);
        UIManager.put("OptionPane.buttonFont", sans);                  // Sets up ui stuff
        UIManager UI = new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(69,69,69));
         UI.put("Panel.background", new ColorUIResource(253,43,54));
         
        Game game1 = new Game(); //Creates a gameObject
        game1.FirstRound(); //Starts a round
        
       
    }
}