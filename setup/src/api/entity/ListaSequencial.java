package api.entity;

public class ListaSequencial {
    private Aluno[] alunos = new Aluno[60]; //cria um arr de Alunos com capacidade de 60
    private int qntdAluno = 0;// conta a qntd de alunos cadastrados

    public void append(Aluno aluno) {                   // MÉTODO PARA ADD UM NOVO ALUNO

        if (this.qntdAluno < this.alunos.length) {      //verifica de tem espaço em no array
            this.alunos[this.qntdAluno] = aluno;        //add uma instancia de aluno na proxima posição livre
            this.qntdAluno++;                           //incrementa o contador de alunos
            System.out.println("Aluno Cadastrado!");
            ordenarAlunosPorRGM();                      //Chama o metodo de ordenarAlunosporRGM e faz a ordenagem numérica
        } else {
            System.out.println("LISTA CHEIA! ");
        }
    }

    public void ordenarAlunosPorRGM(){ // MÉTODO PARA ORDENAR ALUNOS POR RGM (Técnica Bubble Sort)

        for(int i = 0 ; i < this.qntdAluno; i++){               //loop externo
            for(int j = 0 ; j < this.qntdAluno - 1; j++){       //loop interno para comparar os pares de alunos
                if(alunos[j].getRgm() > alunos[j+1].getRgm()){  //Se RGM for maior que o que o próximo
                    Aluno alunoParaTroca = this.alunos[j];      //Guarda o aluno atual
                    this.alunos[j] = this.alunos[j + 1];        //troca de posição  com o proximo
                    this.alunos[j +1] = alunoParaTroca;         //Finaliza a troca
                }
            }
        }
    }

    public void exibirAlunos() {    //MÉTODO PARA EXIBIR TODOS OS ALUNOS CADASTRADOS

        if (this.qntdAluno == 0) {
            System.out.println("Nenhum aluno cadastrado!");
        } else {
            System.out.println("Lista de Alunos:");
            System.out.println("-----------------");
            for (int i = 0; i < this.qntdAluno; i++) {
                Aluno aluno = this.alunos[i];
                System.out.println(aluno);
                aluno.exibirDisciplinas();
            }
        }
    }

    public Aluno buscaPorRGM(int rgm) {             //MÉTODO PARA FAZER A BUSCA POR RGM
        for (int i = 0; i < this.qntdAluno; i++) {  //vai em todos os alunos cadastrados e se bater ele retorna o aluno
            if (rgm == alunos[i].getRgm()) {
                return alunos[i];
            }
        }
        return null;
    }

    public Aluno removerAlunoPorRGM(int rgm) {          //MÉTODO PARA REMOVER UM ALUNO PELO RGM
        int indiceDoAlunoRemovido = 0;
        Aluno alunoRemovido = null;
        for (int i = 0; i < this.qntdAluno; i++) {      // LOop para encontrar o aluno
            if (rgm == alunos[i].getRgm()) {            // se o rgm for igual ao procurado
                alunoRemovido = alunos[i];              //guarda
                alunos[i] = null;                       //remove a posição no array
                indiceDoAlunoRemovido = i;              //Guarda o indice para a proxima etapa
            }
        }
        if(alunoRemovido == null){ //ou seja, removeu. Agora...
            return null;
        }else{
            for(int i = indiceDoAlunoRemovido; i < this.qntdAluno; i++){ // arruma os alunos restantes
                if(i < alunos.length - 1){                              //
                    alunos[i] = alunos[i+1];                            //move os alunos para a esquerda
                }
            }
        }
        this.qntdAluno--; // subtrai a qntd de alunos
        return alunoRemovido;
    }
}