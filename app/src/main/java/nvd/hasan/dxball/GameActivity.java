package nvd.hasan.dxball;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class GameActivity extends AppCompatActivity {
    private InGameView gameView;
    int c=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView=new InGameView(GameActivity.this,GameActivity.this);
        setContentView(gameView);
        //getSupportActionBar().hide();
        gameView.setBackgroundColor(getResources().getColor(R.color.colorBg));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction()== MotionEvent.ACTION_DOWN){
            if (event.getX()>gameView.getMaxX()/2){
                gameView.getBar().moveRight();
            }
            else if (event.getX()<gameView.getMaxX()/2){
                gameView.getBar().moveLeft();
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
