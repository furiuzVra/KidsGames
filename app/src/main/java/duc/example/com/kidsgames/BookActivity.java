package duc.example.com.kidsgames;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BookActivity extends AppCompatActivity {
    private Button btnRed;
    private Button btnGreen;
    private Button btnBlue;
    private Button btnCyan;
    private Button btnBrown;
    private Button btnGrey;
    private Button btnPurple;
    private Button btnReset;
    private Button btnOrange;
    private Button btnBlack;
    private Button btnPink;
    private Button btnYellow;
    private PaintView paintView;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater findMenuItems = getMenuInflater();
        findMenuItems.inflate(R.menu.coloring, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.girl:
                paintView.setBackgroundResource(R.drawable.girl);
                break;
            case R.id.bambi:
                paintView.setBackgroundResource(R.drawable.coloringbamib);
                break;
            case R.id.bear:
                paintView.setBackgroundResource(R.drawable.bearcoloring);
                break;
            case R.id.siren:
                paintView.setBackgroundResource(R.drawable.sirenecoloring);
                break;
            case R.id.minion:
                paintView.setBackgroundResource(R.drawable.minion);
                break;
                case R.id.dog:
                    paintView.setBackgroundResource(R.drawable.dogcoloring);
                    break;
        }

        return super.onOptionsItemSelected(item);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initListeners();
        clickListeners();







    }
    public void initListeners(){
        btnBlack=(Button)findViewById(R.id.btnBlack);
        btnOrange=(Button)findViewById(R.id.btnOrange);
        btnYellow=(Button)findViewById(R.id.btnYellow);
        btnBlue=(Button)findViewById(R.id.btnBlue);
        btnGreen=(Button)findViewById(R.id.btnGreen);
        btnRed=(Button)findViewById(R.id.btnRed);
        btnReset=(Button)findViewById(R.id.btnReset);
        paintView=(PaintView)findViewById(R.id.coloringBambi);
        btnPurple=(Button)findViewById(R.id.btnPurple);
        btnBrown=(Button)findViewById(R.id.btnBrown);
        btnGrey=(Button)findViewById(R.id.btnGreen);
        btnCyan=(Button)findViewById(R.id.btnCyan);
        btnPink=(Button)findViewById(R.id.btnPink);
    }
    public void clickListeners(){
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.black));
            }
        });
        btnOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.orange));
            }
        });
        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.yellow));
            }
        });
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(Color.BLUE);

            }
        });
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(Color.GREEN);

            }
        });
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(Color.RED);

            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.reset();

            }
        });

        btnPurple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.purple));
            }
        });
        btnCyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.cyan));
            }
        });
        btnGrey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.grey));
            }
        });
        btnBrown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.brown));
            }
        });
        btnPink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setPenCol(getResources().getColor(R.color.pink));
            }
        });
    }


}
