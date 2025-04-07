package api.entity;
import api.entity.Disciplina;

public class Aluno {
    private String nome;
    private int rgm;
    private Disciplina disciplina;
    private Disciplina ponteiroParaAProximaDisciplina;

    public Aluno(String nome, int rgm, Disciplina disciplina){
        this.nome = nome;
        this.rgm = rgm;
        this.disciplina = disciplina;
    }

    public Aluno(String nome, int rgm, String disciplinas){
        this.nome = nome;
        this.rgm = rgm;
    }


    public int getRgm() {
        return rgm;
    }


    @Override
    public String toString() {
        return "Aluno: " + nome + " | " + " RGM: " + rgm;
    }


    public void exibirDisciplinas() {
        Disciplina disciplinaParaExibir = this.disciplina;
        while (disciplinaParaExibir != null){ //
            System.out.println(disciplinaParaExibir);
            disciplinaParaExibir = disciplinaParaExibir.getPonteiroParaAProximaDisciplina();
        }
        System.out.println("-------------------");


    }
}


















