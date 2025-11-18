package de.uniwue.jpp.hoelzchenspiel;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public abstract class TreeNode {

    public int numberOfSticksLeft;
    public TreeNode(int numberOfSticksLeft){
        if (numberOfSticksLeft<0)throw new IllegalArgumentException("numberOfSticksLeft  less than 0 ");
        this.numberOfSticksLeft=numberOfSticksLeft;


    }
    public TreeNode createChild(int numberOfSticksLeft){
        throw new UnsupportedOperationException();
    }

    public TreeNode createChildChecked(int sticksToTake){
        if (sticksToTake>3||sticksToTake<=0) throw new IllegalArgumentException("invalid draw");
        if (numberOfSticksLeft<0) throw new IllegalArgumentException("numberOfSticksLeft less than 0");
        int restSticks = numberOfSticksLeft-sticksToTake;
        if (restSticks==0){
            return new Leaf();
        }
        return createChild(restSticks);
    }
    public abstract int getValue(TreeNode parent);

    public int getNumberOfSticksLeft(){
        return numberOfSticksLeft;
    }
    public int getChildLeafValue(){
        throw new UnsupportedOperationException();
    }

    public Collection<TreeNode> getSuccessors(){
        return null;
    }
    public Optional<Integer> getDrawWithHighestValueSuccessor(){
        return Optional.empty();
    }

}
