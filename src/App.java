import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class App {
	public static void main(String[] args) {
		processFile("resources/file.txt");
	}

	public static void processFile(String path) {
		List<String> words = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(path))) {
			while (scanner.hasNextLine()) {
				String wordWithoutPunctuation = scanner.next().replaceAll("[^А-Яа-яё]", "").toLowerCase();
				if (!wordWithoutPunctuation.isEmpty()) {
					words.add(wordWithoutPunctuation);
				}
			}

			searchForDuplicates(words, new LinkedHashMap<String, Integer>());
			searchForDuplicates(words, new HashMap<String, Integer>());
		} catch (FileNotFoundException e) {
			System.out.println("Error! File with text for parsing isn`t found");
		}
	}

	public static void searchForDuplicates(List<String> words, HashMap<String, Integer> wordsDuplicates) {
		StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		for (String word : words) {
			if (wordsDuplicates.containsKey(word)) {
				int countBefore = wordsDuplicates.get(word);
				wordsDuplicates.put(word, ++countBefore);
			}
			else {
				wordsDuplicates.put(word, 1);
			}
		}
		stopWatch.end();
		stopWatch.printTime(wordsDuplicates.getClass().getName());

		printMap(wordsDuplicates);
	}

	public static void printMap(Map<String, Integer> wordsDuplicates) {
		for (Entry<String, Integer> entry : wordsDuplicates.entrySet()) {
			System.out.print("["+entry.getKey()+": "+entry.getValue()+"] ");
		}
		System.out.println();
	}

}
