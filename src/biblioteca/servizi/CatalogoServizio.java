package biblioteca.servizi;

import java.util.ArrayList;
import java.util.List;

import biblioteca.modello.ElementoBibliotecario;
import biblioteca.modello.Libro;
import biblioteca.modello.Rivista;

public class CatalogoServizio {
	private List<ElementoBibliotecario> catalogo = new ArrayList<>();

	public void aggiungiElemento(ElementoBibliotecario elemento) {
		catalogo.add(elemento);
	}

	public void rimuoviElemento(String ISBN) {
		catalogo.removeIf(e -> e.getISBN().equals(ISBN));
	}

	public ElementoBibliotecario ricercaPerISBN(String ISBN) {
		return catalogo.stream().filter(e -> e.getISBN().equals(ISBN)).findFirst().orElse(null);
	}

	public Libro ricercaPerISBNLibro(String ISBN) {
		return catalogo.stream().filter(e -> e instanceof Libro && e.getISBN().equals(ISBN)).map(e -> (Libro) e)
				.findFirst().orElse(null);
	}

	public List<ElementoBibliotecario> ricercaPerAnnoPubblicazione(int anno) {
		return catalogo.stream().filter(e -> e.getAnnoPubblicazione() == anno).toList();
	}

	public List<ElementoBibliotecario> ricercaPerAutore(String autore) {
		return catalogo.stream().filter(e -> e instanceof Libro && ((Libro) e).getAutore().equals(autore)).toList();
	}

	public List<ElementoBibliotecario> ricercaPerTitoloLibro(String titolo) {
		return catalogo.stream().filter(e -> e instanceof Libro && e.getTitolo().equalsIgnoreCase(titolo)).toList();
	}

	public List<ElementoBibliotecario> ricercaPerTitoloRivista(String titolo) {
		return catalogo.stream().filter(e -> e instanceof Rivista && e.getTitolo().equalsIgnoreCase(titolo)).toList();
	}

	public Rivista ricercaPerISBNRivista(String ISBN) {
		return catalogo.stream().filter(e -> e instanceof Rivista && e.getISBN().equals(ISBN)).map(e -> (Rivista) e)
				.findFirst().orElse(null);
	}

	public List<ElementoBibliotecario> getCatalogo() {
		return catalogo;
	}
}
