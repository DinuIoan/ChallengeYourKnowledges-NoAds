package challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.database.DatabaseData;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.database.DatabaseHandler;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.database.InitializeDatabase;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.game.CountdownActivity;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.rezultate.NoteActivity;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.rezultate.RezultateActivity;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.rules.RulesActivity;
import challengeyourknowledges.appsyouneed.idinu.challengeyourknowledgesnoads.zonarelaxare.ZonaRelaxareActivity;

public class MainActivity extends AppCompatActivity {
    private Button playButton;
    private Button rulesButton;
    private Button zonaRelaxareButton;
    private Button noteButton;
    private TextView pointsTextView;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
            return;
        }
        setContentView(R.layout.activity_main);

        databaseHandler = new DatabaseHandler(MainActivity.this);
        if (databaseHandler.getAllQuestions().size() < 1) {
            InitializeDatabase.initializeDatabase(databaseHandler, getApplicationContext());
        }
        playButton = (Button) findViewById(R.id.button_play);
        rulesButton = (Button) findViewById(R.id.button_rules);
        zonaRelaxareButton = (Button) findViewById(R.id.button_tips_tricks);
        noteButton = (Button) findViewById(R.id.button_rezultate);

        pointsTextView = (TextView) findViewById(R.id.points_text_view);

        if (DatabaseData.getPlayerState().getPoints() == 0) {
            pointsTextView.setText("0");
        } else {
            pointsTextView.setText("" + DatabaseData.getPlayerState().getPoints());
        }

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), CountdownActivity.class);
                        startActivity(intent);
                    }
                }, 500);

            }
        });

        rulesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RulesActivity.class);
                startActivity(intent);
            }
        });

        zonaRelaxareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ZonaRelaxareActivity.class);
                startActivity(intent);
            }
        });

        noteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RezultateActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
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
