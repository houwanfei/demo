package com.example.demo.algorithm;

/**
 * @author houwanfei
 * @create 2017-11-13 上午11:16
 */
public class AlgorithmBM {
    private static int[] suff;
    private static int[] bmgs;
    private static int[] bmbc;
    private static int ASIZE = 256;

    private static void countBadArray(String word){
        bmbc = new int[ASIZE];
        int len = word.length();
        char[] cWords = word.toCharArray();
        for (int i=0; i<ASIZE; i++){
            bmbc[i] = len;
        }

        for(int i=0; i<len-1; i++){
            bmbc[cWords[i]] = len - 1 - i;
        }
    }

    private static void countSuff(String word){
        int len = word.length();
        char[] cWords = word.toCharArray();
        suff = new int[len];

        suff[len-1] = len;
        for (int i = len-2; i>=0; i--){
            int q = i;
            while (q>=0 && cWords[q] == cWords[len-1-i+q]){
                q--;
            }
            suff[i] = i-q;
            //System.out.println(i);
        }
    }

    private static void countGoodStuffix(String word){
        int len = word.length();
        char[] cWords = word.toCharArray();
        bmgs = new int[len];

        for (int i = 0; i < len; i++){
            bmgs[i] = len;
        }
        int j = 0;
        for (int i = len-1; i >= 0; i--){
            if(suff[i] == i+1){
                for(; j<len-1-i; j++){
                    if(bmgs[j] == len){
                        bmgs[j] = len-1-i;
                    }
                }
            }
        }
        for (int i=0; i<=len-2; i++){
            bmgs[len-1-suff[i]] = len-1-i;
        }
    }

    public static void main(String[] args) {
        String str = "gcagagag";
        countSuff(str);
        countGoodStuffix(str);
        countBadArray(str);
        for (int i=0;i<str.length();i++){
            System.out.print(bmgs[i]+"\t");
        }

        System.out.println();
        for (int i=0;i<ASIZE;i++){
            System.out.print(bmbc[i]+"\t");
        }
    }
}
