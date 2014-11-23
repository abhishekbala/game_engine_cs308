package authoring.view.graphicsview;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import authoring.eventhandlers.GameHandler;

/**
 * Represents an image, but does not instantiate JavaFX object so that the
 * object can easily be serialized if necessary.
 * 
 * @author Chris Bernt
 * @author Kevin Li
 * @author Arjun Jain
 * @author Wesley Valentine
 *
 */
public class Graphic extends VBox {

	private String myName;
	private GameHandler[] myOnClick;
	private boolean myIsVisible = true;

	public boolean getVisible() {
		return myIsVisible;
	}

	public Graphic(String s, GameHandler ... event) {
		myName = s;
		myOnClick = event;
	}

	/**
	 * creates an instance of the JavaFX object that can be displayed on the
	 * GUI. Takes in a MouseEvent so that the graphic will respond to the
	 * specified events.
	 * 
	 * @param event
	 */
	public void makeGraphic() {
		Image image = new Image(getClass().getResourceAsStream(myName));
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(70);
		imageView.setFitWidth(70);
		this.getChildren().add(imageView);
		this.getChildren().add(new Text(myName));
		for(GameHandler g: myOnClick){
			this.addEventFilter(g.getEventType(), g);
		}
	}

	public String getName() {
		return myName;
	}

}