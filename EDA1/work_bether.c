#include<stdio.h>
#include<stdlib.h>
#include<wchar.h>
#include <string.h>
#include <stdbool.h>
#include <limits.h>
#include <wctype.h>
#include <time.h>
#include"funcions.h"
#include"fatal.h"
typedef unsigned int Index;
typedef struct ListNode *Position;
typedef struct HashTbl *HashTable;
typedef struct KeyBoard *Board;
typedef int ElementType;
#define MinTableSize (10)
struct ListNode{
    char *Element[100];
    Position    Next;
};
typedef Position List;

struct HashTbl{
    unsigned long int TableSize;
    List *TheLists;
};
static int NextPrime( int N ){
    return N+1;
}

HashTable InitializeTable( int TableSize ){
    HashTable H;
    int i;

    if(TableSize<MinTableSize)
    {
        Error("Table is to Small");
        return NULL;
    }


    /* Allocate table */
    H=malloc(sizeof(struct HashTbl));
    if(H==NULL)
        FatalError("Out of space!!");

    /* Allocate array of lists */
    H->TableSize = NextPrime( TableSize );
    H->TheLists = malloc( sizeof(List) * H->TableSize );
    if( H->TheLists == NULL )
        FatalError( "Out of space!!!" );


    /* Allocate list headers */
    for (int i = 0; i < H->TableSize; i++)
    {
        H->TheLists[i]=malloc(sizeof(struct ListNode));
        if(H->TheLists[i]==NULL)
            FatalError("Out Space!!");
        else
            H->TheLists[i]->Next=NULL;
    }
    

    return H;
}
void Insert( Position NewCell, HashTable H ){
    Position Pos;
    unsigned long int Key;
    Key=Hash(NewCell->Element,H->TableSize);
    List L;
    
    if(NewCell==NULL)
        FatalError("Out of Space");
    else{
        L=H->TheLists[Key];
        NewCell->Next=L->Next;
        //NewCell->Element=word;
        L->Next=NewCell;
    }
    

}
unsigned long int combi (char word[100]){
    int key;
    unsigned long int result=0;
    for (int i =0;word[i]!='\0'; i++)
    {
        result=result*10;
        key=word[i];
        wchar_t c;
        
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

int Hash(char word[100], unsigned long int TableSize){
    return combi(word)%TableSize;
}
Position Find(unsigned long int combin,HashTable H){
    Position P;
    List L;
    L=H->TheLists[combin%H->TableSize];
    P=L->Next;
    return P;
}


HashTable ReadDicionary(HashTable D){
    float time;
    char name[100];
    char word[100];
    int key=0;
    Position P=NULL;
    printf("Dictionary Name:");
    gets(name);
    clock_t ini=clock();
    D=InitializeTable(9000000);
    FILE *fp=fopen(name,"r");;
    if(fp==NULL){
        printf("Problems opning the file !!\n");
        ReadDicionary(D);
    }
    while(!feof(fp)){
        Position NewCell=malloc(sizeof(Position));
        List L;
        if(NewCell==NULL)
            FatalError("Out of space!!");
        else{
            fscanf(fp,"%s",&NewCell->Element);
            L=D->TheLists[Hash(NewCell->Element,D->TableSize)];
            NewCell->Next=L->Next;  
            L->Next=NewCell;
        }
        printf("->%s-->%d\n",NewCell->Element,combi(NewCell->Element));
        
    }
    clock_t fim=clock();
    time=(float)(fim-ini);
    printf("Executado em %.0fs\n",time/1000);
    return D;
}
void print_msg(List msg){
    List aux=msg->Next;
    printf("Mensagem: ");
    while(aux!=NULL){
        printf("%s ",aux->Element);
        aux=aux->Next;
    }
}
Position New_word(HashTable D){
    Position NewCell=malloc(sizeof(Position));

    printf("Não existem mais sugestões; introduza a palavra do teclado.\n");
    scanf("%s",&NewCell->Element);
    Insert(NewCell,D);
    return NewCell;
}
Position chose_word(Position P,HashTable D){
    char option;
    Position aux=NULL;
    printf("Sugestão: %s, aceita sugestão(s/n)?",P->Element);
    scanf("%c",&option);
    if(option=='s'){
        aux=P;
        aux->Next=NULL;
        return aux;
    }
    else if(option=='n'){
        if(P->Next==NULL){
            aux=New_word(D);
            return aux;
        }
        else
            chose_word(P->Next,D);
    }
    else{
        printf("&\n");
        chose_word(P,D);
    }


}
void write_mensagem(Position msg,HashTable Dicionary){
    unsigned long int comb=0;
    char opt[1];
    List aux=msg;
    Position P=NULL,ptr=NULL;

    
    scanf("%d",&comb);
    if(comb==1){
        print_msg(msg);
        printf("\n\n** Escreva a sua mensagem **\n");
        write_mensagem(msg,Dicionary);
    }
    if(comb==0){
        printf("pretende sair da aplicação (s/n)?");
        gets(&opt);
        if(opt[0]=='s')
            exit(EXIT_SUCCESS);
        else
            write_mensagem(msg,Dicionary);
    }
    else{
        P=Find(comb,Dicionary);
        if(P==NULL){
            ptr=New_word(Dicionary);
            while(aux->Next!=NULL)
                aux=aux->Next; 
            aux->Next=ptr;
            aux=ptr;
            aux->Next=NULL;
            write_mensagem(msg,Dicionary);
        }
        else{
            ptr=chose_word(P,Dicionary);
            ptr->Next=NULL;
            while(aux->Next!=NULL)
                aux=aux->Next; 
            aux->Next=ptr;
            write_mensagem(msg,Dicionary);
        }
    }
       
    
}
void main(){
    //system("clear");
    Position p;
    HashTable L=NULL;
    L=ReadDicionary(L);
    printf("** Escreva a sua mensagem **\n");
    List msg=malloc(sizeof(List));
    write_mensagem(msg,L);
} 