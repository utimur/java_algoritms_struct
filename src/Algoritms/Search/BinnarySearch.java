package Algoritms.Search;

public class BinnarySearch {

    public static void main(String[] args) {
        int[] arr = {0,1, 2, 3, 4, 5, 6, 7, 8,9,10};
        System.out.println(binnarySearch(arr,0, arr.length, 0));
    }

    public static int binnarySearch(int[] arr, int left, int right, int i) {
        int avg = (left + right)/2;
        if(i == arr[avg]) return avg;
        if(i > arr[avg]){
            return binnarySearch(arr, avg, right, i);
        }
        return binnarySearch(arr,left,avg,i);
    }
}
