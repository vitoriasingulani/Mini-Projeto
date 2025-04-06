package api.entity;

public class Aluno {
    private String nome;
    private int rgm;
    private String Disciplinas;

    public Aluno(String nome, int rgm){
        this.nome = nome;
        this.rgm = rgm;
    }

    public Aluno(String nome, int rgm, String disciplinas){
        this.nome = nome;
        this.rgm = rgm;
        //this.disciplinas = disciplinas; // tem que instaciar?
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRgm() {
        return rgm;
    }

    public void setRgm(int rgm) {
        this.rgm = rgm;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | " + " RGM: " + rgm;
    }
//    public String[] getDisciplinas() {
//        return disciplinas;
//    }
//
//    public void setDisciplinas(String[] disciplinas) {
//        this.disciplinas = disciplinas;
//    }









}
