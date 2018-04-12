package omhhiyobi.firstclassproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView editText;
    TextView button;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.a1);
        editText = findViewById(R.id.a2);
        button = findViewById(R.id.a3);
        toolbar = findViewById(R.id.toolBar);
        sharedPreferences = getSharedPreferences("Setting", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        setSupportActionBar(toolbar);
        textView.setText(sharedPreferences.getString("text","등록된 텍스트가 없습니다"));
    }
    public void Click (View v){
        Intent intent = new Intent(getApplicationContext(),other_Class.class);
        //this   Toolbar toolbar = findViewById(R.id.toolBar);

        //MainActivity.this
        startActivityForResult(intent,100);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.move:
                Intent intent = new Intent(getApplicationContext(),other_Class.class);
                intent.putExtra("key",editText.getText().toString());
                startActivityForResult(intent,002);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 100:
                if(resultCode == Activity.RESULT_OK){
                    textView.setText(data.getStringExtra("asdf"));
                    editor.putString("text",data.getStringExtra("asdf"));
                    editor.commit();

                    break;
                }
            case 002:
                Toast.makeText(getApplicationContext(), data.getStringExtra("asdf"), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}