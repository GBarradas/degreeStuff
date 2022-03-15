# Aula Pratica 1  
##### *Redes de Computadores* | **Data:** 15/02/2021; **Hora**:14:00; **Duração**: 2h; **Sala**:CLAV_139; **Docente**: [Pedro Salgueiro](../#docentes)  
### [Pagina Principal](../)
 ---  
## [Resolução de Exercicios](https://www.moodle.uevora.pt/2122/mod/page/view.php?id=46205)
> #### [*\*Material_de_Apoio_1*](Redes%20Prática%2001.pdf)  

1. Qual é a latência da rede entre o seu computador e "www.uevora.pt"?  
   ``` bash 
    --- arachne.uevora.pt ping statistics ---
    9 packets transmitted, 9 received, 0% packet loss, time 8013ms
    rtt min/avg/max/mdev = 6.634/9.038/15.616/2.974 ms
    ```

2. Qual é a latência da rede entre o seu computador e "www.google.com"?
    ``` bash
    --- www.google.com ping statistics ---
    19 packets transmitted, 18 received, 5.26316% packet loss, time 18033ms
    rtt min/avg/max/mdev = 15.290/30.453/212.418/44.183 ms
    ```

3. Qual é a latência da rede entre o seu computador e "www.baidu.com"?  
    ``` bash
    --- www.wshifen.com ping statistics ---
    13 packets transmitted, 13 received, 0% packet loss, time 12015ms
    rtt min/avg/max/mdev = 193.302/249.745/370.576/46.323 ms
    ```

4. Será que o *host* 12.13.14.15 está "vivo" na rede? Justifique.   
    Não esta "vivo" pois ao executar o comando `$ ping 12.13.14.15` não obtemos resposta 

5. Que outros computadores estão no caminho entre o seu computador e:

    a. www.uevora.pt?  
    `$ traceroute www.uevora.pt`  
    ``` bash 
        traceroute to www.uevora.pt (193.136.216.21), 30 hops max, 60 byte packets
        1  _gateway (10.2.0.254)  4.210 ms  4.137 ms  4.277 ms
        2  router01-ac.bkb.uevora.pt (193.137.219.28)  6.301 ms  6.518 ms  6.723 ms
        3  arachne.uevora.pt (193.136.216.21)  4.849 ms  4.830 ms  4.938 ms
    ```

    b. www.google.com?  
    `traceroute www.google.com`
    ``` bash
     traceroute to www.google.com (142.250.184.4), 30 hops max, 60 byte packets
     1  _gateway (10.2.0.254)  1.623 ms  2.595 ms  3.905 ms
     2  router01-ac.bkb.uevora.pt (193.137.219.28)  5.728 ms  6.621 ms  7.770 ms
     3  * * *
     4  * * *
     5  * * *
     6  * * *
     7  * * *
     8  * * *
     9  * * *
     10  * * *
     11  * * *
     12  * * *
     13  * * *
     14  * * *
     15  * * *
     16  * * *
     17  * * *
     18  * * *
     19  * * *
     20  * * *
     21  * * *
     22  * * *
     23  * * *
     24  * * *
     25  * * *
     26  * * *
     27  * * *
     28  * * *
     29  * * *
     30  * * *
    ```

    c. www.baidu.com?  
    `traceroute www.baidu.com`
    ``` bash
        traceroute to www.baidu.com (104.193.88.123), 30 hops max, 60 byte packets
        1  _gateway (10.2.0.254)  4.263 ms  4.203 ms  4.378 ms
        2  router01-ac.bkb.uevora.pt (193.137.219.28)  1.928 ms  2.141 ms  2.353 ms
        3  * * *
        4  * * *
        5  * * *
        6  * * *
        7  * * *
        8  * * *
        9  * * *
        10  * * *
        11  * * *
        12  * * *
        13  * * *
        14  * * *
        15  * * *
        16  * * *
        17  * * *
        18  * * *
        19  * * *
        20  * * *
        21  * * *
        22  * * *
        23  * * *
        24  * * *
        25  * * *
        26  * * *
        27  * * *
        28  * * *
        29  * * *
        30  * * *
    ```  

6. Implemente um programa (em C) que replique o funcionamento de

    $ nc time.nist.gov 13  
(i.e., liga à porta 13 do \*host\* "time.nist.gov" e faz printf do texto recebido).  
 Codico:  [telnet.c](telnet.c)  



Dicas -> responda às seguintes questões:

- O que é um *socket*?

- O que é um *cliente*?
- Endereços **127.x.x.x** corresponde á propria maquina
- Endereços **192.x.x.x** corresponde á propria rede so existem dentro da rede

Links úteis:

- https://www.geeksforgeeks.org/socket-programming-cc/   

---  


<div id="nav">

<span class="left"> <a href="../../" >Pagina Principal</a></span>
<span class="right" ><a href="../aula2" >Proxima Aula</a></span>
</div><br>  

---  


<style>
#nav{
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
    background: white;
    padding: 0 1em;
    padding: 0 1em;
    color: #000000;
    border-left: 0.25em solid #007fff;
    }   
 </style>
