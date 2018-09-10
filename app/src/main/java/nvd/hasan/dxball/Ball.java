package nvd.hasan.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    private int ballCenterX;
    private int ballCenterY;
    private int ballRadius;
    private int speed;
    private int maxWidth;
    private int maxHeight;
    Paint paint;
    Thread thread;

    public Ball(int ballCenterX, int ballCenterY, int ballRadius) {
        this.ballCenterX = ballCenterX;
        this.ballCenterY = ballCenterY;
        this.ballRadius = ballRadius;
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#519c3f"));

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ballPositionUpdate();
            }
        });
    }

    public int getBallCenterX() {
        return ballCenterX;
    }

    public void setBallCenterX(int ballCenterX) {
        this.ballCenterX = ballCenterX;
    }

    public int getBallCenterY() {
        return ballCenterY;
    }

    public void setBallCenterY(int ballCenterY) {
        this.ballCenterY = ballCenterY;
    }

    public int getBallRadius() {
        return ballRadius;
    }

    public void setMax(int X, int Y) {
        this.maxWidth=X;
        this.maxHeight=Y;
    }

    public void setSpeed(int speed) {
        this.speed=speed;
    }

    public void setBallRadius(int ballRadius) {
        this.ballRadius = ballRadius;
    }

    public void drawBall(Canvas canvas){
        canvas.drawCircle(getBallCenterX(), getBallCenterY(), getBallRadius(), paint);
    }

    public void ballPositionUpdate(){
        if (ballCenterX+ballRadius > maxWidth){
            speed = speed*-1;
        }
        else if (ballCenterX-ballRadius < 0){
            speed = speed *-1;
        }

        if (ballCenterY+ballRadius > maxHeight){
            speed = speed*-1;
        }
        else if (ballCenterY-ballRadius < 0){
            speed = speed*-1;
        }

        ballCenterX += speed;
        ballCenterY += speed;
    }

    public void barCollusion(){
        speed= speed*-1;
        ballCenterX += speed;
        ballCenterY += speed;
    }

    public int getLeft() {
        return ballCenterX-ballRadius;
    }

    public int getRight() {
        return ballCenterX+ballRadius;
    }

    public int getTop() {
        return ballCenterY-ballRadius;
    }

    public int getDown() {
        return ballCenterY+ballRadius;
    }

}
