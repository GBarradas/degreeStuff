#include<string.h>
#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<time.h>
typedef struct doubly *doubly;
struct doubly{
    char *linha[10000];
    bool save;          //toma o valor de true quando a função w é acionada
    int size;
    char *file[100];
    doubly *next;
    doubly *prev;
    
};
doubly iniciazedoubly(doubly text){ //inicializa a nossa lista
    text=malloc(sizeof(doubly));
    text->next=NULL;
    text->prev=NULL;
    return text;
}
void createspace(doubly text){      //cria espaço em branco para quando é pedido para inserir numa posição maior do que a do nosso texto
    doubly p=text;
    doubly space=malloc(sizeof(doubly));
    while(p->next!=NULL){
        p=p->next;
    }
    p->next=space;
    text->size++;
    space->prev=p;
    space->next=NULL;

    
}
void insert (int nulinha,doubly texto){     //função vai inserindo a partir da posição desejada ate '.'
    doubly Newi=malloc(sizeof(doubly));
    doubly pi=texto;
    char ponto='.';
    gets(&Newi->linha);
    if(Newi->linha[0]==ponto)
        comando(texto);
    for (int i = 0; i < nulinha; i++) //tambem  podia fazer nulinha--
    {
        pi=pi->next;
    }
    texto->size+=1;
    Newi->next=pi->next;
    Newi->prev=pi;
    pi->next=Newi;
    pi=pi->next;
    pi->prev=Newi;
    nulinha=nulinha+1;
    insert(nulinha,texto);
     
}
void insertone (int nulinha,doubly texto){      //função parcida á de cima mas so insere um no usada para o comando c e para a leitura de ficheiros
    doubly New=malloc(sizeof(doubly));
    doubly p=texto;
    char ponto='.';
    gets(&New->linha);
    for (int i = 0; i < nulinha; i++) //tambem  podia fazer nulinha--
    {
        p=p->next;
    }
    
    texto->size+=1;
    New->next=p->next;
    New->prev=p;
    p->next=New;
    p=p->next;
    p->prev=New;
    
     
}
void dellast(doubly texto)      //função para eleminar o ultimo da lista 
{
    doubly ptr,ptr2;
    ptr=texto;
    ptr2=texto;
    while(ptr->next!= NULL)
    {
        ptr2=ptr;
        ptr=ptr->next;
    }
    ptr2->next=NULL;
    free(ptr);
    ptr=NULL;
}
void delete( int nulinha, doubly text){     //função para eleminar um elemento em determinada posição
    doubly p=text;
    doubly temp;
    text->size--;
    for(int i=0;i<nulinha-1;i++){
            temp=p;
            p=p->next;
        }
    
    if(p->next!=NULL){
        
        text->size--;
        temp=p->next;
        p->next=temp->next;
        p=temp->next;
        p->prev=temp->prev;
        free(temp);
    }
}

void print(int linha, doubly texto){    //função mostra o conteudo de certa posição
    doubly ptr=texto;
    if(texto==NULL)
        printf("The List is empty");
    if(linha>texto->size)
        printf("print?\n");
    else{
        while(linha>0)
        {
            ptr=ptr->next;
            linha--;
        }
        printf("%s\n",ptr->linha);
    }
}
void printall(doubly texto){    //função mostra todo o conteudo da lista
    doubly p=texto;
    int i=0;
    while(p->next!=NULL){
        p=p->next;
        printf("%s\n",p->linha);
    }

}
     
bool exist(char comand[40],char key){   //função que verifica se existe um certo caracter numa string
    for (int i = 0; i < 40; i++)
    {
        if(comand[i]==key)
            return true;

    }
    return false;
}

void comando(doubly texto)  //função que analisa qual a função a executar
{
    doubly aux=texto;
    char comand[40]={0};
    char *com;
    char linha[10000];
    char *cat;
    int nchars=0;
    int nlinha=0,nlinha2=0, i=0;
    gets(comand);
          
    
            if(exist(comand,'i')){
                texto->save=false;  //quando fazemos i alteramos o ficheiro que tinhamos gravado 
                nlinha=atoi(comand);    //determina o numero agarrado á instrução
                if(nlinha>texto->size){
                    while(texto->size<nlinha){
                        createspace(texto);
                    }
                }
                if(nlinha==0)       // caso não tenha nenhum numero agarrado faz insert na posição atual
                    insert(texto->size,texto);
                else{               //caso contrario faz insert na posição desejada
                    insert(nlinha-1,texto);
                }
            }
        if(exist(comand,'a')){      
            texto->save=false;      //quando fazemos i alteramos o ficheiro que tinhamos gravado 
            nlinha=atoi(comand);    //determina o numero agarrado á instrução
            if(nlinha>texto->size){
                    while(texto->size<nlinha){
                        createspace(texto);
                    }
                }
                if(nlinha==0){      // caso não tenha nenhum numero agarrado faz insert na posição atual
                    createspace(texto);
                    insert(texto->size,texto);
                }
                    
                else{               //caso contrario faz insert na posição desejada
                    insert(nlinha,texto);
                }            
            
        }      
        if(exist(comand,'c')){
            texto->save=false;      //quando fazemos i alteramos o ficheiro que tinhamos gravado 
            nlinha=atoi(comand);        //determina o numero agarrado á instrução
            if(nlinha>texto->size){
                comando(texto);
            }
            if(nlinha==0){          // caso não tenha nenhum numero agarrado faz insert na posição atual
                nlinha=texto->size;
                delete(nlinha,texto);
                insertone(nlinha,texto);
                comando(texto);
            }
            else{               //caso contrario faz insert na posição desejada
                delete(nlinha,texto);
                insertone(nlinha-1,texto);
                comando(texto);
            }

        }
        if(exist(comand,'d')){
            texto->save=false;      //quando fazemos i alteramos o ficheiro que tinhamos gravado 
            nlinha=atoi(comand);    //determina o numero agarrado á instrução
            if(nlinha==0){          // caso não tenha nenhum numero agarrado faz insert na posição atual
                dellast(texto);
                comando(texto);
            }
            else{                   //caso contrario faz insert na posição desejada
                delete(nlinha,texto);       
                comando(texto);
            }
        }
        if(exist(comand,'p')){
            if(comand[0]=='%'&&comand[1]=='p'){     //caso a instrução seja '%p' mostra a lista toda
                printall(texto);
                comando(texto);
            }
            else{                           //caso contrario mostra o elemento em certa posição
                nlinha=atoi(comand);
                print(nlinha,texto);
                comando(texto);
            }
        }
         if(exist(comand,'e')){
            if(strlen(texto->file)!=0 && texto->next!=NULL) {   //verificar se ja não existe um ficheiro aberto
                printf("?\n");
                comando(texto);
            }
            printf("Docoment name:");   //Ler nome do ficheiro
            gets(texto->file);
            FILE *f=fopen(texto->file,"r");     //Abre o ficheiro para leitura
            nlinha=0;
            if(f==NULL)
            {
                printf("problemas ao abrir o arquivo.");
                comando(texto);
            }
            while(!feof(f)){                    // Vamos ler o ficheiro e colocalo na nossa lista
                
                doubly N=malloc(sizeof(doubly));
                doubly p=texto;
                char ponto='.';
                fscanf(f,"%s\n",&N->linha);
                for (int i = 0; i < nlinha; i++) //tambem  podia fazer nulinha--
                {
                    p=p->next;
                }
                
                texto->size+=1;
                N->next=p->next;
                N->prev=p;
                p->next=N;
                p=p->next;
                p->prev=N;
                nchars =nchars+strlen(N->linha)+1;
                nlinha=nlinha+1;
                printf("Inserido na pos:%s :::::%d\n",N->linha,nlinha);

            }
            printf("%d\n",nchars);
            comando(texto);
        }
            
        if(exist(comand,'f')){          //cria ou abre ficheiro mas não o le
            if(strlen(texto->file)!=0){
                printf("?\n");
                comando(texto);
            }
            printf("Docoment name:");
            gets(texto->file);
            FILE *f=fopen(texto->file,"w+");
            fclose(f);
            comando(texto);
        }   
        
        if(exist(comand,'w')){  //caso funciona-se a função vai guardar a nossa lista no ficheiro aberto ou criado em 'e' ou'f'
            int k=1;
            doubly write=texto;
            nlinha2=0;
            texto->save=true;       //como o ficheiro esta a ser gravado logo texto->save=true
            if(strlen(texto->file==0)){
                printf("?\n");
                comando(texto);
            }

            FILE *f=fopen(texto->file,"w");
            while(k<texto->size){
                
                fprintf("%s\n",write->linha);
                nlinha2=nlinha2+strlen(write->linha)+1;     //conta o numero de caracters
                write=write->next;
                k++;
            }
            fclose(f);
            printf("%d\n",nlinha2);
            
            comando(texto);
            

        }
        if(exist(comand,'q'))   //Função que sai do editor de linha se a nossa lista estiver gravada
            if(texto->save==true)
                exit(EXIT_SUCCESS);
            else{
                printf("?\n");
                comando(texto);
            }
        if(exist(comand,'Q')){  //função que sai do editor de linha mesmo que o ficheiro não esteja gravado
            exit(1);
        }
        else{
            printf("?\n");
            comando(texto);
        }
            
    
}

void main(){
    doubly texto=iniciazedoubly(texto);
    
    printf("\n\n\n\t            Importante!!!          \n\tÃ função (w) que serve para  escrever o texto \n\t     no ficheiro não esta a funcionar. \n\t  As outras funções estão a funcionar bem\n");
    
    comando(texto);
        
            
}