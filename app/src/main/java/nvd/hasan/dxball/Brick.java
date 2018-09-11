package nvd.hasan.dxball;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Brick {
    private int brickTopX;
    private int brickTopY;
    private int brickHeight;
    private int brickWidth;

    private Paint paint;
    private Rect bounds;
    private int maxWidth;
    private int maxHeight;
    private int speedX;
    private int speedY;
    private int type;


    public Brick(int color,int type){
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        bounds=new Rect();
        this.type=type;
    }

    public void setCoords(int x,int y,int height, int width) {
        brickTopX=x;
        brickTopY=y;
        this.brickHeight=height;
        this.brickWidth=width;
        bounds.set(brickTopX,brickTopY,brickTopX+this.brickWidth,brickTopY+this.brickHeight);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(bounds,paint);
    }

    public int getBrickTopX() {
        return brickTopX;
    }

    public int getBrickTopY() {
        return brickTopY;
    }

    public void setMax(int X, int Y) {
        this.maxWidth = X;
        this.maxHeight = Y;
    }

    public void setSpeed(int speedX, int speedY) {
        this.speedX=speedX;
        this.speedY=speedY;
    }

    public int getLeft() {
        return brickTopX;
    }

    public int getRight() {
        return brickTopX+brickWidth;
    }

    public int getTop() {
        return brickTopY;
    }

    public int getDown() {
        return brickTopY+brickHeight;
    }

    public int getType() {
        return type;
    }
}
