# Aula Pratica 2  
##### *Redes de Computadores* | **Data:** 22/02/2021; **Hora**:14:00; **Duração**: 2h; **Sala**:CLAV_139; **Docente**: [Pedro Salgueiro](https://github.com/GBarradas/degreeStuff/tree/main/Redes#docentes)  
### [Pagina Principal](../README.md)
 ---    
## [Resolução de Exercicios](https://www.moodle.uevora.pt/2122/mod/page/view.php?id=48802)  

 1. Implemente um servidor TCP que imite o comportamento do "time.nist.gov" no porto 13, como vimos na aula passada. (nota: como 13 é um porto privilegiado, pode usar o porto 1300)

    O servidor deve:

    &emsp;&emsp;i. Aceitar ligações (sockets) no porto 1300;

    &emsp;&emsp;ii. Enviar a data e hora (numa string) ao cliente;

    &emsp;&emsp;iii. Fechar a ligação (`close()`).

1. Teste o seu servidor com "telnet localhost 1300" ou "nc localhost 1300".

2. Modifique o cliente da aula passada para se ligar a este novo servidor e teste os dois programas em conjunto.

3. (TPC) Modifique o servidor (TCP) para funcionar como "echo server", i.e., receba uma mensagem e envie exactamente a mesma mensagem ao cliente que a enviou (como um eco). Teste com 'telnet' ou 'nc'.
