package biblioteca.modello;

import java.io.Serializable;

public class Rivista implements ElementoBibliotecario, Serializable {
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	private String periodicità;

	public Rivista(String ISBN, String titolo, int annoPubblicazione, int numeroPagine, String periodicità) {
		this.ISBN = ISBN;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
		this.periodicità = periodicità;
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

	public String getPeriodicita() {
		return periodicità;
	}
}
