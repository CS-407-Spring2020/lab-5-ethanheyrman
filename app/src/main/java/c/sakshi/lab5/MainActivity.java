package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        if (!sharedPreferences.getString("username", "").equals("")) {
            username = sharedPreferences.getString("username", "");
            goToActivity2();
        }
        else setContentView(R.layout.activity_main);
    }
    public void goToActivity2() {
        Intent intent = new Intent(this,
                c.sakshi.lab5.MainActivity2.class);
        startActivity(intent);
    }

    public void clickFunction(View view) {
        EditText userInput = (EditText) findViewById(R.id.user);
        username = userInput.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", username).apply();

        if (!sharedPreferences.getString("username", "").equals(""))
            goToActivity2();
    }
}
