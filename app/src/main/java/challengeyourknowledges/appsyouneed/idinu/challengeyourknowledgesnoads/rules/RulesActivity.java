package challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.rules;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.MainActivity;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.R;

public class RulesActivity extends AppCompatActivity {
    private TextView rulesTextView;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        rulesTextView = (TextView) findViewById(R.id.rules_text_view);
        backButton = (Button) findViewById(R.id.back_button);

        StringBuilder text = new StringBuilder();
        final Resources resources = getApplicationContext().getResources();
        InputStream inputStream = resources.openRawResource(R.raw.rules);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        rulesTextView.setText(text);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RulesActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(RulesActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
