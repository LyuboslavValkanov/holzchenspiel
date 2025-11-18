package de.uniwue.jpp.hoelzchenspiel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Player {

     int takeSticks(int numberOfSticksAvailableInTheGame);

     String getName();

     static Collection<Integer> getValidDraws(){
        Collection<Integer>roundlist;
        roundlist= Stream.iterate(1,n->n+1).limit(3).collect(Collectors.toList());
        return roundlist;

    }
     static Collection<Integer> getValidDraws(int numberOfSticksAvailableInTheGame){
        Collection<Integer>roundList = new ArrayList<>();
        for (int i = 1; i <=3 ; i++) {
            if (i<=numberOfSticksAvailableInTheGame){
                roundList.add(i);
            }
        }
        return roundList;

    }

     static boolean isValidDraw(int draw){

        return getValidDraws().contains(draw);
    }
    //Gibt zurück, ob der übergebene Zug bei dem übergebenem Spielstand valide ist.
     static boolean isValidDraw(int draw, int numberOfSticksAvailableInTheGame){
        return  (getValidDraws(numberOfSticksAvailableInTheGame).contains(draw));

            }
}
