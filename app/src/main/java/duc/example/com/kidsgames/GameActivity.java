package duc.example.com.kidsgames;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;


import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private int numberOfElements;
    private MemoryButton[] buttons;
    private int[] buttonGraphicLocations;
    private int[] buttonGraphics;
    private MemoryButton selectedButton1;
    private MemoryButton selectedButton2;
    private boolean isBusy=false;
    private boolean isOver=false;
    private Button btnBack;
    private Button btnNewGame;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initListeners();
        clickListeners();



        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLy);

        int numColumns=gridLayout.getColumnCount();
        int numRows=gridLayout.getRowCount();
        numberOfElements=numColumns*numRows;
        buttons=new MemoryButton[numberOfElements];

        buttonGraphics=new int[numberOfElements/2];
        buttonGraphics[0]=R.drawable.bells;
        buttonGraphics[1]=R.drawable.cookie;
        buttonGraphics[2]=R.drawable.images;
        buttonGraphics[3]=R.drawable.indeks;
        buttonGraphics[4]=R.drawable.index;
        buttonGraphics[5]=R.drawable.littlesanta;
        buttonGraphics[6]=R.drawable.tree;
        buttonGraphics[7]=R.drawable.santa;

        buttonGraphicLocations=new int[numberOfElements];
        shuffleButtonGraphics();

        for(int r=0;r<numRows;r++){
            for(int c=0;c<numColumns;c++){

                MemoryButton tempButton=new MemoryButton(this,r,c,buttonGraphics[buttonGraphicLocations[r*numColumns+c]]);
                tempButton.setId(View.generateViewId());
                tempButton.setOnClickListener(this);
                buttons[r*numColumns+c]=tempButton;
                gridLayout.addView(tempButton);
            }

        }





    }
    public void clickListeners(){
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void initListeners(){
        btnNewGame=(Button)findViewById(R.id.btnNew);
        btnBack=(Button)findViewById(R.id.btnBack);

    }
    public void shuffleButtonGraphics(){

        Random random=new Random();

        for(int i=0;i<numberOfElements;i++){
            buttonGraphicLocations[i]=(i%numberOfElements/2);
        }
        for(int i=0;i<numberOfElements;i++){

            int temp=buttonGraphicLocations[i];
            int swapIndex=random.nextInt(16);
            buttonGraphicLocations[i]= buttonGraphicLocations[swapIndex];
            buttonGraphicLocations[swapIndex]=temp;
        }


    }

    @Override
    public void onClick(View v) {
        if(isBusy)
            return;
        MemoryButton button=(MemoryButton)v;
        if (button.isMatched)
            return;
        if(selectedButton1==null){
            selectedButton1=button;
            selectedButton1.flip();
            return;
        }
        if(selectedButton1.getId()==button.getId()){
            return;
        }
        if(selectedButton1.getFrontDrawableId()==button.getFrontDrawableId()){
            button.flip();
            button.setMatched(true);
            selectedButton1.setMatched(true);
            selectedButton1.setEnabled(false);
            button.setEnabled(false);
            selectedButton1=null;
            return;
        }
        else {

            selectedButton2=button;
            selectedButton2.flip();
            isBusy=true;

            final Handler handler=new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectedButton2.flip();
                    selectedButton1.flip();
                    selectedButton1=null;
                    selectedButton2=null;
                    isBusy=false;
                }
            },500);

       }

    }


}