import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ErgueiAsMaos {

    public static void main(String[] args) {

        System.out.println("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
        System.out.println("Você já conhece a música do Padre Marcelo Rossi, Erguei as Mãos.\n" +
                "Por isso, irei trazer a você a letra desse sucesso.\n" +
                "Afinal, ela foi lançada em 1998.\n" +
                "Ela tem duas partes, por isso você pode escolher relembrar de cada uma delas separadamente.\n" +
                "Mas, se preferir, podemos trazer a letra inteira para você!\n" +
                "\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");

        Scanner opcao = new Scanner(System.in);
        int escolhida;

        //Menu interativo, permite ao usuário mostrar a letra até que deseje sair
        try {
            do {
                System.out.print("Escolha uma opção: \n\n" +
                        "1 - Mostrar somente a primeira parte da música;\n" +
                        "2 - Mostrar somente a segunda parte da música;\n" +
                        "3 - Mostrar toda a letra da música;\n" +
                        "9 - Sair do programa\n\n" +
                        "Digite a opção desejada: ");
                escolhida = opcao.nextInt();
                System.out.println("\n\n");

                switch (escolhida) {

                    //Mostra somente a primeira parte
                    case 1:
                        System.out.println(musicaUm());
                        break;

                    //Mostra somente a segunda parte
                    case 2:
                        System.out.println(musicaDois());
                        break;

                    //Mostra a letra inteira
                    case 3:
                        System.out.println(musicaUm());
                        System.out.println("E atenção agora, porque\n");
                        System.out.println(musicaDois());
                        break;

                    //Opção de saída do programa
                    case 9:
                        System.out.println("Muito Obrigado! \n\n" +
                                "Até a Próxima!");
                        break;

                    //Mensagem caso o usuário digite uma opção inválida
                    default:
                        System.out.println("Opção Inválida! Por favor, escolha uma opção válida.\n\n");
                        break;
                }

            } while (escolhida != 9);
        } catch (InputMismatchException e) {
            System.out.println("Por favor, digite somente números inteiros para as opções!");
        } finally {
            opcao.close();
        }
    }


    //M[etodos para os versos que se repetem
    public static String primeiraParte() {

        return "Erguei as mãos e dai glória a Deus\n" +
                "Erguei as mãos e dai glória a Deus\n" +
                "Erguei as mãos\n" +
                "E cantai com os filhos do Senhor.\n";
    }

    public static String segundaParte(String artigo, String animal1, String animal2) {

        return "Os animaizinhos subiram de dois em dois\n" +
                "Os animaizinhos subiram de dois em dois\n" +
                artigo + " " + animal1 + "\n" +
                "E os " + animal2 + ", como os filhos do Senhor\n";
    }

    public static String terceiraParte() {

        return "Deus disse a Noé: Constrói uma arca\n" +
                "Deus disse a Noé: Constrói uma arca\n" +
                "Que seja feita\n" +
                "De madeira para os filhos do Senhor\n";
    }

    public static String quartaParte() {

        return "\nO senhor tem muitos filhos\n" +
                "Muitos filhos ele tem\n" +
                "Eu sou um deles, você também\n" +
                "Louvemos ao senhor\n";
    }

    //Override do método, para adicionar as partes opcionais de fala do cantor
    public static String quartaParte(int verso, String fala) {

        String versoQuatro = "";

        if (verso == 2 || verso == 6) {
            versoQuatro = "\nO senhor tem muitos filhos\n" +
                    "Muitos filhos ele tem" + fala + "\n" +
                    "Eu sou um deles, você também\n" +
                    "Louvemos ao senhor\n";

        }
        if (verso == 7) {
            versoQuatro = "\nO senhor tem muitos filhos" + fala + "\n" +
                    "Muitos filhos ele tem\n" +
                    "Eu sou um deles, você também\n" +
                    "Louvemos ao senhor\n";

        }
        return versoQuatro;
    }

    public static String quartaParte(int verso, String fala, String falaDois) {

        String versoQuatro = "\nO senhor tem muitos filhos" + fala + "\n" +
                "Muitos filhos ele tem\n" +
                "Eu sou um deles, você também" + falaDois + "\n" +
                "Louvemos ao senhor\n";

        return versoQuatro;
    }

    //Construindo a primeira parte da música
    public static String musicaUm() {

        ArrayList<String> listaUm = new ArrayList<String>();

        listaUm.add(primeiraParte());

        for (int i = 1; i < 8; i++) {

            if (i == 1) {
                listaUm.add(segundaParte("O", "elefante", "passarinhos"));
            }
            if (i == 2) {
                listaUm.add("(Para não!)");
                listaUm.add(segundaParte("A", "minhoquinha", "penguins"));
            }
            if (i == 3) {
                listaUm.add(segundaParte("O", "canguru", "sapinho"));
            }
            if (i == 4) {
                listaUm.add(terceiraParte());
            }
            if (i == 5) {
                listaUm.add("Por isso...!");
                listaUm.add(primeiraParte());
            }
            if (i == 6) {
                listaUm.add(primeiraParte());
            }
            if (i == 7) {
                listaUm.add(primeiraParte());
            }

        }

        StringBuilder mostrarUm = new StringBuilder();

        for (String um : listaUm) {
            mostrarUm.append(um);
            mostrarUm.append("\n");
        }

        return mostrarUm.toString();
    }

    //Construindo a segunda parte da música
    private static String musicaDois() {

        String parteCorpo = "";

        String[] listaCorpo = {"Braço Direito", "Braço Esquerdo", "Perna Direita",
                "Perna Esquerda", "Balança a cabeça", "dá uma voltinha",
                "Dá um pulinho", "e abraça o irmão"};

        ArrayList<String> listaDois = new ArrayList<>();

        for (int i = 0; i < listaCorpo.length; i++) {

            switch (i) {
                case 0:
                    listaDois.add(quartaParte());
                    parteCorpo += (listaCorpo[i]);
                    break;

                case 2:
                    listaDois.add(quartaParte(i, " (Até que eu tô em forma)"));
                    parteCorpo += (listaCorpo[i]);
                    break;

                case 4:
                    listaDois.add(quartaParte(i, " (muitos filhos)", " (Que saudade dessa música)"));
                    parteCorpo += (listaCorpo[i]);
                    break;

                case 1, 3, 5:
                    listaDois.add(quartaParte());
                    parteCorpo += ", " + (listaCorpo[i]) + "\n";
                    break;

                case 6:
                    listaDois.add(quartaParte(i, " (Bonita Cruz)"));
                    parteCorpo += (listaCorpo[i]);
                    break;

                case 7:
                    listaDois.add(quartaParte(i, " (Para não)"));
                    parteCorpo += " " + (listaCorpo[i]) + "\n";
                    break;

            }
            listaDois.add(parteCorpo);
        }

        StringBuilder mostrarDois = new StringBuilder();

        for (String dois : listaDois) {
            mostrarDois.append(dois);
            mostrarDois.append("\n");
        }

        return mostrarDois.toString();

    }

}
