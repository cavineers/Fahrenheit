package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.EjectCube;
import frc.robot.commands.HomeElevator;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.ShiftGear;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.ToggleIntake;
import frc.robot.subsystems.CompressorController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

public class RobotContainer {
    // Controller
    public Joystick joy = new Joystick(0);
    public JoystickButton a_button = new JoystickButton(joy, 1);
    public JoystickButton b_button = new JoystickButton(joy, 2);
    public JoystickButton x_button = new JoystickButton(joy, 3);
    public JoystickButton y_button = new JoystickButton(joy, 4);

    public JoystickButton l_bump = new JoystickButton(joy, 5);
    public JoystickButton r_bump = new JoystickButton(joy, 6);
    public JoystickButton left_menu = new JoystickButton(joy, 7);
    public JoystickButton right_menu = new JoystickButton(joy, 8);
    public JoystickButton left_stick = new JoystickButton(joy, 9);
    public JoystickButton right_stick = new JoystickButton(joy, 10);

    // Subsystems
    public DriveTrain drivetrain = new DriveTrain(this.joy);
    public CompressorController compressor = new CompressorController();
    public Elevator elevator = new Elevator(this.joy);
    public Intake intake = new Intake();

    private double lastPrint = 0.0;

    /**
     * RobotContainer
     */
    public RobotContainer() {
        configureButtonBindings(); // Config Buttons
    }

    /**
     * configureButtonBindings
     */
    private void configureButtonBindings() {
        // right_menu.whenPressed(new HomeElevator(this.elevator));
        x_button.whenPressed(new ToggleIntake(this.intake));
        a_button.whenPressed(new EjectCube(this.intake));
        y_button.whenPressed(new IntakeOn(this.intake));
        b_button.whenPressed(new IntakeOff(this.intake));

        left_stick.whenPressed(new ShiftGear(this.drivetrain, DriveTrain.DriveGear.HIGH_GEAR));
		right_stick.whenPressed(new ShiftGear(this.drivetrain, DriveTrain.DriveGear.LOW_GEAR));
    }

    /**
     * updateController
     * Periodic to update controller
     */
    public void updateController() {
    }

    // Tele init
    public void teleInit() {
        new TeleopDrive(this.joy, this.drivetrain);
        // new HomeElevator(this.elevator);
    }

    /**
     * getJoystick
     * @return returns the joystick
     */
    public Joystick getJoystick() {
        return joy;
    }
}
