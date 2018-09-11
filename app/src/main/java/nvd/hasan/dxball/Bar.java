package nvd.hasan.dxball;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

public class Bar {
    private int barTopX;
    private int barTopY;
    private int barHeight;
    private int barWidth;
    Paint paint;
    Rect bounds;

    private int speedX;
    private int speedY;
    private int maxWidth;
    private int maxHeight;

    public Bar() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#5D4037"));
        bounds=new Rect();
    }

    public void setCoordinates(int barTopX, int barTopY, int barHeight, int barWidth) {
        this.barTopX = barTopX;
        this.barTopY = barTopY;
        this.barHeight = barHeight;
        this.barWidth = barWidth;
        bounds.set(this.barTopX,barTopY,this.barTopX+this.barWidth,this.barTopY+this.barHeight);
    }

    public void drawBar(Canvas canvas){
        canvas.drawRect(bounds,paint);
    }

    public void setMax(int maxX, int maxY) {
        this.maxWidth=maxX;
        this.maxHeight=maxY;
    }

    public void setSpeed(int speedX, int speedY) {
        this.speedX=speedX;
        this.speedY=speedY;
    }

    public void moveRight(){

        barTopX=barTopX+speedX;
        if (barTopX+barWidth >= maxWidth){
            barTopX = maxWidth - barWidth;
        }

        bounds.set(barTopX,barTopY,barTopX+this.barWidth,barTopY+this.barHeight);
        Log.d("barmove","right");
    }


    public void moveLeft(){
        barTopX=barTopX-speedX;
        if (this.barTopX<=0){
            this.barTopX=0;
        }
        bounds.set(barTopX,barTopY,barTopX+this.barWidth,barTopY+this.barHeight);
        Log.d("barmove","left");
    }

    public int getLeft() {
        return barTopX;
    }

    public int getRight() {
        return barTopX+this.barWidth;
    }

    public int getTop() {
        return barTopY;
    }

    public int getDown() {
        return barTopY+this.barHeight;
    }


}
