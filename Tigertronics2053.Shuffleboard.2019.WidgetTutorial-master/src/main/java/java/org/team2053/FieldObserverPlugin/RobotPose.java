package org.team2053.FieldObserverPlugin;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

public final class RobotPose extends ComplexData<RobotPose> {

    private final double x;
    private final double y;
    private final double heading;
  
    public RobotPose(double x, double y, double heading) {
      this.x = x;
      this.y = y;
      this.heading = heading;
    }
  
    @Override
    public Map<String, Object> asMap() {
      Map<String, Object> map = new HashMap<>();
      map.put("x", this.x);
      map.put("y", this.y);
      map.put("heading", this.heading);
      return map;
    }
  
    public double getX() {
      return x;
    }
  
    public double getY() {
      return y;
    }

    public double getHeading() {
        return heading;
    }
  
    public RobotPose withX(double newX) {
      return new RobotPose(newX, this.y, this.heading);
    }
  
    public RobotPose withY(double newY) {
      return new RobotPose(this.x, newY, this.heading);
    }
  
    public RobotPose withHeading(double newHeading) {
      return new RobotPose(this.x, this.y, newHeading);
    } 
}