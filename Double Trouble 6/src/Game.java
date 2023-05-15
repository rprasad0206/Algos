import java.util.Locale;
import java.util.Random;

public class Game {

    Marker pile[] = new Marker[3];

    //Game set up with 3 different color markers in arrays called pile
    public Game() {
        this.pile[0] = new Marker("Green", 3);
        this.pile[1] = new Marker("Orange", 5);
        this.pile[2] = new Marker("Yellow", 7);
    }

    //prints the game pile showing values of each color
    public void showGamePiles() {
        if(this.pile[0].getValue() == 1 && this.pile[1].getValue() != 1 && this.pile[2].getValue() != 1 ) {
            System.out.println("\nThere is " + this.pile[0].getValue() + " green marker"
                    +"\nThere are " + this.pile[1].getValue() + " orange markers"
                    +"\nThere are " + this.pile[2].getValue() + " yellow markers\n");
        } else if (this.pile[1].getValue() == 1 && this.pile[0].getValue() != 1 && this.pile[2].getValue() != 1 ) {
            System.out.println("\nThere is " + this.pile[0].getValue() + " green marker"
                    +"\nThere is " + this.pile[1].getValue() + " orange marker"
                    +"\nThere are " + this.pile[2].getValue() + " yellow markers\n");
        } else if (this.pile[2].getValue() == 1 && this.pile[0].getValue() != 1 && this.pile[1].getValue() != 1 ) {
            System.out.println("\nThere are " + this.pile[0].getValue() + " green markers"
                    + "\nThere are " + this.pile[1].getValue() + " orange markers"
                    + "\nThere is " + this.pile[2].getValue() + " yellow marker\n");
        } else if (this.pile[0].getValue() == 1 && this.pile[1].getValue() == 1 && this.pile[2].getValue() != 1 ) {
            System.out.println("\nThere is " + this.pile[0].getValue() + " green marker"
                    +"\nThere is " + this.pile[1].getValue() + " orange marker"
                    +"\nThere are " + this.pile[2].getValue() + " yellow markers\n");
        } else if (this.pile[1].getValue() == 1 && this.pile[2].getValue() == 1 && this.pile[0].getValue() != 1 ) {
            System.out.println("\nThere are " + this.pile[0].getValue() + " green markers"
                    +"\nThere is " + this.pile[1].getValue() + " orange marker"
                    +"\nThere is " + this.pile[2].getValue() + " yellow marker\n");
        } else if (this.pile[0].getValue() == 1 && this.pile[2].getValue() == 1 && this.pile[1].getValue() != 1 ) {
            System.out.println("\nThere is " + this.pile[0].getValue() + " green marker"
                    +"\nThere are " + this.pile[1].getValue() + " orange markers"
                    +"\nThere is " + this.pile[2].getValue() + " yellow marker\n");
        } else if (this.pile[0].getValue() == 1 && this.pile[2].getValue() == 1 && this.pile[1].getValue() == 1 ) {
            System.out.println("\nThere is " + this.pile[0].getValue() + " green marker"
                    +"\nThere is " + this.pile[1].getValue() + " orange marker"
                    +"\nThere is " + this.pile[2].getValue() + " yellow marker\n");
        } else {
            System.out.println("\nThere are " + this.pile[0].getValue() + " green markers"
                    + "\nThere are " + this.pile[1].getValue() + " orange markers"
                    + "\nThere are " + this.pile[2].getValue() + " yellow markers\n");
        }
    }

    //Sees the total amount of markers left

    public int markersLeft() {
        return this.pile[0].value + this.pile[1].value + this.pile[2].value;
    }

    //sees if the input color by the user is valid,
    //if no valid colors are entered, then validColorInput is false

    public boolean trueColor(String color) {
        if (color.toLowerCase(Locale.of("")).equals("green")) {
            if (pile[0].getValue() > 0) {
                return true;
            } else {
                return false;
            }
        } else if (color.toLowerCase(Locale.of("")).equals("orange")) {
            if (pile[1].getValue() > 0) {
                return true;
            } else {
                return false;
            }
        } else if (color.toLowerCase(Locale.of("")).equals("yellow")) {
            if (pile[2].getValue() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    //sees if valid number of markers was in the input

    public boolean trueValue(int value, String color) {
        if (color.toLowerCase(Locale.of("")).equals("green")) {
            if (pile[0].getValue() >= value && value > 0) {
                return true;
            }
        }
        else if (color.toLowerCase(Locale.of("")).equals("orange")) {
            if (pile[1].getValue() >= value && value > 0) {
                return true;
            }
        }
        else if (color.toLowerCase(Locale.of("")).equals("yellow")) {
            if (pile[2].getValue() >= value && value > 0) {
                return true;
            }
        }
        return false;
    }

    //remove number of markers from a color

    public void removeMarker(String color, int value) {
        if (color.toLowerCase(Locale.of("")).contentEquals("green")) {
            this.pile[0].value = this.pile[0].value - value;
        }
        if (color.toLowerCase(Locale.of("")).contentEquals("orange")) {
            this.pile[1].value = this.pile[1].value - value;
        }
        if (color.toLowerCase(Locale.of("")).contentEquals("yellow")) {
            this.pile[2].value = this.pile[2].value - value;
        }
    }

    //Computer Random move

    public void gompeiRandomMove() {
        System.out.println("GOMPEI is making a random move");
        Random rand = new Random();
        boolean validRandom = false;
        int removeRandom = 0;
        while (!validRandom) {
            int randValue = rand.nextInt(3);
            if (pile[randValue].value > 0) {
                if (pile[randValue].value == 1) {
                    removeRandom = 1;
                } else {
                    removeRandom = rand.nextInt(pile[randValue].value - 1 ) + 1;
                }
                pile[randValue].value = pile[randValue].value - removeRandom;
                validRandom = true;
                if (randValue == 0) {
                    if(removeRandom == 1) {
                        System.out.println("\nGOMPEI takes " + removeRandom + " marker from the green pile\n");
                    } else {
                        System.out.println("\nGOMPEI takes " + removeRandom + " markers from the green pile\n");
                    }
                }
                if (randValue == 1) {
                    if(removeRandom == 1) {
                        System.out.println("\nGOMPEI takes " + removeRandom + " marker from the orange pile\n");
                    } else {
                        System.out.println("\nGOMPEI takes " + removeRandom + " markers from the orange pile\n");
                    }
                }
                if (randValue == 2) {
                    if(removeRandom == 1) {
                        System.out.println("\nGOMPEI takes " + removeRandom + " marker from the yellow pile\n");
                    } else {
                        System.out.println("\nGOMPEI takes " + removeRandom + " markers from the yellow pile\n");
                    }
                }
            }
        }
    }

    //check Xor value
    public int Xor() {
        return pile[0].value ^ pile[1].value ^ pile[2].value;
    }

    //computer smart move: Checks Xor
    //If there is only markers from one color left, GOMPEI takes the rest of the markers left to result in GOMPEI winning

    //  green value > (orange value ⊕ yellow value), remove markers from green to create (orange value ⊕ yellow value)
    //  orange value > (green value ⊕ yellow value), remove markers from orange to create (green value ⊕ yellow value)
    //  yellow value > (green value ⊕ orange value), remove markers from yellow to create (green value ⊕ orange value)

    public void gompeiSmartMove() {
        //remove rest of color if one color is left
        System.out.println("GOMPEI is making a smart move");
        if (pile[0].value == 0 && pile[1].value == 0) {
            if (pile[2].value == 1 ) {
                System.out.println("\nGOMPEI takes " + pile[2].value + " marker from the yellow pile\n");
            } else {
                System.out.println("\nGOMPEI takes " + pile[2].value + " markers from the yellow pile\n");
            }
            removeMarker("yellow", pile[2].value);
        } else if (pile[1].value == 0 && pile[2].value == 0) {
            if (pile[0].value == 1 ) {
                System.out.println("\nGOMPEI takes " + pile[0].value + " marker from the green pile\n");
            } else {
                System.out.println("\nGOMPEI takes " + pile[0].value + " markers from the green pile\n");
            }
            removeMarker("green", pile[0].value);
        } else if (pile[0].value == 0 && pile[2].value == 0) {
            if (pile[1].value == 1 ) {
                System.out.println("\nGOMPEI takes " + pile[1].value + " marker from the orange pile\n");
            } else {
                System.out.println("\nGOMPEI takes " + pile[1].value + " markers from the orange pile\n");
            }
            removeMarker("orange", pile[1].value);

        } else {
            if (pile[0].value > (pile[1].value ^ pile[2].value)) {
                if((pile[0].value - (pile[1].value ^ pile[2].value)) ==1) {
                    System.out.println("\nGOMPEI takes " + (pile[0].value - (pile[1].value ^ pile[2].value)) + " marker from the green pile\n");
                } else {
                    System.out.println("\nGOMPEI takes " + (pile[0].value - (pile[1].value ^ pile[2].value)) + " markers from the green pile\n");
                }
                pile[0].value = (pile[1].value ^ pile[2].value);
            }
            if (pile[1].value > (pile[0].value ^ pile[2].value)) {
                if ((pile[1].value - (pile[0].value ^ pile[2].value)) == 1) {
                    System.out.println("\nGOMPEI takes " + (pile[1].value - (pile[0].value ^ pile[2].value)) + " marker from the orange pile\n");
                } else {
                    System.out.println("\nGOMPEI takes " + (pile[1].value - (pile[0].value ^ pile[2].value)) + " markers from the orange pile\n");
                }
                pile[1].value = (pile[0].value ^ pile[2].value);
            }
            if (pile[2].value > (pile[0].value ^ pile[1].value)) {
                if((pile[2].value - (pile[0].value ^ pile[1].value)) == 1) {
                    System.out.println("\nGOMPEI takes " + (pile[2].value - (pile[0].value ^ pile[1].value)) + " marker from the yellow pile\n");
                } else {
                    System.out.println("\nGOMPEI takes " + (pile[2].value - (pile[0].value ^ pile[1].value)) + " markers from the yellow pile\n");
                }
                pile[2].value = (pile[0].value ^ pile[1].value);
            }
        }
    }
}




















