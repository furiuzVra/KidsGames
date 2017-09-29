package duc.example.com.kidsgames;


public class Computer {
    protected String myMark;
    protected String oppMark;
    protected String[][] board;

    Computer(String marker) {
        this.myMark = "X";
        this.oppMark ="O";
    }

    public int[] move(GameBoard board, String marker) {
        this.myMark = "X";
        this.oppMark = "O";
        this.board = board.getBoard();
        int[] result = generateMoves();
        return new int[] { result[0], result[1] };
    }

    private int[] generateMoves() {
        int column, row;
        row = (int)((Math.random() * 3));
        column = (int)(Math.random() * 3);
        if (board[row][column] != null && board[row][column].equals(""))
        {
            board[row][column]="O";
            return new int[]{row, column};
        }
        else
        {
            return generateMoves();
        }
    }
}