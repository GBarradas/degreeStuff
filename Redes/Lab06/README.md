# Aula Pratica 6   
##### *Redes de Computadores* | **Data:** 29/03/2021; **Hora**:13:30; **Duração**: 2h; **Sala**:CLAV_139; **Docente**: [Pedro Salgueiro](../#docentes)  
### [Pagina Principal](../)
---    
# Sistema de "chat"
1. Implemente um sistema de "chat" que funciona da seguinte forma:

O servidor aceita ligações na porta 1234 de vários clientes em simultâneo
Se um dos clientes envia uma mensagem, esta deve ser retransmitida a todos os clientes (inclusive ao próprio que a enviou)
2. O cliente deve receber mensagens do teclado e enviá-las para o servidor, ao mesmo tempo que recebe mensagens do servidor e mostrá-las no ecrã (sugestão: usar select() entre o socket e o stdin)

3. Altere o servidor (1), de modo a que o cliente que envia a mensagem não a receba (só os outros recebem)

4. Altere novamente o servidor, desta vez para permitir mensagens de 1 para 1:

Cada cliente deve escolher um "nome" (ou nickname) quando se liga:
assim que estabelece conexão, envia uma string "<nome>\n".
o servidor gere uma "tabela" onde faz corresponder cada "nome" ao socket do cliente respectivo (para já, assumimos que não há nomes repetidos)
As mensagens passam a ter um prefixo:
+ <mensagem>\n (significa que a mensagem é para todos)
-<nome> <mensagem>\n (significa que a mensagem é apenas para o cliente <nome>)
O cliente deve receber a mensagem com o mesmo prefixo, para saber se é só para ele (privada) ou para todos (pública)
Todas as mensagens entre cliente e servidor devem ser terminadas com um caracter '\n'.

---  

<div id="nav">
<span class="left" ><a href="../Lab05" >Aula Anterior</a></span>
<span> <a href="../" >Pagina Principal</a></span>
<span class="right" ><a href="../Lab07" >Proxima Aula</a></span>
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