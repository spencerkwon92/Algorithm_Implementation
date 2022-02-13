package career.projects.algorithmImplementation.searchingLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SearchingMachine {
    int index, comparison;

    SearchingMachine(){
        this.comparison = 0;
    }

    // Inner class to form the data.
    static class Employee{
        String name, job;
        int id, age, hire;

        Employee(String data){
            String[] temp = data.split("\\|");
            this.name = temp[0];
            this.id = Integer.valueOf(temp[1]);
            this.age = Integer.valueOf(temp[2]);
            this.job = temp[3];
            this.hire = Integer.valueOf(temp[4]);
        }
    }

    //Method for binary search.
    public Employee binarySearch(int targetID, List<Employee> db){
        int low = 0;
        int high = db.size();

        while (low < high) {
            double mid = Math.floor((low + high) / 2); // drop the decimal point by using floor function.
            if (targetID <= db.get((int) mid).id) {
                high = (int) mid;
                index = (int) mid;
            } else {
                low = (int) mid + 1;
                index = low;
            }
            comparison++;
        }
        return db.get(high);
    }

    //Method for sequencial search.
    public Employee sequencialSearch(int targetID, List<Employee> db){
        Employee emp = null;
        for(Employee ele:db){
            if(ele.id == targetID){
                emp = ele;
            }
            comparison++;
        }
        return emp;
    }

    public static void main(String[] args){
        SearchingMachine sm = new SearchingMachine();
        List<Employee> db = new ArrayList<>();

        /**
         * Start to ask questions to the users.
         * Users need to choose and input the number of data, data file directory, searching machines, and target ID to find.
         */

        System.out.println("Input the data file name. ");
        String fileName = new Scanner(System.in).next();

        System.out.println("");
        System.out.println("Data Init Process...");

        try{
            File file = new File(fileName);
            Scanner scan = new Scanner(file);

            while(scan.hasNextLine()){
                String line = scan.nextLine();
                Employee data = new Employee(line);
                db.add(data);
            }

        }catch(FileNotFoundException e){
            System.out.println("File Not Found....");
            e.printStackTrace();
        }
        System.out.println("");
        System.out.println(db.size());
        System.out.println("Init Done...");

        System.out.println("How many number of data are you searching? ");
        int searchingDataNum = Integer.valueOf(new Scanner(System.in).next());

        System.out.println("Please input "+searchingDataNum+" id number. ");
        String values = new Scanner(System.in).nextLine();
        String[] targetIDs = values.split(",");

        System.out.print("Choose the search algorithm. ");
        String searchEngine = new Scanner(System.in).nextLine();

        System.out.println("Start to data search...");
        System.out.println("");

        System.out.println("SEARCH RESULT");

        long startTime = System.currentTimeMillis();
        double[] workQuery = new double[searchingDataNum];

        //apply the sorting machine.
        for(int i=0; i<targetIDs.length; i++) {

            Employee emp = null;
            int targetID = Integer.valueOf(targetIDs[i]);

            if (searchEngine.equals("binary search")) {
                emp = sm.binarySearch(targetID, db);
                workQuery[i] = sm.comparison;
            } else if (searchEngine.equals("sequential search")) {
                emp = sm.sequencialSearch(targetID, db);
                workQuery[i] = sm.comparison;
            }

            if (emp != null) {
                System.out.println("**************************");
                System.out.println("Name: " + emp.name +"\nID: " + emp.id + "\nAge: " + emp.age + "\nJob: " + emp.job
                        + "\nHired: " + emp.hire);
            }else{
                System.out.println("**************************");
                System.out.println(targetID + " is not found...");
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("**************************");

        System.out.println("");

        //Analysis of speed to search and comparisons.
        System.out.println("EFFICIENCY CALCULATION.");
        System.out.println("**************************");

        long calculationTime = (endTime-startTime)/1000;
        double query = 0;
        for (double ele: workQuery){
            query += ele;
        }

        System.out.println("Algorithm Searching Time: " + calculationTime + "sec.");
        System.out.println("Average work per query: " + (query / searchingDataNum)+".");
    }
}
