import java.util.concurrent.ThreadLocalRandom;

public class map {

    public int size;

    public char[][] mapMatrix;



    public void print() {

        for(int i=0; i<size; ++i)
        {
            for(int j=0;j<size; ++j)
            {
                System.out.print(mapMatrix[i][j]);
            }
            System.out.println();
        }
    }

    public map() {

        this.size = 12;

        this.mapMatrix = new char[size][size];

        initMap();

        generateMap();
    }

    public void initMap() {
        for(int i=0; i<size; ++i)
        {
            for(int j=0;j<size; ++j)
            {
                this.mapMatrix[i][j] = ' ';
            }

        }

        for(int i=1; i < size-1; i=i+3)
        {
            for(int j=1; j < size-1; j=j+3)
            {
                this.mapMatrix[i][j] = 'C';
            }
        }
    }

    public void generateMap() {

        for(int i=1; i<size-1; i=i+3)
        {
            for(int j=1; j<size-1;j=j+3)
            {
                if(mapMatrix[i][j] == 'C')
                {
                    mapMatrix[i-1][j] = ranItemInt();
                    mapMatrix[i][j-1] = ranItemInt();
                    mapMatrix[i+1][j] = ranItemInt();
                    mapMatrix[i][j+1] = ranItemInt();
                }
            }
        }
    }

    private char ranItemExt() {

        char[] outsideArray = {'W', 'W', ' ', ' '};

        return outsideArray[ThreadLocalRandom.current().nextInt(0,3 + 1)];
    }

    private char ranItemInt() {

        char[] outsideArray = {'W', 'W', 'D', 'D', ' ', ' '};

        return outsideArray[ThreadLocalRandom.current().nextInt(0,5 + 1)];
    }

}




/*

C - Columns

W - Single Walls

WW - Wide Walls

- Long Wall

- Single Doors

DD - Wide Door

W





 */