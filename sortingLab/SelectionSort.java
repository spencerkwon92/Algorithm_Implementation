package career.projects.algorithmImplementation.sortingLab;

public class SelectionSort implements SortEngine{

    private int comparison;

    SelectionSort(){
        comparison = 0;
    }

    public void engine(Employee[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].id < arr[minIndex].id) {
                    minIndex = j;
                }
            }
            Employee temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            comparison++;
        }
    }

    public int getComparison(){
        return comparison;
    }
}