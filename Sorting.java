import java.util.Arrays;
import java.io.*;
import java.util.*;

/**
 *@author Pedro Arriola 20188
 *@author Esteban Aldana 20591
 *@author Andrés de la Roca 20332
 */
public class Sorting{

    
    public static String gnomeSort(Comparable[] list){
        int i=1;
        int j=2;
        Comparable tmp;

        while(i<list.length){
            if(list[i-1].compareTo(list[i])<0){
                tmp = list[i-1];
                list[i-1] =list[i];
                list[i--] = tmp;
                i = (i==0) ? j++:i;
            }else{
                i = j; j++;
            }
        }
        return ("Los datos ordenados son ");
    }

    //sort para tipo Merge
    public static  Comparable[] mergeSort(Comparable[] list) {
        if(list.length<=1){
            return list;
        }
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);
        merge(first, second, list);

        return list;

    }

    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) {
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;

        while (iFirst < first.length && iSecond < second.length)
        {
            if (first[iFirst].compareTo(second[iSecond]) > 0)
            {
                result[iMerged] = first[iFirst];
                iFirst++;
            }
            else
            {
                result[iMerged] = second[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
        System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static String bubbleSort(Comparable[] list)
    {
        int n = list.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (list[j].compareTo(list[j+1]) < 0 )
                {
                    // cambia arr[j+1] con arr[j]
                    Comparable temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
        return ("Los datos ordenados son ");
    }


    static int getMax(Numeros[] list, int n)
    {
        int mx = list[0].getlastNum();
        for (int i = 1; i < n; i++)
            if (list[i].getlastNum() > mx)
                mx = list[i].getlastNum();
        return mx;
    }


    static void countSort(Numeros[] list, int n, int exp)
    {
        Numeros output[] = new Numeros[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(list[i].getlastNum() / exp) % 10]++;


        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[( list[i].getlastNum() / exp) % 10] - 1] = list[i];
            count[(list[i].getlastNum() / exp) % 10]--;
        }


        for (i = 0; i < n; i++)
            list[i] = output[i];
    }


    static String radixSort(Numeros[] list, int n)
    {
        int m = getMax(list, n);

        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(list, n, exp);
        return ("Los datos ordenados son ");
    }


    private static int partition(Comparable[] list, int low, int high)
    {
        Comparable pivot = list[high];
        int i = (low-1);
        for (int j=low; j<high; j++)
        {

            if (list[j].compareTo(pivot) > 0)
            {
                i++;
                Comparable temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        Comparable temp = list[i+1];
        list[i+1] = list[high];
        list[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static String quickSort(Comparable[] list, int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(list, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(list, low, pi-1);
            quickSort(list, pi+1, high);
        }

        return ("Los datos ordenados son ");
    }


}