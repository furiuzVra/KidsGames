package duc.example.com.kidsgames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

import java.util.Random;

public class GuessingActivity extends AppCompatActivity {
    private Button btnNew;
    private Button btnBack;
    private Button btnGuess;
    private EditText etNumber;
    private TextView tvResult;
    int x;
    int numberOfTries =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);
        initListeners();
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x=random();
                StyleableToast.makeText(getApplicationContext(), "Number is Generated", Toast.LENGTH_SHORT,R.style.MyToast).show();
               btnGuess.setEnabled(true);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random();
                String b = etNumber.getText().toString();
                Integer broj = Integer.parseInt(b);



                if(broj>100){
                    tvResult.setText("Incorrect Number");
                }

               else if (broj < x) {
                   tvResult.setText("Your guess is to low");


                } else if (broj > x) {

                    tvResult.setText("Your guess to High");

                }

                else if(broj==x){
                    btnGuess.setEnabled(false);
                    tvResult.setText("You win number is "+x+"\n"+" Numbers of tries " +numberOfTries);
                    numberOfTries=0;
                }

                numberOfTries++;

            }
        });
    }

    public void initListeners(){
        btnNew=(Button)findViewById(R.id.btnNew);
        btnGuess=(Button)findViewById(R.id.btnGuess);
        btnBack=(Button)findViewById(R.id.btnBack);
        etNumber=(EditText)findViewById(R.id.etNumber);
        tvResult=(TextView) findViewById(R.id.tvResult);


    }





    public static int random() {
        Random generator = new Random();

        int x = generator.nextInt(100);
        return x;
    }
}
