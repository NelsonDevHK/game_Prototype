import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class GameWorld {
    private int MAX_H = 10;
    private int MAX_W = 10;
    Scanner sc;
    String[][] gmap;
    int posx = 0;
    int posy = 0;

    int winX = 9;
    int winY = 9;

    boolean ifWin() {
        return (posx == winX && posy == winY);
    }

    void move() {
        System.out.println("choose move direction");
        System.out.println(posx + "   " + posy);
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
        }
        if (posx < 0)
            this.posx = 0;
        if (posx >= MAX_W)
            this.posx = MAX_W - 1;
        if (posy < 0)
            this.posy = 0;
        if (posy >= MAX_H)
            this.posy = MAX_H - 1;
    }

    GameWorld() {
        sc = new Scanner(System.in);
        gmap = new String[MAX_H][MAX_W];
        for (int i = 0; i < MAX_H; i++) {
            for (int j = 0; j < MAX_W; j++) {
                gmap[i][j] = "_";
            }
        }
    }

    void vander() {
        for (int i = 0; i < MAX_H; i++) {
            for (int j = 0; j < MAX_W; j++) {
                if (i == posy && j == posx)
                    System.out.print("N");
                else if (i == winY && j == winX)
                    System.out.print("O");
                else
                    System.out.print(gmap[i][j]);
            }
            System.out.println();
        }
    }

    void gameLoop() {
        while (true) {
            move();
            if (ifWin())
                break;
            vander();
        }
        System.out.println("WINNER!");
    }

    void sleep1sec() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {

        }
    }
}

public class GameLogic {
    public static void main(String[] args) {
        GameWorld first = new GameWorld();
        first.gameLoop();

    }
}