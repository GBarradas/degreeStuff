#include<stdio.h>
#include<stdlib.h>
#include<wchar.h>
#include <string.h>
#include <stdbool.h>
#include <limits.h>
#include <wctype.h>
#include"fatal.h"
typedef struct list *Node;



struct list{
  char word[100];
  unsigned long int key;
  Node next;
};

unsigned long int combi (char word[100]){
    int key;
    unsigned long int result=0;
    for (int i =0;word[i]!='\0'; i++)
    {
        result=result*10;
        key=word[i];
        char c;
        
        if(key!=-119||key!=45||key!=39||key!=-118||key!=-115||key!=-107||key!=-108||key!=-109||key!=-102||key!=-127||key!=-128||key!=-126||key!=-125||key!=-121)
            c=towlower(word[i]);
        key=c;
        if(key==97||key==98||key==99)
            result+=2;
        if(key==100||key==101||key==102)
            result+=3;
        if(key==103||key==104||key==105)
            result+=4;
        if(key==106||key==107||key==108)
            result+=5;
        if(key==109||key==110||key==111)
            result=result+6;
        if(key==112||key==113||key==114||key==115)
            {result=result+7;}
        if(key==116||key==117||key==118)
            {result+=8;}
        if(key==119||key==120||key==121||key==122)
            result+=9;

        if(key==-95||key==-96||key==-94||key==-93||key==-89||key==-127||key==-128||key==-126||key==-125||key==-121){
            result=result/10;
            result+=2;
        }
        if(key==-87||key==-86||key==-119||key==-118){
            result=result/10;
            result+=3;
        }
        if(key==-83||key==-115){
            result=result/10;
            result+=4;
        }
        
        if(key==-75||key==-76||key==-77||key==-109||key==-108||key==-107){
            result=result/10;
            result+=6;
        }
        if(key==-70||key==-102){
            result=result/10;
            result+=8;
        }
    }
    
    return result;
}
	void printnode(Node head)
{
    if(head==NULL)
    {
        printf("Linked List is empty");
    }
    Node ptr = NULL;
    ptr=head->next;
    while(ptr != NULL)
    {
        printf("--%d\t-->  ",ptr->key);
        ptr=ptr->next;
    }
    printf("\n");
}

Node ReadDicionary ( Node Dicionary){
  char name[100];
  unsigned long int key;
  printf("Dictionary Name:");
    gets(name);
    FILE *fp=fopen(name,"r+");
    printf("cona da mae");
    if(fp==NULL){
        printf("Problems opning the file !!\n");
        ReadDicionary(Dicionary);
    }
    while(!feof(fp)){
      Node New=malloc(sizeof(Node));
      New->next=NULL;
      fscanf(fp,"%s",&New->word);
      key=combi(New->word);
      New->key=key;
      New->next=Dicionary;
      Dicionary=New;
      printf("-->%d-->%s\n",New->key,New->word);
    }
    fclose(fp);
}



int main(){
  wchar_t word[100];
  int i=0;
  wscanf("%ls",&word);
  while(word[i]!='\0'){
      wprintf("%lc\n",word[i]);
      i++;
  }
}