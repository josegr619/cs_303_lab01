package cs_303_lab01;

import java.util.Random;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Paths;
public class Lab_01 {
	public static String name = "Jose Garcia";
	public static String blazerID = "jegarcia";
	//#(1): LINEAR SEARCH
	public static int linearSearch(int[] arr, int x) {
		for(int i = 0; i < arr.length; i++) {
			if( arr[i] == x) {
				return i;
			}
		}
		return -1; // return index of x, -1 if not found
	}
	//#(2): BINARY SEARCH
	public static int binarySearch(int[] arr, int low, int high, int x) {
		// code binary search
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] == x) {
				return mid;
			}
			if(arr[mid] > x) {
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
			
		}
		return -1; // return index of x, -1 if not found
	}
	//#(3): TEST FUNCTIONS
	/*
	* @param arr - randomly generated array
	* @param keys - array of integers to search for in array
	*
	* @return - an array of indices of each key's location, -1 if not found
	*/
	public static int[] linear_search_1000(int[] arr, int[] keys) {
		int[] result = new int[keys.length];
		int index = 0;
		for(int key:keys) {
			result[index] = linearSearch(arr, key);
			index++;
		}
		return result; // return an array of indices of each key
	}
	public static int[] binary_search_1000(int[] arr, int[] keys) {
		Arrays.sort(arr);
		int[] result = new int[keys.length];
		for(int i = 0; i < keys.length; i++) {
			result[i] = binarySearch(arr, 0, arr.length - 1, keys[i]);
		}
		return result; // return an array of indices of each key
	}
	//############# DO NOT MODIFY CODE BELOW THIS LINE #############
	public static int[] gen_array(int n) {
		Random rand = new Random();
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}
	public static void main(String[] args) {
		System.out.println("Name: " + name);
		System.out.println("BlazerID: " + blazerID);
		System.out.println("------ Linear Search ------");
		int[] keys = gen_array(1000);
		for (int n=4; n<19; n++) {
			boolean is_true = true;
			int[] arr = gen_array((int)(Math.pow(2, n)));
			long start = System.nanoTime();
			int[] key_indices = linear_search_1000(arr, keys);
			long stop = System.nanoTime();
			for (int i=0; i<keys.length; i++) {
				int index = key_indices[i];
	if ((index != -1) && (keys[i] != arr[index])){
		is_true = false;
	}
			}
			System.out.println("ArraySize: 2**" + n + " || Correct: " +
					is_true +
					" || Time: " + (stop-start) + "ns");
		}
		System.out.println("------ Binary Search ------");
		for (int n=4; n<19; n++) {
			boolean is_true = true;
			int[] arr = gen_array((int)(Math.pow(2, n)));
			long start = System.nanoTime();
			int[] key_indices = binary_search_1000(arr, keys);
			long stop = System.nanoTime();
			for (int i=0; i<keys.length; i++) {
				int index = key_indices[i];
				if ((index != -1) && (keys[i] != arr[index])){
					is_true = false;
				}
			}
			System.out.println("ArraySize: 2**" + n + " || Correct: " + is_true + " || Time: " + (stop-start) + "ns");
		}
	}
}
