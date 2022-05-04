package oop.labor10.lab10_3;

public class Main {

    static void completeRow(String fileName, String updateName){

        System.out.println("products:" + fileName +"\n" + "Updates: " + updateName);

        long start = System.nanoTime();
        Storage st = new Storage(fileName);
        st.update(updateName);
        long end  = System.nanoTime();

        double dur = (double) (end - start) / 1_000_000_000;
        System.out.println("Execution time: " + dur + " seconds\n");
    }

    public static void main(String[] args) {

        //Szép munka!
        completeRow("data1000.txt", "update1000.txt");
        completeRow("data1000.txt", "update1000000.txt");
        completeRow("data1000000.txt", "update1000.txt");
        completeRow("data1000000.txt", "update1000000.txt");

    }

}
