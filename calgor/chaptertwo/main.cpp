#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

/**
��֪�����õ�������Ϊn��������Ϊm������n��m���������������Ŀ���õ���Ŀ��
����޽⣬�����No answer

������
	�������� ����ͷ+��ͷ=ͷ
	2*���� + 4*�ý� 
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
