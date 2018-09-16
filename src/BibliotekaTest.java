import java.util.ArrayList;
import java.util.Scanner;

public class BibliotekaTest {

	static ArrayList<Racun> racuni = new ArrayList<>();
	static ArrayList<Knjiga> knjige = new ArrayList<>();

	public static void main(String[] args) {

		int izbor = -1;
		Racun racun;
		Knjiga knjiga;
		int idKorisnika = 0;
		int idKnjige = 0;

		Scanner unos = new Scanner(System.in);
		Scanner input = new Scanner(System.in);

		System.out.println("============================\nWELLCOME TO LIBRARY\n============================");

		while (izbor != 0) {
			System.out.println(
					"1) Kreiraj račun \n2) Kreiraj knjigu \n3) Informacije o korisniku \n4) Informacije o knjizi"
							+ "\n5) Podigni knjigu \n6) Vrati knjigu \n7) Upisi korisnike u fajl \n8) Upisi knjige u fajl \n0) Izlaz \nIzaberite opciju: ");

			switch (izbor = unos.nextInt()) {
			case 0:
				break;
			case 1:
				do {
					racun = new Racun();
				} while (existUser(racun.getBrojRacuna()));
				System.out.println("Unesite broj racuna: ");
				racun.setBrojRacuna(unos.nextInt());
				System.out.print("Upisite vase ime: ");
				String ime = input.nextLine();
				racun.setIme(ime);
				racuni.add(racun);
				break;
			case 2:
				do {
					knjiga = new Knjiga();
				} while (existBook(knjiga.getBrojKnjige()));
				System.out.println("Unesite broj knjige: ");
				knjiga.setBrojKnjige(unos.nextInt());
				System.out.print("Unesite ime knjige: ");
				String imeKnjige = input.nextLine();
				knjiga.setImeKnjige(imeKnjige);
				knjige.add(knjiga);
				break;
			case 3:
				System.out.print("Upiste broj racuna: ");
				idKorisnika = unos.nextInt();
				if (existUser(idKorisnika) == false) {
					System.out.println("Korisnik sa unijetim brojem ne postoji!");
				}

				for (int i = 0; i < racuni.size(); i++) {
					if (racuni.get(i).getBrojRacuna() == idKorisnika) {
						racuni.get(i).info();
					}
				}
				break;
			case 4:
				do {
					System.out.println("Upisite broj knjige: ");
					idKnjige = input.nextInt();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < knjige.size(); i++) {
					if (knjige.get(i).getBrojKnjige() == idKnjige) {
						knjige.get(i).info();
					}
				}
				break;
			case 5:
				do {
					System.out.println("Upiste broj korisnika koji podize knjigu: ");
					idKorisnika = unos.nextInt();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				do {
					System.out.println("Upisite broj knjige koju korisnik dize: ");
					idKnjige = unos.nextInt();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < knjige.size(); i++) {
					if (knjige.get(i).getBrojKnjige() == idKnjige) {
						Knjiga knjigaZaPodizanje = knjige.get(i);
						if (knjigaZaPodizanje.isStatus() == true) {
							knjigaZaPodizanje.podigniKnjigu();
							for (int j = 0; j < racuni.size(); j++) {
								if (racuni.get(j).getBrojRacuna() == idKorisnika) {
									Racun korisnikKojiPodizeKjigu = racuni.get(j);
									korisnikKojiPodizeKjigu.povecajBrojPosudjenihKnjiga();
									;
								}
							}
						} else {
							System.out.println("Knjiga je vec podignuta!");
						}
					}
				}
				break;

			case 6:
				do {
					System.out.println("Upiste ID korisnika koji vraca knjigu: ");
					idKorisnika = unos.nextInt();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				do {
					System.out.println("Upisite ID knjige koju korisnik vraca: ");
					idKnjige = unos.nextInt();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < knjige.size(); i++) {
					if (knjige.get(i).getBrojKnjige() == idKnjige) {
						Knjiga knjigaZaVracanje = knjige.get(i);
						if (knjigaZaVracanje.isStatus() == false) {
							knjigaZaVracanje.vratiKnjigu();
							for (int j = 0; j < racuni.size(); j++) {
								if (racuni.get(j).getBrojRacuna() == idKorisnika) {
									Racun korisnikKojiVracaKnjigu = racuni.get(j);
									korisnikKojiVracaKnjigu.smanjiBrojPosudjenihKnjiga();
								}
							}
						} else {
							System.out.println("Knjiga nije podignuta!");
						}
					}
				}
				break;

			case 7:
				do {
					System.out.println("Upiste broj racuna korisnika kojeg zelite upisati u fajl: ");
					idKorisnika = unos.nextInt();
					if (existUser(idKorisnika) == false) {
						System.out.println("Korisnik sa unijetim ID brojem ne postoji!");
					}
				} while (existUser(idKorisnika) == false);
				for (int i = 0; i < racuni.size(); i++) {
					if (racuni.get(i).getBrojRacuna() == idKorisnika) {
						try {
							racuni.get(i).upisInFile();
						} catch (Exception e) {
							e.printStackTrace();
						}
						;
					}
				}
				break;
			case 8:
				do {
					System.out.println("Upiste broj knjige koju zelite upisati u fajl: ");
					idKnjige = unos.nextInt();
					if (existBook(idKnjige) == false) {
						System.out.println("Knjiga sa unijetim ID brojem ne postoji!");
					}
				} while (existBook(idKnjige) == false);
				for (int i = 0; i < knjige.size(); i++) {
					if (knjige.get(i).getBrojKnjige() == idKnjige) {
						try {
							knjige.get(i).writeInFile();
						} catch (Exception e) {
							e.printStackTrace();
						}
						;
					}
				}
				break;
			default:
				System.out.println("Pogresan unos!");
			}

		}
		unos.close();
		input.close();

	}

	public static boolean existUser(int id) {
		boolean exist = false;
		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == id) {
				exist = true;
				break;
			}
		}
		return exist;
	}

	public static boolean existBook(int id) {
		boolean exist = false;
		for (int i = 0; i < knjige.size(); i++) {
			if (knjige.get(i).getBrojKnjige() == id) {
				exist = true;
				break;
			}
		}
		return exist;
	}
}