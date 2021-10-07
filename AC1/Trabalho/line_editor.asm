.globl main
.data
FILE: .space 32		#Nome do ficheiro
Com:.space 32		#localm para onde vai ser lida a instrução
SPACE: .space 2048	#local auxilir para função insertmidle

.text
#-----------------------------------------------------------------------------------
count:					# Conta o número de carácteres numa linha
	addi sp,sp,-12			# Adicionamos espaço á pilha e guardamos
	sw ra,0(sp)			# os valores nos registo abaixo. 
	sw t0,4(sp)		
	sw t1,8(sp)		
	li t0, 0		
	
Sum:	lbu t1,0(a0)			# Carregamos o byte para t1
	beq t1,zero,R			# Quando o fim da linha for 0 salta
	addi t0,t0,1			# Contador
	addi a0,a0,1			# Anda para o próximo caractere
	jal Sum
	
R:	mv a0,t0			# Coloca em a0 o valor total de caracteres
	lw ra,0(sp)			# Vai buscar o valor guardado e fecha o espaço
	lw t0,4(sp)			
	lw t1,8(sp)
	addi sp,sp,12
	ret	
	
#-----------------------------------------------------------------------------------
countall:				# Conta todos os caracteres inseridos.
	lui t0,0x10040			# Chama-se a posição inicial do texto.
	li a2,0
SumA:		
	lb t1,0(t0)			# Carrega os dois primeiros bytes um para t0 e outro para t1
	lb t2,1(t0)
	addi t0,t0,1			# Anda para o próximo caractere
	addi a2,a2,1			# Contador
	bne t1,zero,SumA		# Enquanto for diferente de zero continua a andar de caractere
	bne t1,t2,SumA			# Quando os dois forem 0 (chegmos ao fim do texto) dá ret
	ret
#-----------------------------------------------------------------------------------
countline:				# Conta o número de linhas
	addi sp,sp,-4
	sw ra,0(sp)
	
	lui t0,0x10040
	li t1,'\n'
	li t4,0
	
CL:	lb t2,0(t0)			# Carrega os dois primeiros bytes um para t2 e outro para t3
	lb t3,1(t0)			
	addi t0,t0,1			# Anda para o próximo caractere
	bne t2,t1,NE			#quando t2 for \n salta
	addi t4,t4,1			# Contador
	jal CL				
	 
NE:	bne t2,zero,CL			#quando t2 for 0 volta para cima
	bne t2,t3,CL			# enquanto não forem iguais volta para cima
	
	lw ra,0(sp)			
	mv a3,t4			# coloca em a3 o número de linhas
	addi sp,sp,4
	ret

#-----------------------------------------------------------------------------------
file_name:				# retira da instrução o nome do file e coloca na label File
    addi sp,sp,-12
    sw a1,0(sp)
    sw a0,4(sp)
    sw ra,8(sp)
    la a0,Com				# coloca em a0 o endereço da instrução
    addi a0,a0,2			# coloca a0 no ínicio do nome do file
    la a1,FILE				# coloca a1 na posição inicial do file
    j FCP
FC:					# anda um caractere para frente
    addi a0,a0,1
    addi a1,a1,1
FCP: 					
    lb t2,0(a0)				# carrega o byte da instrução
    sb t2,0(a1)				# guarda o byte na label FILE
    li t1,'\n'
    bne t2,t1,FC			# caso o byte em questão não seja o último
    addi a0,a0,1			# anda para a frente 1x
    addi a1,a1,1			# anda para a frente 1x
    lb t2,0(a0)				
    sb t2,0(a1)

    lw a1,0(sp)
    lw a0,4(sp)
    lw ra,8(sp)
    addi sp,sp,12
    ret

#-----------------------------------------------------------------------------------
inicializelist:				# cria o espaço na heap
	li a7,9
	li a0,1024
	ecall
	add a1,zero,a0			# guarda em a1 o valoe de a0
	add a0,zero,zero		# coloca a0 a 0
	ret
#-----------------------------------------------------------------------------------
quitQ:					# termina o programa e sai
	li a7,10
	ecall
#-----------------------------------------------------------------------------------
quit:					# termina e sai caso o ficheiro esteja guardado
	beq a2,zero,NS			# NS será a label para um novo jal caso o ficheiro não esteja guardado (a0=a0)
	jal quitQ
NS:	jal DR				# DR será a label para printar "?"
	
#-----------------------------------------------------------------------------------
insert_end:				# insere no fim do texto
	addi sp,sp,-4
	sw ra,0(sp)

	li a7, 8			# dá a instrução para para ler uma string da consola
	mv a0,a1			# coloca a nova posição a inserir no fim do texto
	ecall
	lb t2,0(a0)
	jal count			# contar o número de caracteres da linha lida
	addi a3,a3,1			# adiciona 1 ao número de linhas
	add a1,a1,a0 			# adiciona o número de caracteres inseridos a a1
	addi a1,a1,1			# adiciona 1 por causo do \0
	li t0,'.'
	bne t2,t0,insert_end		# enquanto o caractere inserido nao for "." continua a inserir
	addi a1,a1,-3			# remove o ponto final
	addi a3,a3,-1			# remove a linha do ponto final
	sb zero,0(a1)
	sb zero,2(a1)
	sb zero,3(a1)
	lw ra,0(sp)
	addi sp,sp,4
	ret
#----------------------------------------------------------------------------------

insertmidle:				# insere no meio
	addi sp,sp,-12			
	sw ra,0(sp)
	sw a1,4(sp)
	li t5,0
	#posição=a4
	
	addi a4,a4,-1
	lui a1,0x10040
M:	lb t0,0(a1)			# vai andar até á linha desejada
	addi a1,a1,1	
	li t1,'\n'
	bne t0,t1,M
	addi a4,a4,-1
	bnez a4,M
	addi a1,a1,1
	la t0,SPACE			# coloca o texto num espaço para ler antes de colocar na heap
	addi a1,a1,-1
M2:	li a7,8				# instrução para ler uma string da consola
	mv a0,t0			# coloca em a0 o locar para onde ler
	ecall
	li t4,'.'
	lb t2,0(t0)
	jal count
	addi a0,a0,1
	addi a3,a3,1
	add t5,t5,a0			# conta o número total de caracteres lidos
	add t0,t0,a0			# acrescenta o espaço para escrever a seguir 
	bne t4,t2,M2			# enquanto o caractere inserido nao for um ponto continua a inserir
	addi a3,a3,-1		
	addi t5,t5,-3 
	lw t1,4(sp)
	sw t5,8(sp)
	
M3:	lb t2,0(t1)			# abre espaço entre linhas
	add t1,t1,t5
	sb t2,0(t1)
	sub t1,t1,t5
	addi t1,t1,-1
	bne a1,t1,M3
	la t0,SPACE
	addi a1,a1,1
M4:					# coloca as linhas lidas no espaço criado em M3
	lb t2,0(t0)
	sb t2,0(a1)
	addi a1,a1,1
	addi t0,t0,1
	addi t5,t5,-1
	bnez t5,M4
			
	lw a1,4(sp)
	lw t5,8(sp)
	add a1,a1,t5
	lw ra,0(sp)
	addi sp,sp,12
	ret
	
#-----------------------------------------------------------------------------------
delete_last:				# apaga a última linha
	mv a0,a1			# pega no final do texto e vai andando menos um
	addi a0,a0,-3			# até encontrar o barra \n
DL:	lb t2,0(a0)
	addi a0,a0,-1
	addi t3,t3,1			# contador
	li t1,'\n'
	bne t2,t1, DL			# quando encontrar \n elimina
	sub a1,a1,t3
	addi a1,a1,2
	addi a3,a3,-1
	ret
	
#-----------------------------------------------------------------------------------
delete_midle:				# apaga uma linha do meio do texto
	addi sp,sp,-8
	sw ra,0(sp)
	sw a4,4(sp)
	
	addi a4,a4,-1			# apaga a linha do ponto final
	li t4,0
	lui t0, 0x10040
DP:	beq a4,zero,DC			# quando chega á posição pretendida do texto salta
	lb t1, 0(t0)
	addi t0, t0, 1
	li t2, '\n'
	bne t2, t1, DP			# quando o caractere em questão for \n salta
	addi a4, a4, -1
	bnez a4, DP			# enquanto nao for a posição pretendida continua no ciclo
	
DC:	lb t3, 0(t0)			# conta desde a posição pretendida
	addi t4, t4, 1			# até ao final da linha a eliminar
	addi t0, t0, 1
	bne t3, t2, DC

DD:	lb t2, 0(t0)			# move para a esquerda o restante texto o número de posições em t4
	sub t0, t0, t4
	sb t2, 0(t0)
	add t0, t0, t4
	addi t0, t0, 1
	bne t0, a1, DD
	sub a1, a1, t4
	
	addi a3,a3,-1
	lw a4,4(sp)
	lw ra,0(sp)
	addi sp,sp,8
	ret
#-----------------------------------------------------------------------------------
print:					# printa a linha desejada
	addi sp,sp,-4
	sw a4,0(sp)
	
	lui a0, 0x10040
	addi a4,a4,-1
PR:	lb t0,0(a0)			# anda até ao inicio da linha a printar
	addi a0,a0,1
	li t1,'\n'
	bne t0,t1,PR
	addi a4,a4,-1
	bnez a4,PR
	
	li a7,4				# dá a instrução para printar na consola
	addi a0,a0,1			# printa a linha desejada
	ecall
	
	lw a4,0(sp)
	addi sp,sp,4
	ret
	
#-----------------------------------------------------------------------------------
printall:				# printa todo o texto
	addi sp,sp,-4
	sw ra,0(sp)
	lui a0,0x10040
	li t3,0
	j P1				# salta para a label que permite imprimira string
	
PA:	beq t3,a3,PEX
	lb t2,0(a0)
	li t1,'\n'
	addi a0,a0,1
	bne t1,t2,PA			# percorre todo o texto enquanto a posição em t2 não for igual a \n t1
	beq t3,a3,PEX			# salta para fechar a função quando t3 for igual ao número de linhas
	addi a0,a0,1
P1:	li a7,4				# printa a string e salta para percorrer até á próxima linha
	addi t3,t3,1			# que printa tudo até chegar ao \n e conta em t3
	ecall				# o número de linhas printadas
	jal PA
PEX:
	lw ra,0(sp)
	addi sp,sp,4
	ret	
	
#-----------------------------------------------------------------------------------
comando:				# comandos
	li t1,0				# analisa a instrução dada e determina qual a função a chamar
	li a7,8
	la a0,Com
	ecall
	jal count	
	mv t3,a0
	la a0,Com
	
Verify:					# compara o valor da instrução
	lb t2, 0(a0)			# para determinar qual a função
	addi a0,a0,1
	addi t1,t1,1
	li t0,'e'
	beq t0,t2,open_file
	li t0,'f'
	beq t0,t2,define_name
	li t0,'w'
	beq t0,t2,write_file
	li t0,'i'
	beq t0,t2,insert
	li t0,'a'
	beq t0,t2,append
	li t0,'c'
	beq t0,t2,change
	li t0,'d'
	beq t0,t2,delete
	li t0,'p'
	beq t0,t2,pPrint
	li t0,'q'
	beq t0,t2,quit
	li t0,'Q'
	beq t0,t2,quitQ
	bne t3,t1,Verify
	
DR:					# printa o ponto de interrogação
	li a7,11
	li a0,'?'
	ecall
	li a0,'\n'
	ecall
	jal comando
#.........................................................			
	# intrução e
open_file:				#abre e le o ficheiro
    la s4,FILE				
    lw s4,0(s4)				
    bne s4,zero,DR			


	addi sp,sp,-4	
	sw ra,0(sp)
	

	li a7,1024			#abreo o ficheiro lido em jutamente com a instrução
	li a1,0
	la a0,Com
	addi a0,a0,2
	ecall
	mv s5,a0
	
	li a7,63			#le o ficheiro 
	lui a1,0x10040			#para a heap
	li a2, 2028
	ecall
	
	addi t2,zero,-1			
	beq a0,t2,DR			#caso o ficheiro não tenha sido aberto printa "?"
	jal file_name			#obtem do comando o nome do ficheiro
					#colaca o nome do ficheiro na label FILE
	li a7,1				#printa o numero de caracteres lidos
	ecall
	
	li a7,11			#printa \n
	li a0,'\n'
	ecall
	
	li a7,57			#fecha o ficheiro
	mv a0,s5
	addi a0,a0,2
	ecall
	
	jal countline			#conta o numero de linha lidas e guarda em a3
	
	jal countall			#conta o numero total de caracteres lidos
	lui a1,0x10040			#coloca em a0 o registo onde começa o nosso texto
    	add a1,a1,a2			#adiciona a a0 o valor de caracteres  lidos
					#colocando a0 no final do texto
	addi a2,zero,1			#coloca o nosso a2 a 1(safe)
	
	lw ra,0(sp)
	addi sp,sp,4
	jal comando
#.........................................................
	#intrução w
write_file:
				#guarda o texto no ficheiro 
    la s4,FILE
    lw s4,0(s4)
    beq s4,zero,DR

	addi sp,sp,-8
	sw a1,4(sp)		
	sw ra,0(sp)
	
	li a7,1024		#abre o ficheiro
	li a1,1
    	la a0,Com
    	addi a0,a0,2
    	ecall
    	
	li a7,64		#escreve o ficheiro
	lui a1,0x10040
	jal countall		#vai por em a2 o numero de caracteres do texto que é o memo numero de caracteres a gravar
	ecall
	
	li a7,1			#printa o numero de caracteres gravados
    	mv a0,a2
	ecall
	
	li a7,11		#printa '\n'
	li a0,'\n'
	ecall
	
	li a7,57		#fecha o ficheiro
	la a0,FILE
	ecall
	
	addi a2,zero,1		#coloca em a0 1(safe)
	lw ra,0(sp)
    	lw a1,4(sp)
	addi sp,sp,8
	jal comando
#.........................................................
	#instrução f
define_name:			#cria um ficheiro em branco
    	la s4,FILE
    	lw s4,0(s4)
   	bne s4,zero,DR

	addi sp,sp,-8
	sw a1,4(sp)		
	sw ra,0(sp)
	
	jal file_name		#coloca na label FILE o nome do ficheiro
	
	li a7,1024		#cria o ficheiro com o nome desejado
	li a1,1
	la a0,FILE
	ecall

	li a7,4			#printa o nome do ficheiro
	la a0,FILE
	ecall
	
	li a7,57		#fecha o ficheiro
	la a0,FILE
	ecall
	

	add a2,zero,zero
	lw a1,4(sp)
	lw ra,0(sp)
	addi sp,sp,8
	jal comando
#.........................................................
	#intrução i
insert:				#insere linhas na posição desejada
	addi a2,zero,0		#coloca em a2 0 (not safe)
	la a0,Com		
	lb a0,0(a0)
	li t1,'i'		#caso o comando seja simplemente i vai ir para insert_end
	bne t1,a0,IN
	jal insert_end
	jal comando
	
IN:	li a0,'i'		#caso contrario vamos usar a fução atoi
	jal atoi		#retorna em a0 o valor da que vem junto com a instrução
	mv a4,a0
	bgt a4,a3,DR		#caso esse valor seja maior que o numero de linhas printa ?
	jal insertmidle
	jal comando	
#.........................................................	
append:	
	addi a2,zero,0		#coloca em a2 o valor de 0 (not safe)
	la a0,Com		
	lb a0,0(a0)		
	li t1,'a'		#caso o comando seja simplemente a vai ir para insert_end
	bne t1,a0,AN
	jal insert_end
	jal comando
	
AN:	li a0,'a'		#caso contrario vamos usar a fução atoi
	jal atoi		#retorna em a0 o valor da que vem junto com a instrução
	mv a4,a0
	addi a4,a4,1		#adicionamos 1 porque é a apende
	bgt a4,a3,DR		#caso o valor seja maior que o numero de linhas printa ?
	jal insertmidle
	jal comando	
#.........................................................	
change:	#change
	beq a3,zero,DR
	addi a2,zero,0		#coloca em a2 o valor de 0 (not safe)
	la a0,Com
	lb a0,0(a0)
	li t1,'c'		#caso o comando seja simplemente c
	bne t1,a0,CN
	jal delete_last		#vamos fazer uma delete_end
	jal insert_end		#seguida de uma insert_end
	jal comando
	
CN:	li a0,'c'		#caso contrario vamos usar a fução atoi
	jal atoi		#retorna em a0 o valor da que vem junto com a instrução
	mv a4,a0
	mv t6,a4
	bgt a4,a3,DR		#caso o valor seja maior que o numero de linhas printa ?
	jal delete_midle	#vamos fazer uma delete_midle
	mv a4,t6
	jal insertmidle		#seguida de uma insert midle
	jal comando
#.........................................................	
delete:	#delete			#função que elemina linhas
	li a0,'d'
	jal virgul		#função se verifiva se existe virgulas numa string
	bne a0,zero,DV		#caso haja virgula salta para a label DV
	addi a2,zero,0		#coloca em a2 o valor de 0 (not safe)
	la a0,Com
	lb a0,0(a0)
	li t1,'d'		#caso o comando seja simplemente d
	bne t1,a0,DN
	jal delete_last		#vamos fazer delete_end
	jal comando
	
DN:	li a0,'d'		#caso contrario vamos usar a fução atoi
	jal atoi		#retorna em a0 o valor da que vem junto com a instrução
	mv a4,a0
	bgt a4,a3,DR		#caso o valor seja maior que o numero de linhas printa ?
	jal delete_midle	#então vamos fazer uma delete_midle
	jal comando
DV:
				#caso haja virgulas viemos para aqui
	li a0,','
	jal atoi		#com a atoi vamos determinar qual o primeiro valor antes da virgula
	mv a5,a0		#e colocamos o em a5
	la a0,Com
D$:	
	lb t2,0(a0)
	addi a0,a0,1
	li t6,','		#andamos ate á posição da virgula
	bne t2,t6,D$	
	lb t2,0(a0)
	li t6,'$'		#caso o valor apos á virgula seja "$" 
	beq t2,t6,DLF		#salta para a label DLF
		
	li a0,'d'		#se não usamos uma adptação da atoi
	jal atoiav		# que retorna o numro asseguir á virgula 
	mv a4,a0
	blt a4,a5,DR		#caso o valor apos a virgula seja menor que o antes da virgual ele printa um ?
	bgt a4,a3,DR		#caso o valor apos a virgula seja maior que o numero de linhas printa um ?
	#addi a4,a4,-1
	addi a5,a5,-1		
	j DCL
DLF:	
    	mv a4,a3			#dizemos que é a4 é igual ao numero de linhas
	addi a5,a5,-1
DCL:	
    	jal delete_midle		#eleminamos a linha pretendida
	addi a4,a4,-1		# adicinamos -1 á linha
	bne a4,a5,DCL		# enquanto a4 for diferente de a5 voltamos a eleminar
	jal comando
	
#.........................................................	
pPrint:	#print			#função que printa linhas
	li a0,'p'
	jal virgul		#função que verifica se existem virgulas
	bne a0,zero,PL
	la a0,Com
	lb a0,0(a0)
	li t1,'p'
	bne t1,a0,PNL		#caso a função seja so p printa a ultima linha
	mv a4,a3
	jal print
	jal comando
	
	
	
PNL:	
    	la a0,Com
	lb a0,0(a0)
	li t1,'%'		#caso a intrução seja %p printa todo o texo
	bne t1,a0,PNA
	beq a3,zero,DR
	jal printall
	jal comando
		
	
PNA:	
    li a0,'p'
	jal atoi		#caso contrario vamos usar a fução atoi
	mv a4,a0		#retorna em a0 o valor da que vem junto com a instrução
	bgt a4,a3,DR		# caso essse valor seja maoir do que o numero de linhas printa ?
	jal print
	jal comando
PL:
	
	li a0,','		#caso exista virgualas usamos a função atoi 
	jal atoi		#para cacular o valor antes da virgula
	mv a4,a0
	la a0,Com
P$:	
	lb t2,0(a0)		#andamos com o nosso registo ate á posição da virgula
	addi a0,a0,1		
	li t6,','
	bne t2,t6,P$
	lb t2,0(a0)
	li t6,'$'		# caso a seguir da virgula se encontre um $
	beq t2,t6,PLF		# saltamos para a label PLF
		
	li a0,'p'		
	jal atoiav		#para calcular o valor apos a virgula vamos usar uma daptação da atoi
	mv a5,a0
	bgt a4,a5,DR		# caso o valor antes seja maior que o valor apos a virgula printa ?
	bgt a5,a3,DR		# caso o valor a seguir da virgula seja maior que o numero de linhas printa ?
	addi a5,a5,1
	j PCL		
PLF:	
    	mv a5,a3		#coloca em a5 o numero de linhas do nosso texto
	addi a5,a5,1
PCL:	    
    	jal print		#printa a linha em desejada
	addi a4,a4,1		#avança para a proxima linha
	bne a4,a5,PCL		#entanto a4 for difernte de a5 vai printar a proxima linha
	jal comando
	
#-----------------------------------------------------------------------------------
atoi:				#função que obtem numero de uma string
	addi sp,sp,-4
	sw ra,0(sp)
	mv t0,a0
	la a0,Com
	li t1,0
	
AT:	
    	lb t2,0(a0)	
	addi a0,a0,1
	beq t2,t0,EX		#caso o byte em analise corresponda ao byte que estava em a0 no inicio da função 
				#a função retorna onde estava
	
	li t4,48		
	add t5,zero,zero	
	beq t4,t2,ADD		#verifica se é 0
	li t4,49
	addi t5,zero,1	
	beq t4,t2,ADD		#verifica se é 1
	li t4,50
	addi t5,zero,2
	beq t4,t2,ADD		#verifica se é 2
	li t4,51
	addi t5,zero,3
	beq t4,t2,ADD		#verifica se é 3
	li t4,52
	addi t5,zero,4
	beq t4,t2,ADD		#verifica se é 4
	li t4,53
	addi t5,zero,5
	beq t4,t2,ADD		#verifica se é 5
	li t4,54
	addi t5,zero,6
	beq t4,t2,ADD		#verifica se é 6
	li t4,55
	addi t5,zero,7
	beq t4,t2,ADD		#verifica se é 7
	li t4,56
	addi t5,zero,8
	beq t4,t2,ADD		#verifica se é 8
	li t4,57
	addi t5,zero,9
	beq t4,t2,ADD		#verifica se é 9
	jal DR


	
	#------------
ADD:	
    	mv t2,t5
	mv t3,t1
	slli t1,t1,3		#multiplica por 8
	add t1,t1,t3		#adiciona o valor antes da multiplicação por 8
	add t1,t1,t3		#adiciona o valor antes da multiplicação por 8
	add t1,t1,t2		#no final obtemos a multiplicação por 10
	jal AT			#apos a multiplicação por 10 adicionamos o valor atual
	
EX:	
    	mv a0,t1		#retorna em a0 o valor obtido pela analise da string
	lw ra,0(sp)
	addi sp,sp,4
	ret
#-----------------------------------------------------------------------------------
atoiav:			#parecida á de cima mas com adaptações
	addi sp,sp,-4
	sw ra,0(sp)
	mv t0,a0
	la a0,Com
	li t1,0

DVR:			#anda ate á posição da virgula
    lb t2,0(a0)
	addi a0,a0,1
	li t6,','
	bne t2,t6,DVR
	
ADT2:	
    lb t2,0(a0)
	addi a0,a0,1
	beq t2,t0,EXv		#caso o byte em analise corresponda ao byte que estava em a0 no inicio da função 
				#a função retorna onde estava
	li t4,48
	add t5,zero,zero
	beq t4,t2,ADD2		#verifica se é 0
	li t4,49
	addi t5,zero,1
	beq t4,t2,ADD2		#verifica se é 1
	li t4,50
	addi t5,zero,2
	beq t4,t2,ADD2		#verifica se é 2
	li t4,51
	addi t5,zero,3
	beq t4,t2,ADD2		#verifica se é 3
	li t4,52
	addi t5,zero,4
	beq t4,t2,ADD2		#verifica se é 4
	li t4,53
	addi t5,zero,5
	beq t4,t2,ADD2		#verifica se é 5
	li t4,54
	addi t5,zero,6
	beq t4,t2,ADD2		#verifica se é 6
	li t4,55
	addi t5,zero,7
	beq t4,t2,ADD2		#verifica se é 7
	li t4,56
	addi t5,zero,8
	beq t4,t2,ADD2		#verifica se é 8
	li t4,57
	addi t5,zero,9
	beq t4,t2,ADD2		#verifica se é 9
	jal DR
	
ADD2:	
    	mv t2,t5
	mv t3,t1
	slli t1,t1,3		#multiplica por 8
	add t1,t1,t3		#adiciona o valor antes da multiplicação por 8
	add t1,t1,t3		#adiciona o valor antes da multiplicação por 8
	add t1,t1,t2		#no final obtemos a multiplicação por 10
	jal ADT2		#apos a multiplicação por 10 adicionamos o valor atual
			
EXv:	
    	mv a0,t1		#retorna em a0 o valor obtido pela analise da string
	lw ra,0(sp)
	addi sp,sp,4
	ret
#-----------------------------------------------------------------------------------
virgul:				#função que verfica se existem ","numa string
	addi sp,sp,-4
	sw ra,0(sp)
	mv t0,a0
	la a0,Com
	
VR:	    
    	lb t2,0(a0)		
	addi a0,a0,1
	li t1,','
	beq t2,t1,VE		#caso exista salta para a label VE
	beq t2,t0,VEX		#caso o caracter em analise seja igual ao passado em a0 no inicio da função ela retorna 
	jal VR
VEX:	
	add a0,zero,zero	#coloca em a0 0 logo não existe "," na função
	lw ra,0(sp)
	addi sp,sp,4
	ret
		
VE:	
	addi a0,zero,1		#coloca em a0 1 o que quer dizer que existe ","
	lw ra,0(sp)
	addi sp,sp,4
	ret
	
#-----------------------------------------------------------------------------------
main:
	
	jal inicializelist	#criar espaço
	jal comando		#começar a ler intruções e a ler texto
