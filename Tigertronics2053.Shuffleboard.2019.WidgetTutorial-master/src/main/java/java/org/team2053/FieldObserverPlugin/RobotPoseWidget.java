package org.team2053.FieldObserverPlugin;

import org.fxmisc.easybind.monadic.MonadicBinding;

import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

@Description(dataTypes = { RobotPoseType.class }, name = "Robot Pose Widget")
@ParametrizedController(value = "RobotPoseWidget.fxml")
@SuppressWarnings("all")
public class RobotPoseWidget extends SimpleAnnotatedWidget<RobotPose> {

	@FXML
	protected Pane _thePane;
	
	@FXML
	protected Label _xPos;
	@FXML
    protected Label _yPos;
    @FXML
	protected Label _heading;
	@FXML
	protected Canvas _theCanvas;
	@FXML
	protected Circle _robot;
	@FXML
	protected Line _robotHeading;

	private ObjectProperty<Image> imageToBeDrawn = new SimpleObjectProperty<Image>(new Image(getClass().getResource("2019-field.jpg").toExternalForm()));
	
	public Pane getView() {

		GraphicsContext gc = _theCanvas.getGraphicsContext2D();
		gc.drawImage(imageToBeDrawn.get(), 0, 0);

		//DRAWING
		_robot.centerXProperty().bind(dataOrDefault.map(pose -> pose.getX()).map(x -> (x * 579) / (12 * 54)));
		_robot.centerYProperty().bind(dataOrDefault.map(pose -> pose.getY()).map(y -> (y * 287) / (12 * 27)));
		_robot.setRadius(10);

		_robotHeading.setStroke(Color.CYAN);
		_robotHeading.startXProperty().bind(dataOrDefault.map(pose -> pose.getX()).map(x -> (x * 579) / (12 * 54)));
		_robotHeading.startYProperty().bind(dataOrDefault.map(pose -> pose.getY()).map(y -> (y * 287) / (12 * 27)));
		_robotHeading.endXProperty().bind(dataOrDefault.map(pose -> pose.getX()).map(x -> ((x * 579) / (12 * 54)) + 15 * (dataOrDefault.map(pose -> pose.getHeading()).map(heading -> Math.sin(Math.toRadians(heading + 90)))).get()));
		_robotHeading.endYProperty().bind(dataOrDefault.map(pose -> pose.getY()).map(y -> ((y * 287) / (12 * 27)) + 15 * (dataOrDefault.map(pose -> pose.getHeading()).map(heading -> -Math.cos(Math.toRadians(heading + 90)))).get()));
		_robotHeading.setStrokeWidth(2.5);

		//LABELS
		_xPos.textProperty().bind(dataOrDefault.map(pose -> pose.getX()).map(x -> "X: " + x));
		_yPos.textProperty().bind(dataOrDefault.map(pose -> pose.getY()).map(y -> "Y: " + y));
		_heading.textProperty().bind(dataOrDefault.map(pose -> pose.getHeading()).map(heading -> "Heading: " + heading));
		return _thePane;
	}
}
