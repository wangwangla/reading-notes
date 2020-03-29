package com.letcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * 通过次数125,048提交次数645,590
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question9 {
    /**
     * 这个方法可以不，可以，但是有什么问题，string转换为Inter总是出错，如果超过了他的范围
     * 可以使用Long呀，对，可以使用，但是使用long如果编译器不支持（如提交letcode）怎么办。、
     *
     * 对于这个，这样很愚蠢，还不如使用num*10+temp; 判断的使用使用num>Interger.MAX/10.
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        boolean flag = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c==' '){
//                continue;
//            }else if (c == '-'){
//                flag = true;
//            }else if(c>'9'&&c<'0'){
//                if(builder.length()==1&&flag){
//                    continue;
//                }
//            }
            if (builder.length()==0&&str.charAt(i)>='a'&&str.charAt(i)<='z'){
                break;
            }
            if (str.charAt(i)=='-'||str.charAt(i)>='0'&&str.charAt(i)<='9'){
                builder.append(str.charAt(i));
            }
        }
        if (builder.length()==0){
            return 0;
        }
        if(builder.length() == 1&& builder.charAt(0)=='-')return 0;
       // System.out.println(builder.toString());
        return 0;
    }

    /**
     * 目前 +2没过   +-2
     * @param str
     * @return
     */
    public static int myAtoi1(String str) {
        boolean flag = false;
        int num=0;
        for (int i = 0; i < str.length(); i++) {
            if (!flag&&str.charAt(i)>='a'&&str.charAt(i)<='z'&&num == 0){
                return 0;
            }
            if (str.charAt(i)=='-'){
                flag = true;
            }

            if (str.charAt(i)>='0'&&str.charAt(i)<='9'){
                if (flag){
                    if (-num<Integer.MIN_VALUE/10)
                        return -Integer.MIN_VALUE;
                }else {
                    if (num>Integer.MAX_VALUE/10)
                        return Integer.MAX_VALUE;
                }
                num = num*10+str.charAt(i)-'0';
            }
        }
        if (flag){
            num = -num;
        }
        return num;
    }
    public static void main(String[] args) {
        String str = "words and 987";
        str = "- words and 987";
        str = "- words and";
       // str = "words and 987";
      //  str = "419388837777474884 with words";
        str = "+-2";
        System.out.println(myAtoi1(str));
        System.out.println(Integer.MAX_VALUE);
    }
}
