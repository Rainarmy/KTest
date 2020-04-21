public class Test {
    public static void main(String[] args) {

    }

    public static int search(int[] arr, int x){
        if(arr == null || arr.length <= 0){
            return -1;
        }
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == x){
                return  i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr, int x) {
        if(arr == null || arr.length <= 0){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high){
            mid = (low+high)>>1;
            if(arr[mid] == x){
                return mid;
            }else if(arr[mid] > x){
                low = mid + 1;
            }else{
                high = mid + 1;
            }
        }
        return -1;
    }

    public static int recBinSearch(int[] arr, int low, int high, int x){
        if(arr == null || arr.length <= 0 || low < 0 || high < 0 || low > high){
            return -1;
        }

        int mid = (low + high) >> 1;
        if(arr[mid] > x){
            return recBinSearch(arr,low,mid+1,x);
        }else if(arr[mid] < x){
            return recBinSearch(arr,mid+1,high,x);
        }else{
            return mid;
        }
    }

    public static int[] BubblingSort(int[] arr){
        if(arr == null){
            return null;
        }
        if(arr.length <= 1){
            return arr;
        }
        for(int i = arr.length-1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static int Partition(int[] arr, int low, int high){
        int i = low;
        int j =  high;

        while( i < j ){
            while(i < j && arr[i] <= arr[j]){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }

            while(i < j && arr[j] >= arr[i]){
                i++;
            }
            if(arr[j] < arr[i]){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j--;
            }
        }
        return i;
    }

    public static int[] QuickSort(int[] arr){
        if(arr == null){
            return null;
        }
        return QuickSort(arr,0,arr.length-1);
    }

    public static int[] QuickSort(int[] arr, int low, int high){
        if(arr == null || low < 0 || high < 0 || low > high)
        {
            return null;
        }
        int v = Partition(arr,low,high);
        QuickSort(arr,low,v);
        QuickSort(arr,v,high);

        return arr;
    }

    public static int[] MergeSort(int[] arr){
        if(arr == null){
            return null;
        }
        if(arr.length <= 1){
            return arr;
        }
        return mergePass(arr,0,arr.length-1);
    }

    public static int[] mergePass(int[] arr, int low, int high){
        if(arr == null || low <0 || high < 0 || low > high){
            return null;
        }

        int mid = (low + high) >>1;
        mergePass(arr,low,mid);
        mergePass(arr,mid+1,high);
        merge(arr,low,mid,high);
        return arr;
    }

    public static int[] mergeP(int[] arr, int n){
        int d = 1;
        while ( d <= n){
            int i = 0;
            for(;i < n -2*d +1; i += 2 * d){
                merge(arr,i,i+d,i+2*d -1);
            }
            if(i < n - d +1){
                merge(arr,i,i+d-1,n);
            }
            d = d << 1;
        }
        return arr;
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid+1;
        int k =0;
        int len = high - low + 1;
        int[] t = new int[len];

        while ( i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                t[k++] = arr[i++];
            }else{
                t[k++] = arr[j++];
            }
        }
        while(i <= mid){
            t[k++] = arr[i++];
        }
        while (j <= high){
            t[k++] = arr[j++];
        }
    }
}
