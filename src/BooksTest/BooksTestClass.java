package BooksTest;

import java.util.Arrays;
import java.util.List;

public class BooksTestClass {

    public static final String TRADE_MARK = "Первый механизированный имени царя батюшки с дозволения божьего печатный двор!";

    public static void main(String[] args) {
        Publisher tsarskiyPechatniyDvor = new Publisher(1000L, TRADE_MARK);

        Author dostoevskiy = new Author(1L, "Fedor", "Dostoevskiy");
        Book karamazovi = new Book(10L, "Karomazovi Brothers", 1202, dostoevskiy, tsarskiyPechatniyDvor);
        Book idiot = new Book(11L, "Idiot", 792, dostoevskiy, tsarskiyPechatniyDvor);
        Book prestuplenieNakazanie = new Book(12L, "Crime and punishment", 1053, dostoevskiy, tsarskiyPechatniyDvor);
        dostoevskiy.setBooks(Arrays.asList(karamazovi, idiot, prestuplenieNakazanie));

        Author tolstoy = new Author(2L, "Leo", "Tolstoy");
        Book voinaMir = new Book(20L, "War and peace", 3113, tolstoy, tsarskiyPechatniyDvor);
        Book karenina = new Book(21L, "Anna Karenina", 1423, tolstoy, tsarskiyPechatniyDvor);
        Book detstvo = new Book(22L, "Detstvo", 786, tolstoy, tsarskiyPechatniyDvor);
        Book detstvoCopy = new Book(23L, "Detstvo", 786, tolstoy, tsarskiyPechatniyDvor);
        tolstoy.setBooks(Arrays.asList(voinaMir, karenina, detstvo, detstvoCopy));

        Author gogol = new Author(3L, "Nikiloy", "Gogal");
        Book vecheraDekanky = new Book(30L, "Evenings on a farm near Dikanka", 1423, gogol, tsarskiyPechatniyDvor);
        Book mertvieDushi = new Book(31L, "Dead souls", 1243, gogol, tsarskiyPechatniyDvor);
        Book revizor = new Book(32L, "Controller", 892, gogol, tsarskiyPechatniyDvor);
        Book revizorCopy = new Book(32L, "Controller", 892, gogol, tsarskiyPechatniyDvor);
        gogol.setBooks(Arrays.asList(vecheraDekanky, mertvieDushi, revizor, revizorCopy));


        /* add to TreeSet, and to HashSet
         * print all books in set
         * see two copy of detstvo and revizor
         * implement hashcode and equals the way
         * that there will be only 2 copy of detstvo
         */

    }
}