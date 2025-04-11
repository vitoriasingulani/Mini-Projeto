package api;

import api.entity.Aluno;
import api.entity.Disciplina;
import api.entity.ListaSequencial;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ListaSequencial listaSequencial = new ListaSequencial();

        while (true) {
            System.out.println("---------------------------------------------------------");
            System.out.println("------------------------ M E N U ------------------------");
            System.out.println("---------------------------------------------------------");
            System.out.println("--------  1 - Adicionar Aluno  --------------------------");
            System.out.println("--------  2 - Buscar Aluno por RGM ----------------------");
            System.out.println("--------  3 - Mostra todos os alunos e disciplinas -----");
            System.out.println("--------  4 - Remover Aluno por RGM  --------------------");
            System.out.println("--------  5 - Sair  -------------------------------------");
            System.out.println("---------------------------------------------------------");

            System.out.println("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: //adcionar uma instacia de aluno
                    System.out.println("Nome: ");
                    String nome = sc.nextLine();

                    System.out.println("Rgm: ");
                    int rgm = sc.nextInt();
                    sc.nextLine();

                    Disciplina disciplina = new Disciplina(); //cria uma lista de disciplinas. Objeto que vai armazenar a disciplina do aluno

                    while (true) {
                        System.out.println("Deseja adicionar mais disciplinas? Digite '1' para SIM | '2' para NÃO ");
                        int adesaoDeDisciplina = sc.nextInt();
                        sc.nextLine();

                        if (adesaoDeDisciplina == 1) {
                            System.out.println("Digite a disciplina desejada: ");
                            String nomeDaDisciplina = sc.nextLine();

                            Disciplina disciplinaACadastrar = new Disciplina(nomeDaDisciplina); //
                            disciplina.append(disciplinaACadastrar);

                        } else if (adesaoDeDisciplina == 2) {
                            break;
                        } else {
                            System.out.println("Opção inválida!");
                        }

                    }
                    Aluno aluno = new Aluno(nome, rgm, disciplina);
                    listaSequencial.append(aluno);
                    break;
                case 2:
                    System.out.println("Digite o RGM do Aluno:  ");
                    int buscaPorRGM = sc.nextInt();

                    Aluno alunoEncontrado = listaSequencial.buscaPorRGM(buscaPorRGM);
                    if (alunoEncontrado == null) {
                        System.out.println("Aluno não encontrado!");
                    } else {
                        System.out.println(alunoEncontrado);
                    }
                    break;

                case 3:
                    listaSequencial.exibirAlunos();
                    break;

                case 4:
                    System.out.println("Digite o Rgm do aluno que você quer remover: ");
                    int rgmParaRemover = sc.nextInt();

                    Aluno removerAlunoPorRGM = listaSequencial.removerAlunoPorRGM(rgmParaRemover);
                    if (removerAlunoPorRGM == null) {
                        System.out.println("RGM não existente!");
                    } else {
                        System.out.println("Aluno removido!");
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
}
