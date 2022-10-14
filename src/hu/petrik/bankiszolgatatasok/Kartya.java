package hu.petrik.bankiszolgatatasok;

public class Kartya extends  BankiSzolgaltatas{
    private Szamla szamla;
    private String kartyaSzam;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaSzam) {
        super(tulajdonos);
        this.szamla = szamla;
        this.kartyaSzam = kartyaSzam;
    }

    public String getKartyaSzam() {
        return kartyaSzam;
    }
    public boolean vasarlas(int osszeg) {
        return this.szamla.kivesz(osszeg);
    }
}
