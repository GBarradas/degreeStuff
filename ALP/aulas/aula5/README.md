# Aula Pratica 5  
##### *Autómatos e Liguagens de Programação* | **Data:** 09/03/2021; **Hora**:16:00; **Duração**: 2h; **Sala**:CLAV_136; **Docente**: [Francisco Coelho](../../#docentes)  
### [Pagina Principal](../../)  
---
## Resolução de Exercicios
## [Exercicio 28](https://home.uevora.pt/~fc/alp/02-automatos_finitos/02.90-exercicios.html#o-pumping-lemma)  

Mostre que as seguintes linguagens não são regulares:  

1. ✓<span class="math" >L1</span>={1^n+1m =1 n+m: n,m≥0}.  
2. A linguagem das palavras capicua sobre <span class="math" >{a,b}</span>.  
3. <span class="math" >L_3</span>={aa^nb^n: n≥0}.   
4. <span class="math" >L4</span>={0n 1 n+1  : n≥0}.  
   `Resolução ...`
5. <span class="math" >L5</span>={a n cb n  : n≥0}.  
   `Resolução ...`
6. <span class="math" >L6</span>={a n b m  : m>n≥0}.  


---
## Pumping Lemma  
Se <span class="math" >L</span> é <u> Regular</u>  
**a)** Seja <span class="math" >K</span> o numero de estados de um AFD que acita <span class="math" >L</span>

---  
## [Exercicio 2](https://home.uevora.pt/~fc/alp/03-gramaticas_automatos_pilha/03.90-exercicios.html#exerc%C3%ADcio-01)  
Defina uma gramática independente do contexto que gere a linguagem:  
1. {wcw R  : w∈{a,b} ∗ }.  
2. {wc n  : w∈{a,b} ∗  e n=∣w∣}.  
3. {a i b j c k  : k≥0 e i+j=k}.  
4. ✓ {a n b m  : m,n≥0 e m != n}.  
5. dos números naturais sem zeros não significativos.  
   
---  
## [Exercicio 4](https://home.uevora.pt/~fc/alp/03-gramaticas_automatos_pilha/03.90-exercicios.html#exerc%C3%ADcio-03)  
✓ Seja LL a linguagem de todas sequências de parêntesis, curvos - ‘((’ e ‘))’ - e rectos - ‘[’ e ‘]’ -, bem emparelhados. Pertencem a esta linguagem palavras como λ, “()()”, “[]”, “()()()[()]”, “(())([()])” e “(())([][([])])[]”. Não pertencem a LL palavras como “]”, “((”, “((]”, “(([)]”, “)()(” e “[()]]”.

1. Mostre que LL não é regular;  
2. Defina uma gramática independente do contexto que gere LL.  

---
## [Exercico 6](https://home.uevora.pt/~fc/alp/03-gramaticas_automatos_pilha/03.90-exercicios.html#exerc%C3%ADcio-06)  
Considere a gramática G=({A},{a,b},{A→AA ∣ aAb ∣ λ},A).

1. Construa uma derivação esquerda para a palavra `aababb` e a respetiva árvore de derivação.  
2. Construa uma derivação direita para a palavra `ababab` e a respetiva árvore de derivação.  
3. Determine se G é ambígua. † Em caso afirmativo, apresente uma gramática não ambígua equivalente.  

---  
## [Exercico 7](https://home.uevora.pt/~fc/alp/03-gramaticas_automatos_pilha/03.90-exercicios.html#exerc%C3%ADcio-07)  
✓ Considere a gramática independente do contexto  
<p class="nav">G=({S},{a},{S→aa ∣ SS},S).</p>   

1. Mostre que esta gramática é ambígua.  
2. † Apresente uma gramática equivalente não ambígua.
3. Apresente uma gramática regular equivalente.  
4. Apresente uma expressão regular que represente a linguagem gerada pela gramática.  

---  

<div id="nav">
<span class="left" ><a href="../aula4" >Aula Anterior</a></span>
<span> <a href="../../" >Pagina Principal</a></span>
<span class="right" ><a href="../aula6" >Proxima Aula</a></span>
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
