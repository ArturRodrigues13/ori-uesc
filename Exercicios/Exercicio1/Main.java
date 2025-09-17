package Exercicios.Exercicio1;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

	public static File CriarDiretorio(String path) {

		File diretorio = new File(path);

		boolean status = diretorio.mkdir();

		if (status) {

			return diretorio;
		} else {

			return null;
		}
	}

	public static void CriarSubDiretorio(String path, String nome) {

		File subDir = new File(path,nome);

		subDir.mkdir();

		if(subDir.exists()) System.out.println("Criado com sucesso!");
	}

	public static File CriarArquivo(String path, String fileName) throws IOException {

		fileName += ".txt";

		try {
			File arquivo = new File(path, fileName);

			boolean status = arquivo.createNewFile();

			if(status) {
				return arquivo;

			} else return null;

		} catch (IOException e) {
			e.printStackTrace();

			return null;
		}
	}

	public static boolean DiretorioExiste(File diretorio) {

		boolean status = diretorio.exists();

		return status;
	}

	public static boolean ArquivoExiste(File arquivo) {

		boolean status = arquivo.exists();

		return status;
	}

	public static void ListaArquivos(File diretorio) throws IOException {

		String[] arquivos = diretorio.list();

		for (int i = 0; i < arquivos.length; i++) {

			File filho = new File(diretorio, arquivos[i]);
			System.out.println(filho.getAbsolutePath());
		}
	}

	public static boolean RenomearArquivo(String path, File arquivo, String novoNome) {

		novoNome += ".txt";

		File novoArquivo = new File(path, novoNome);

		boolean status = arquivo.renameTo(novoArquivo);

		return status;
	}

	public static void StatusDiretorio(File diretorio) {

		boolean status = diretorio.exists();

		JOptionPane.showMessageDialog(null, "Diretório Existe" + status);

		if (status) {

			String nome = diretorio.getName();

			JOptionPane.showMessageDialog(null, "Nome da pasta: " + nome);

			String parent = diretorio.getParent();

			JOptionPane.showMessageDialog(null, "Caminho Pai da pasta: " + parent);

			String caminho = diretorio.getAbsolutePath();

			JOptionPane.showMessageDialog(null, "Caminho para a pasta: " + caminho);

			long tamanho = diretorio.list().length;

			JOptionPane.showMessageDialog(null, "Quantidade de arquivos ou diretórios na pasta: " + tamanho);
		}
	}

	public static void main(String[] args) throws Exception {

		Scanner input = new Scanner(System.in);

		System.out.println("Vamos fazer umas operações com arquivos!");

		String path = "C:\\Teste";

		File diretorio = CriarDiretorio(path);

		if(diretorio != null) {

			System.out.println("Primeiro diretório criado com sucesso!");

			System.out.println("Vamos fazer um arquivo agora, digite um nome para ele (não precisa colocar a extensão)");

			String nome = input.nextLine();

			File arquivo = CriarArquivo(path, nome);

			if(ArquivoExiste(arquivo)) {

				System.out.println("Arquivo criado com sucesso!");
			} else {

				System.out.println("Erro ao criar arquivo!");
			}

			System.out.println("Vamos criar umas subpastas em nossa pasta base, me dê um nome pra primeira: ");

			nome = input.nextLine();

			CriarSubDiretorio(path, nome);

			System.out.println("Outro nome agora: ");

			nome = input.nextLine();

			CriarSubDiretorio(path, nome);

			System.out.println("Bacana, vamos ver o que temos na nossa pasta até o momento");

			ListaArquivos(diretorio);

			System.out.println("Beleza, agora vamos renomear o arquivo que você criou anteriormente, digite o novo nome (sem extensão)");

			nome = input.nextLine();

			if(RenomearArquivo(path, arquivo, nome)) {

				System.out.println("Renomeado com sucesso!");
			} else {

				System.out.println("Erro ao renomear!");
			}

			input.close();

			System.out.println("Okay, agora vamos ver alguns status com janelas sobre sua pasta (Clique em ok na janela que irá aparecer para continuar)");

			StatusDiretorio(diretorio);
		}

		input.close();
	}
}
