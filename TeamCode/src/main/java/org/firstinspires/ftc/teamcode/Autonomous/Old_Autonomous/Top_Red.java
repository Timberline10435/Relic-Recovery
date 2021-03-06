package org.firstinspires.ftc.teamcode.Autonomous.Old_Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.GlobalVariables;

/**
 * Created by Drew on 10/25/2017.
 */
@Disabled
public class Top_Red extends Nav_Routines {
    String[] vuforiareading = new String[2];

    @Override
    public void runOpMode() throws InterruptedException {
        NAV_init();
        runtime.reset();
        lift_glyph("up");
        vuforiareading = vuforia_scan10435();
        jewelknockvuforia("red", vuforiareading[1], false);

        if (vuforiareading[0] == "RIGHT"){
            go_forward(21, 0,.2, false);
            turn_to_heading_pirouette(127, false);
            go_forward(16.5,127,.2, false);
            sleep(300);
            lift_glyph("down");
            sleep(500);
            leftclamp.setPosition(GlobalVariables.leftclampopenpos);
            rightclamp.setPosition(GlobalVariables.rightclampopenpos);
            sleep(1000);
            go_forward(2,127,-.2, true);


        } else if (vuforiareading[0] == "LEFT"){
            go_forward(26, 0,.2, false);
            turn_to_heading_pirouette(90, false);
            go_forward(11,90,.2, false);
            turn_to_heading_pirouette(120, false);
            go_forward(5.5,120, .2, false);
            sleep(300);
            lift_glyph("down");
            sleep(500);
            leftclamp.setPosition(GlobalVariables.leftclampopenpos);
            rightclamp.setPosition(GlobalVariables.rightclampopenpos);
            sleep(1000);
            go_forward(2,120,-.2, true);

        } else { // center
            go_forward(26, 0,.2, false);
            turn_to_heading_pirouette(124, false);
            go_forward(16.5,124,.2, false);
            sleep(300);
            lift_glyph("down");
            sleep(500);
            leftclamp.setPosition(GlobalVariables.leftclampopenpos);
            rightclamp.setPosition(GlobalVariables.rightclampopenpos);
            sleep(1000);
            go_forward(2,124,-.2, true);
        }

    }
}