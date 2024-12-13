package frc.robot.subsystems.DriveSubsystem;

import com.revrobotics.CANSparkMax;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants.PortConstants;

public class DriveSubsystem extends SubsystemBase{
    
    private CANSparkMax leftSparkMax,rightSparkMax;
    private DifferentialDrive diffDrive;

    public DriveSubsystem(){
        leftSparkMax = new CANSparkMax(PortConstants.LEFT_MOTOR_CAN_ID, MotorType.kBrushed);
        rightSparkMax = new CANSparkMax(PortConstants.RIGHT_MOTOR_CAN_ID, MotorType.kBrushed);

        leftSparkMax.restoreFactoryDefaults();
        rightSparkMax.restoreFactoryDefaults();
        leftSparkMax.getInverted();
        diffDrive = new DifferentialDrive(leftSparkMax, rightSparkMax);
    }

    public void drive(DoubleSupplier x, DoubleSupplier rot) {
        if (x.getAsDouble()==0){
            diffDrive.arcadeDrive(0, rot.getAsDouble());
        }
        else{
            diffDrive.curvatureDrive(x.getAsDouble(), rot.getAsDouble(), false);
        }
    }

    public void setBrakeMode(boolean enable) {
        if(enable){
            leftSparkMax.setIdleMode(IdleMode.kBrake);
            rightSparkMax.setIdleMode(IdleMode.kBrake);
        }
    }
    
    @Override
    public void periodic(){
      diffDrive.feed();
    }
}
