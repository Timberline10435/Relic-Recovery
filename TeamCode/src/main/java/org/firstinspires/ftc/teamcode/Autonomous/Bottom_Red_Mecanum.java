package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.GlobalVariables;

/**
 * Created by Drew on 2/1/2018.
 */
@Autonomous(name = "Bottom Red", group = "Autonomous")
public class Bottom_Red_Mecanum extends Mecanum_Nav_Routines {

    String[] vuforiareading = new String[2];

    @Override
    public void runOpMode() throws InterruptedException {
        MNav_Init();
        runtime.reset();
        lift_glyph("up", 7, true);
        vuforiareading = vuforia_scan10435();
        jewelknockvuforia("red", vuforiareading[1], true);

        go_forward(26, 0, .12, false);
        turn_to_heading(90);
        lift_glyph("up", 15, false);
        go_sideways(null, 90, 90, .27, 2, 0);
        wall_distance_align(16.5);
        go_forward(2,90,.2, false);
        sleep(500);
        go_sideways("red", 270, 90, .27, 10, 16.5);

        if (vuforiareading[0] == "LEFT") {
            go_sideways(null, 270, 90, .27, 2, 0);
        } else if (vuforiareading[0] == "RIGHT") {
            go_sideways(null, 90, 90, .27, 2, 0);
        } else {
            go_sideways(null, 270, 90, .27, .2, 0);
        }
        lift_glyph("down", 3,false);
        go_forward(7, 90, .15, false);
        sleep(300);
        lift_glyph("down", 0, false);
        sleep(500);
        leftclamp.setPosition(GlobalVariables.leftclampinitpos);
        rightclamp.setPosition(GlobalVariables.rightclampinitpos);
        sleep(1000);
        go_forward(4, 90, -.2, true);

    }
}
