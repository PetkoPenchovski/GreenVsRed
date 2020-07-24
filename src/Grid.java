public class Grid {

    private static final int RED = 0;
    private static final int GREEN = 1;

    private int width;
    private int height;

    private int[][] currentGrid;

    public Grid (int width, int height, int[][] initialGrid) {
        this.width = width;
        this.height = height;
        this.currentGrid = initialGrid;
    }

    private int getColor (int x, int y){
        return currentGrid[x][y];
    }

    private void generateNewGeneration () {
        int[][] newGeneration = new int[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int currentColor = getColor(row, col);
                int greenNeighbours = getNumberOfGreenNeighbours(row, col);
                newGeneration[row][col] = getNewColor(currentColor, greenNeighbours);
            }
        }
        currentGrid = newGeneration;
        printBoard();
    }

    private int getNumberOfGreenNeighbours(int x, int y) {
        int greenNeighbour = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                // the condition (i != 0 || j != 0) is making sure that we are not counting the current cell as its neighbour
                if ((i != 0 || j != 0) && isValidCell(x + i, y + j)) {
                    if (currentGrid[x+i][y+j] == GREEN) {
                        greenNeighbour++;
                    }
                }
            }
        }
        return greenNeighbour;
    }

    private int getNewColor (int currentColor, int greenNeighbours) {
        if (currentColor == RED) {
            if (greenNeighbours == 3 || greenNeighbours == 6) {
                return GREEN;
            }
            return RED;
        }

        if (greenNeighbours == 2 || greenNeighbours == 3 || greenNeighbours == 6) {
            return GREEN;
        }
        return RED;
    }

    private boolean isValidCell (int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    private void printBoard() {
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print(currentGrid[row][col]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
