package career.projects.algorithmImplementation.sortingLab;

class MergeSort implements SortEngine{

    private int comparison;

    MergeSort(){
        comparison = 0;
    }

    public void engine(Employee[] arr){}

    public void engine(Employee[] arr, int p, int r){
        if(p < r){
            int q = (int)Math.floor((p+r) / 2);
            engine(arr, p, q);
            engine(arr, q+1, r);
            mergeing(arr,p,q,r);
        }
    }

    public void mergeing(Employee[] arr, int p, int q, int r){
        int n1 = q - p + 1;
        int n2 = r - q;
        Employee[] L = new Employee[n1 + 1];
        Employee[] R = new Employee[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[q + j + 1];
        }
        L[n1] = new Employee();
        R[n2] = new Employee();

        int i = 0;
        int j = 0;

        for (int k = p; k <= r; k++) {
            if (L[i].id <= R[j].id) {
                arr[k] = L[i];
                i = i + 1;
                comparison++;
            } else {
                arr[k] = R[j];
                j = j + 1;
                comparison++;
            }
        }
    }

    public int getComparison(){
        return comparison;
    }
}
