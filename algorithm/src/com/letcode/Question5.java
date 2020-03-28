package com.letcode;

import java.util.Arrays;

/**
 * 网上看到的方法，好像是不可以
 *     void ReverseString(char[] s,int from,int to)
 *     {
 *         while (from < to)
 *         {
 *             char t = s[from];
 *             s[from++] = s[to];
 *             s[to--] = t;
 *         }
 *     }
 *
 *     void LeftRotateString(char[] s,int n,int m)
 *     {
 *         m %= n;               //若要左移动大于n位，那么和%n 是等价的
 *         ReverseString(s, 0, m - 1); //反转[0..m - 1]，套用到上面举的例子中，就是X->X^T，即 abc->cba
 *         ReverseString(s, m, n - 1); //反转[m..n - 1]，例如Y->Y^T，即 def->fed
 *         ReverseString(s, 0, n - 1); //反转[0..n - 1]，即如整个反转，(X^TY^T)^T=YX，即 cbafed->defabc。
 *     }
 *
 *   但是可以直接点使用上面的方法进行，这个也就是和for循环一样，好像没有什么特殊的
 */
public class Question5 {
    void ReverseString(char[] s,int from,int to)
    {
        while (from < to)
        {
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }
    }

    void LeftRotateString(char[] s,int n,int m)
    {
        m %= n;               //若要左移动大于n位，那么和%n 是等价的
        ReverseString(s, 0, m - 1); //反转[0..m - 1]，套用到上面举的例子中，就是X->X^T，即 abc->cba
        ReverseString(s, m, n - 1); //反转[m..n - 1]，例如Y->Y^T，即 def->fed
        ReverseString(s, 0, n - 1); //反转[0..n - 1]，即如整个反转，(X^TY^T)^T=YX，即 cbafed->defabc。
    }

    public static void main(String[] args) {
        Question5 d = new Question5();
        char arr[] = {'a','b','c','d','e','f'};
//        d.LeftRotateString(arr,1,arr.length);
        d.ReverseString(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
