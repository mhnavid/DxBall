package nvd.hasan.dxball;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class InGameView extends View {
    private int maxWidth;
    private int maxHeight;
    private Boolean first=TRUE;
    private Context context;
    private Activity activity;
    private int Score=0;


    //private Ball ball;
    private Bar bar;
    private Ball ball;
    public InGameView(Context context, Activity activity) {
        super(context);
        this.activity = activity;
        bar = new Bar();
        ball = new Ball(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        maxWidth=canvas.getWidth();
        maxHeight=canvas.getHeight();
        Log.d("scsize",String.valueOf(maxWidth+", "+maxHeight));

        if (first){
            bar.setCoordinates((int)((maxWidth/2)-150),(int)(maxHeight-120),(int)(60),(int)(370));
            ball.setCoordinates((int)(maxWidth*0.2),(int)(maxHeight-(maxHeight*.3)));
            Log.d("scsize",String.valueOf(maxWidth+", "+maxHeight));
            ball.setSpeed(10, 10);
            bar.setSpeed(50, 50);
            first=FALSE;
        }
        bar.drawBar(canvas);
        ball.drawBall(canvas);
        //updateScore();

        if (ball.getDown() >= bar.getTop()){
            if (ball.getRight() > bar.getLeft() && ball.getRight() < bar.getRight()  || ball.getLeft()<bar.getRight() && ball.getLeft()>bar.getLeft() ){
                Log.d("ballpos","crossed");
                // Log.d("ballpos", "bar " +bar.getLeftTopX() +"  "+bar.getRightDownX()+" ball "+ball.getLeftTopX() +"  "+ball.getRightDownX());
                ball.barCollusion();
                invalidate();
            }
            else {
                if (ball.getDown()>=maxHeight){
                    Log.d("ballpos","Game OVer");
                }
                else {
                    invalidate();
                }
                //  getContext().startActivity(new Intent(getContext(),GameEndActivity.class));
            }
        }

        else {
            invalidate();
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        maxWidth=w;
        maxHeight=h;
        // ball.setMax(maxX,maxY);
        bar.setMax(maxWidth,maxHeight);
        ball.setMax(maxWidth,maxHeight);
        invalidate();
    }

    private void updateScore(){
        //activity.updateActionBar(
        ActionBar actionBar=((GameActivity)activity).getSupportActionBar();
        actionBar.setTitle(String.valueOf("Score : "+Score++));
    }


    public int getMaxX() {
        return maxWidth;
    }

    public void setMaxX(int maxX) {
        this.maxWidth = maxX;
    }

    public int getMaxY() {
        return maxHeight;
    }

    public void setMaxY(int maxY) {
        this.maxHeight = maxY;
    }

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }
}