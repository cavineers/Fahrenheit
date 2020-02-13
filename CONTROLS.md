# Fahrenheit Controls

![Controller Format](https://github.com/cavineers/Fahrenheit/blob/master/controller_mapped.png)

### Buttons

**Left Joystick** => Forward & Reverse drive

**Right Joystick** => Left & Right drive

**Left stick button** => High gear

**Right stick button** => Low gear

**X Button** => Toggle intake piston open/closed (will auto shutoff intake after closing)

**Y Button** => Turn the intake motors on

**B Button** => Turn off the intake motors

**A Button** => Eject the cube

**Left Trigger** => Elevator down (based on how hard you press: motor is set to `-(pressure/4)`)

**Right Trigger** => Elevator up (based on how hard you press: motor is set to `pressure/2`)

### Important Note

Please disable the robot when not using it. To combat gravity, the elevator is always set to 10% output

when the initial velocity is set to 0. This may cause the motor to get warm.

(This will be eventually tuned to auto disable the gravity combat below a certain point on the elevator)
