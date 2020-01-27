package com.jianxiansiqi;

/**
 * 题目：
 *  Given	a	sorted	array,	remove	the	duplicates	in	place	such	that	each	element	appear	only	once	and	return the	new	length.
 *  Do	not	allocate	extra	space	for	another	array,	you	must	do	this	in	place	with	constant	memory.
 *  For	example,	Given	input	array		A	=	[1,1,2]	,
 *  Your	function	should	return	length	=	2,	and		A		is	now		[1,2]	.
 *
 * 分析：
 *  一个排序的数组，删除数据，返回不重复数据的个数
 *
 *
 */
public class Demo01 {
    public static void main(String[] args) {

    }

    /**
     * 实现方法：
     *  第一个和第二个比较，不相等，就将第二个加入到数组中
     *
     */
    public int test(int nums[]){
        if (nums.length == 0){
            return 0;
        }
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=nums[index-1]) {
                nums[index++] = nums[i];
            }
        }
        //可以直接返回长度
        //return  nums.length;
        return index;
    }
    //上面是答案，我的解法如下：
    public int test1(int nums[]){
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=nums[index-1]) {
                index ++ ;
            }
        }
        return index;
    }

    /**
     * Follow	up	for	"Remove	Duplicates":
     * What	if	duplicates	are	allowed	at	most	twice?
     * For	example,	given	sorted	array		A	=	[1,1,1,2,2,3]	,
     * your	function	should	return	length	=		5	,	and	A	is now
     * [1,1,2,2,3]
     *
     */
    public int test3(int nums[]){
        int index = 2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=nums[index-2]) {
                index ++ ;
            }
        }
        return index;
    }

}
