// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotConstants.DriverConstants;
import frc.robot.subsystems.DriveSubsystem.DriveSubsystem;

/** An example command that uses an example subsystem. */
public class TeleopDrive extends Command {
  private DriveSubsystem driveSubsystem;
  Joystick driverController;
  private double xConstrained, rotConstrained;

  public TeleopDrive(DriveSubsystem driveSubsystem, Joystick driverController) {
    this.driveSubsystem = driveSubsystem;
    this.driverController = driverController;
    addRequirements(driveSubsystem);
  }


  @Override
  public void initialize() {
    driveSubsystem.drive(()->0, ()->0);
  }

  @Override
  public void execute() {
    xConstrained = MathUtil.applyDeadband(driverController.getRawAxis(1), DriverConstants.CONTROLLER_DEADZONE);
    rotConstrained = MathUtil.applyDeadband(driverController.getRawAxis(4), DriverConstants.CONTROLLER_DEADZONE);


    driveSubsystem.drive(()->xConstrained, ()->rotConstrained);

  }
  
  @Override
  public void end(boolean interrupted) {
    driveSubsystem.drive(()->0, ()->0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
