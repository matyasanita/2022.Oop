package lab12_2;

public class Main {

    static void completeRow(String fileName, String updateName){

        System.out.println("ArrayList implementation:");

        long start = System.nanoTime();
        Storage storageArrayList = new Storage(fileName);
        storageArrayList.update(updateName);
        long end  = System.nanoTime();

        double dur = (double) (end - start) / 1_000_000_000;
        System.out.println("Execution time: " + dur + " seconds\n");

        System.out.println("---------------------------\n");

        System.out.println("HashMap implementation:");

        start = System.nanoTime();
        StorageHash storageHash = new StorageHash(fileName);
        storageHash.update(updateName);
        end  = System.nanoTime();

        dur = (double) (end - start) / 1_000_000_000;
        System.out.println("Execution time: " + dur + " seconds\n");
    }

    public static void main(String[] args) {

        completeRow("data1000000.txt", "update1000000.txt");

    }

}
