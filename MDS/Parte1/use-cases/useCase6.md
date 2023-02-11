* #### Nome: Aceitar Encomendas e Entregas  
* #### Ator principal: Estafeta
* #### Comportamento Normal
1. O Estafeta insere as credenciais de acesso;
2. O sistema processa as credenciais de acesso e autentica o Estafeta;
3. O sistema fornece ao Estafeta uma lista de encomendas disponíveis para entrega;
4. O Estafeta seleciona uma encomenda para entrega;
5. O Estafeta tem acesso às informações da entrega;
6. O Estafeta recolhe a encomenda (ou parte desta);
7. O Estafeta entrega a encomenda na morada do Cliente;
8. O Estafeta informa o sistema que a encomenda foi entregue;
9. O sistema muda o estado da encomenda para "entregue"

* #### Extensões:
- 2. A autenticação falhou:
	1. O sistema informa o Estafeta que a autenticação falhou;
	2. O sistema pede ao Estafeta volte a inserir as suas credenciais de acesso;
	3. Volta ao ponto 1 do _Comportamento Normal_ 
- A qualquer momento o Cliente pode cancelar a encomenda, terminando assim o Use Case