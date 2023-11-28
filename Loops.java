public class Loops {

    public static void main (String[] args) {

        // MyBackgroundTask thread = new MyBackgroundTask();
        // thread.start();

        // for loop

        for (int i = 1; i <= 5; i++){
            System.out.println("Iteration " + i);
        }

        System.out.println();

        // For loop to retrieve files

        // File[] listofFiles = new File("name_of_directory");

        // for(File filename : listofFiles){

        // }

        // while loop

        int count = 0;
        while (count < 5){
            System.out.println("Count: " + count);
            count++;

            System.out.println();
        }

        // do while loop

        int num = 1;
        do{
            System.out.println("Number: " + num);
            num++;
        } while (num <= 5);

    }
    
}

