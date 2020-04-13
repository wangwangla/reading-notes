# 最长回文

## 方法一：
    找到一个值，然后向两边扩展
    int count = 0;
    for(int i =  0;i < s.length ;i++){
        char ch = schaAt(i);
        //分情况，如果 abba的形式
        for(int j = i-1,k = i+1;j>0,k<s.length;j--,k++){
            if(s.charAt(j) == s.charAt(k)){
                count ++ ;
            }
        }
    }
    int count1=0
    for(int i =  0;i < s.length ;i++){
        char ch = schaAt(i);
        //分情况，如果 abba的形式
        for(int j = i,k = i+1;j>0,k<s.length;j--,k++){
            if(s.charAt(j) == s.charAt(k)){
                count1 ++ ;
            }
        }
    }

    Math.max(counnt,count1);
    