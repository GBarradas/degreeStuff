#include <stdio.h>
#include <stdlib.h>

void main(int argc,char *argv[]){
    float usd = atof(argv[1]);
    printf("Em USD: %.4f\n", (usd/1.012));
}