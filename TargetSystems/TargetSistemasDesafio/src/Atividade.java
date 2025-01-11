import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.json.*;

public class Atividade {
    Scanner scan = new Scanner(System.in);

    public void q1() {
        int indice = 13;
        int soma = 0, k = 0;

       for (k = 0; k < indice; k++) {
           soma = k + soma;
       }

        System.out.println(soma);
    }

    public void q2() {

        System.out.println("Insira o valor a ser buscado");
        int a = scan.nextInt();
        int value = scan.nextInt();

        System.out.println("insira o valor ate onde sera gerado a sequencia");
        int x = value;
        int n1 = 1, n2 = 1;

        x = x - 2;

        while (x > 0) {
            if (n2 == a) {
                System.out.println(a + " existe na sequencia");

                return;
            }

            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            x--;
        }
    }

    public void q3() throws FileNotFoundException {
        calcularFaturamento();
    }

    public static void calcularFaturamento() throws FileNotFoundException {

        InputStream fis = new FileInputStream("dados.json");

        JsonReader reader = Json.createReader(fis);

        JsonArray faturamentoObject = reader.readArray();

        reader.close();

        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");

        double menorFaturamento = Double.MAX_VALUE, maiorFaturamento = Double.MIN_VALUE, somaFaturamento = 0;
        int diasComFaturamento = 0;

        List <Faturamento> faturamentos = new ArrayList<>();

        for (int i = 0; i < faturamentoObject.size(); i++) {
            JsonObject  fJSON = (JsonObject) faturamentoObject.get(i);

            JsonNumber jasonValue = fJSON.getJsonNumber("valor");

            Faturamento faturamento = new Faturamento(fJSON.getInt("dia"), jasonValue.doubleValue());

            faturamentos.add(faturamento);

            double valor = faturamento.getValor();
            if (valor > 0) {
                menorFaturamento = Math.min(menorFaturamento, valor);
                maiorFaturamento = Math.max(maiorFaturamento, valor);
                somaFaturamento += valor;
                diasComFaturamento++;
            }
        }

        double mediaMensal = somaFaturamento / diasComFaturamento;

        int diasAcimaDaMedia = 0;
        for (Faturamento faturamento : faturamentos) {
            if (faturamento.getValor() > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Dados em JSON: " + faturamentoObject);
        System.out.println("Menor valor de faturamento: " + menorFaturamento);
        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
        System.out.println("Número de dias com faturamento superior à média: " + diasAcimaDaMedia);
    }

    public static class Faturamento {
        private int dia;
        private double valor;

        public Faturamento(int dia, double valor) {
            this.dia = dia;
            this.valor = valor;
        }

        public int getDia() {
            return dia;
        }

        public double getValor() {
            return valor;
        }
    }

    public void q4() {
        String[] states = {"SP", "RJ", "MG", "ES", "OUTROS"};
        double[] faturamento = {67836.43, 36678.66, 29229.88, 27165.48, 19849.53};


        double faturamentoTotal = 0;
        for (double valor : faturamento) {
            faturamentoTotal += valor;
        }

        System.out.printf("O faturamento total da Distribuidora foi: R$ %.2f%n", faturamentoTotal);


        for (int i = 0; i < faturamento.length; i++) {
            double percentual = (faturamento[i] / faturamentoTotal) * 100;
            System.out.printf("O percentual de faturamento de %s é: %.2f %%\n", states[i], percentual);
        }
    }

    public void q5(){
        System.out.print("Digite uma string para inverter: ");
        String scanner = scan.nextLine();


        char[] characters = scanner.toCharArray();

        for (int i = 0, j = characters.length - 1; i < j; i++, j--) {
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }

        String inverted = new String(characters);


        System.out.println("String invertida: " + inverted);
    }
}
