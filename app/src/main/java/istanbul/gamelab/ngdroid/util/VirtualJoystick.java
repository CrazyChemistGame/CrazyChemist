package istanbul.gamelab.ngdroid.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import istanbul.gamelab.ngdroid.base.BaseCanvas;
import com.ngdroidapp.NgApp;

/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */


public class VirtualJoystick{

    private Bitmap right, left, up, down, all;
    private Rect rightSource, rightDestination, leftSource, leftDestination, upSource, upDestination, downSource, downDestination, allSource, allDestination;
    private int rightSrcX, rightSrcY, rightSrcW, rightSrcH, rightDstX, rightDstY, rightDstW, rightDstH;
    private int leftSrcX, leftSrcY, leftSrcW, leftSrcH, leftDstX, leftDstY, leftDstW, leftDstH;
    private int upSrcX, upSrcY, upSrcW, upSrcH, upDstX, upDstY, upDstW, upDstH;
    private int downSrcX, downSrcY, downSrcW, downSrcH, downDstX, downDstY, downDstW, downDstH;
    private int allSrcX, allSrcY, allSrcW, allSrcH, allDstX, allDstY, allDstW, allDstH;

    public void setJoystick(NgApp root,BaseCanvas canvas ,String direction) {
        if(direction == "Right") {
            right = Utils.loadImage(root,"arrowRight.png");
            rightSrcW = right.getWidth();
            rightSrcH = right.getHeight();
            rightSrcX = 0;
            rightSrcY = 0;
            rightDstW = canvas.proportionWidth(50);
            rightDstH = right.getHeight() / 5;
            rightDstX = 0;
            rightDstY = 0;

            rightSource = new Rect();
            rightDestination = new Rect();

            rightSource.set(rightSrcX, rightSrcY, rightSrcW,rightSrcH);
            rightDestination.set(rightDstX, rightDstY, rightDstX + rightDstW, rightDstY + rightDstH);
        }
        else if(direction == "Left") {
            left = Utils.loadImage(root,"arrowLeft.png");
            leftSrcW = left.getWidth();
            leftSrcH = left.getHeight();
            leftSrcX = 0;
            leftSrcY = 0;
            //leftDstW = ;
            leftDstH = left.getHeight() / 5;
            leftDstX = 0;
            leftDstY = 0;

            leftSource = new Rect();
            leftDestination = new Rect();

            leftSource.set(leftSrcX, leftSrcY, leftSrcW,leftSrcH);
            leftDestination.set(leftDstX, leftDstY, leftDstX + leftDstW, leftDstY + leftDstH);

        }
        else if(direction == "Up") {
            up = Utils.loadImage(root,"arrowUp.png");
            upSrcW = up.getWidth();
            upSrcH = up.getHeight();
            upSrcX = 0;
            upSrcY = 0;
            //upDstW = ;
            upDstH = up.getHeight() / 5;
            upDstX = 0;
            upDstY = 0;

            upSource = new Rect();
            upDestination = new Rect();

            upSource.set(upSrcX, upSrcY, upSrcW,upSrcH);
            upDestination.set(upDstX, upDstY, upDstX + upDstW, upDstY + upDstH);
        }
        else if(direction == "Down") {
            down = Utils.loadImage(root,"arrowDown.png");
            downSrcW = down.getWidth();
            downSrcH = down.getHeight();
            downSrcX = 0;
            downSrcY = 0;
            //downDstW = ;
            downDstH = down.getHeight() / 5;
            downDstX = 0;
            downDstY = 0;

            downSource = new Rect();
            downDestination = new Rect();

            downSource.set(downSrcX, downSrcY, downSrcW,downSrcH);
            downDestination.set(downDstX, downDstY, downDstX + downDstW, downDstY + downDstH);
        }
        else if(direction == "All") {
            all = Utils.loadImage(root,"arrowAll.png");
            allSrcW = all.getWidth();
            allSrcH = all.getHeight();
            allSrcX = 0;
            allSrcY = 0;
            //allDstW = ;
            allDstH = all.getHeight() / 5;
            allDstX = 0;
            allDstY = 0;

            allSource = new Rect();
            allDestination = new Rect();

            allSource.set(allSrcX, allSrcY, allSrcW,allSrcH);
            allDestination.set(allDstX, allDstY, allDstX + allDstW, allDstY + allDstH);
        }
    }
    public void drawJoystick(String direction, Canvas canvas) {
        if(direction == "Right") {
            canvas.drawBitmap(right, rightSource, rightDestination, null);
        }
        else if(direction == "Left") {
            canvas.drawBitmap(left, leftSource, leftDestination, null);
        }
        else if(direction == "Up") {
            canvas.drawBitmap(up, upSource, upDestination, null);
        }
        else if(direction == "Down") {
            canvas.drawBitmap(down, downSource, downDestination, null);
        }
        else if(direction == "All") {
            canvas.drawBitmap(all, allSource, allDestination, null);
        }
    }

}
