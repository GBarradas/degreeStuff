# Aula Pratica 1  
##### *Autómatos e Liguagens de Programação* | **Data:** 09/02/2021; **Hora**:16:00; **Duração**: 1:45; **Sala**:CLAV_136;**Docente**: [Francisco Coelho](../../#docentes)  
### [Pagina Principal](../../)  
## Resolução de Exercicios
## [Exercício 03](https://home.uevora.pt/~fc/alp/01-palavras_linguagens_expressoes_regulares/01.90-exercicios.html#exerc%C3%ADcio-03)  
Seja Σ={a,b}. Construa definições recursivas dos seguintes conjuntos:

1. <img src="https://render.githubusercontent.com/render/math?math=\large\C_1"> = {palavras sobre Σ tais que o símbolo a ocorre aos pares}. <img src="https://render.githubusercontent.com/render/math?math=\large\C_1"> inclui, por exemplo, bbaabbbaab e aaaaaaaa mas não inclui aaaaaa nem aabaaabaaabaaaba.  
    > **Base**: <img src="https://render.githubusercontent.com/render/math?math=\large\aa"><br>
    **Passo**:  
    <img src="https://render.githubusercontent.com/render/math?math=\large\aap\in C_1"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\paa\in C_1"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\bp\in C_1"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\pb\in C_1"><br>

 
2. <img src="https://render.githubusercontent.com/render/math?math=\large\C_2 = p \in \Sigma^* : |p|"> é par , p começa por a e, em p , os a e os b ocorrem alternados }
    > 
3.  <img src="https://render.githubusercontent.com/render/math?math=\large\C_3 =\{p \in \Sigma^* "> é caicua  <img src="https://render.githubusercontent.com/render/math?math=\large\ \}"><br>  
    > **Base**: <img src="https://render.githubusercontent.com/render/math?math=\large\a, b"><br>
     **Hipoteses**:  
    <img src="https://render.githubusercontent.com/render/math?math=\color{green}\large\a, b"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\color{green}\large\aa, bb,"> <img src="https://render.githubusercontent.com/render/math?math=\color{red}\large\ab, ba"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\color{green}\large\aaa, bbb,aba,bab,"> <img src="https://render.githubusercontent.com/render/math?math=\color{red}\large\abb, baa,bba,aab"><br>
     **Passo**:  
     <img src="https://render.githubusercontent.com/render/math?math=\large\apa\in C_3"><br>
     <img src="https://render.githubusercontent.com/render/math?math=\large\bpb\in C_3"><br>  
4. <img src="https://render.githubusercontent.com/render/math?math=\large\c_4=\{a^nb^n\in \Sigma^* : n>0\}"><br> 
    >    **Base**: <img src="https://render.githubusercontent.com/render/math?math=\large\ab"><br>
    **Passo**:  
    se <img src="https://render.githubusercontent.com/render/math?math=\large\p\in C_4"> então<br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\apb\in C_4"><br>
5. <img src="https://render.githubusercontent.com/render/math?math=\large\C_5 =\{a^ib^j\in \Sigma^* : 0\le i\le j \}"><br>$C_5$=
    >    **Base**: <img src="https://render.githubusercontent.com/render/math?math=\large\a, b"><br>
    >    **Hipoteses**:   
    > <img src="https://render.githubusercontent.com/render/math?math=\large\bb"><br>
    > <img src="https://render.githubusercontent.com/render/math?math=\large\abb"><br>
    > <img src="https://render.githubusercontent.com/render/math?math=\large\abbb"><br>
    >   **Passo**:  
     se <img src="https://render.githubusercontent.com/render/math?math=\large\p\in C_5"> então:<br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\pb\in C_5"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\apb\in C_5"><br>
6. <img src="https://render.githubusercontent.com/render/math?math=\large\c_6=\{p\in\Sigma^*:|p|_a=|P|_b\}"><br>  
    > **Base**: <img src="https://render.githubusercontent.com/render/math?math=\large\a, b"><br>
    **Passo**:  
    <img src="https://render.githubusercontent.com/render/math?math=\large\apb\in C_6"><br>
    <img src="https://render.githubusercontent.com/render/math?math=\large\bpa\in C_6"><br>
  
---
## [Exercicio 04](https://home.uevora.pt/~fc/alp/01-palavras_linguagens_expressoes_regulares/01.90-exercicios.html#exerc%C3%ADcio-04)  

- Encontre a menor palavra sobre o alfabeto <img src="https://render.githubusercontent.com/render/math?math=\Sigma =\{0\}"> que não está em <img src="https://render.githubusercontent.com/render/math?math=\{\lambda,0,0^2,0^5\}^3">.  
    `Não percebi be como se resolve o exercicio`


    >|Valor|Esta|calculo|
    >|-----|----|-------|
    >|0    |✓ |![][0]|
    >|1    |✓ |![][1]|
    >|2    |✓ |![][2]|
    >|3    |✓ |![][3]|
    >|4    |✓ |![][4]|
    >|5    |✓ |![][5]|
    >|6    |✓ |![][6]|
    >|7    |✓ |![][7]|
    >|8    |✓ |![][8]|
    >|9    |✓ |![][9]|
    >|10   |✓ |![][10]|
    >|11   |✓ |![][11]|
    >|12   |✓ |![][12]|
    >|13   |  |![][13]|
    >|14   |  |![][14]|
    >|15   |✓ |![][15]| 

    > Logo o menor possivel <img src="https://render.githubusercontent.com/render/math?math=\{\lambda,0,0^2,0^5\}^3"> com <img src="https://render.githubusercontent.com/render/math?math=\Sigma =\{0\}">
    é <img src="https://render.githubusercontent.com/render/math?math=0^{13}">  
    
---  

[0]:  https://render.githubusercontent.com/render/math?math=0
[1]:  https://render.githubusercontent.com/render/math?math=0
[2]:  https://render.githubusercontent.com/render/math?math=0^2
[3]:  https://render.githubusercontent.com/render/math?math=0^2+0=0^3
[4]:  https://render.githubusercontent.com/render/math?math=0^2+0^2=0^4
[5]:  https://render.githubusercontent.com/render/math?math=0^5
[6]:  https://render.githubusercontent.com/render/math?math={0^2}+0^3=0^6
[7]:  https://render.githubusercontent.com/render/math?math=0^5+0^2=0^7
[8]:  https://render.githubusercontent.com/render/math?math=0^5+0^3=0^8
[9]:  https://render.githubusercontent.com/render/math?math=0^5+0^2+0^2=0^{5+2+2}=0^9
[10]: https://render.githubusercontent.com/render/math?math={0^5}^2=0^{2*5}=0^{10}
[11]: https://render.githubusercontent.com/render/math?math=0^5+0^2+0^2+0^2=0^{11}
[12]: https://render.githubusercontent.com/render/math?math=0^5+0^5+0^2=0^{12}
[13]: https://render.githubusercontent.com/render/math?math=0
[14]: https://render.githubusercontent.com/render/math?math=0
[15]: https://render.githubusercontent.com/render/math?math={0^5}^3=0^{5*3}=0^{15}  

<div id="nav">

<span class="left"> <a href="../../" >Pagina Principal</a></span>
<span class="right" ><a href="../aula2" >Proxima Aula</a></span>
</div>

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
