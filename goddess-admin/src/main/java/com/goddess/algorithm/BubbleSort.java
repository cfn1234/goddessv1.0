package com.goddess.algorithm;

import java.util.Arrays;

/**
 * <br>
 * 〈功能详细描述〉--冒泡排序
 * com.goddess.algorithm
 *
 * @author caofengnian
 * @Date 2019/5/21 0021 19:24
 */
public class BubbleSort {

	public static int[] sort(int[] sourceArray)  {
		// 对 arr 进行拷贝，不改变参数内容
		int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
		for (int i = 1; i < arr.length; i++) {
			// 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
			boolean flag = true;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];;
					arr[j + 1] = tmp;
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr =new int[]{1,7,4,6,10,2};
		int[] arsr =sort(arr);
		System.out.println();
	}
}
