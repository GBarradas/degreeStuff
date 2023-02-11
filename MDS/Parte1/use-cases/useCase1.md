## Use Case 1 - Fazer encomenda
* ##### Nome: Fazer encomenda
* ##### Ator principal: Cliente
* #### Comportamento normal:
	1. O Cliente pesquisa sobre os diferentes restaurantes, artigos e menus;
	2. O Cliente pode selecionar múltiplos artigos de vários restaurantes e definir as suas quantidades;
	3. O Cliente procede com a encomenda e clica na opção "Encomendar";
	4. O Cliente pode escrever uma pequena mensagem para os restaurantes;
	5. O Cliente confirma os artigos adicionados ao carrinho utilizando a opção Check-Out;
	6. O Cliente confirma os seus dados pessoais e clica na opção "Confirmar";
	7. O Sistema reencaminha o Cliente para a página da entrega;
	8. O Cliente seleciona o método de entrega (1 ou mais estafetas);
	9. O Cliente confirma a morada de entrega;
	10. O Cliente pode escrever uma mensagem para o estafeta;
	11. O Sistema reencaminha o Cliente para a página de pagamento;
	12. O Cliente seleciona a forma de pagamento;
	13. O Cliente fornece ao Sistema as informações necessárias de pagamento;
	14. O Sistema confirma as informações de pagamento;
	15. A encomenda é submetida pelo Sistema;
	16. O Sistema confirma a encomenda e indica um número para a encomenda

 * #### Extensões: 
	- 3.
		1. Caso o Cliente não esteja autenticado perante o Sistema:
			1. O Sistema reencaminha o cliente para a página de login;
			2. O Cliente insere as credenciais de acesso;
			3. O Sistema verifica a identidade do Cliente
			4. volta ao ponto 3

			- 1. Caso o Cliente não possua registo no sistema:
				1. O Cliente clica na opção "Registar";
				2. É pedido ao Cliente que forneça vários dados pessoais;
				3. Após fornecer todas as informações, o Cliente clica na opção "Efetuar Registo";
			- 3. Caso a autenticação falhe:
				1. O Cliente é notificado que autenticação falhou;
				2. Volta ao ponto 1.
	
	- 5.
		1. O Cliente pode remover artigos;
		2. O Cliente pode alterar a quantidade de artigos;
		3. O Cliente pode voltar ao ponto 1 e adicionar mais artigos e/ou menus;
		 
	 * 8.
		1. No caso dos artigos serem encomendados apenas num Restaurante, o Cliente passa ao passo seguinte sendo-lhe apenas atribuído um Estafeta para entrega	
	 * 6
		1. Caso o Cliente já possua os seus dados pessoais guardados no Sistema, estes campos já se encontrarão devidamente preenchidos, sendo possível:
			1. Confirmar os dados 
			2. Alterar os dados
	 * 9.
		 1. Se o Cliente já possuir uma morada de entrega, esta aparecerá como morada predefinida para entrega;
		 2. O Cliente pode alterar a morada de entrega se assim desejar:
			 1. Ou até adicioná-la à lista de moradas do cliente (possibilidade a implementar)
		 
	- 13.
		1. No caso do Cliente já possuir as suas informações de pagamento no Sistema:
			1. Confirma os dados para efetuar o pagamento;
			2. Ou utilizar dados diferentes para efetuar o pagamento, sendo necessário indicar novos dados para o efeito
	 * 14
		 Caso o pagamento não seja bem sucedido:
		 1. O Cliente é informado que ocorreu um erro ao efetuar o pagamento;
		 2. É pedido ao Cliente que volte a efetuar o pagamento;
		 3. Volta ao passo 11;
		 
	 * O Cliente pode cancelar a encomenda a qualquer momento, utilizando a opção "Cancelar"

