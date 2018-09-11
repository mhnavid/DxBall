package nvd.hasan.dxball;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SaveScore {
    private Context context;

    public SaveScore(Context context){
        this.context = context;
    }

    public void setScore(String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("savedScore", value);
        editor.commit();
    }

    public String getScore() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("savedScore", "");
    }
}
