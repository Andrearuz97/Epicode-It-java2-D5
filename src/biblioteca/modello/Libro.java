package biblioteca.modello;

import java.io.Serializable;

public class Libro implements ElementoBibliotecario, Serializable {
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	private String autore;
	private String genere;

	public Libro(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		this.ISBN = ISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String getISBN() {
		return ISBN;
	}

	@Override
	public String getTitolo() {
		return titolo;
	}

	@Override
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	@Override
	public int getNumeroPagine() {
		return numeroPagine;
	}

	public String getAutore() {
		return autore;
	}

	public String getGenere() {
		return genere;
	}
}
