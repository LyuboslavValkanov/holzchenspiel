package de.uniwue.jpp.hoelzchenspiel;

import java.util.Scanner;

public class HumanPlayer implements Player{
    public String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    // Der Rückgabewert ist die Anzahl der Hölzchen, die der Spieler zieht
    public int takeSticks(int numberOfSticksAvailableInTheGame) {
       int sticksToRemove = 0;
       Scanner input = new Scanner(System.in);
       while (true){
           System.out.print(getName() + " Anzahl der Hoelzchen: 1-3 pro Runde ");
           int draw = input.nextInt();

           try{
               sticksToRemove=draw;
           }catch (Exception e ){
           }
           if (Player.isValidDraw(sticksToRemove,numberOfSticksAvailableInTheGame)) break;
       }
       return sticksToRemove;
    }

    @Override
    public String getName() {
        return name;
    }
}
