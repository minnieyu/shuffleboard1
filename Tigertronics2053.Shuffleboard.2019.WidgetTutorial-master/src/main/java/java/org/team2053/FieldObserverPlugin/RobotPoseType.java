package org.team2053.FieldObserverPlugin;

import java.util.Map;
import java.util.function.Function;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

public final class RobotPoseType extends ComplexDataType<RobotPose> {

  private static final String NAME = "RobotPose";

  public RobotPoseType() {
    super(NAME, RobotPose.class);
  }

  @Override
  public Function<Map<String, Object>, RobotPose> fromMap() {
    return map -> {
      return new RobotPose((double) map.getOrDefault("x", 0.0), (double) map.getOrDefault("y", 0.0), (double) map.getOrDefault("heading", 0.0));
    };
  }

  @Override
  public RobotPose getDefaultValue() {
    return new RobotPose(0, 0, 0);
  }
}