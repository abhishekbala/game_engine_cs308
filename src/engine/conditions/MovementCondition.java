package engine.conditions;

import java.util.List;

import engine.actions.Action;
import engine.gameObject.GameObject;
import engine.gameObject.Identifier;

/**
 * abstract class based on the movement of game objects.
 * @author Davis
 *
 */

public abstract class MovementCondition extends GameObjectCondition {

    public MovementCondition (List<Action> myActions, List<Identifier> myIDs) {
        super(myActions, myIDs);
        assignListeners();
    }

    @Override
    protected void executeActions(){
        for (Action a : getActions()){
            a.execute();
        }
    }
    
    /**
     * method to assign movement listeners for the game objects
     */
    private void assignListeners(){
        for(GameObject s : getGameObjects()){
            s.getXPositionProperty().addListener(changeEvent -> xLayoutChange());
            s.getYPositionProperty().addListener(changeEvent -> yLayoutChange());
        }
    }
    
    protected abstract void xLayoutChange();
    
    protected abstract void yLayoutChange();
}
