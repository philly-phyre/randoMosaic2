/**
 * Created by Phil on 11/17/2015.
 */
public class jrun4 {

    static int ROWS = 61;
    static int COLUMNS = 87;

    static int currentRow;
    static int currentCol;

    public static void main(String[] args) {

    Mosaic.open(ROWS,COLUMNS,15,15);
    Mosaic.fillRandomly();
    currentRow = (int)Math.ceil(ROWS/2);
    currentCol = (int)Math.ceil(COLUMNS/2);

    while (Mosaic.isOpen()) {
        colorSquareRandom(currentRow,currentCol);
        rand();
        Mosaic.delay(1);
    }



    } //end main()



    static void colorSquareRandom(int x, int y) {
        int rand = (int)(Math.random()*3);
        int red = Mosaic.getRed(x,y);
        int green = Mosaic.getGreen(x,y);
        int blue = Mosaic.getBlue(x,y);
        switch (rand) {
            case 0:
                if (Mosaic.getRed(x,y) >= 255)
                    Mosaic.setColor(x,y,0,green,blue);
                else
                    Mosaic.setColor(x, y, red + 44, (int)(green/1.8), (int)(blue/1.8));
                break;
            case 1:
                if (Mosaic.getGreen(x,y) >= 255)
                    Mosaic.setColor(x,y,red,0,blue);
                else
                    Mosaic.setColor(x, y, (int)(red/1.8), green + 44, (int)(blue/1.8));
                break;
            case 2:
                if (Mosaic.getBlue(x,y) >= 255)
                    Mosaic.setColor(x,y,red,green,0);
                else
                    Mosaic.setColor(x, y, (int)(red/1.8), (int)(green/1.8), blue + 44);
                break;
        } //end color change switch


    } //end colorSquareRandom()


    static void rand() {
        int randNum = (int) (Math.random() * 4);
        switch (randNum) {
            case 0:
                if (currentRow <= 0)
                    currentRow++;  // or break; for brighter model.
                else if (currentRow - 1 <= 0)
                    currentRow--;
                else
                    currentRow-=2;
                break;
            case 1:
                if (currentRow >= ROWS - 1)
                    currentRow--;  // or break; for brighter model.
                else if (currentRow + 1 == ROWS - 1)
                    currentRow++;
                else
                    currentRow+=2;
                break;
            case 2:
                if (currentCol <= 0)
                    currentCol++;
                else if (currentCol - 1 == 0)
                    currentCol--;
                else
                    currentCol-=2;
                break;
            case 3:
                if (currentCol >= COLUMNS - 1)
                    currentCol--;
                else if (currentCol + 1 == COLUMNS - 1)
                    currentCol++;
                else
                    currentCol+=2;
                break;
        } //end random movement switch
    } //end rand()



    }//end jrun4
