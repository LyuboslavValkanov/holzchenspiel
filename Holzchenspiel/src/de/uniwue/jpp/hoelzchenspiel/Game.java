package de.uniwue.jpp.hoelzchenspiel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game  {
    public int initialNumberOfSticks; // die Anzahl der noch im Spiel verbleibenden Hölzchen
    public Player p1;
    public Player p2;
     Player currentPlayer;


    public Game(int initialNumberOfSticks, Player p1, Player p2) {
        this.initialNumberOfSticks = initialNumberOfSticks;
        this.p1 = p1;
        this.p2 = p2;
        currentPlayer=p1;

    }
//beginnend mit einem Zug des Spielers p1, und gibt den Spieler zurück, der das Spiel gewonnen hat.
    // Der Spieler, der das letzte Hölzchen nimmt, hat verloren, der andere gewonnen.
    public Player play(){

        while (initialNumberOfSticks>0){
            int stickstoRemove = currentPlayer.takeSticks(initialNumberOfSticks);
            int maxNumberOfSticks = Math.max(stickstoRemove,1);
            stickstoRemove = Math.min(maxNumberOfSticks,3);
            initialNumberOfSticks-=stickstoRemove;

            if (currentPlayer==p1){
                currentPlayer=p2;
            }else {
                currentPlayer=p1;
            }
        }
        return currentPlayer;

    }





    public static void main(String[] args) {
//isValidDraw(0, 1) should return false

        System.out.println(Player.isValidDraw(0,1));//false
        System.out.println(Player.isValidDraw(2,1));//false
        System.out.println(Player.isValidDraw(1,1));//true

        Player p1 = new HumanPlayer("Player 1");
        Player p2 = new HumanPlayer("Player 2");

        Game game = new Game(10,p1,p2);
        game.play();

        TreeNode t = new MaxNode(1);
        TreeNode minNode = new MinNode(5);
        minNode.getValue(t);

        Player.getValidDraws();
        Player.getValidDraws(7);
        Player.isValidDraw(2);
        Player.isValidDraw(3,5);


        List<Integer >emptyList = new ArrayList<>();
        List<Integer>roundList = Stream.iterate(1,n->n+1).limit(3).collect(Collectors.toList());
        System.out.println(roundList);
        System.out.println(roundList.size());
        Player p3 = new HumanPlayer("Player3");
        p3.takeSticks(15);


    }
}
