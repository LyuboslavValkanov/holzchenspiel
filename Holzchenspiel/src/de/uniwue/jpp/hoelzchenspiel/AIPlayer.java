package de.uniwue.jpp.hoelzchenspiel;

public class AIPlayer implements Player{

    @Override
    public int takeSticks(int numberOfSticksAvailableInTheGame) {
        TreeNode beginn = new MaxNode(numberOfSticksAvailableInTheGame);

        int endResult = beginn.getDrawWithHighestValueSuccessor().get();

        return endResult;
    }

    @Override
    public String getName() {
        return "AIPlayer";
    }
}
