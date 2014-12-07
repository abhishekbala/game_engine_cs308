package authoring.eventhandlers;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import authoring.view.icons.LevelIcon;
import authoring.view.levelview.LevelsView;
import authoring.view.levelview.SingleLevelView;

public class LevelToViewHandler implements GameHandler<MouseEvent>{

	private LevelsView myLevels;
	
	public LevelToViewHandler(LevelsView levels){
		myLevels = levels;
	}
	
	@Override
	public void handle(MouseEvent event) {
		LevelIcon l = (LevelIcon) event.getSource();
		SingleLevelView newLevelView = myLevels.addExistingLevel(l.getLevel(), l.getLevelEvents());
		newLevelView.setID(l.getLevel().getIdentifier().getUniqueId());
		l.getLevel().addObserver(newLevelView);
	}

	@Override
	public EventType<MouseEvent> getEventType() {
		return MouseEvent.MOUSE_CLICKED;
	}

}
