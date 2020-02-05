#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

/**
已知鸡和兔的总数量为n，总腿数为m。输入n和m，依次输出鸡的数目和兔的数目。
如果无解，则输出No answer

分析：
	鸡和兔子 ，鸡头+兔头=头
	2*鸡脚 + 4*兔脚 
*/
void printNum();
int main(int argc, char** argv) {
	printNum();
	return 0;
}

void  printNum(){
	int m,n,a,b;
	scanf("%d %d",&m,&n);
	a = (4*n-m)/2;
  	b = n-a;  
	if(m % 2 == 1 || a < 0 || b < 0)
	    printf("No answer\n");  
	else    
		printf("%d %d\n", a, b);  
}
