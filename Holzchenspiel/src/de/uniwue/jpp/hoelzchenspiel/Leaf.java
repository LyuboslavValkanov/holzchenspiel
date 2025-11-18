package de.uniwue.jpp.hoelzchenspiel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class Leaf extends TreeNode {

    public Leaf(){
        super(0);
    }
    public int getValue(TreeNode parent) {
        if ( parent!=null && parent instanceof MaxNode) {
            return -1;
        }else if(parent!=null && parent instanceof MinNode) {
            return 1;
        } else{
            throw new UnsupportedOperationException("Not Parent Node found");
        }

    }
    public Collection<TreeNode> getSuccessors(){

        return new ArrayList<>();
    }
    public Optional<Integer> getDrawWithHighestValueSuccessor(){

        return Optional.empty();
    }
}

