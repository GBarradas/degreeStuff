int init_board(int board[8][8]){
    for(int i =0;i<8;i++){
        for(int j;j<8;j++){
            board[i][j]=0;
        }
    }
    board[3][3]=10;
    board[3][4]=11;
    board[4][3]=11;
    board[4][4]=10;
    return board;
}
void print_board(int board[8][8]){
    printf("\n");           
    int numero= 0;
    char letra='A';
    printf("   ");   
    for (int coluna = 0; coluna < 8; coluna++)          
    {
        printf("%c ",letra);                
        letra++;
    }
    printf("\n");

    for (int linha = 00; linha < 8; linha++)
    {
        
            printf("%d  ",linha+1);  
       for (int coluna = 0; coluna < 8; coluna++)       
       {
           
           if (board[linha][coluna]==10) printf("o ");
           else if(board[linha][coluna]==11) printf("x ")        ;
           else printf(". ");
            
        }
        printf("\n");
    }
}
void play(int board[8][8],int line, int col,int color){
    
}
void main(){
    int board[8][8];
    init_board(board);
    print_board(board);

}