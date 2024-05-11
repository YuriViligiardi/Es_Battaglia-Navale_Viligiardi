package it.viligiardi.pojo;

public class Game {
    // attributes
    public static Field f1 = new Field(10);
    public static Field f2 = new Field(10);
    public static Player p1 = new Player("GIOCATORE", 9, f1);
    public static Player p2 = new Player("GIOCATORE", 9, f2);

    // methods and constructors
    public static void placeShipsRandom(Player p) {
        int randomX, randomY;
        boolean check;
        for (Ship s : p.getShipsList()) {
            do {
                randomX = (int) (Math.random() * 10);
                randomY = (int) (Math.random() * 10);
                boolean hor = checkDirection(s); // true = orizzontale ; false = verticale
                boolean check2 = Game.isEmpty(randomX, randomY, s, hor);
                if (check2) {
                    check = Game.PlaceShip(randomX, randomY, s, p);
                } else {
                    check = false;
                }
            } while (check != true);
        }
    }

    public static boolean isEmpty(int x, int y, Ship s, boolean hor) {
        if (hor) {
            if ((y + s.getDimShip()) > 9) {
                return false;
            } else {
                return true;
            }
        } else {
            if ((x + s.getDimShip()) > 9) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean checkDirection(Ship s) {
        if (s.getDirection() == 0) {
            // la nave è in verticale
            return false;
        } else {
            // senno la nave è in orizzontale
            return true;
        }
    }

    public static boolean controlWater(int x, int y, Player p) {
        if (p.getField().getMatrix()[x][y] == "a") {
            return true;
        } else {
            return false;
        }
    }

    public static boolean PlaceShip(int x, int y, Ship s, Player p) {
        boolean check;
        if (checkDirection(s)) {
            check = Game.put(x, y, x + 1, (y + s.getDimShip()), s, p);
            return check;
        } else {
            check = Game.put(x, y, (x + s.getDimShip()), y + 1, s, p);
            return check;
        }
    }

    public static boolean put(int xStart, int yStart, int xFinish, int yFinish, Ship s, Player p) {
        for (int i = xStart; i < xFinish; i++) {
            for (int j = yStart; j < xFinish; j++) {
                if (Game.controlWater(i, j, p)) {
                    p.getField().getMatrix()[i][j] = s.getSymbol();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void isVictory() {

    }

    // per il controllo
    public static void printMatrix(Player p) {
        for (int i = 0; i < p.getField().getDimMatrix(); i++) {
            System.out.println(" ");
            for (int j = 0; j < p.getField().getDimMatrix(); j++) {
                System.out.print(p.getField().getMatrix()[i][j]);
            }
        }
    }

}