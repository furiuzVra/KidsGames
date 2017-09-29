package duc.example.com.kidsgames;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Welcome extends Activity {

    private Button book;
    private Button game;
    private Button guess;
    private Button ticTacToe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        game=(Button)findViewById(R.id.btnGame);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GameActivity.class));
            }
        });
        book=(Button)findViewById(R.id.btn_coloring);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),BookActivity.class));
            }
        });
       guess=(Button)findViewById(R.id.btnGuess);
        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GuessingActivity.class));
            }
        });
        ticTacToe=(Button)findViewById(R.id.btnTicTacToe);
        ticTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(getApplicationContext(),TicTacToeActivity.class));
            }
        });
    }
}