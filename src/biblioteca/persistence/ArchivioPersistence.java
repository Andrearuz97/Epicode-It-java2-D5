package biblioteca.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import biblioteca.modello.ElementoBibliotecario;

public class ArchivioPersistence {
	public void salvataggioSuDisco(List<ElementoBibliotecario> catalogo, String filePath) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
			out.writeObject(catalogo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ElementoBibliotecario> caricamentoDaDisco(String filePath) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
			return castToElementoBibliotecarioList(in.readObject());

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private List<ElementoBibliotecario> castToElementoBibliotecarioList(Object obj) {
		if (obj instanceof List<?>) {
			return (List<ElementoBibliotecario>) obj;
		}
		return null;
	}

}
