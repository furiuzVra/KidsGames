package duc.example.com.kidsgames;


public class GameBoard
{
    private String[][] theBoard = new String[3][3];

    GameBoard()
    {

        for (int x = 0; x < 3; x++) {

            for (int y = 0; y < 3; y++) {
                theBoard[x][y] = "";
            }

        }

    }

    public void clear()
    {
        for (int x = 0; x < 3; x++) {

            for (int y = 0; y < 3; y++) {
                theBoard[x][y] = "";
            }

        }

    }

    public String[][] getBoard() {
        return theBoard;

    }

    public void placeMark(int xLoc, int yLoc, String mark)
    {
        if (theBoard[xLoc][yLoc] == "") {
            theBoard[xLoc][yLoc] = mark;
        }

    }

    public boolean isWinner(String player) {
        if (theBoard[0][0].equals(theBoard[1][1]) && theBoard[0][0].equals(theBoard[2][2]) && !theBoard[0][0].equals("") && theBoard[0][0].equals(player))

            return true;

        if (theBoard[2][0].equals(theBoard[1][1]) && theBoard[2][0].equals(theBoard[0][2]) && !theBoard[2][0].equals("") && theBoard[2][0].equals(player))

            return true;

        for (int i = 0; i < 3; i++)
        {


            if (theBoard[i][0].equals(theBoard[i][1]) && theBoard[i][1].equals(theBoard[i][2]) && !theBoard[i][0].equals("") && theBoard[i][0].equals(player))

                return true;

            if (theBoard[0][i].equals(theBoard[1][i]) && theBoard[1][i].equals(theBoard[2][i]) && !theBoard[0][i].equals("") && theBoard[0][i].equals(player))

                return true;
        }
        return false;
    }
}