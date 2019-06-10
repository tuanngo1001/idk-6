package idk6.csexperience.application;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import idk6.csexperience.R;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import idk6.csexperience.objects.Game;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startBtn = (Button) findViewById(R.id.startBtn);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameTxt = (EditText) findViewById(R.id.nameTxt);

                String name = nameTxt.getText().toString();

                Intent startIntent = new Intent(getApplicationContext(), HomePage.class);

                startIntent.putExtra("name", name);

                startActivity(startIntent);

            }
        });
    }
}
