package duc.example.com.kidsgames;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class TicTacToeActivity extends AppCompatActivity {

    private GameBoard board = null;
    private int moveCount = 0, xLoc = 0, yLoc = 0;
    private String mark = "X", compMark = "O";
    private boolean isOver = false;
    private Computer comp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        board = new GameBoard();
        comp = new Computer(compMark);
    }

    public void resetClick(View v) {
        clear();
        if (compMark == "X") getComputerMove(board);

    }

    public void cellClick(View v) {

        TextView cell = (TextView) findViewById(v.getId());
        String content = (String) cell.getText();
        if (content.equals("") && !isOver)
        {
            switch (cell.getId()) {

                case R.id.cell11:
                    xLoc = 0;
                    yLoc = 0;
                    break;
                case R.id.cell12:
                    xLoc = 0;
                    yLoc = 1;
                    break;
                case R.id.cell13:
                    xLoc = 0;
                    yLoc = 2;
                    break;
                case R.id.cell21:
                    xLoc = 1;
                    yLoc = 0;
                    break;
                case R.id.cell22:
                    xLoc = 1;
                    yLoc = 1;
                    break;
                case R.id.cell23:
                    xLoc = 1;
                    yLoc = 2;
                    break;
                case R.id.cell31:
                    xLoc = 2;
                    yLoc = 0;
                    break;
                case R.id.cell32:
                    xLoc = 2;
                    yLoc = 1;
                    break;
                case R.id.cell33:
                    xLoc = 2;
                    yLoc = 2;
                    break;

            }

            board.placeMark(xLoc, yLoc, mark);
            cell.setText(mark);
            moveCount++;


            isOver = checkEnd(mark);

            if (!isOver)
                getComputerMove(board);
        }
    }
    private boolean checkEnd(String player)
    {

        if (board.isWinner(player))
        {
            announce(true, player);
            return true;
        }

        else if (moveCount >= 9)
        {
            announce(false, player);
            return true;
        }

        return false;
    }
    private void announce(boolean endState, String player)
    {

        if (endState == true)
        {
            if (player.equals("X"))
            {
                player = "You win!";
            }
            else
            {
                player = "The computer wins!";
            }
        }

        else {
            player = "It's a draw!";
        }

        StyleableToast.makeText(getApplicationContext(),player,Toast.LENGTH_SHORT,R.style.MyToast).show();
    }
    private void clear()
    {
        int[] idList = { R.id.cell11, R.id.cell12, R.id.cell13, R.id.cell21, R.id.cell22, R.id.cell23, R.id.cell31, R.id.cell32, R.id.cell33 };
        TextView cell;
        for (int item : idList)
        {
            cell = (TextView) findViewById(item);
            cell.setText("");
        }

        isOver = false;
        moveCount = 0;
        board.clear();
    }
    private void getComputerMove(GameBoard board)
    {

        int[] move = comp.move(board,compMark);
        TextView cell = null;
        switch (move[0]) {
            case 0:

                switch (move[1]) {
                    case 0:

                        cell = (TextView) findViewById(R.id.cell11);
                        break;

                    case 1:

                        cell = (TextView) findViewById(R.id.cell12);
                        break;

                    case 2:

                        cell = (TextView) findViewById(R.id.cell13);
                        break;

                }
                break;

            case 1:

                switch (move[1]) {
                    case 0:

                        cell = (TextView) findViewById(R.id.cell21);
                        break;

                    case 1:

                        cell = (TextView) findViewById(R.id.cell22);
                        break;

                    case 2:

                        cell = (TextView) findViewById(R.id.cell23);
                        break;

                }
                break;

            case 2:

                switch (move[1]) {
                    case 0:

                        cell = (TextView) findViewById(R.id.cell31);
                        break;

                    case 1:

                        cell = (TextView) findViewById(R.id.cell32);
                        break;

                    case 2:

                        cell = (TextView) findViewById(R.id.cell33);
                        break;

                }
                break;

        }
        if (cell != null && cell.getText() == "")
        {
            board.placeMark(move[0], move[1], compMark);
            System.out.println(cell);
            cell.setText(compMark);
            moveCount++;
            isOver = checkEnd(compMark);

        }
    }
}