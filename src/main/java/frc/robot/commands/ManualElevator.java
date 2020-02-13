package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class ManualElevator extends CommandBase {
    private Elevator elevator;
    private Joystick joy;

    public ManualElevator(Joystick joy, Elevator elevator) {
        addRequirements(elevator);
        this.joy = joy;
        this.elevator = elevator;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (addDeadZone(this.joy.getRawAxis(2)) != 0.0) {
            this.elevator.setVelocity(-this.joy.getRawAxis(2)*0.5);
        } else
        if (addDeadZone(this.joy.getRawAxis(3)) != 0.0) {
            this.elevator.setVelocity(this.joy.getRawAxis(3));
        } else {
            this.elevator.setVelocity(0.0);
        }
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
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
