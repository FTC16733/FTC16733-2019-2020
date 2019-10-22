package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="TeleOp1", group="Iterative OpMode")
public class Teleop extends OpMode {

    
    DcMotor frontLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backLeftMotor;
    DcMotor backRightMotor;
    Servo servo1;
    @Override
    public void init() {
        frontLeftMotor = hardwareMap.get(DcMotor.class, RobotPreferences.motor1);
        frontRightMotor = hardwareMap.get(DcMotor.class, RobotPreferences.motor2);
        backLeftMotor =hardwareMap.get(DcMotor.class, RobotPreferences.motor3);
        backRightMotor =hardwareMap.get(DcMotor.class, RobotPreferences.motor4);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        servo1 = hardwareMap.get(Servo.class, RobotPreferences.servo1);
    }

    @Override
    public void loop(){
        mecanumDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        }




    private void mecanumDrive(double leftx, double lefty, double rightx) {
        double fl = lefty-leftx+rightx;
        double fr = lefty+leftx-rightx;
        double bl = lefty+leftx+rightx;
        double br = lefty-leftx-rightx;
        frontLeftMotor.setPower(fl);
        frontRightMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }

    public void servo(int position, Servo servo){
        servo.setPosition(position);
    }

}