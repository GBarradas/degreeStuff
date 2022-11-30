#include <stdio.h>
#include <stdlib.h>

void main(int argc,char *argv[]){
    int a = atoi(argv[1]),b = atoi(argv[2]);
    printf("Soma %d\n", a+b);
    printf("Diferenca %d\n",a-b);
    printf("Produto %d\n",a*b);
    printf("Divisao %d\n",a/b);
    printf("Resto divisao %d\n",a%b);
}