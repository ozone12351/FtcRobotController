package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.AprilTagWebcam;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@Autonomous
public class AprilTagWebcamExample extends OpMode {

    AprilTagWebcam aprilTagWebcam = new AprilTagWebcam();
    double HorizontalDistance;

    @Override
    public void init() {
        aprilTagWebcam.init(hardwareMap, telemetry);
    }


    @Override
    public void loop() {
        // update vision portal
        aprilTagWebcam.update();
        AprilTagDetection id20 = aprilTagWebcam.getTagBySpecificId(20);
        if (id20!=null){
            aprilTagWebcam.displayDetectionTelemetry(id20);
            HorizontalDistance = id20.ftcPose.x;
            telemetry.addLine(String.format("horizontaldisatnce: %6.1f (cm)",HorizontalDistance));
            

        }
        else{
            telemetry.addData("nodata",0);
        }
    }
}
