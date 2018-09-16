import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Knjiga {
	private int brojKnjige;
	private String imeKnjige;
	private boolean status = true;

	// contructors

	Knjiga() {

	}

	public Knjiga(int brojKnjige, String imeKnjige) {
		this.brojKnjige = brojKnjige;
		this.imeKnjige = imeKnjige;

	}

	public Knjiga(int brojKnjige, String imeKnjige, boolean status) {
		this.brojKnjige = brojKnjige;
		this.imeKnjige = imeKnjige;
		this.status = status;
	}

	// getters

	public int getBrojKnjige() {
		return brojKnjige;
	}

	public void setBrojKnjige(int brojKnjige) {
		this.brojKnjige = brojKnjige;
	}

	public String getImeKnjige() {
		return imeKnjige;
	}

	// setters

	public void setImeKnjige(String imeKnjige) {
		this.imeKnjige = imeKnjige;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	// methods

	public void podigniKnjigu() {
		setStatus(false);
	}

	public void vratiKnjigu() {
		setStatus(true);
	}

	public void info() {
		System.out.println("Broj knjige: " + getBrojKnjige() + "\nIme knjige: " + getImeKnjige());
		if (isStatus() == true) {
			System.out.println("Knjiga je dostupna");
		} else {
			System.out.println("Knjiga nije dostupna");
		}
	}

	public void writeInFile() throws FileNotFoundException {
		File knjige = new File(getImeKnjige() + ".txt");
		PrintWriter pw = new PrintWriter(knjige);
		pw.println("Broj knjige: " + getBrojKnjige() + "\r|Ime knjige: " + getImeKnjige());
		if (isStatus() == true) {
			pw.println("Knjiga je dostupna");
		} else {
			pw.println("Knjiga nije dostupna");
		}
		pw.flush();
		pw.close();
	}
}
