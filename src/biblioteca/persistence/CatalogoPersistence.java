package biblioteca.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import biblioteca.modello.ElementoBibliotecario;

public class CatalogoPersistence {
	public void salvataggioSuDisco(List<ElementoBibliotecario> catalogo, String filePath) {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
			out.writeObject(catalogo);
			System.out.println("Salvataggio del catalogo su disco completato.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<ElementoBibliotecario> caricamentoDaDisco(String filePath) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
			Object obj = in.readObject();
			if (obj instanceof List<?>) {
				List<?> catalogo = (List<?>) obj;
				if (!catalogo.isEmpty() && catalogo.get(0) instanceof ElementoBibliotecario) {
					System.out.println("Caricamento del catalogo da disco completato.");
					return castToElementoBibliotecarioList(catalogo);

				}
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private List<ElementoBibliotecario> castToElementoBibliotecarioList(List<?> catalogo) {
		return (List<ElementoBibliotecario>) catalogo;
	}

}
