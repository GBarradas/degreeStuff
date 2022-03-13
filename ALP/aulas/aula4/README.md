# Aula Pratica 4  
##### *Autómatos e Liguagens de Programação* | **Data:** 02/03/2021; **Hora**:16:00; **Duração**: 2h; **Sala**:CLAV_136;**Docente**: [Francisco Coelho](../../#docentes)  
### [Pagina Principal](../../)
---  

## Operações com Autómatos Finitos não Determinista  
![](lr_er_af.png)   
 
Para realizar estas operações é precisso ter Autómatos finitos não defenidos bem preparados.  
![](afnd_bp.png)  


|AFND|Linguagem|Operaçao|
|----|---------|--------|
|A|La=L(A)|-|
|B|Lb=L(B)|-|
|C|Lc=La.Lb|Concatenação de LR's|
|D|Ld=La U Lb|União de LR's|
|E|Le=La*|A*|   

### Exemplos  
![](c.png)  

![](d.png)  

![](e.png)  
  
# Interseção com Autómatos Finitos Deterministab  

![](afd.png) ![](x.png)  

![](afd&x.png)

--- 
<div id="nav">
<span class="left" ><a href="../aula3" >Aula Anterior</a></span>
<span> <a href="../../" >Pagina Principal</a></span>
<span class="right" ><a href="../aula5" >Proxima Aula</a></span>
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
    background:rgb(140 143 147 / 17%);
    padding: 0 1em;
    padding: 0 1em;
    color: #000000;
    border-left: 0.25em solid #007fff;
    }   
 </style>
