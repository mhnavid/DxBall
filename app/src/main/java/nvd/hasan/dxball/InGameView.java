package nvd.hasan.dxball;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class InGameView extends View {
    private int maxWidth;
    private int maxHeight;
    private Boolean first=TRUE;
    private Context context;
    private Activity activity;
    private int Score=0;
    private int life = 3;
    private int level = 0;
    private ArrayList<Brick> bricks;
    private Bar bar;
    private Ball ball;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public InGameView(Context context, Activity activity, int level, int score) {
        super(context);
        this.activity = activity;
        this.context = context;
        this.Score = score;
        this.level = level;
//        GameActivity gameActivity = (GameActivity) getContext().getApplicationContext();
//        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
        bar = new Bar();
        ball = new Ball(30);
        bricks = new ArrayList<>();
        int brickNumber = 15;
        if (level == 2){
            brickNumber = 20;
        }
        for (int i=0;i<brickNumber;i++){
            if (i%2==0){
                bricks.add(new Brick(Color.parseColor("#00796B"),2));
            }
            else {
                bricks.add(new Brick(Color.parseColor("#0097A7"),3));
            }
        }
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
            int brickX = 0;
            int brickY = 0;
            int brickHeight = (int) (maxHeight * .1);
            int brickWidth = (int) maxWidth / 5;

            for (int i = 0; i < 5; i++) {
                bricks.get(i).setCoords(brickX, brickY, brickHeight, brickWidth);
                brickX += brickWidth;
            }

            brickX = 0;
            brickY = brickHeight;
            for (int i = 5; i < 10; i++) {
                bricks.get(i).setCoords(brickX,brickY,brickHeight,brickWidth);
                brickX+=brickWidth;
            }

            brickX = 0;
            brickY = brickHeight*2;
            for (int i = 10; i < 15; i++) {
                bricks.get(i).setCoords(brickX,brickY,brickHeight,brickWidth);
                brickX+=brickWidth;
            }

            if (level==2){
                brickX = 0;
                brickY = brickHeight*4;
                for (int i = 15; i < 20; i++) {
                    bricks.get(i).setCoords(brickX,brickY,brickHeight,brickWidth);
                    brickX+=brickWidth;
                }
            }
            first=FALSE;
        }

        for (Brick b : bricks){
            b.draw(canvas);
        }

        bar.drawBar(canvas);
        ball.drawBall(canvas);
        updateScore();

        for (Brick b : bricks ){
            if (ball.getRight() >= b.getLeft() && ball.getLeft() <= b.getRight() && ball.getTop() <= b.getDown() && ball.getDown() >= b.getTop()) {
                Log.d("ballpos","bar hit");
                bricks.remove(b);
                ball.barCollusion();
                Score+=b.getType();

                if (bricks.size()==0){
                    if (level==1){
                        Intent intent=new Intent(context,GameActivity.class);
                        intent.putExtra("score",Score);
                        intent.putExtra("level",2);
                        context.startActivity(intent);
                        activity.finish();
                    }
                    else {
                        Intent intent=new Intent(context,GameOver.class);
                        intent.putExtra("score",Score);
                        context.startActivity(intent);
                        activity.finish();
                    }
                }

                break;
            }
        }

        if (ball.getDown() >= bar.getTop()){
            if (ball.getRight() > bar.getLeft() && ball.getRight() < bar.getRight()  || ball.getLeft()<bar.getRight() && ball.getLeft()>bar.getLeft() ){
                ball.barCollusion();
                invalidate();
            }
            else {
                if (ball.getDown()>=maxHeight){
                    Log.d("ballpos","Game OVer");
                    if (life!=1){
                        life-=1;
                        ball.setCoordinates((int) (maxWidth * 0.2), (int) (maxHeight - (maxHeight * .3)));
                        ball.barCollusion();
                        invalidate();
                    }
                    else {
                        Log.d("ballpos","Game OVer");
                        Intent intent=new Intent(context,GameOver.class);
                        intent.putExtra("score",Score);
                        context.startActivity(intent);
                        activity.finish();
                    }
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
        actionBar.setTitle(String.valueOf("Score : "+Score +" Life : "+life+" Level : "+level));
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