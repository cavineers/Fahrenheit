package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class ToggleIntake extends CommandBase {
    private Intake intake;

    private double startTime;

    public ToggleIntake(Intake intake) {
        addRequirements(intake);
        this.intake = intake;
        
    }

    @Override
    public void initialize() {
        this.startTime = Timer.getFPGATimestamp();
        if (this.intake.getSolenoid() == Value.kReverse) {
            this.intake.openSolenoid();
        } else {
            this.intake.closeSolenoid();
        }
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        if (this.intake.getSolenoid() == Value.kForward) {
            this.intake.setIntakeSpeed(0);
        }
    }

    @Override
    public boolean isFinished() {
        if (Timer.getFPGATimestamp()-startTime > 0.9) {
            return true;
        } else {
            return false;
        }
    }
}
