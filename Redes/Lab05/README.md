# Aula Pratica 5   
##### *Redes de Computadores* | **Data:** 22/03/2021; **Hora**:13:30; **Duração**: 2h; **Sala**:CLAV_139; **Docente**: [Pedro Salgueiro](../#docentes)  
### [Pagina Principal](../)
---    
1. Enumere as características que distinguem as 3 alternativas mais comuns para suportar vários clientes em simultâneo:

- fork() (multi-processo)  
- posix threads (multi-threading)  
- select() (mono-processo)  
2. Altere o servidor 'echo' da última aula para utilizar select(), de forma a poder "atender" vários clientes em simultâneo

3. (TPC) Implemente um sistema de "chat" que funciona da seguinte forma:

- O servidor aceita ligações na porta 1234 de vários clientes em simultâneo  
- Se um dos clientes envia uma mensagem, esta deve ser retransmitida a todos os clientes (inclusive ao próprio que a enviou)  
- O cliente deve receber mensagens do teclado e enviá-las para o servidor, ao mesmo tempo que recebe mensagens do servidor e mostrá-las no ecrã (será que isto é possível?)

---  

<div id="nav">
<span class="left" ><a href="../Lab04" >Aula Anterior</a></span>
<span> <a href="../" >Pagina Principal</a></span>
<span class="right" ><a href="../Lab06" >Proxima Aula</a></span>
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
