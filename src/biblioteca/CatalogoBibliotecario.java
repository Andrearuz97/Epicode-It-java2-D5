package biblioteca;

import java.util.List;
import java.util.Scanner;

import biblioteca.modello.ElementoBibliotecario;
import biblioteca.modello.Libro;
import biblioteca.modello.Rivista;
import biblioteca.persistence.CatalogoPersistence;
import biblioteca.servizi.CatalogoServizio;

public class CatalogoBibliotecario {
	public static void main(String[] args) {
		CatalogoServizio catalogoServizio = new CatalogoServizio();
		CatalogoPersistence catalogoPersistence = new CatalogoPersistence();

		Libro libro1 = new Libro("9788804686614", "1984", 1949, 328, "George Orwell", "Romanzo distopico");
		Libro libro2 = new Libro("9788806222092", "Il piccolo principe", 1943, 96, "Antoine de Saint-Exupéry",
				"Romanzo");
		Libro libro3 = new Libro("9788807902388", "Cronaca di una morte annunciata", 1981, 120,
				"Gabriel García Márquez", "Romanzo");
		Libro libro4 = new Libro("9788807882253", "Cent'anni di solitudine", 1967, 432, "Gabriel García Márquez",
				"Romanzo");
		Libro libro5 = new Libro("9788804668238", "Il signore degli anelli", 1954, 1137, "J.R.R. Tolkien", "Fantasy");
		Libro libro6 = new Libro("9788804683767", "Harry Potter e la pietra filosofale", 1997, 223, "J.K. Rowling",
				"Fantasy");
		Libro libro7 = new Libro("9788804662946", "Il nome della rosa", 1980, 552, "Umberto Eco", "Romanzo giallo");
		Libro libro8 = new Libro("9788804546116", "Orgoglio e pregiudizio", 1813, 416, "Jane Austen", "Romanzo");
		Libro libro9 = new Libro("9788804671542", "Cime tempestose", 1847, 450, "Emily Brontë", "Romanzo gotico");
		Libro libro10 = new Libro("9788806229305", "Il vecchio e il mare", 1952, 127, "Ernest Hemingway", "Romanzo");

		Rivista rivista1 = new Rivista("9772282980001", "National Geographic", 2021, 150, "mensile");
		Rivista rivista2 = new Rivista("9770005550004", "Vanity Fair", 2023, 100, "settimanale");
		Rivista rivista3 = new Rivista("9770216716004", "Time", 1923, 64, "settimanale");
		Rivista rivista4 = new Rivista("9771123778007", "Scientific American", 1845, 84, "mensile");
		Rivista rivista5 = new Rivista("9770003637001", "The New Yorker", 1925, 96, "settimanale");
		Rivista rivista6 = new Rivista("9770393197009", "Forbes", 1917, 132, "mensile");
		Rivista rivista7 = new Rivista("9771720065008", "Wired", 1993, 100, "semestrale");
		Rivista rivista8 = new Rivista("9771594022007", "National Geographic Italia", 1999, 140, "mensile");
		Rivista rivista9 = new Rivista("9770012910007", "Harvard Business Review", 1922, 80, "semestrale");
		Rivista rivista10 = new Rivista("9770003962003", "New Scientist", 1956, 64, "settimanale");

		catalogoServizio.aggiungiElemento(libro1);
		catalogoServizio.aggiungiElemento(libro2);
		catalogoServizio.aggiungiElemento(libro3);
		catalogoServizio.aggiungiElemento(libro4);
		catalogoServizio.aggiungiElemento(libro5);
		catalogoServizio.aggiungiElemento(libro6);
		catalogoServizio.aggiungiElemento(libro7);
		catalogoServizio.aggiungiElemento(libro8);
		catalogoServizio.aggiungiElemento(libro9);
		catalogoServizio.aggiungiElemento(libro10);
		catalogoServizio.aggiungiElemento(rivista1);
		catalogoServizio.aggiungiElemento(rivista2);
		catalogoServizio.aggiungiElemento(rivista3);
		catalogoServizio.aggiungiElemento(rivista4);
		catalogoServizio.aggiungiElemento(rivista5);
		catalogoServizio.aggiungiElemento(rivista6);
		catalogoServizio.aggiungiElemento(rivista7);
		catalogoServizio.aggiungiElemento(rivista8);
		catalogoServizio.aggiungiElemento(rivista9);
		catalogoServizio.aggiungiElemento(rivista10);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Seleziona il tipo di elemento da cercare:");
		System.out.println("1. Libro");
		System.out.println("2. Rivista");
		System.out.print("Scelta: ");
		int scelta = scanner.nextInt();
		scanner.nextLine();

		String modalitaRicerca = "";
		switch (scelta) {
		case 1:
			System.out.println("Modalità di ricerca per il libro:");
			System.out.println("1. Ricerca per titolo");
			System.out.println("2. Ricerca per autore");
			System.out.println("3. Ricerca per ISBN");
			System.out.print("Scelta: ");
			int sceltaLibro = scanner.nextInt();
			scanner.nextLine();

			switch (sceltaLibro) {
			case 1:
				modalitaRicerca = "titolo";
				break;
			case 2:
				modalitaRicerca = "autore";
				break;
			case 3:
				modalitaRicerca = "ISBN";
				break;
			default:
				System.out.println("Scelta non valida. Verrà effettuata la ricerca per titolo.");
				modalitaRicerca = "titolo";
				break;
			}
			break;
		case 2:
			System.out.println("Modalità di ricerca per la rivista:");
			System.out.println("1. Ricerca per titolo");
			System.out.println("2. Ricerca per ISBN");
			System.out.print("Scelta: ");
			int sceltaRivista = scanner.nextInt();
			scanner.nextLine(); // Consuma il carattere newline dopo la lettura dell'intero

			switch (sceltaRivista) {
			case 1:
				modalitaRicerca = "titolo";
				break;
			case 2:
				modalitaRicerca = "ISBN";
				break;
			default:
				System.out.println("Scelta non valida. Verrà effettuata la ricerca per titolo.");
				modalitaRicerca = "titolo";
				break;
			}
			break;
		default:
			System.out.println("Scelta non valida. Verrà effettuata la ricerca per titolo.");
			modalitaRicerca = "titolo";
			break;
		}

		System.out.print("Inserisci il " + modalitaRicerca + " da cercare: ");
		String valoreRicerca = scanner.nextLine();
		List<ElementoBibliotecario> elementiTrovati = null;
		switch (scelta) {
		case 1:
			switch (modalitaRicerca) {
			case "titolo":
				elementiTrovati = catalogoServizio.ricercaPerTitoloLibro(valoreRicerca);
				break;
			case "autore":
				elementiTrovati = catalogoServizio.ricercaPerAutore(valoreRicerca);
				break;
			case "ISBN":
				Libro libroTrovato = catalogoServizio.ricercaPerISBNLibro(valoreRicerca);
				if (libroTrovato != null) {
					elementiTrovati = List.of(libroTrovato);
				}
				break;
			default:
				break;
			}
			break;
		case 2:
			switch (modalitaRicerca) {
			case "titolo":
				elementiTrovati = catalogoServizio.ricercaPerTitoloRivista(valoreRicerca);
				break;
			case "ISBN":
				Rivista rivistaTrovata = catalogoServizio.ricercaPerISBNRivista(valoreRicerca);
				if (rivistaTrovata != null) {
					elementiTrovati = List.of(rivistaTrovata);
				}
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}

		if (elementiTrovati != null && !elementiTrovati.isEmpty()) {
			System.out.println("Elementi trovati per " + modalitaRicerca + " " + valoreRicerca + ":");
			for (ElementoBibliotecario elemento : elementiTrovati) {
				System.out.println(elemento.getTitolo());
			}
		} else {
			System.out.println("Nessun elemento trovato per " + modalitaRicerca + " " + valoreRicerca);
		}

		scanner.close();

		String filePath = "catalogo.dat";
		catalogoPersistence.salvataggioSuDisco(catalogoServizio.getCatalogo(), filePath);
		System.out.println("Catalogo salvato su disco.");

		List<ElementoBibliotecario> catalogoCaricato = catalogoPersistence.caricamentoDaDisco(filePath);
		if (catalogoCaricato != null) {
			System.out.println("Catalogo caricato da disco:");
			for (ElementoBibliotecario elemento : catalogoCaricato) {
				System.out.println(elemento.getTitolo());
			}
		} else {
			System.out.println("Errore nel caricamento del catalogo da disco.");
		}
	}
}