package roulette;

import java.util.Random;

public class Wheel {
	
    public int GenerateRandomNumber() {
        Random rand = new Random(); // Creates Random object and generates a random number
        return rand.nextInt(37);
    }
}