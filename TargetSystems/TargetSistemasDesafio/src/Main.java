import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Atividade atividade = new Atividade();
        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha uma opcao: ");
        System.out.println("Q1");
        System.out.println("Q2");
        System.out.println("Q3");
        System.out.println("Q4");
        System.out.println("Q5");
        int choice = scan.nextInt();

        switch (choice) {
            case (1):
                System.out.println("q1");
                atividade.q1();

                break;

            case (2):
                System.out.println("q2");
                atividade.q2();

                break;

            case (3):
                System.out.println("q3");
                atividade.q3();

                break;

            case (4):
                System.out.println("q4");
                atividade.q4();

                break;

            case (5):
                System.out.println("q5");
                atividade.q5();

                break;
        }
    }
}