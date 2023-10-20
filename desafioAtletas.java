import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String maisAlto = "";
		int contadorM = 0;
		int contadorF = 0;
		double testeAltura = 0;
		double alturaF = 0;
		double pesoTotal = 0;
		double altura = 0;
		double peso = 0;
		double pesoMedio = 0;
		double mediaF = 0;

		System.out.println("Qual a quantidade de atletas: ");
		int N = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			System.out.printf("Digite os dados do atleta numero %d : ", i);

			System.out.print("Nome: ");
			String nome = sc.next();
			sc.nextLine();

			System.out.print("Sexo: ");
			char sexo = sc.next().charAt(0);
			while (sexo != 'F' && sexo != 'M') {
				System.out.println("Valor inválido! Favor digitar F ou M: ");
				sexo = sc.next().charAt(0);
			}

			System.out.print("Altura: ");
			altura = sc.nextDouble();
			if (sexo == 'M' && altura > testeAltura) {
				testeAltura = altura;
				maisAlto = nome;
			} else {
				testeAltura = testeAltura;
			}
			while (altura <= 0) {
				System.out.println("Valor inválido! Favor digitar um valor positivo: ");
				altura = sc.nextDouble();
			}
			if (sexo == 'M') {
				contadorM = contadorM + 1;
			} else if (sexo == 'F') {
				contadorF = contadorF + 1;
				alturaF = alturaF + altura;
			}

			System.out.print("Peso: ");
			peso = sc.nextDouble();
			while (peso <= 0) {
				System.out.println("Valor inválido! Favor digitar um valor positivo: ");
				peso = sc.nextDouble();
			}
			pesoTotal = pesoTotal + peso;
			pesoMedio = pesoTotal / N;
		}

		double porcenM = (contadorM * 100) / N;

		System.out.println("RELATÓRIO: ");

		System.out.println("");

		System.out.printf("Peso médio dos atletas: %.2f%n", pesoMedio);

		System.out.printf("Atleta mais alto: %s%n", maisAlto);

		System.out.printf("Porcentagem dos homens: %.2f%%%n", porcenM);

		if (contadorF == 0) {
			System.out.println("Não há mulheres cadastradas");
		} else {
			mediaF = alturaF / contadorF;
			System.out.printf("Altura média das mulheres: %.2f%n", mediaF);
		}

		sc.close();
	}

}
