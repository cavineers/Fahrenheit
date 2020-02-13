package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    // Intake motors
    private WPI_TalonSRX intakeMotor1 = new WPI_TalonSRX(Constants.CANIds.Intake1);
	private WPI_TalonSRX intakeMotor2 = new WPI_TalonSRX(Constants.CANIds.Intake2);

    // Solenoid piston
    private DoubleSolenoid sol = new DoubleSolenoid(Constants.CANIds.PCM, 4, 5);

    public Intake() {
        this.setIntakeSpeed(0);
    }

    @Override
    public void periodic() {
        
    }

    public void setIntakeSpeed(double speed) {
        this.intakeMotor1.set(ControlMode.PercentOutput, -speed);
        this.intakeMotor2.set(ControlMode.PercentOutput, speed);
    }

    public void openSolenoid(){
        this.sol.set(Value.kForward);
    }

    public void closeSolenoid() {
        this.sol.set(Value.kReverse);
    }

    public DoubleSolenoid.Value getSolenoid() {
        return this.sol.get();
    }
}
