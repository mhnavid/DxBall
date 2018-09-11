package nvd.hasan.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    private int ballCenterX;
    private int ballCenterY;
    private int ballRadius;
    private int speedX, speedY;
    private int maxWidth;
    private int maxHeight;
    Paint paint;
    Thread thread;

    public Ball( int ballRadius) {
        this.ballRadius = ballRadius;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#519c3f"));

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ballPositionUpdate();
            }
        });
    }

    public void setCoordinates(int x, int y){
        ballCenterX = x;
        ballCenterY = y;
    }


    public void drawBall(Canvas canvas){
        canvas.drawCircle(ballCenterX, ballCenterY, ballRadius, paint);
        thread.run();
    }

    public void ballPositionUpdate(){
        if (ballCenterX+ballRadius > maxWidth){
            speedX = speedX*-1;
        }
        else if (ballCenterX-ballRadius < 0){
            speedX = speedX *-1;
        }

        if (ballCenterY+ballRadius > maxHeight){
            speedY = speedY*-1;
        }
        else if (ballCenterY-ballRadius < 0){
            speedY = speedY*-1;
        }

        ballCenterX = ballCenterX + speedX;
        ballCenterY = ballCenterY + speedY;
    }

    public void barCollusion(){
        speedY= speedY*-1;
        ballCenterX += speedX;
        ballCenterY += speedY;
    }

    public int getLeftTopX() {
        return 0;
    }

    public int getLeftTopY() {
        return 0;
    }

    public void setMax(int x, int y){
        this.maxWidth = x;
        this.maxHeight = y;
    }

    public void setSpeed(int x, int y){
        this.speedX = x;
        this.speedY = y;
    }

    public int getLeft() {
        return this.ballCenterX-this.ballRadius;
    }

    public int getRight() {
        return this.ballCenterX+this.ballRadius;
    }

    public int getTop() {
        return this.ballCenterY-this.ballRadius;
    }

    public int getDown() {
        return this.ballCenterY+this.ballRadius;
    }

}
