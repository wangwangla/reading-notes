#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
void revseNum();
void revseNum1();
void swapTemp();
int main(int argc, char** argv) {
	//反转
	//revseNum1();
	//swapTemp
	swapTemp();
	return 0;
}

//三位数的反转
/**
输入一个三位数，将三位数反转

分析:将数据分离开，然后重新显示 
*/ 
void revseNum(){
	int n;
	scanf("%d",&n);
	printf("%d %d %d",n%10 ,n/10%10 ,n/100);
} 

void revseNum1(){
	int n;
	int temp;
	scanf("%d",&n);
	temp = n;
	while(n>0){
		if(temp == n){
			if(n %10!=0){
				printf("%d",n%10);
			}
		}else{
			printf("%d",n%10);
		}
		n = n / 10;
	}
}

/**
交换数字

输入两个数据，交换器位置。

分析和解析
- 使用第三个数据作为交换
- 二者相加，然后得到数据 
*/
void swapTemp(){
	int n,m;
	int temp; 
	scanf("%d  %d",&n,&m);
	printf("输出数据%d %d \n",n,m);
	temp = n;
	n = m;
	m = temp;
	printf("交换之后%d %d",n,m);
	m = m+n;
	n = m - n;
	m = m - n;
	printf("交换之后%d %d",n,m); 
} 


















