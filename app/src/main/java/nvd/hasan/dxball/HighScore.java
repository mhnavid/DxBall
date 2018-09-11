package nvd.hasan.dxball;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {
    Button backBtn;
    TextView scoreView;
    SaveScore saveScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        saveScore = new SaveScore(HighScore.this);

        backBtn = findViewById(R.id.backBtn);
        scoreView = findViewById(R.id.scoreView);

        String savedScore = saveScore.getScore();
        Log.d("savedScore", String.valueOf(savedScore));
        if (savedScore.isEmpty()){
            scoreView.setText("0");
        }
        else {
            scoreView.setText(savedScore);
        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HighScore.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
