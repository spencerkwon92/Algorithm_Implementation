package career.projects.algorithmImplementation.sortingLab;

public class InsertionSort implements SortEngine{

    private int comparison;
    InsertionSort(){
        comparison = 0;
    }

    public void engine(Employee[] arr){
        for (int i = 1; i < arr.length; i++) {
            Employee key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].id > key.id) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
            comparison++;
        }
    }

    public int getComparison(){
        return comparison;
    }
}