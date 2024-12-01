package frc.robot.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public interface DriveSubsystemIO {

    public class DriveSubsystemIOInputs {
        public double leftAppliedVolts = 0.0;
        public double leftDistanceMeters = 0.0;

        public double rightAppliedVolts = 0.0;
        public double rightDistanceMeters = 0.0;
    }

    /** Updates the set of loggable inputs. */
  public default void updateInputs(DriveSubsystemIOInputs inputs) {}

  /** Run open loop at the specified voltage. */
  public default void drive(DoubleSupplier x, DoubleSupplier rot) {}

  /** Enable or disable brake mode. */
  public default void setBrakeMode(boolean enable) {}

  /** Set velocity PID constants. */
  public default void configurePID(double kp, double ki, double kd) {}

  public default void feed(){}
}