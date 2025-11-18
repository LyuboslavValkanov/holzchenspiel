package de.uniwue.jpp.hoelzchenspiel;

public class LocalTest {
    public static void main(String[] args) {
Player p1 = new HumanPlayer("Player1");

p1.takeSticks(20);
TreeNode minNode = new MinNode(20);
minNode.getDrawWithHighestValueSuccessor();
minNode.createChildChecked(5);

TreeNode maxNode = new MaxNode(20);
maxNode.getValue(minNode);


Player AIPlayer = new AIPlayer();
AIPlayer.takeSticks(10);


    }
}
