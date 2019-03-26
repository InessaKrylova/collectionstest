import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.util.Map.Entry;

public class App {
	public static void main(String[] args) {
		processFile("resources/file.txt");
	}

	public static void processFile(String path) {
		List<String> words = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(path))) {
			while (scanner.hasNextLine()) {
				String wordWithoutPunctuation = scanner.next().replaceAll("[^А-Яа-яё]", "");
				words.add(wordWithoutPunctuation.toLowerCase());
			}
			//System.out.println(words.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		searchForDuplicates(words, new LinkedHashMap<String, Integer>());
		searchForDuplicates(words, new HashMap<String, Integer>());
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

		stopWatch.getTime(wordsDuplicates.getClass().getName());

		//printMap(wordsDuplicates);
	}

	public void printMap(HashMap<String, Integer> wordsDuplicates) {
		for (Entry<String, Integer> entry : wordsDuplicates.entrySet()) {
			System.out.println("["+entry.getKey()+": "+entry.getValue()+"]");
		}
	}

}
