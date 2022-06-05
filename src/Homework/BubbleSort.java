package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
//        冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢"浮"到数列的顶端。
//        算法步骤：
//        a. 比较相邻的元素。如果第一个比第二个小，就交换他们两个。
//        b. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最小的数。
//        c. 针对所有的元素重复以上的步骤，除了最后一个。
//        d. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较
        //创建输入
        Scanner in = new Scanner(System.in);
        System.out.println("请输入：");
        String input = in.nextLine();
        //将输入转换为字符数组
        char[] inputChars = input.toCharArray();
        //冒泡排序
        for (int i = 0; i < inputChars.length - 1; i++) {
            for (int j = 0; j < inputChars.length - i - 1; j++) {
                if ((int) inputChars[j] < (int) inputChars[j + 1]) {
                    char temp = inputChars[j];
                    inputChars[j] = inputChars[j + 1];
                    inputChars[j + 1] = temp;
                }
            }
        }
        //------------------------问题1
        //System.out.println("有序字符串："+inputChars);
        System.out.print("有序字符串：");
        System.out.println(inputChars);
        //-----------------------
        //用于存储ASCII码的数组
        int[] ASCIIChars = new int[inputChars.length];
        for (int i = 0; i <= inputChars.length - 1; i++) {
            ASCIIChars[i] = (int) inputChars[i];
        }
        //Arrays.toString不需要循环遍历直接输出数组
        System.out.println("ASCII码："+Arrays.toString(ASCIIChars));
    }
}
