package com.company;
import java.util.Scanner;
public class Main {

    static int filledCount = 0;
    static char[][] grid = new char[3][3];
    static boolean isX = true;

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        String input;

        int col = 0;
        int row = 0;

        fillGrid();
        printGrid();

        do {
            System.out.print("Enter the coordinates: ");
            try {
                input = scanner.nextLine();
                String[] num = input.split(" ");
                col = Integer.parseInt(num[0]);
                row = Integer.parseInt(num[1]);
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            if (addNew(col, row)) {
                printGrid();
            }
            if (checkResult(grid)) {
                break;
            }
        } while (true);
    }

    public static boolean addNew(int col, int row) {

        int[][] coor = changeCoor(col, row);
        int newCol = coor[0][0];
        int newRow = coor[0][1];

        if (col < 1 || col > 3 || row < 1 || row > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        if (grid[newCol][newRow] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

        grid[newCol][newRow] = isX ? 'X' : 'O';
        isX = !isX;
        filledCount++;
        return true;
    }

    public static int[][] changeCoor(int col, int row) {
        int[][] coor = new int[1][2];

        coor[0][0] = 3 - row;
        coor[0][1] = col - 1;

        return coor;
    }

    public static void fillGrid() {
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                grid[i][k] = ' ';
            }
        }
    }

    public static void printGrid() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int k = 0; k < 3; k++) {
                System.out.print(grid[i][k] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkResult(char[][] grid) {
        boolean xWin = false;
        boolean oWin = false;
        int x = 'X';
        int o = 'O';

        if (grid[0][0] != '_') {
            if (grid[0][0] + grid[0][1] + grid[0][2] == (grid[0][0] == 'X' ? x * 3 : o * 3)) {
                if (grid[0][0] == 'X') {
                    xWin = true;
                } else if (grid[0][0] == 'O') {
                    oWin = true;
                }
            }
            if (grid[0][0] + grid[1][0] + grid[2][0] == (grid[0][0] == 'X' ? x * 3 : o * 3)) {
                if (grid[0][0] == 'X') {
                    xWin = true;
                } else if (grid[0][0] == 'O') {
                    oWin = true;
                }
            }
            if (grid[0][0] + grid[1][1] + grid[2][2] == (grid[0][0] == 'X' ? x * 3 : o * 3)) {
                if (grid[0][0] == 'X') {
                    xWin = true;
                } else if (grid[0][0] == 'O') {
                    oWin = true;
                }
            }
        }

        if (grid[0][1] != '_') {
            if (grid[0][1] + grid[1][1] + grid[2][1] == (grid[0][1] == 'X' ? x * 3 : o * 3)) {
                if (grid[0][1] == 'X') {
                    xWin = true;
                } else if (grid[0][1] == 'O') {
                    oWin = true;
                }
            }
        }

        if (grid[0][2] != '_') {
            if (grid[0][2] + grid[1][2] + grid[2][2] == (grid[0][2] == 'X' ? x * 3 : o * 3)) {
                if (grid[0][2] == 'X') {
                    xWin = true;
                } else if (grid[0][2] == 'O') {
                    oWin = true;
                }
            }
        }

        if (grid[1][0] != '_') {
            if (grid[1][0] + grid[1][1] + grid[1][2] == (grid[1][0] == 'X' ? x * 3 : o * 3)) {
                if (grid[1][0] == 'X') {
                    xWin = true;
                } else if (grid[1][0] == 'O') {
                    oWin = true;
                }
            }
        }

        if (grid[2][0] != '_') {
            if (grid[2][0] + grid[2][1] + grid[2][2] == (grid[2][0] == 'X' ? x * 3 : o * 3)) {
                if (grid[2][0] == 'X') {
                    xWin = true;
                } else if (grid[2][0] == 'O') {
                    oWin = true;
                }
            }
        }

        if (grid[0][2] != '_') {
            if (grid[0][2] + grid[1][1] + grid[2][0] == (grid[0][2] == 'X' ? x * 3 : o * 3)) {
                if (grid[0][2] == 'X') {
                    xWin = true;
                } else if (grid[0][2] == 'O') {
                    oWin = true;
                }
            }
        }

        if (xWin && !oWin) {
            System.out.println("X wins");
            return true;
        } else if (!xWin && oWin) {
            System.out.println("O wins");
            return true;
        } else if (filledCount == 9) {
            System.out.println("Draw");
            return true;
        } else {
            return false;
        }
    }
}
