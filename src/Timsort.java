public class Timsort {
    public static long iterations = 0;
    public static final int MIN_MERGE = 64;

    public static int minRunLength(int n)
    {
        int r = 0;
        while (n >= MIN_MERGE)
        {
            iterations++;
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    public static void insertionSort(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                iterations++;
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
    public static void merge(int[] arr, int l, int m, int r)
    {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            iterations++;
            left[x] = arr[l + x];
        }
        for (int x = 0; x < len2; x++)
        {
            iterations++;
            right[x] = arr[m + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2)
        {
            iterations++;
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < len1)
        {
            iterations++;
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < len2)
        {
            iterations++;
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public void timSort(int[] arr) {
        int n = arr.length;
        int minRun = minRunLength(n);
        System.out.println("minrun = " + minRun);
        for (int i = 0; i < n; i += minRun)
        {
            iterations++;
            insertionSort(arr, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size)
        {
            for (int left = 0; left < n; left += 2 * size)
            {
                iterations++;
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if(mid < right)
                    merge(arr, left, mid, right);
            }
        }
        System.out.println("iteration = " + iterations);
    }

    public void printArray(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}