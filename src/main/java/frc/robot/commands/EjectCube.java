package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class EjectCube extends CommandBase {
    private Intake intake;
    private double startTime;

    public EjectCube(Intake intake) {
        addRequirements(intake);
        this.intake = intake;
    }

    @Override
    public void initialize() {
        this.startTime = Timer.getFPGATimestamp();
        intake.setIntakeSpeed(-1);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        intake.setIntakeSpeed(0);
    }

    @Override
    public boolean isFinished() {
        if (Timer.getFPGATimestamp()-startTime > 1.0) {
            return true;
        } else {
            return false;
        }
    }
}
