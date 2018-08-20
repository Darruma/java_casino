package roulette;



public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        System.out.println("Hey");
        game1.addPlayers();    // Creates game object ,adds players and starts rounds.
        game1.StartRound(); // Starts the round - starts the bet for players
    }
}