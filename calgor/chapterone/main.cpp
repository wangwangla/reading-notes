#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
void revseNum();
void revseNum1();
void swapTemp();
int main(int argc, char** argv) {
	//��ת
	//revseNum1();
	//swapTemp
	swapTemp();
	return 0;
}

//��λ���ķ�ת
/**
����һ����λ��������λ����ת

����:�����ݷ��뿪��Ȼ��������ʾ 
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
��������

�����������ݣ�������λ�á�

�����ͽ���
- ʹ�õ�����������Ϊ����
- ������ӣ�Ȼ��õ����� 
*/
void swapTemp(){
	int n,m;
	int temp; 
	scanf("%d  %d",&n,&m);
	printf("�������%d %d \n",n,m);
	temp = n;
	n = m;
	m = temp;
	printf("����֮��%d %d",n,m);
	m = m+n;
	n = m - n;
	m = m - n;
	printf("����֮��%d %d",n,m); 
} 


















