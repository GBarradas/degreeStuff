# Relatório
## Introdução
Após a planificação de um software de entrega de comida em casa, foi proposto a 
implementação do mesmo, dando assim continuidade ao que tinha sido feito 
anteriormente. A implementação do sistema foi feita em linguagem Java, sendo esta uma 
linguagem muito interessante para o desenvolvimentos de software e aplicações, pois o 
Java trata-se de uma linguagem de programação orientada a objetos, baseada em classes,
o que, no mundo do software e aplicações, é muito valorizado pois torna-se muito 
intuitivo o desenvolvimento das mesmas.

De forma a tornar mais fácil a implementação do software, foi necessário recorrer ao
Maven. O Maven trata-se de um software para construção e gestão de projetos, o que
facilita no caso de ser necessário recorrer a uma biblioteca externa ao Java, isto é, 
uma biblioteca que seja necessário um driver externo de forma a ser reconhecida e
passível de utilizar na linguagem Java.

Um dos objetivos principais deste trabalho não é a correta implementação do software, mas
sim os testes desenvolvidos para os métodos do mesmo, de forma a aferir se estes se 
encontram corretamente implementados. De maneira a ser possível implementar esses mesmos 
testes e ainda automatizá-los, isto é, tornar a sua execução autónoma de quaisquer 
operadores humanos, foi necessário recorrer ao JUnit, que consiste numa framework 
desenvolvida para a linguagem Java que auxilia e facilita a criação e manutenção de
código para a automatização de testes. O objetivo principal do JUnit é permitir ao 
utilizador criar testes unitários automatizados, o que auxilia na deteção de erros ou
comportamentos anómalos por parte de algum método de uma determinada classe do programa.

O outro grande objetivo deste projeto é permitir ganhar mais liberdade e experiência com
o sistema Git e ainda com a plataforma GitLab, com a utilização de diferentes branches 
ou issues para cada tarefa do trabalho. O Git consiste num sistema de controlo de 
versões, o que permite controlar as diferentes branches do projeto. Já o GitLab é uma
plataforma de gestão de repositórios de software, baseado em Git, o que possibilita
guardar todo o projeto num servidor ao invés de localmente, minimizando assim o risco
de perda de dados.
## Desenvolvimento
Inicialmente foi necessário criar o projeto Maven e configurá-lo, ou seja, criar as
classes necessários para a implementação do software. Após criadas as classes, foi 
necessário implementar os métodos de forma a tornar o software funcional e, só depois
de configuradas as classes, foi possível criar as classes de teste, que servem para testar
os vários métodos presentes em cada uma das classes. De salientar que cada classe possui
a sua própria classe de teste.

O método utilizado de forma a executar os testes da maneira mais correta possível foi,
quando uma classe de testes fosse finalizada, executar vários testes de acordo com aquilo
que o método implementa, isto é, testar valores inválidos, verificar se os cálculos
estavam corretos, verificar se os métodos de get e set das classes estavam a funcionar
corretamente, entre outros testes.

Após terminar de implementar e testar todas as classes de teste referentes ao projeto, 
foi necessário criar a classe Main, pois esta é responsável por demonstrar as várias 
funcionalidades presentes no software. Foram criadas três demosntrações de forma a 
conseguir demonstrar vários casos possíveis de acontecer tanto do lado do restaurante
como até do lado do cliente.
## Discussão de resultados
A maior dificuldade sentida na implementação do software foi na criação dos testes
unitários no JUnit pois, devido à pouca experiência e conhecimento no uso desta framework,
foi necessário realizar uma pesquisa de forma a perceber as várias funcionalidades
oferecidas pelo JUnit e também a forma correta de implementar os testes de acordo com
o método a testar. Após executar vários testes como testar valores inválidos, verificar 
se os cálculos estavam corretos, verificar se os métodos de get e set das classes estavam
a funcionar corretamente, entre outros, foram descobertos alguns erros durante este 
processo, o que atrasou na concretização dos testes e da implementação próprio software.
## Conclusão
A planificação do sistema feita no primeiro trabalho veio a revelar-se bastante útil para
a realização deste segundo trabalho, pois como o feedback dado pelo docente na 
planificação do sistema foi bastante positivo, significa que este foi corretamente
idealizado, o que tornou a implementação do mesmo muito mais fácil e intuitiva. Devido a 
este facto, a implementação do software foi bastante rápida de concluir, o que permitiu
dedicar mais tempo a desenvolver e, mais tarde, aperfeiçoar os testes feitos aos métodos
do programa.

Referir ainda que, a realização deste trabalho, permitiu adquirir mais conhecimento
acerca de funcionalidades que podem ser utilizadas na linguagem Java, mais concretamente
o JUnit e ainda permitiu adquirir uma maior liberdade na utilização do Git e do GitLab, 
ferramentas cuja utilização é bastante valorizada, senão mesmo indispensável, não só no
ramo da engenharia de software, como na maioria das áreas ligadas ao setor da informática.
## Bibliografia
[Salgueiro, 2023] Salgueiro, P. (2023). Aulas de Metodologias e Desenvolvimento de Software. *in Universidade de Évora*

[Sommerville, 2016] Sommerville, I. (2016). Software Engineering 10th Edition.