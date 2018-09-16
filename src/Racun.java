import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Racun {
	private int brojRacuna;
	private String ime;
	private int brojKnjiga = 0;

	// constructors

	Racun() {

	}

	public Racun(int brojRacuna, String ime) {
		this.brojRacuna = brojRacuna;
		this.ime = ime;
	}

	public Racun(int brojRacuna, String ime, int brojKnjiga) {
		this.brojRacuna = brojRacuna;
		this.ime = ime;
		this.brojKnjiga = brojKnjiga;
	}

	// getters

	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getIme() {
		return ime;
	}

	// setters

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getBrojKnjiga() {
		return brojKnjiga;
	}

	public void setBrojKnjiga(int brojKnjiga) {
		this.brojKnjiga = brojKnjiga;
	}

	// methods

	public void povecajBrojPosudjenihKnjiga() {
		if (brojKnjiga < 3) {
			brojKnjiga += 1;
		} else {
			System.out.println("Dozvoljeno je podiæi samo tri knjige!");
		}
	}

	public void smanjiBrojPosudjenihKnjiga() {
		if (brojKnjiga > 0) {
			brojKnjiga -= 1;
		} else {
			System.out.println("Nemate posudjenih knjiga");
		}
	}

	public void info() {
		System.out.println("Broj racuna: " + getBrojRacuna() + "\nIme korisnika: " + getIme()
				+ "\nBroj posudjenih knjiga: " + getBrojKnjiga());
	}

	public void upisInFile() throws FileNotFoundException {
		File racuni = new File(getIme() + ".txt");
		PrintWriter pw = new PrintWriter(racuni);
		pw.println("Broj racuna: " + getBrojRacuna() + "\n|Ime: " + getIme() + "\n|Broj posudjenih knjiga: "
				+ getBrojKnjiga());
		pw.flush();
		pw.close();
	}
}
