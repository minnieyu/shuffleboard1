package org.team2053.FieldObserverPlugin;

import java.util.List;

import com.google.common.collect.ImmutableList;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = "Tigertronics 2053", name = "FieldObserverPlugin", summary = "A plugin to show robot pose on a virtual field", version = "1.0.0")
public class App extends Plugin {
	@Override
	@SuppressWarnings("all")
	public List<ComponentType> getComponents() {
		return ImmutableList.of(WidgetType.forAnnotatedWidget(RobotPoseWidget.class));
	}

	@Override
	@SuppressWarnings("all")
	public List<DataType> getDataTypes() {
		return ImmutableList.of(new RobotPoseType());
	}
}
