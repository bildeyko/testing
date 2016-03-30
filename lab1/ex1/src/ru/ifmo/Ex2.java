package ru.ifmo;

import java.util.Arrays;

/**
 * Created by bilde_000 on 30.03.2016.
 */
public class Ex2 {

    public int[] sort(int[] arr, StringBuilder tst){
        if(arr.length < 2) {
            tst.append("s2"); // FOR TESTING
            return arr;
        }
        tst.append("s1"); // FOR TESTING
        int m = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, m);
        int[] arr2 = Arrays.copyOfRange(arr, m, arr.length);
        return merge(sort(arr1,tst), sort(arr2,tst), tst);
    }

    public int[] merge(int[] arr1,int arr2[], StringBuilder tst){
        int n = arr1.length + arr2.length;
        int[] arr = new int[n];
        int i1=0;
        int i2=0;
        tst.append("m1"); // FOR TESTING
        for(int i=0;i<n;i++){
            if(i1 == arr1.length){
                tst.append("f1"); // FOR TESTING
                arr[i] = arr2[i2++];
            }else if(i2 == arr2.length){
                tst.append("f2"); // FOR TESTING
                arr[i] = arr1[i1++];
            }else{
                if(arr1[i1] < arr2[i2]){
                    tst.append("f3"); // FOR TESTING
                    arr[i] = arr1[i1++];
                }else{
                    tst.append("f4"); // FOR TESTING
                    arr[i] = arr2[i2++];
                }
            }
        }
        return arr;
    }
}
