#include <stdio.h>
#include <stdlib.h>

void main(int argc, char *argv[]){
    float tc = atof(argv[1]);
    float tk = tc + 273.15;
    float tf = (9*tc/5)+32;
    printf("Em Kelvin: %.2f\nEm Fahrenheit: %.2f F\n",tk,tf);
}