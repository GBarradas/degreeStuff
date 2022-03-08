# Aula Pratica 3   
##### *Redes de Computadores* | **Data:** 08/03/2021; **Hora**:13:30; **Duração**: 2h; **Sala**:CLAV_139; **Docente**: [Pedro Salgueiro](../#docentes)  
### [Pagina Principal](../)
 ---    
## [Resolução de Exercicios](https://www.moodle.uevora.pt/2122/mod/page/view.php?id=51550)

1. Considere um sistema de framing onde a flag de início de frame é 000111. 

    a) Proponha um sistema eficiente de bit-stuffing e aplique-o à seguinte mensagem:

    100100011000111100001100011001000011110010101  
    >Resposta:   
    Flag: 000111.  
    100100011<span class="green">0</span>00011<span class="green">0</span>11000011<span class="green">0</span>00011<span class="green">0</span>001000011<span class="green">0</span>110010101

    

    b) Proponha um novo sistema de bit-stuffing para a flag 110011. Aplique-o à mensagem anterior.  
    > Resposta:   
    Flag: 110011  
    100100011000111100001100011001<span class="green">0</span>00001111001<span class="green">0</span>0101  

2. Considere dois hosts de rede, A e B, ligados entre si por um canal de 300Kbps, com um tempo de propagação entre extremidades de 75ms. A envia pacotes com 10000 bits de comprimento para B.  
    > Tamanho do canal = 300 Kbps = 300*10³ bps  

    

    a) Qual é o número máximo de pacotes por segundo que A consegue transmitir para B (assumindo que não é usado qualquer protocolo de transporte)?  
    >   Tempo de transmissão = 1*10³ / 300*10³ = 0.033s  
    1 / 0.033s = 30 pacotes/s  

    b) Qual é o número máximo de pacotes por segundo que A consegue transmitir para B usando o protocolo Stop&Wait?
    > 0.033 s + 0.075 s + 0.075 s =0.183 s  
    1/0.183 = 5 pacotes/s

    c) Qual é a taxa de utilização do canal, nas condições da alínea anterior?  
    > Usage Rate = Transmission Time / ( Transmission Time + RTT )

    d) Mantendo as condições anteriores, que tamanho de janela aconselharia usar, para um protocolo Go-Back-N?

    e) Qual seria um timeout adequado para este último protocolo, usando a janela proposta?


3. Considere dois hosts de rede, A e B, ligados entre si por um canal de 1Mbps, com um tempo de propagação entre extremidades de 50ms. A envia pacotes com 1000 bytes de comprimento para B.

    a) Qual é o número máximo de pacotes por segundo que A consegue transmitir para B (assumindo que não é usado qualquer protocolo de transporte)?

    b) Qual é o número máximo de pacotes por segundo que A consegue transmitir para B usando o protocolo Selective Repeat com uma janela de tamanho 3?

    c) Qual é a taxa de utilização do canal, nas condições da alínea anterior?

    d) Existe alguma vantagem em usar este protocolo, em detrimento de um Stop&Wait?
 
    e) Será que o tamanho de janela proposto é o ideal?

    f) Qual seria um timeout adequado para este último protocolo, usando a janela proposta   


``` 
Packet Transit Time = Transmission Time + Propagation Time
Transmission Time = Packet Size / Bandwidth
Propagation Time = Channel Length / Propagation Speed  ( ~ 200.000Km/s)
Usage Rate = Transmission Time / ( Transmission Time + RTT )
 ```  
 <style>
     .green{
         color: red;
     }
    .markdown-body blockquote {
        padding: 0 1em;
        color: #000000;
        border-left: 0.25em solid #007fff;
    }   
 </style>