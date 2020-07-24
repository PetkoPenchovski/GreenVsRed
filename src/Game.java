import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        int width, height, x1, y1, N;
        int[][] initialBoard;

        Scanner in = new Scanner(System.in);

        System.out.println("Insert Grid dimension:");

        String gridSize = in.nextLine();
        System.out.println("Insert the colors that fill the Grid 0-Red, 1-Green:");

        width = Integer.parseInt(gridSize.split(",")[0].trim());
        height = Integer.parseInt(gridSize.split(",")[1].trim());
        initialBoard = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine();
            for (int j = 0; j < width; j++) {
                initialBoard[i][j] = Integer.parseInt(line.split("")[j]);
            }
        }
        String line = in.nextLine();
        System.out.println("Insert the coordinates(x,y) and the Generation:");

        x1 = Integer.parseInt(line.split(",")[0].trim());
        y1 = Integer.parseInt(line.split(",")[1].trim());
        N = Integer.parseInt(line.split(",")[2].trim());
        
        System.out.println(String.format("Width: %d, height: %d, x1: %d, y1: %d, Generation: %d", width, height, x1, y1, N));

        Grid grid = new Grid(width, height, initialBoard);
        System.out.println();
        System.out.println("Result: " + grid.play(x1, y1, N));
    }
}
