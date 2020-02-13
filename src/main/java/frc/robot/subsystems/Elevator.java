package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import frc.robot.commands.ManualElevator;

public class Elevator extends SubsystemBase {
    public WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(Constants.CANIds.ElevatorMotor);

    public DigitalInput limitSwitch = new DigitalInput(5);

    public PIDController velocityPID = new PIDController(1.0, 0, 4.0); // imported from 2018 project

    public PIDController outputPID = new PIDController(0.000005, 0, 0.00005); // imported from 2018 project

    public double velocity = 0.0;

    private Joystick joy;

    public Elevator(Joystick joy) {
        // Reset encoder
        this.elevatorMotor.setSelectedSensorPosition(0);

        this.elevatorMotor.setNeutralMode(NeutralMode.Brake);

        this.joy = joy;

        setDefaultCommand(new ManualElevator(this.joy, this));
    }

    @Override
    public void periodic() {
        this.elevatorMotor.set(ControlMode.PercentOutput, this.velocity);
    }

    public double getMeasurement() {
        return this.elevatorMotor.getSelectedSensorPosition();
    }

    public boolean getLimitSwitch() {
		return limitSwitch.get();
    }

    public void setVelocity(double vel) {
        if (vel == 0.0) {
            this.velocity = 0.1;
        } else {
            this.velocity = vel;
        }
    }

}
