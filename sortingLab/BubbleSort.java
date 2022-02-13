package career.projects.algorithmImplementation.sortingLab;

public class BubbleSort implements SortEngine{

    private int comparison;

    BubbleSort(){
        comparison = 0;
    }

    @Override
    public void engine(Employee[] arr){
        for (int i = 0; i <= arr.length - 2; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j].id < arr[j - 1].id) {
                    Employee temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
                comparison++;
            }
        }
    }

    public int getComparison(){
        return comparison;
    }
}
