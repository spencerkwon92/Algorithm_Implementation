package career.projects.algorithmImplementation.sortingLab;

public class HeapSort implements SortEngine{

    private int comparison;
    HeapSort(){
        comparison=0;
    }

    public void engine(Employee[] arr){}

    public void engine(Employee[] arr, int hs){
        for (Employee ele : arr) {
            System.out.print(ele.id + " ");
        }
        // create maxheap.
        maxHeap(arr, hs);

        for (Employee ele : arr) {
            System.out.print(ele.id + " ");
        }

        for (int i = arr.length - 1; i >= 1; i--) {
            Employee temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            hs = hs - 1;
            heapify(arr, 0, hs);
        }
    }

    public void maxHeap(Employee[] arr, int hs) {
        int loop = (int) Math.floor(arr.length / 2);
        for (int i = loop; i >= 0; i--) {
            heapify(arr, i, hs);
        }
    }

    public void heapify(Employee[] arr, int i, int hs) {
        int max = 0;
        int left = 2 * i + 1;
        int right = 2 * (i + 1);
        comparison++;
        if (left <= hs && arr[left].id > arr[i].id) {
            max = left;
        } else {
            max = i;
        }
        comparison++;

        if (right <= hs && arr[right].id > arr[max].id) {
            max = right;
        }

        if (max != i) {
            Employee temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heapify(arr, max, hs);
        }
    }

    public int getComparison(){
        return comparison;
    }
}

