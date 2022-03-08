#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

void main(void){
pid_t x=fork();
pid_t y=fork();
printf ("%jd+%jd=%jd\n",(__intmax_t)x,(__intmax_t)y,(__intmax_t)x+y);
if ((x+y) == 0) {
    printf(" B \n");
    }else
    {
    printf(" A\n ");
    }
}
