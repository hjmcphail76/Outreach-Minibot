// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private DriveSubsystemIO io;
  public DriveSubsystem(DriveSubsystemIO io) {
    this.io = io;

  }

  public void drive(DoubleSupplier x, DoubleSupplier rot){
    io.drive(x, rot);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    io.feed();
  }
}
