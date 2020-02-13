package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.TeleopDrive;

public class DriveTrain extends SubsystemBase {
    // Drive motors
    private WPI_TalonSRX leftMotor1  = new WPI_TalonSRX(Constants.CANIds.DriveTrainMotor1);
    private WPI_TalonSRX leftMotor2  = new WPI_TalonSRX(Constants.CANIds.DriveTrainMotor2);
    private WPI_TalonSRX rightMotor1 = new WPI_TalonSRX(Constants.CANIds.DriveTrainMotor3);
    private WPI_TalonSRX rightMotor2 = new WPI_TalonSRX(Constants.CANIds.DriveTrainMotor4);
    
    // Differential Drive
    private DifferentialDrive differentialDrive = new DifferentialDrive(leftMotor1, rightMotor1);

    // Shifting
    private DoubleSolenoid shiftingSol = new DoubleSolenoid(Constants.CANIds.PCM, 3, 2);

    // Drive Gear
    public enum DriveGear {
        HIGH_GEAR,
        LOW_GEAR
    }

    private Joystick joy;

    public DriveTrain(Joystick joy) {
        // Follow
		leftMotor2.follow(leftMotor1);
        rightMotor2.follow(rightMotor1);

        this.joy = joy;

        setDefaultCommand(new TeleopDrive(this.joy, this));
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void setDriveGear(DriveGear gear) {
        if (gear == DriveGear.HIGH_GEAR) {
            this.shiftingSol.set(DoubleSolenoid.Value.kForward);
        } else {
            this.shiftingSol.set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void drive(double forward, double rotate) {
		this.differentialDrive.curvatureDrive(forward, rotate, true);
    }
    
    public void drive(Joystick joy) {
		this.drive(this.addDeadZone(joy.getRawAxis(1)), this.addDeadZone(-joy.getRawAxis(4)));
    }
    
    public double addDeadZone(double input) {
		if (Math.abs(input) <= .05)
			input = 0;
		else if (input < 0)
			input = -Math.pow(input, 2);
		else
			input = Math.pow(input, 2);
		return input;
	}
}
