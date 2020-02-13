package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class HomeElevator extends CommandBase {
    private Elevator elevator;

    private int step;

    private boolean homed = false;
    
    public HomeElevator(Elevator elevator) {
        addRequirements(elevator);
        this.elevator = elevator;
        step = 0;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        switch (this.step) {
            case 0:
                if (this.elevator.elevatorMotor.getSelectedSensorPosition() >= 1500) {
                    this.step++;
                } else {
                    this.elevator.elevatorMotor.set(ControlMode.PercentOutput, 0.3);
                }
                break;
            case 1:
                if (this.elevator.getLimitSwitch()) {
                    this.step++;
                    this.elevator.elevatorMotor.setSelectedSensorPosition(0);
                    this.elevator.elevatorMotor.set(ControlMode.PercentOutput, 0);
                    this.homed = true;
                } else {
                    this.elevator.elevatorMotor.set(ControlMode.PercentOutput, -0.2);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return this.homed;
    }
}
