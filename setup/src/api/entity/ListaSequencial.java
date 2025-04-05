package api.entity;

public class ListaSequencial {
    private Aluno[] alunos = new Aluno[60];
    private int qntdAluno = 0;
    private int rgm;


    public void append(Aluno aluno) { // publico é o modificador de acesso | void é o tipo de retorno | append é o método
        if (this.qntdAluno < this.alunos.length) { // this.alunos.length é o tamnho total do array | Aqui tem uma verificação de
            this.alunos[this.qntdAluno] = aluno;
            this.qntdAluno++;
            System.out.println("Aluno Cadastrado!");
        }else {
            System.out.println("LISTA CHEIA! ");
        }
    }

    public void exibirAlunos() {
        if (this.qntdAluno == 0) {
            System.out.println("Nenhum aluno cadastrado!");
        } else {
            System.out.println("Lista de Alunos:");
            for (int i = 0; i < this.qntdAluno; i++) {
                System.out.println(alunos[i]);
            }
        }
    }

    public Aluno buscaPorRGM(int rgm) {
        for (int i = 0; i < this.qntdAluno; i++) {
            if (rgm == alunos[i].getRgm()) {
                return alunos[i];
            }
        }
        return null;
    }


    public Aluno removerAlunoPorRGM(int rgm) {
        int indiceDoAlunoRemovido = 0;
        Aluno alunoRemovido = null;
        for (int i = 0; i < this.qntdAluno; i++) {
            if (rgm == alunos[i].getRgm()) {
                alunoRemovido = alunos[i];
                alunos[i] = null;//
                indiceDoAlunoRemovido = i;

            }
        }
        if(alunoRemovido == null){
            return null;
        }else{
            for(int i = indiceDoAlunoRemovido; i < this.qntdAluno; i++){
                if(i < alunos.length - 1){
                    alunos[i] = alunos[i+1];
                }
            }
        }

        this.qntdAluno--;
        return alunoRemovido;
    }


        //todo sprint2: Criar metodo para adcionar o rgm por ordem numérica
}