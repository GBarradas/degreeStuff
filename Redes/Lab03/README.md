# Aula Pratica 3   
##### *Redes de Computadores* | **Data:** 08/03/2021; **Hora**:13:30; **Duração**: 2h; **Sala**:CLAV_139; **Docente**: [Pedro Salgueiro](../#docentes)  
### [Pagina Principal](../)
 ---    

### [Solução Professor](sol.html)  

## [Resolução de Exercicios](https://www.moodle.uevora.pt/2122/mod/page/view.php?id=51550)

1. Considere um sistema de framing onde a flag de início de frame é 000111. 

    **a)** Proponha um sistema eficiente de bit-stuffing e aplique-o à seguinte mensagem:

    100100011000111100001100011001000011110010101  
    >Resposta:   
    Flag: 000111.  
    100100011<span class="red">0</span>00011<span class="red">0</span>11000011<span class="red">0</span>00011<span class="red">0</span>001000011<span class="red">0</span>110010101

    

    **b)** Proponha um novo sistema de bit-stuffing para a flag 110011. Aplique-o à mensagem anterior.  
    > Resposta:   
    Flag: 110011  
    100100011000111100001100011001<span class="red">0</span>00001111001<span class="red">0</span>0101  

2. Considere dois hosts de rede, A e B, ligados entre si por um canal de 300Kbps, com um tempo de propagação entre extremidades de 75ms. A envia pacotes com 10000 bits de comprimento para B.  
    > Tamanho do canal = 300 Kbps = 300\*10³ bps  

    

    **a)** Qual é o número máximo de pacotes por segundo que A consegue transmitir para B (assumindo que não é usado qualquer protocolo de transporte)?  
    >   Tempo de transmissão = 1\*10³ / 300\*10³ = 0.033s  
    1 / 0.033s = 30 pacotes/s  

    **b)** Qual é o número máximo de pacotes por segundo que A consegue transmitir para B usando o protocolo Stop&Wait?
    > 0.033 s + 0.075 s + 0.075 s =0.183 s  
    1/0.183 = 5 pacotes/s

    **c)** Qual é a taxa de utilização do canal, nas condições da alínea anterior?  
    > Usage Rate = Transmission Time / ( Transmission Time + RTT )  
    Usage Rate = 0.033 7(0.033/0.15) = 0.180 = 18%

    **d)** Mantendo as condições anteriores, que tamanho de janela aconselharia usar, para um protocolo Go-Back-N?  
    > 5

    **e)** Qual seria um timeout adequado para este último protocolo, usando a janela proposta?  
    > 5 \* 0.033 + 0.075 + 0.075 = 0.315 s  
    timeout = 0.315 + delta  > 0  
    =350 s


3. Considere dois hosts de rede, A e B, ligados entre si por um canal de 1Mbps, com um tempo de propagação entre extremidades de 50ms. A envia pacotes com 1000 bytes de comprimento para B.  
    > 1Mbps = 1 \* 10⁶ bps

    **a)** Qual é o número máximo de pacotes por segundo que A consegue transmitir para B (assumindo que não é usado qualquer protocolo de transporte)?   
    > 1 \* 10⁶ bps  
    8000 bits  
    8000 / 1000000 = 0.008 s  
    1/0.008 = 125 pacotes/s

    **b)** Qual é o número máximo de pacotes por segundo que A consegue transmitir para B usando o protocolo Selective Repeat com uma janela de tamanho 3?  
    > Ta = 0.008 \* 3s = 0.024  
    Tp  = 0.1 s  
    T= 0.124 s  
    1 / 0.124 = 8 janelas = 24 pacotes

    **c)** Qual é a taxa de utilização do canal, nas condições da alínea anterior?  
    > Tu = 24 / ( 24 + 100 ) = 20%

    **d)** Existe alguma vantagem em usar este protocolo, em detrimento de um Stop&Wait?  
    > 
 
    **e)** Será que o tamanho de janela proposto é o ideal?  
    > 15 \* 0.008 / ( 15 \* 0.008 +100 )= 55%  
    Logo não o tamanho não é ideal

    **f)** Qual seria um timeout adequado para este último protocolo, usando a janela proposta   
    > RTT = 0.1 | Tt = 0.008  
    0.1 +0.008 +delta = 0.108 + delta = 0.115s

  
``` 
Packet Transit Time = Transmission Time + Propagation Time
Transmission Time = Packet Size / Bandwidth
Propagation Time = Channel Length / Propagation Speed  ( ~ 200.000Km/s)
Usage Rate = Transmission Time / ( Transmission Time + RTT )
 ```   
---  

<div id="nav">
<span class="left" ><a href="../Lab02" >Aula Anterior</a></span>
<span> <a href="../../" >Pagina Principal</a></span>
<span class="right" ><a href="../Lab04" >Proxima Aula</a></span>
</div>  

---  

<style>
    .math {
    font-family: KaTeX_Math;
    font-style: italic;
}
.nav, #nav{
    position: inline-block;
    align-items: center;
    text-align: center;
    
}
.left{
    float: left;
}
.center{
    text-align=center;
}
.right{
    float: right;
}
.red{
    color: red;
}
.markdown-body blockquote {
    background:rgb(140 143 147 / 17%);
    padding: 0 1em;
    padding: 0 1em;
    color: #000000;
    border-left: 0.25em solid #007fff;
    }   
 </style>
