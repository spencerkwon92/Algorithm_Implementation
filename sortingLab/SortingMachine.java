package career.projects.algorithmImplementation.sortingLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SortingMachine {
    static int comparison;

    SortingMachine(){
        comparison = 0;

    }

    public static void main(String[] args){

        System.out.println("How many employee data are you input? ");
        int dataNum = Integer.valueOf(new Scanner(System.in).next());
        Employee[] db = new Employee[dataNum];

        System.out.println("Input the data file directory.");
        String fileName = new Scanner(System.in).nextLine();

        try{
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            for(int i=0; i<dataNum; i++) {
                String line = scan.nextLine();
                Employee data = new Employee(line);
                db[i] = data;
            }

        }catch (FileNotFoundException e){
            System.out.println("File Not Found...");
            e.printStackTrace();
        }

        System.out.print("Choose the sorting algorithm. ");

        String searchEngine = new Scanner(System.in).nextLine();

        System.out.println("Starting sort your data by using " + searchEngine);

        double start = System.currentTimeMillis();
        SortEngine engine = null;
        switch (searchEngine){
            case "bubble sort":
                engine = new BubbleSort();
                engine.engine(db);
                comparison = ((BubbleSort) engine).getComparison();
                break;
            case "insertion sort":
                engine = new InsertionSort();
                engine.engine(db);
                comparison = ((InsertionSort) engine).getComparison();
                break;
            case "selection sort":
                engine = new SelectionSort();
                engine.engine(db);
                comparison = ((SelectionSort) engine).getComparison();
                break;
            case "merge sort":
                engine = new MergeSort();
                ((MergeSort) engine).engine(db,0, db.length-1);
                comparison = ((MergeSort) engine).getComparison();
                break;
            case "heap sort":
                engine = new HeapSort();
                ((HeapSort) engine).engine(db, db.length - 1);
                comparison = ((HeapSort) engine).getComparison();
                break;
        }

        double end = System.currentTimeMillis();
        double times = (end - start) / 1000;

        System.out.println("Data sorting Done!");
        System.out.println("***************************************************");
        System.out.println("Analysis...");

        System.out.println("Comparison: " + comparison + " comparison to sort your data.");
        System.out.println("Time: it takes "+ times + " sec to sort your data.");
    }
}
