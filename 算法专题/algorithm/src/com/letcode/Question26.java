package com.letcode;

/**
 *     public int peakIndexInMountainArray(int[] A) {
 * 		for(int i=1;i<A.length-1;i++){
 * 			if(A[i-1]<A[i]){
 *                 if(A[i]>A[i+1]){
 *                     return i;
 *
 *                 }
 *
 *                        }* 		}
 *     return A.length-1;
 * 	}
 */
public class Question26 {
    public int peakIndexInMountainArray(int[] A) {

        for(int i=1;i<A.length-1;i++){
            if(A[i-1]<A[i]){
                if(A[i]>A[i+1]){
                    return i;

                }

            }
        }
        return A.length-1;

    }
}
