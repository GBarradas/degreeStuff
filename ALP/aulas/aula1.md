# Aula Pratica 1  
##### *Autómatos e Liguagens de Programação* | **Data:** 09/02/2021; **Hora**:16:00; **Duração**: 1:45; **Sala**:CLAV_136;**Docente**: [Francisco Coelho](https://github.com/GBarradas/degreeStuff/blob/main/ALP/README.md#docentes)  
### [Pagina Principal](../README.md)
## Resolução de Exercicios
## [Exercício 03](https://home.uevora.pt/~fc/alp/01-palavras_linguagens_expressoes_regulares/01.90-exercicios.html#exerc%C3%ADcio-03)  
Seja Σ={a,b}. Construa definições recursivas dos seguintes conjuntos:

1. <img src="https://render.githubusercontent.com/render/math?math=\color{white}C_1"> = {palavras sobre Σ tais que o símbolo a ocorre aos pares}. <img src="https://render.githubusercontent.com/render/math?math=\color{white}C_1"> inclui, por exemplo, bbaabbbaab e aaaaaaaa mas não inclui aaaaaa nem aabaaabaaabaaaba.  
    > **Base**: <img src="https://render.githubusercontent.com/render/math?math=\color{white}aa">  
    **Passo**:  
    <img src="https://render.githubusercontent.com/render/math?math=\color{white}aap\in C_1">  
    <img src="https://render.githubusercontent.com/render/math?math=\color{white}paa\in C_1">  
    <img src="https://render.githubusercontent.com/render/math?math=\color{white}bp\in C_1">  
    <img src="https://render.githubusercontent.com/render/math?math=\color{white}pb\in C_1">  

 
2. <img src="https://render.githubusercontent.com/render/math?math=\color{white}C_2 = p \in \Sigma^* : |p|"> é par , p começa por a e, em p , os a e os b ocorrem alternados }
    > 
3.  <img src="https://render.githubusercontent.com/render/math?math=\color{white}C_3 =\{p \in \Sigma^* "> é caicua  <img src="https://render.githubusercontent.com/render/math?math=\color{white} \}">
   
    > **Base**: <img src="https://render.githubusercontent.com/render/math?math=\color{white}a, b">  
     **Hipoteses**:  
    <img src="https://render.githubusercontent.com/render/math?math=\color{green}a, b">  
    <img src="https://render.githubusercontent.com/render/math?math=\color{green}aa, bb,"> <img src="https://render.githubusercontent.com/render/math?math=\color{red}ab, ba">  
    <img src="https://render.githubusercontent.com/render/math?math=\color{green}aaa, bbb,aba,bab,"> <img src="https://render.githubusercontent.com/render/math?math=\color{red}abb, baa,bba,aab">  
     **Passo**:  
    $apa\in C_3$  
    $bpb\in C_3$
4. $C_4$={$a^n b^n\in \Sigma^*$ :$n>0$}  
    >    **Base**:$ab$  
    **Passo**: se $p\in C_4$ então  
    $apb$
5. $C_5$={$a^ib^j\in\Sigma^* :0\le i\le j$}
    >    **Base**: $a,b$  
    >    **Hipoteses**:   
    > $bb$  
    > $abb$   
    > $abbb$  
    >   **Passo**: se $p\in C_5$ então:  
    > $pb\in C_5$  
    > $apb\in C_5$ 
6. $c_6$={$p\in\Sigma^*:|p|_a=|P|_b$}   
    > **Base**: a,b
    **Passo**:
    $apb\in C_6$
    $bpa\in C_6$  
---
## [Exercicio 04](https://home.uevora.pt/~fc/alp/01-palavras_linguagens_expressoes_regulares/01.90-exercicios.html#exerc%C3%ADcio-04)  

- Encontre a menor palavra sobre o alfabeto $\Sigma =\{0\}$ que não está em $\{\lambda,0,0^2,0^5\}^3$.   
    `Não percebi be como se resolveo exercicio`


    |Valor|Esta|calculo|
    |-----|----|-------|
    |0    |- [x] |$0$|
    |1    |- [x] |$0$|
    |2    |- [x] |$0^2$|
    |3    |- [x] |$0^2+0=0^3$|
    |4    |- [x] |$0^2+0^2=0^4$|
    |5    |- [x] |$0^5$|
    |6    |- [x] |${0^2}+0^3=0^6$|
    |7    |- [x] |$0^5+0^2=0^7$|
    |8    |- [x] |$0^5+0^3=0^8$|
    |9    |- [x] |$0^5+0^2+0^2=0^{5+2+2}=0^9$|
    |10   |- [x] |${0^5}^2=0^{2*5}=0^{10}$|
    |11   |- [x] |$0^5+0^2+0^2+0^2=0^{11}$
    |12   |- [x] |$0^5+0^5+0^2=0^12$|
    |13   |- [ ] |$$|
    |14   |- [ ] |$$|
    |15   |- [ ] |${0^5}^3=0^{5*3}=0^{15}$|  
    
     
    > Logo o menor possivel $\{\lambda,0,0^2,0^5\}^3$ com $\Sigma =\{0\}$
    é $0^{13}$  
---  
<div style=" width:100%;
    text-align:center;">
<p style="float:left;">pdci</p>
<p style="display: inline-block;
    margin:0 auto;
    width:100px;">pdci</p>
<p style="float:right;
    width:100px;">pdci</p>
</div>
 
