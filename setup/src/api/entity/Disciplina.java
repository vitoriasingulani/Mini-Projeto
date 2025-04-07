package api.entity;

public class Disciplina {
    private String nomeDisciplina;
    private Disciplina ponteiroParaAProximaDisciplina;

    public  Disciplina(String nomeDaDisciplina){
        this.nomeDisciplina = nomeDaDisciplina;
    }
    public Disciplina(){
    }

    public void append(Disciplina disciplina){ // recurssão?
        if(this.nomeDisciplina == null) {
            this.nomeDisciplina = disciplina.getNomeDaDisciplina();
        }else if(this.ponteiroParaAProximaDisciplina == null){
            this.ponteiroParaAProximaDisciplina = disciplina;
        }else{
            this.ponteiroParaAProximaDisciplina.append(disciplina);
        }
    }


    public Disciplina getPonteiroParaAProximaDisciplina (){
        return ponteiroParaAProximaDisciplina;
    }

    public String getNomeDaDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDaDisciplina(String nomeDaDisciplina) {
        this.nomeDisciplina = nomeDaDisciplina;
    }

    @Override
    public String toString() {
        return "Disciplina :" + nomeDisciplina;
    }
}
