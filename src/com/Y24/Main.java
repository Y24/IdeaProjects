package com.Y24;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int length=0;

        if (sc.hasNext())length=sc.nextInt();
        int[] Input = new int[length];
        for (int i=0;i<length;i++)
            Input[i]=sc.nextInt();
        int[] storage=new int[length];
        int[] assist=new int[length];
        for (int i=0;i<length;i++)
            assist[i]=BuildUnlimitedAssist(Input,i+1);
        System.out.println("输入数组的最大非递增子序列长度为：　"+Build(Input,storage,assist));
    }

    private static int BuildUnlimitedAssist(final int[] input,int length) {
        if (length==0) return 0;
        else if (length==1) return 1;
        return Math.max(BuildUnlimitedAssist(input,length-1),1+BuildLimitedAssist(input,length-1,input[length-1]));

    }
    private static int BuildLimitedAssist(final int[] input,int length,int limit) {
        int[] storage=new int[length];
        int count=0;
        for (int i = 0; i < length; i++)
           if (input[i]>=limit)storage[count++]=input[i];
       return BuildUnlimitedAssist(storage,count);
    }
    private static int Build(final int[] input, int[] storage,int[] assit) {
        storage[0]=1;
        for (int i=1;i<input.length;i++)
            storage[i]=Math.max(storage[i-1],assit[i]);
        return storage[storage.length-1];
    }
}