package api.entity;

public class Disciplina {
    private String nomeDisciplina;
    private Disciplina ponteiroParaAProximaDisciplina;

    public Disciplina(String nomeDaDisciplina) {
        this.nomeDisciplina = nomeDaDisciplina;
    }
    public Disciplina() {
    }

                                                //LISTA ENCANDEADA  -  MÉTODO DE RECURSÃO
    public void append(Disciplina disciplina) {                         //recebe a disciplina como parâmetro
        if (this.nomeDisciplina == null) {                              //verifica se a disciplina atual esta vazia
            this.nomeDisciplina = disciplina.getNomeDaDisciplina();     //então se ela estiver vazia, ele aproveita esse espaço e preenche com a nova disciplina.
        } else if (this.ponteiroParaAProximaDisciplina == null) {       //Se a disciplina atual já tem um nome, mas não aponta pra ninguém (ou seja, não tem outra disciplina depois dela
            this.ponteiroParaAProximaDisciplina = disciplina;           //então a nova disciplina fica aqui, como a próxima da fila. Agora a lista tem mais um nó!
        } else {
            this.ponteiroParaAProximaDisciplina.append(disciplina);     //Se já existe alguém depois da atual, o que ele faz? Chama o método append de novo, mas na próxima disciplina.
        }
    }

    public Disciplina getPonteiroParaAProximaDisciplina() {
        return ponteiroParaAProximaDisciplina;
    }

    public String getNomeDaDisciplina() {
        return nomeDisciplina;
    }

    @Override
    public String toString() {
        if (nomeDisciplina == null) {
            return "Esse Aluno não possui disciplinas.";
        } else {
            return "Disciplina: " + nomeDisciplina;
        }
    }
}
