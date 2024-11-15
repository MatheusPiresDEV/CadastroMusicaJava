import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Album> albuns = new ArrayList<>();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar Álbuns");
            System.out.println("2 - Listar Álbuns, Músicas e Notas");

            try {
                int opcao = scanner.nextInt();

                if (opcao == 0) {
                    System.out.println("Encerrando o programa.");
                    break;
                } else if (opcao == 1) {

                    Album album = new Album();
                    scanner.nextLine();
                    System.out.print("Digite o nome do álbum: ");
                    album.nome = scanner.nextLine();
                    System.out.print("Quantas músicas tem o álbum? ");
                    int numMusicas = scanner.nextInt();

                    for (int i = 0; i < numMusicas; i++) {
                        scanner.nextLine();
                        System.out.print("Nome da música " + (i + 1) + ": ");
                        album.musicas.add(scanner.nextLine());
                        System.out.print("Nota da música " + (i + 1) + " (0 a 10): ");
                        album.notas.add(scanner.nextDouble());
                    }

                    albuns.add(album);
                } else if (opcao == 2) {
                    System.out.println("Álbuns cadastrados:");
                    for (Album album : albuns) {
                        System.out.println("Álbum: " + album.nome);
                        for (int i = 0; i < album.musicas.size(); i++) {
                            System.out.println("  Música: " + album.musicas.get(i) + " - Nota: " + album.notas.get(i));
                        }
                    }
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Certifique-se de inserir um número inteiro.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }
}