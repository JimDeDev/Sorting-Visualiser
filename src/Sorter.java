import java.util.Random;

public class Sorter implements Runnable{

    private static final int SIZE_OF_ARRAY = 500;
    private int[] numbers;

    public Sorter() {

        this.numbers = new int[SIZE_OF_ARRAY];
        generateNumbers();


    }

    private void generateNumbers() {

        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            this.numbers[i] = i + 1;
        }
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void shuffle() {
        
        int[] tempArray = new int[SIZE_OF_ARRAY];
        System.arraycopy(this.numbers, 0, tempArray, 0, SIZE_OF_ARRAY);

        for (int i = 0; i< SIZE_OF_ARRAY; i++) {
            numbers[i] = -1;
        }
        
        Random rand = new Random();
        boolean placed = false;
        int randomPlace;
        
        
        
        for (int i = 0; i< SIZE_OF_ARRAY; i++) {
            
            placed = false;
            
            while (!placed) {
                randomPlace = rand.nextInt(SIZE_OF_ARRAY);
                if (numbers[randomPlace] == -1) {
                    numbers[randomPlace] = tempArray[i];
                    placed = true;
                }
            }
        }
    }

    public void sort() {

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        boolean swaps = true;
        while (swaps) {
            swaps = false;
            for (int i = 0; i < SIZE_OF_ARRAY - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i + 1] = temp;
                    swaps = true;
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
