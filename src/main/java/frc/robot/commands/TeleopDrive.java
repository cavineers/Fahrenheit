package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TeleopDrive extends CommandBase {
    private DriveTrain dt;
    private Joystick joy;

    public TeleopDrive(Joystick joy, DriveTrain dt) {
        addRequirements(dt);
        this.dt = dt;
        this.joy = joy;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        this.dt.drive(this.joy);
    }

    @Override
    public void end(boolean interrupted) {
        this.dt.drive(0, 0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
