* #### Nome: Despachar uma encomenda  
* #### Ator principal: Restaurante
* #### Ator secundário: Estafeta, Cliente
* #### Pré-condição:
1. É considerado que o Restaurante se encontra devidamente autenticado perante o sistema;
* #### Comportamento Normal
1. O sistema informa o Restaurante que tem uma nova encomenda;
2. O Restaurante visualiza a informação sobre a encomenda;
3. O Restaurante começa a preparar a encomenda;
4. O Restaurante é notificado que foi atribuído um Estafeta para a encomenda em questão;
5. O Estafeta chega para levantar a encomenda;
6. O Restaurante altera o estado da encomenda para "Levantada pelo Estafeta";

* #### Extensões:
- 2. Produto esgotado:
	1. O Restaurante informa o sistema que um artigo se encontra esgotado;
	2. O sistema informa o Cliente do ocorrido.
	3. O sistema pergunta ao Cliente se pretende cancelar a encomenda ou prosseguir com a encomenda, já sem o artigo em falta:
		-  Caso o Cliente pretenda cancelar a encomenda o Use Case termina;
		-  Caso o Cliente pretendas prosseguir com a encomenda o use Case continua no ponto 3 do _Comportamento Normal_ 
- A qualquer momento o Cliente pode cancelar a encomenda, terminado assim o Use Case