package sd.rest;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "turma")
public class Turma {

    @XmlElement(required = true)
    protected List<Aluno> alunos;


    public Turma() {
    	alunos = new LinkedList<Aluno>();
    }	

   
    public List<Aluno> getAlunos() {
        return this.alunos;
    }
    

    protected void add( Aluno a ) {
	alunos.add( a );
    }

    protected int size() {
	return alunos.size();
    }

    public String toString() {
        return alunos.toString();
    }
}
