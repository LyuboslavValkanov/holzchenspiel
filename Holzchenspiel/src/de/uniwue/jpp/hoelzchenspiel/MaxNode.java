package de.uniwue.jpp.hoelzchenspiel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MaxNode extends TreeNode {

    public MaxNode(int numberOfSticksLeft) {
        super(numberOfSticksLeft);

    }

    public int getChildLeafValue() {
        return -1;
    }
//Soll derart abgeändert werden, dass das Maximum aller Bewertungen der Kindknoten zurückgegeben wird.
    public int getValue(TreeNode parent) {

        Collection<TreeNode> kindKnoten = getSuccessors();
        int parentValue = -1;
        for (TreeNode node : kindKnoten
        ) {
            int nodeValue = node.getValue(this);

            if (nodeValue > parentValue) {
                parentValue = nodeValue;


            }
//expected:<-1> but was:<1>

        }
        return parentValue;

    }

    public TreeNode createChild(int numberOfSticksLeft) {
        return new MinNode(numberOfSticksLeft);
    }

    public Collection<TreeNode> getSuccessors() {

        List<TreeNode> kindKnotenList = new ArrayList<>();
        Collection<Integer> treeNodeList = Player.getValidDraws(getNumberOfSticksLeft());
        for (int i : treeNodeList
        ) {
            kindKnotenList.add(createChildChecked(i));
        }
        return kindKnotenList;

    }

    public Optional<Integer> getDrawWithHighestValueSuccessor() {

        int maxValue = Integer.MIN_VALUE;
        int bestDraw = 0;

        for (TreeNode node : getSuccessors()
        ) {
            int nodeValue = node.getValue(this);
            if (nodeValue > maxValue) {
                maxValue = nodeValue;
                bestDraw = numberOfSticksLeft - node.getNumberOfSticksLeft();
            }

        }

        return Optional.ofNullable(bestDraw);
    }
}


