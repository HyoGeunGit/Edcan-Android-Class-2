package omhhiyobi.firstclassproject;

/**
 * Created by shimh on 2018-04-10.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class other_Class extends AppCompatActivity {
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        textView = findViewById(R.id.other_text);
        editText = findViewById(R.id.EditText);
        Button button =findViewById(R.id.hiyobi);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("asdf", editText.getText().toString());
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("key"));
    }

}