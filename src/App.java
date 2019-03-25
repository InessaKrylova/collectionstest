import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class App {
	public static void main(String[] args) {
		readFile("resources/file.txt");
	}

	public static void readFile(String path) {
		List<String> words = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(path))) {
			while (scanner.hasNextLine()) {
				String wordWithoutPunctuation = scanner.next().replaceAll("[^А-Яа-яё]", "");
				words.add(wordWithoutPunctuation);
			}
			System.out.println(words.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//http://qaru.site/questions/651601/finding-repeated-words-on-a-string-and-counting-the-repetitions
}
