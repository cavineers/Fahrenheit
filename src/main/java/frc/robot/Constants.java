package frc.robot;
 
public final class Constants {
    //? All constants begin with a lowercase 'k'

    // CAN network mapping
    public static class CANIds {
        public static int PCM                    = 0;  // Pneumatic Control Module (PCM)
        public static int DriveTrainMotor1       = 2;  // Left 1
        public static int DriveTrainMotor2       = 3;  // Left 2
        public static int DriveTrainMotor3       = 1;  // Right 1
        public static int DriveTrainMotor4       = 5;  // Right 2
        public static int Intake1                = 7;  // Intake1
        public static int Intake2                = 6;  // Intake2
        public static int ElevatorMotor          = 4;  // Elevator motor
        public static int PowerDistributionPanel = 30; // Power Distribution Panel (PDP)
    }
}