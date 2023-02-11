* #### Nome: Registar Estafetas/Restaurantes  
* #### Ator principal: Administrador
* #### Comportamento Normal:
1. O Administrador fornece ao sistema as suas credenciais de acesso;
2. O sistema processa as credenciais de acesso;
3. O administrador clica na opção "Novo Estafeta"/"Novo Restaurante";
4. O administrador fornece as informações necessárias ao sistema, sendo uma delas o email;
5. O sistema cria as credenciais de acesso para o Restaurante/Estafeta e envia as mesmas por email.
## Exeções  
- 2. Autenticação falhada:
	1. O sistema informa o Administrador que a autenticação falhou;
	2. O sistema pede ao Administrador que insira as suas credenciais de acesso novamente;
	3. Volta ao Passo 1 do _Comportamento Normal_  