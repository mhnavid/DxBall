package nvd.hasan.dxball;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    Button restartBtn, homeBtn, exitBtn;
    private MediaPlayer mMediaPlayer;
    TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        restartBtn = findViewById(R.id.restartBtn);
        homeBtn = findViewById(R.id.homeBtn);
        exitBtn = findViewById(R.id.exitBtn);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOver.this,GameActivity.class);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOver.this, MainActivity.class);
                startActivity(intent);
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(1);
            }
        });
        playSound();
    }

    @Override
    public void onBackPressed() {

    }

    private void playSound(){
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this, soundUri);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();

    }
}
