package istanbul.gamelab.ngdroid.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

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
    private boolean rightCheck = false, leftCheck = false, upCheck = false, downCheck = false, allCheck = false;

    public void move(int iX, int vX){

    }

    public void drawJoystick(NgApp root, Canvas canvas, String direction) {
        if(direction == "Right") {
            if (rightCheck) {
                canvas.drawBitmap(right, rightSource, rightDestination, null);
            } else {
                right = Utils.loadImage(root,"arrowRight.png");
                rightSrcW = right.getWidth();
                rightSrcH = right.getHeight();
                rightSrcX = 0;
                rightSrcY = 0;
                rightDstW = root.proportionWidth(rightSrcW);
                rightDstH = root.proportionHeight(rightSrcH);
                rightDstX = (root.getWidth() / 10);
                rightDstY = (root.getHeight()) - (root.getHeight() / 8);

                rightSource = new Rect();
                rightDestination = new Rect();

                rightSource.set(rightSrcX, rightSrcY, rightSrcW, rightSrcH);
                rightDestination.set(rightDstX, rightDstY, rightDstX + rightDstW, rightDstY + rightDstH);
                canvas.drawBitmap(right, rightSource, rightDestination, null);
                rightCheck = true;
            }
        } else if(direction == "Left") {
            if (leftCheck) {
                canvas.drawBitmap(left, leftSource, leftDestination, null);
            } else {
                left = Utils.loadImage(root,"arrowLeft.png");
                leftSrcW = left.getWidth();
                leftSrcH = left.getHeight();
                leftSrcX = 0;
                leftSrcY = 0;
                leftDstW = root.proportionWidth(leftSrcW);
                leftDstH = root.proportionHeight(leftSrcH);
                leftDstX = (root.getWidth() / 10) - leftDstW;
                leftDstY = (root.getHeight()) - (root.getHeight() / 8);

                leftSource = new Rect();
                leftDestination = new Rect();

                leftSource.set(leftSrcX, leftSrcY, leftSrcW, leftSrcH);
                leftDestination.set(leftDstX, leftDstY, leftDstX + leftDstW, leftDstY + leftDstH);
                canvas.drawBitmap(left, leftSource, leftDestination, null);
                leftCheck = true;
            }
        } else if(direction == "Up") {
            if (upCheck) {
                canvas.drawBitmap(up, upSource, upDestination, null);
            } else {
                up = Utils.loadImage(root,"arrowUp.png");
                upSrcW = up.getWidth();
                upSrcH = up.getHeight();
                upSrcX = 0;
                upSrcY = 0;
                upDstW = root.proportionWidth(upSrcW);
                upDstH = root.proportionHeight(upSrcH);
                upDstX = (root.getWidth() / 10);
                upDstY = (root.getHeight()) - (root.getHeight() / 8) + upDstH;

                upSource = new Rect();
                upDestination = new Rect();

                upSource.set(upSrcX, upSrcY, upSrcW, upSrcH);
                upDestination.set(upDstX, upDstY, upDstX + upDstW, upDstY + upDstH);
                canvas.drawBitmap(up, upSource, upDestination, null);
                upCheck = true;
            }
        } else if(direction == "Down") {
            if (downCheck) {
                canvas.drawBitmap(down, downSource, downDestination, null);
            } else {
                down = Utils.loadImage(root,"arrowDown.png");
                downSrcW = down.getWidth();
                downSrcH = down.getHeight();
                downSrcX = 0;
                downSrcY = 0;
                downDstW = root.proportionWidth(downSrcW);
                downDstH = root.proportionHeight(downSrcH);
                downDstX = (root.getWidth() / 10);
                downDstY = (root.getHeight()) - (root.getHeight() / 8) - downDstH;

                downSource = new Rect();
                downDestination = new Rect();

                downSource.set(downSrcX, downSrcY, downSrcW, downSrcH);
                downDestination.set(downDstX, downDstY, downDstX + downDstW, downDstY + downDstH);
                canvas.drawBitmap(down, downSource, downDestination, null);
                downCheck = true;
            }
        } else if(direction == "All") {
            if (allCheck) {
                canvas.drawBitmap(all, allSource, allDestination, null);
            } else {
                all = Utils.loadImage(root,"arrowAll.png");
                allSrcW = all.getWidth();
                allSrcH = all.getHeight();
                allSrcX = 0;
                allSrcY = 0;
                allDstW = root.proportionWidth(allSrcW);
                allDstH = root.proportionHeight(allSrcH);
                allDstX = (root.getWidth() / 10) ;
                allDstY = (root.getHeight()) - (root.getHeight() / 8);


                allSource = new Rect();
                allDestination = new Rect();

                allSource.set(allSrcX, allSrcY, allSrcW, allSrcH);
                allDestination.set(allDstX, allDstY, allDstX + allDstW, allDstY + allDstH);
                canvas.drawBitmap(all, allSource, allDestination, null);
                allCheck = true;
            }
        }
    }
}
