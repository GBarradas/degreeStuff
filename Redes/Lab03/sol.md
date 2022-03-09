# Lab 03
## Exercícios com resolução



1.  Considere um sistema de framing onde a flag de início de frame é `000111`. 
    
a. Proponha um sistema eficiente de bit-stuffing e aplique-o à
seguinte mensagem:

`100100011000111100001100011001000011110010101`

```
    O objectivo é não deixar que a /flag/ ocorra no meio da mensagem. Como
    a /placa/ só "sabe" os bits que já emitiu, temos de nos precaver
    contra o aparecimento de um *1* depois de aparecer *00011*. A proposta
    mais lógica será inserir um *0* sempre que apareça *00011* na
    mensagem.
    
    Mensagem com /stuffing/:
    100100011*0*00011*0*11000011*0*00011*0*001000011*0*110010101
```

b. Proponha um novo sistema de bit-stuffing para a flag
`110011`. Aplique-o à mensagem anterior.

```
    Da mesma forma que a anterior, basta incluir um *0* a cada *11001*.
    
    Mensagem com /stuffing/:
    100100011000111100001100011001*0*00001111001*0*0101
```

2.  Considere dois hosts de rede, A e B, ligados entre si por um canal de 300Kbps, com um tempo de propagação entre extremidades de 75ms. A envia pacotes com 10000 bits de comprimento para B.
    
a. Qual é o número máximo de pacotes por segundo que A consegue
transmitir para B (assumindo que não é usado qualquer protocolo de
transporte)?

```    
    Se o pacote tem 10000bits e conseguimos enviar 300*10³ por
    segundo, então:
    
    1*10^4/300*10^3 = 0,033s
    
    Então, num segundo conseguimos enviar 1/0,033 ~= 30 pacotes.
```

b. Qual é o número máximo de pacotes por segundo que A consegue
transmitir para B usando o protocolo Stop&Wait?

```
   Se tivermos de esperar pelo ACK, então vamos demorar 0,033 segundos a
    transmitir o pacote, mais 0,075s de propagação do pacote, mais 0,075s
    para o ACK chegar.

    0,033+0,075+0,075 = 0,183s

    Ou seja, a cada 0,183s só conseguimos enviar um pacote.
    
    Assim, num segundo:

    1/0,183 = 5,46 ~ 5 pacotes por segundo.
```

c. Qual é a taxa de utilização do canal, nas condições da alínea
anterior?

```
    0,033/(0,033+0,150) ~= 0,18 = 18%
```

d. Mantendo as condições anteriores, que tamanho de janela
aconselharia usar, para um protocolo Go-Back-N?

```
    Tanto pela alínea b) (5) como pela alínea c) (100/18~=5), a resposta
    será 5 pacotes, ou 50000bits.
```

e. Qual seria um timeout adequado para este último protocolo,
usando a janela proposta?

```
    Aqui é subjectivo, mas não pode ser menos do que o tempo de
    transmissão dos 5 pacotes mais o tempo de propagação*2. Também não
    deve ser muito maior, para não demorarmos tempo demais a recuperar de
    um erro:
    
    5*0,033+0,150=0,315 (tempo de chegarem os ACKs da janela)
    
    Timeout proposto: 0,315 + d (sendo d > 0 e não /demasiadamente/
    grande) - Usar bom-senso
    
    0,350 poderá ser um bom timeout.
    
    Se tivéssemos dados do PING, por exemplo, poderíamos usar o tempo
    médio do RTT do PING em vez do RTT teórico.
    
    (atenção que no Go-Back-N o timeout é para a janela, no Selective
    Repeat é para cada pacote.)
```

1.  Considere dois hosts de rede, A e B, ligados entre si por um canal de 1Mbps, com um tempo de propagação entre extremidades de 50ms. A envia pacotes com 1000 bytes de comprimento para B.
    
a. Qual é o número máximo de pacotes por segundo que A consegue
transmitir para B (assumindo que não é usado qualquer protocolo de
transporte)?

```
    1000Bytes=8000bits
    
    8000/1000000 = 0,008s (8ms por pacote)
    
    125 pacotes por segundo.
```

b. Qual é o número máximo de pacotes por segundo que A consegue
transmitir para B usando o protocolo Selective Repeat com uma
janela de tamanho 3?

```
    Se usarmos uma janela de 3, é como se estivéssemos em S&W com 3
    pacotes de cada vez:
    
    Tt(3) = 3*0,008 Tp(3) = 0,1s
    
    T(3) = 0,124
    
    1/0,124 ~ 8 (janelas) por segundo = 24 pacotes por segundo
```

c. Qual é a taxa de utilização do canal, nas condições da
alínea anterior?

```
    24ms/(24+100)ms ~ 20%
```

d. Existe alguma vantagem em usar este protocolo, em detrimento de
um Stop&Wait?

```
    Se fosse s&w tínhamos uma taxa de utilização menor...
    
    8ms/(8+100)ms = 7%
```

e. Será que o tamanho de janela proposto é o ideal?

```
    Se conseguimos mandar 8 janelas por segundo (e temos uma taxa de
    utilização de 20%), poderíamos pelo menos enviar 5x mais pacotes por
    segundo (15 pacotes na janela). Mas na realidade até dá bastante mais.
    
    15*8ms/(15*8+100) = 55%
```

f. Qual seria um timeout adequado para este último protocolo,
usando a janela proposta (na b))?

```
    RTT + 0,008 + delta = 0,108 + delta ~ 115ms parece bom.
```

--
Packet Transit Time = Transmission Time + Propagation Time

Transmission Time = Packet Size / Bandwidth

Propagation Time = Channel Length / Propagation Speed  ( ~≅ 200.000Km/s)

Usage Rate = Transmission Time / ( Transmission Time + RTT )

