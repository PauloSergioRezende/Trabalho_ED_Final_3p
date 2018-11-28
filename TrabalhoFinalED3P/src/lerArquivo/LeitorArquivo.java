package lerArquivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import dados.ItemArvoreBin;

public class LeitorArquivo {
	
	public static List<ItemArvoreBin> leArquivo(String arq) {

		File f = new File(arq);

		Scanner sc = null;

		List<ItemArvoreBin> ItemArvoreBins = new ArrayList<ItemArvoreBin>();

		System.out.println("Existe? " + f.exists() + "  \n" + f.getAbsolutePath());

		try {
			sc = new Scanner(f);

			while (sc.hasNextLine()) {
				String linha = sc.nextLine();
				StringTokenizer st = new StringTokenizer(linha, "*");
				while (st.hasMoreElements()) {

					ItemArvoreBin m = new ItemArvoreBin(st.nextToken(), Long.valueOf(st.nextToken()),
							Integer.valueOf(st.nextToken()), Long.valueOf(st.nextToken()), st.nextToken());

					ItemArvoreBins.add(m);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ItemArvoreBins;

	}
}
