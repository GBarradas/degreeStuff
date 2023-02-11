* #### Nome: Avaliar encomenda
* #### Ator principal: Cliente
* #### Comportamento normal: 
1. Dá-se início ao Use Case a partir do momento em que o sistema confirma a receção da encomenda por parte do cliente;
2. O cliente é notificado de que pode avaliar o serviço do restaurante;
3. O sistema pergunta ao cliente a nota que pretende dar ao restaurante;
4. O cliente tem a possibilidade de responder utilizando uma escala de 0-10, onde 0 é muito mau e 10 é excelente;
5. O cliente submete a nota no sistema utilizando a opção "Submeter";
6. O sistema confirma a submissão da nota por parte do cliente;
7. O sistema pergunta ao cliente se pretende escrever um comentário sobre o restaurante;
8. O cliente escreve e submete o comentário no sistema utilizando a opção "Submeter";
9. O sistema confirma a submissão do comentário por parte do cliente;
10. O cliente é notificado de que pode avaliar o serviço do estafeta;
11. O sistema pergunta ao cliente a nota que pretende dar ao estafeta;
12.  O cliente tem a possibilidade de responder utilizando uma escala de 0-10, onde 0 é muito mau e 10 é excelente;
13. O cliente submete a nota no sistema utilizando a opção "Submeter";
14. O sistema confirma a submissão da nota por parte do cliente;
15. O sistema pergunta ao cliente se pretende escrever um comentário sobre o estafeta
16. O cliente escreve e submete o comentario no sistema utilizando a opção "Submeter";
17. O sistema confirma a submissão do comentário por parte do cliente;
18. O sistema coloca a avaliação na secção do restaurante avaliado;
19. O sistema coloca a avaliação na secção do estafeta avaliado;
20. O sistema sai da janela de avaliação

* #### Extensões:
2. 
	1. Se existir apenas um restaurante para avaliar e se o cliente se recusar a avaliar, então salta para o passo 10;
	2. Se existirem pelo menos dois restaurantes sujeitos a avaliação, o Use Case vai repetir os passos 2 a 9 para cada restaurante
9. 
	1. Se existir apenas um estafeta para avaliar e se o cliente se recusar a avaliar, então salta para o passo 20;
	2. Se existirem pelo menos dois estafetas sujeitos a avaliação, o Use Case vai repetir os passos 10 a 17 para cada estafeta.
* O cliente pode sair da avaliação a qualquer momento utilizando a opção "Cancelar"
