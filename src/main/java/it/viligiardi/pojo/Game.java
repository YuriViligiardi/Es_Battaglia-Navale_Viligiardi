package it.viligiardi.pojo;

import it.viligiardi.service.ShipService;

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
                boolean check2 = Game.sizeControl(randomX, randomY, s, hor);
                if (check2) {
                    check = Game.PlaceShip(randomX, randomY, s, p);
                } else {
                    check = false;
                }
            } while (check != true);
        }
    }

    public static boolean sizeControl(int x, int y, Ship s, boolean hor) {
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

    public static boolean isWater(int x, int y, Player p) {
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
                if (Game.isWater(i, j, p)) {
                    p.getField().getMatrix()[i][j] = s.getSymbol();
                } else {
                    return false;
                }
            }
        }
        return true;
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

    public static void startGame() {
        Game.placeShipsRandom(Game.p1);
        Game.printMatrix(Game.p1); // controllo per vedere la matrice
        Game.placeShipsRandom(Game.p2);
        Game.printMatrix(Game.p2); // controllo per vedere la matrice
    }

    public static String hit(int x, int y, Player p) {
        if (Game.isWater(x, y, p)) {
            p.getField().getMatrix()[x][y] = "O"; // non colpita
            return "NAVE NON COLPITA";
        } else {
            p.getField().getMatrix()[x][y] = "X"; // colpita
            if (Game.sunk(x, y, p)) {
                return "NAVE AFFONDATA";
            }
            return "NAVE COLPITA";
        }
    }

    public static boolean sunk(int x, int y, Player p) {
        boolean check = false;
        Ship s = Game.searchShip(x, y, p);

        if (Game.checkDirection(s)) {
            check = Game.controlSunk(x, y, x + 1, (y + s.getDimShip()), s, p);
            if (check) {
                Game.changeSunkenSymbol(x, y, x + 1, (y + s.getDimShip()), s, p);
            }
        } else {
            check = Game.controlSunk(x, y, (x + s.getDimShip()), y + 1, s, p);
            if (check) {
                Game.changeSunkenSymbol(x, y, (x + s.getDimShip()), y + 1, s, p);
            }
        }
        return check;
    }

    public static boolean controlSunk(int xStart, int yStart, int xFinish, int yFinish, Ship s, Player p) {
        for (int i = xStart; i < xFinish; i++) {
            for (int j = yStart; j < xFinish; j++) {
                if (isWater(i, j, p)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void changeSunkenSymbol(int xStart, int yStart, int xFinish, int yFinish, Ship s, Player p) {
        for (int i = xStart; i < xFinish; i++) {
            for (int j = yStart; j < xFinish; j++) {
                p.getField().getMatrix()[i][j] = "-";
                s.setSymbol("-");
            }
        }
    }

    public static Ship searchShip(int x, int y, Player p) {
        String sim = p.getField().getMatrix()[x][y];
        switch (sim.toUpperCase()) {
            case "A":
                return p.getShipsList().get(0);
            case "B":
                return p.getShipsList().get(1);
            case "C":
                return p.getShipsList().get(2);
            case "D":
                return p.getShipsList().get(3);
            case "E":
                return p.getShipsList().get(4);
            case "F":
                return p.getShipsList().get(5);
            case "G":
                return p.getShipsList().get(6);
            case "H":
                return p.getShipsList().get(7);

            default:
                return p.getShipsList().get(8);
        }
    }

    public static boolean isVictory(Player p) {
        for (Ship s : p.getShipsList()) {
            if (!(s.getSymbol().equals("-"))) {
                return false;
            }
        }
        return true;
    }
}