package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.GlobalVariables;

/**
 * Created by Drew on 1/21/2018.
 */
@Autonomous(name = "Top Blue", group = "Autonomous")
public class Top_Blue_Mecanum extends Mecanum_Nav_Routines {

    String[] vuforiareading = new String[2];

    @Override
    public void runOpMode() throws InterruptedException {
        MNav_Init();
        runtime.reset();
        setwheelintake(false, true, true);
        leftclamp.setPosition(GlobalVariables.leftclampinitpos);
        rightclamp.setPosition(GlobalVariables.rightclampinitpos);
        sleep(500);
        rightclamp.setPosition(GlobalVariables.rightclampclosedpos);  // Close the right clamp on the glyph
        leftclamp.setPosition(GlobalVariables.leftclampopenpos);      // put the left clamp back to init so that intake arm drops
        vuforiareading[0] = jewelknockvuforia2("blue", false);
        setwheelintake(false, false, true);
        lift_glyph("up", 7, false);
        leftclamp.setPosition(GlobalVariables.leftclampinitpos);

        go_forward(24, 0, .12, false);
        lift_glyph("up", 15, false);
        go_sideways(null, 270, 0, .27, 2, 0);
        sleep(500);
        go_sideways("blue", 90, 0, .27, 10, 16.5);

        if (vuforiareading[0] == "LEFT") {
            go_sideways(null, 270, 0, .27, 2, 0);
        } else if (vuforiareading[0] == "RIGHT") {
            go_sideways(null, 90, 0, .27, 2, 0);
        } else {
            go_sideways(null, 90, 0, .27, .2, 0);
        }
        lift_glyph("down", 3,false);
        go_forward(7, 0, .15, false);
        sleep(300);
        lift_glyph("down", 0, false);
        sleep(500);
        leftclamp.setPosition(GlobalVariables.leftclampinitpos);
        rightclamp.setPosition(GlobalVariables.rightclampinitpos);
        sleep(1000);
        go_forward(4, 0, -.2, true);
    }
}
