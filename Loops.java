public class Loops {
    public static void main(String[] args) {

        MyBackgroundTask thread = new MyBackgroundTask();
        thread.start(); // Start the background thread

        // for loop
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration " + i);
        }
        System.out.println();


        // File[] listOfFiles = new File("name_of_directory");

        // for(File filename : listOfFiles) {

        // }
        
        // while loop
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
            System.out.println();
        }

        // do while loop
        int num = 1;
        do {
            System.out.println("Number: " + num);
            num++;
        } while (num <= 5);

    }

}

class MyBackgroundTask extends Thread {
    @Override
    public void run() {
        System.out.println("hello kings");
    }
}