import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class GameWorld {
    private int MAX_H = 10;
    private int MAX_W = 20;
    Scanner sc;
    String[][] gmap;
    int posx = 0;
    int posy = 0;

    int winX = 14;
    int winY = 5;

    boolean Win() {
        return (posx == winX && posy == winY);
    }

    void useitem() {
            for (int i = 0; i < MAX_H; i++) {
                for (int j = 0; j < MAX_W; j++) {
                    if (i == posy && j == posx)
                        System.out.print("N");
                    else if (i == winY && j == winX) {
                        System.out.print("O");

                    } else
                        System.out.print(gmap[i][j]);
                }
                System.out.println();
            }
        sleep1sec();
    }

    void intsruction() {
        System.out.println("A = move left");
        System.out.println("D = move right");
        System.out.println("W = move up");
        System.out.println("S = move down");
        System.out.println("F = use item(show the Winnig Exit)");
    }

    void move() {
        String choice = sc.nextLine();
        switch (choice) {
            case "A":
                this.posx -= 1;
                break;
            case "W":
                this.posy -= 1;
                break;
            case "S":
                this.posy += 1;
                break;
            case "D":
                this.posx += 1;
                break;
            case "F":
                useitem();
        }
        if (posx < 0)
            this.posx = 0;
        if (posx >= MAX_W)
            this.posx = MAX_W - 1;
        if (posy < 0)
            this.posy = 0;
        if (posy >= MAX_H)
            this.posy = MAX_H - 1;

        clearScreen();
    }

    // Constructer
    GameWorld() {
        sc = new Scanner(System.in);
        gmap = new String[MAX_H][MAX_W];
        for (int i = 0; i < MAX_H; i++) {
            for (int j = 0; j < MAX_W; j++) {
                gmap[i][j] = "_";
            }
        }
    }

    // vander update the graphic only no logic!!!!!!
    void vander() {
        for (int i = 0; i < MAX_H; i++) {
            for (int j = 0; j < MAX_W; j++) {
                if (i == posy && j == posx)
                    System.out.print("N");
                else
                    System.out.print(gmap[i][j]);
            }
            System.out.println();
        }
    }

    // main loop of this game
    void gameLoop() {
        intsruction();

        while (true) {
            vander();
            move();
            if (Win())
                break;
        }
        System.out.println("WINNER!");
    }

    void sleep1sec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }
    }

    void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

public class GameLogic {
    public static void main(String[] args) {
        GameWorld first = new GameWorld();
        first.gameLoop();

    }
}