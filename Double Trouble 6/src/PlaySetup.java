import java.util.Scanner;

public class PlaySetup {
    public static boolean gompeiFirst() {
        int firstTurn;
        Scanner scan = new Scanner(System.in);
        boolean gompeiFirst = false;
        boolean begin = true;


        //Start of game display

        while (begin) {
            System.out.println("Welcome to DOUBLE TROUBLE " +
                    "\nWould you like to go first or let computer opponent 'GOMPEI' go first? " +
                    "\nType '0' for you to go first or '1' for GOMPEI" +
                    "\nType '2' to see HOW TO PLAY");
            firstTurn = scan.nextInt();
            if (firstTurn == 0) {
                begin = false;
                gompeiFirst = false;
                System.out.println("You have the first move\n");
            } else if (firstTurn == 1) {
                begin = false;
                gompeiFirst = true;
                System.out.println("GOMPEI has the first move\n");
            } else if (firstTurn == 2) {
                begin = true;
                gompeiFirst = false;
                System.out.println("HOW TO PLAY: There are 3 piles of different colored markers. " +
                                "\nThere are 3 green markers, 5 orange markers and 7 yellow markers. " +
                                "\nEach turn, the players can remove as many markers of a single color as they wish. " +
                        "\nThe player who makes the last move wins. " +
                        "\nYou can choose if you want to go first or want GOMPEI to make the first move.\n\n ");
            }
            else {
                System.out.println("You have entered an invalid response, please type '0' for you to go first or '1' for GOMPEI\n");
            }
        }
        return gompeiFirst;
    }

    public static void main(String[] args) {
        boolean gompeiTurn = gompeiFirst();
        Game game = new Game();

        while (game.markersLeft() > 0) {

            if (!gompeiTurn) {

                //user's turn
                System.out.println("It is your turn!");
                boolean trueColor = false;
                boolean trueValue = false;
                Scanner colorScanner = new Scanner(System.in);
                Scanner valueScanner = new Scanner(System.in);


                String color = "";
                int value = 0;



                while (!trueColor || !trueValue) {
                    game.showGamePiles();
                    System.out.println("What color do you choose to remove markers from?");
                    color = colorScanner.nextLine();
                    if (game.trueColor(color)) {
                        trueColor = true;
                        System.out.println("How many markers do you want to remove?");
                        value = valueScanner.nextInt();
                        if (game.trueValue(value, color)) {
                            trueValue = true;
                        }
                        else {
                            System.out.println("You have entered an invalid amount of markers to be removed, please enter a valid number\n");
                        }
                    } else {
                        System.out.println("You have entered an invalid color. Please enter a valid color with markers left");
                    }
                }
                game.removeMarker(color, value);
                if(value == 1) {
                    System.out.println("you removed " + value + " marker from " + color + "\n");
                }
                else {
                    System.out.println("you removed " + value + " markers from " + color + "\n");
                }
                gompeiTurn = true;
            } else {
                System.out.println("It is now GOMPEI's turn\n");

                //GOMPEI's turn
                //Xor decides smart or random move from winning pos

                if (game.Xor() > 0) {
                    game.gompeiSmartMove();
                } else {
                    game.gompeiRandomMove();
                }
                gompeiTurn = false;
            }
        }
        if (!gompeiTurn) {
            System.out.println("Game Over! GOMPEI is the Winner.");
        } else {
            System.out.println("Game Over! You Win!");
        }
    }
}

