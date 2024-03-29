package org.firstinspires.ftc.teamcode.autonomous.finalAutos;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "Red 2", group = "Sensor")
public class red2 extends LinearOpMode {
    Robot dobby;
    public void runOpMode() {
            dobby = new Robot();
            dobby.init(this);
            telemetry.addLine("ready to go");
            telemetry.update();
            waitForStart();

            //Get starting angle
            dobby.setStartAngle();

            //Flip Jewel Out
            dobby.jewelOut();

            //Read the correct color
            dobby.readColor();

            //Read the correct column
            dobby.readColumn();

            //grab glyph
            dobby.flipOutarms();
            dobby.liftGlyph();

            //knock appropriate jewel
            dobby.knockRedAlliance();

            //Drive off stone to center
            dobby.moveTime(4, 1); //go halfway
            dobby.moveTime(0, .1);
            dobby.moveTime(1, .95); //go the other way
            dobby.moveTime(0, .1);

            //Turn to original heading
            dobby.turnAngle(dobby.currentAngle() - dobby.veryStartAngle);
            dobby.moveTime(0, .1);
            dobby.turnAngle(90);
            dobby.moveTime(0, .1);


            //place relic into column
            dobby.columnPlace();

            //back away from cryptobox
            dobby.backUpFromBox();

            //idle
            dobby.idle();
    }
}
