package career.projects.algorithmImplementation.sortingLab;

public class Employee {

    String name, job;
    int id, age, hire;

    Employee(){
        id = Integer.MAX_VALUE;
    }
    Employee(String data){
        String[] temp = data.split("\\|");
        this.name = temp[0];
        this.id = Integer.valueOf(temp[1]);
        this.age = Integer.valueOf(temp[2]);
        this.job = temp[3];
        this.hire = Integer.valueOf(temp[4]);
    }
}
