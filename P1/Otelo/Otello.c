#include<stdio.h>
#include <string.h>
#include <time.h>
#include <stdlib.h>
void init_board(char board[][8]); //inicializar o tabuleiro
void print_board(char board[][8]); //imprimir o tabuleiro no ecra
int flanked (char board[][8], int line, int col, char color ); //verificar se for jogado naquela posicao a jogada vira alguma peca, e retorna quantas vira
void play( char board[][8], int line, int col, char color );  //fazer a jogada
int fazer_jogada(char board[][8], char color); //verificar se uma jogada valida ao mesmo tempo que a faz
int count_flips_dir(char board[][8], int line, int col, int delta_line, int delta_col, char color);
void pc_joga(char board[][8],char color);
char cor();

int main(){
    char board[8][8];
    int jg=0;
    int jg1=0;
    int contap=0;
    int contaot=0;
    int num=0;
    int l=0;
    char ot;
    int c=0;
    char p=cor();
    if(p=='X'){
        ot='O';
    }
    else{
        ot='X';
    }

    printf("As suas pecas sao: %c", p);
    printf("\n");
    init_board(board);
    print_board(board);
    if(p=='O'){
        pc_joga(board,ot);
        jg++;
        print_board(board);
        while(jg<=60){
            fazer_jogada(board,p);
            while(fazer_jogada(board,p)==0){
                fazer_jogada(board,p);
            }
            jg++;
            pc_joga(board,ot);
            jg++;
            print_board(board);

        }

    }
    if(p=='X'){
        while(jg1<=60){
            fazer_jogada(board,p);
            jg1++;
            if(jg1%2==0){
                pc_joga(board,ot);
                jg1++;
                print_board(board);
            }
        }
    }
    if(jg==60 || jg1==60){
        printf("Nao existe mais jogadas possiveis");
        for(l=0;l<8;l++){
            for(c=0;c<8;c++){
                if(board[l][c]=='O'){
                    contap++;
                }
                if(board[l][c]=='K'){
                    contaot++;
                }
            }
        }
        if(contap>contaot){
            printf("Ganharam as pecas brancas: %d brancas %d pretas",contap,contaot);
            return 0;
        }
        if(contaot>contap){
            printf("Ganharam as pecas pretas: %d brancas %d pretas",contap,contaot);
            return 0;
        }
        else{
            printf("E empate");
            return 0;
        }
    }



}

void init_board(char board[8][8]){
    int line=0;
    int col=0;
    for (line = 0; line<8; line++) {
        for (col = 0;col<8; col++) {
            if ((line == 3 && col == 3) || (line == 4 && col == 4)) {
                board[line][col] = 'O';
            } else if ((line == 4 && col == 3) || (line == 3 && col == 4)) {
                board[line][col] = 'X';
            } else {
                board[line][col] = '.';
            }
        }
    }
}


void print_board(char board[8][8]){
    int line, col;
    printf("\n    A  B  C  D  E  F  G  H\n");
    for (line = 0; line<8; line++) {
        printf("%d ", line+1);
        for (col = 0; col<8; col++) {
            char x = board[line][col];
            printf("  %c", x);
        }
        printf("\n");
    }
}
void pc_joga(char board[8][8],char color){
    int row = 0;
    int col = 0;
    int best_row = 0;
    int best_col = 0;
    int i = 0;
    int j = 0;
    int new_score = 0;
    int score = 100;
    char board1[8][8];
    for(i=0;i<8;i++){
        for(j=0;j<8;j++){
            board1[i][j]=board[i][j];
        }
    }
    for(row=0;row<8;row++){
        for(col=0;col<8;col++){
            if(board1[row][col]=='.')
                continue;
            play(board1,row,col,color);

            for(i=0;i<8;i++){
                for(j=0;j<8;j++){
                    if(board1[i][j]==color)
                        new_score+=1;
                }
            }
            if(new_score<score){
                score=new_score;
                best_row=row;
                best_col=col;
            }
        }
    }
    play(board,best_row,best_col,color);

}


int flanked (char board[8][8], int line, int col, char color ){
    line+=1;
    int l=0;
    l=count_flips_dir(board,line,col,1,0,color);
    if(l>0){
        return l;
    }
    l=count_flips_dir(board,line,col,1,1,color);
    if(l>0){
        return l;
    }
    l=count_flips_dir(board,line,col,0,1,color);
    if(l>0){
        return l;
    }
    l=count_flips_dir(board,line,col,-1,0,color);
    if(l>0){
        return l;
    }
    l=count_flips_dir(board,line,col,-1,-1,color);
    if(l>0){
        return l;
    }
    return 0;
}


void play( char board[8][8], int line, int col, char color ){
    line+=1;
    int l;
    int col1;
    char op = (color == 'O')? 'X' : 'O';
    char letras[8]={'A','B','C','D','E','F','G','H'};
    for(l=0;l<8;l++){
        if(col==letras[l]){
            col1=l;
        }
    }
    int contarP;
    int rowd = 0;
    int cold = 0;
    int x = 0;
    int y = 0;
    int h=0;

    board[line][col] = color;
    for(rowd = -1; rowd <= 1; rowd++){
        for(cold = -1; cold <= 1; cold++)
        {
            //nao sair fora do tabuleiro ou do sitio onde se encontra
            if(line + rowd < 0 || line+ rowd >= 8 || line + cold < 0 || col + cold >= 8 || (rowd==0 && cold== 0))
                continue;

            if(board[line + rowd][col + cold] == op) //verificar o sitio onde se econtra
            {
                //se for encontrado uma peca contraria a que vai ser jogada vai se mover nessa direcao para trocar a cor
                x = line+ rowd;     //mover para o sitio onde se econtra a peca adversaria
                y = col + cold;

                for(;;)
                {
                    x += rowd;         //mover para o sitio a seguir dessa peca
                    y += cold;

                    //se estiver fora dos limites do tabuleiro para
                    if(x < 0 || x >=8 || y < 0 || y >= 8)
                        break;

                    // se tiver um sitio sem estar la nada para
                    if(board[x][y] == '.')
                        break;
                    //se econtrar uma jogada possivel, faz o caminho contrario trocando as pecas adversarias
                    if(board[x][y] == color)
                    {
                        //se for igual a peca adversaria
                        while(board[x-=rowd][y-=cold]==op)
                            board[x][y] = color;   //mudar a cor da peca
                        break;   //depois da jogada para
                    }
                }
            }
        }
    }
}
int fazer_jogada(char board[8][8], char color ){
    char col;
    int line;
    int c;
    printf("inserir uma jogada: ");
    scanf("%d%c",&line,&col);
    col=col-'A';
    c=(int)col;
    printf("%d-%d",line,c);
    //verificar se a jogada posta e valida(se o primeiro caracter e numero, se o segundo e uma letra, se nao foi inserido mais que 2 caracteres, e se nao esta a ser jogado por cima de outra peca)
    if(line>=1 && line<=8 && c>=1 && c<=8&& board[line][col]=='.'){
        if(flanked(board,line,col,color)>0){// se virar mais que uma peca, ou seja e uma jogada valida faz essa jogada
            play(board,line,col,color);
            print_board(board);
            return 1;
        }
    }
    else{
        printf("jogada invalida \n");
        return 0;
    }
}


int count_flips_dir(char board[8][8], int line, int col, int delta_line, int delta_col, char color){
    char ot;
    if(color=='O'){
        ot='X';
    }
    else if(color=='X'){
        ot='O';
    }
    int count=0;

    //movese ao longo do board na direcao indicada enquanto ouver pecas adversarias
    while(board[line+delta_line][col+delta_col]==ot){
        count++; //conta quantas pecas se econtram
        line=line+delta_line; //movese na direcao indicada
        col=col+delta_col;
        //quando econtrar uma peca da mesma cor depois de pecas adversarias
        if(board[line+delta_line][col+delta_col]==color){
            return count;	//devolve o numero de pecas que e possivel virar
        }
    }
    return 0;
}
char cor(){
    int num;
    char p;
    srand(time(NULL));            // Fazer a escolha de pecas aleatoria
    num=rand() %2;
    if(num==0){
        p= 'X';
    }
    else{
        p= 'O';
    }
    return p;

}