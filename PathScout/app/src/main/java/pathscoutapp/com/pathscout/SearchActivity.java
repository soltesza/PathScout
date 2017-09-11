package pathscoutapp.com.pathscout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {
    public void search(View v) {
        Toast testToast = Toast.makeText(getApplicationContext(),"you just got toasted!", Toast.LENGTH_LONG);
        testToast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }
}
