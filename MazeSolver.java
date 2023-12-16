import java.util.*;

class Maze {
    private final int[][] maze;
    private final int rows;
    private final int columns;
    private final int startRow;
    private final int startCol;
    private final int endRow;
    private final int endCol;
    private final int[] directions = { 0, 1, 0, -1, 0 };

    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.maze = new int[rows][columns];
        this.startRow = 1;
        this.startCol = 0;
        this.endRow = rows - 2;
        this.endCol = columns - 1;
        generateMaze();
    }

    private void generateMaze() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maze[i][j] = random.nextInt(2);
            }
        }
        maze[startRow][startCol] = 0;
        maze[endRow][endCol] = 0;
    }

    public void displayMaze() {
        for (int[] row : maze) {
            for (int cell : row) {
                if (cell == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void solveMaze() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { startRow, startCol });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + directions[i];
                int newCol = col + directions[i + 1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns && maze[newRow][newCol] == 0) {
                    queue.offer(new int[] { newRow, newCol });
                    maze[newRow][newCol] = maze[row][col] + 1;

                    if (newRow == endRow && newCol == endCol) {
                        printSolution();
                        return;
                    }
                }
            }
        }

        System.out.println("No solution found.");
    }

    private void printSolution() {
        System.out.println("Solution:");
        int row = endRow;
        int col = endCol;
        int steps = maze[row][col];

        while (steps > 0) {
            System.out.println("(" + row + ", " + col + ")");
            steps--;

            for (int i = 0; i < 4; i++) {
                int newRow = row + directions[i];
                int newCol = col + directions[i + 1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns && maze[newRow][newCol] == steps) {
                    row = newRow;
                    col = newCol;
                    break;
                }
            }
        }
    }
}

public class MazeSolver {
    public static void main(String[] args) {
        Maze maze = new Maze(10, 15);
        System.out.println("Generated Maze:");
        maze.displayMaze();
        System.out.println("\nSolving Maze...");
        maze.solveMaze();
    }
}
