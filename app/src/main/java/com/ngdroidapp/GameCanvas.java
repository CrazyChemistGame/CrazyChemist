package com.ngdroidapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import istanbul.gamelab.ngdroid.base.BaseCanvas;
import istanbul.gamelab.ngdroid.util.Log;
import istanbul.gamelab.ngdroid.util.Utils;


/**
 * Created by A. Melik ERSOY on 07.09.2018.
 *
 */


public class GameCanvas extends BaseCanvas {

    private Bitmap logo;
    private int logox, logoy, logow, logoh;
    private int firstElement, secondElement, thirdElement, fourthElement, fifthElement; //Array Element Sequence
    private int[][] touchDownPoint, touchUpPoint, touchMovePoint; //Touch Activites Points and Id

    public GameCanvas(NgApp ngApp) {
        super(ngApp);
    }

    public void setup() {
        initializeVariables();
    }

    public void update() {
    }

    public void draw(Canvas canvas) {
        logox = (getWidth() - logow);
        logoy = (getHeight() - logoh);

        canvas.drawBitmap(logo, logox, logoy, null);
        root.gui.drawText(canvas, "FPS: " + root.appManager.getFrameRate() + " / " + root.appManager.getFrameRateTarget(), getWidth()/10, getHeight()/15, 0);
    }

    /**
     * This method assigns initial values, called from setup method.
     *
     */
    public void initializeVariables() {
        logo = Utils.loadImage(root,"background2.png");
        logow = proportionWidth(logo.getWidth());
        logoh = proportionWidth(logo.getHeight());


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
