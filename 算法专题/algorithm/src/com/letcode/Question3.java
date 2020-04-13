package com.letcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Question3 {
    /**
     * 这个的解题思路：
     *  1.将String转化为char[]
     *  2.将char插入到map中，如果有重复就从第一个字母开始删除，直到不包括这个按钮为止。
     *  3.然后和max比较
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<Character,Integer>();
        char [] c = s.toCharArray();
        int max = 0;
        int index = 0;
        for(int i=0;i<c.length;i++) {
            if(!m.containsKey(c[i])) {
                m.put(c[i], 1);
            }else {
                while(m.size()>0&&m.containsKey(c[i])) {
                    m.remove(c[index]);
                    index++;
                }
                m.put(c[i], 1);
            }
            if(m.size()>max) {
                max = m.size();
            }
        }
        return max;
    }

    /**
     * 思路：
     *  开始初始化长度为0
     *  - 先获取到字母
     *  - 如果包含了，那么就重新找到开始位置
     *  - 否则就计算值，然后将字符存入，
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

}
