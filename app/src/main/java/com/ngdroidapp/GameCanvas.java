package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.google.firebase.database.DatabaseReference;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;
import istanbul.gamelab.ngdroid.util.VirtualJoystick;


/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */


public class GameCanvas extends BaseCanvas {
    private Bitmap backgraund;
    private Rect backgraundSrc, backgraundDst;
    private int backgraundSrcX, backgraundSrcY, backgraundSrcW, backgraundSrcH, backgraundDstX, backgraundDstY, backgraundDstW, backgraundDstH;
    private int firstElement, secondElement, thirdElement, fourthElement, fifthElement; //Array Element Sequence
    private int[][] touchDownPoint, touchUpPoint, touchMovePoint; //Touch Activites Points and Id
    private VirtualJoystick virtualJoystick;

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        initializeVariables();
    }

    public void update() {
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(backgraund, backgraundSrc, backgraundDst, null);
        virtualJoystick.drawJoystick(root, canvas, "Right");
        virtualJoystick.drawJoystick(root, canvas, "Left");
        root.gui.drawText(canvas, "FPS: " + root.appManager.getFrameRate() + " / " + root.appManager.getFrameRateTarget(), getWidth()/10, getHeight()/15, 0);
    }

    /**
     * This method assigns initial values, called from setup method.
     *
     */
    public void initializeVariables() {
        backgraund = Utils.loadImage(root,"background.png");
        backgraundSrcW = backgraund.getWidth();
        backgraundSrcH = backgraund.getHeight();
        backgraundSrcX = 0;
        backgraundSrcY = 0;
        backgraundDstW = root.proportionWidth(backgraundSrcW);
        backgraundDstH = root.proportionHeight(backgraundSrcH);
        backgraundDstX = 0;
        backgraundDstY = 0;

        backgraundSrc = new Rect();
        backgraundDst = new Rect();

        backgraundSrc.set(backgraundSrcX, backgraundSrcY, backgraundSrcW, backgraundSrcH);
        backgraundDst.set(backgraundDstX, backgraundDstY, backgraundDstX + backgraundDstW, backgraundDstY + backgraundDstH);

        virtualJoystick = new VirtualJoystick();

        touchDownPoint = new int[3][2];
        touchUpPoint = new int[3][2];
        touchMovePoint = new int[3][2];
    }

    public void keyPressed(int key) {

    }

    public void keyReleased(int key) {

    }

    public boolean backPressed() {
        return true;
    }

    public void surfaceChanged(int width, int height) {

    }

    public void surfaceCreated() {

    }

    public void surfaceDestroyed() {

    }

    public void touchDown(int x, int y, int id) {
        touchDownPoint[id][0] = x;
        touchDownPoint[id][1] = y;
    }

    public void touchMove(int x, int y, int id) {
        touchMovePoint[id][0] = x;
        touchMovePoint[id][1] = y;
    }

    public void touchUp(int x, int y, int id) {
        touchUpPoint[id][0] = x;
        touchUpPoint[id][1] = y;
    }


    public void pause() {

    }


    public void resume() {

    }


    public void reloadTextures() {

    }


    public void showNotify() {
    }

    public void hideNotify() {
    }

}
