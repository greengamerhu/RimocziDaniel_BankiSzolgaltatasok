package hu.petrik.bankiszolgatatasok;

import java.util.IllegalFormatCodePointException;

public class MegtakaritasiSzamla extends Szamla {
    private double kamat;
    public static double alapkamat = 1.1;

    public  MegtakaritasiSzamla(Tulajdonos tulajdonos) {
        super(tulajdonos);
        kamat = alapkamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }
    public void kamatJovairas() {
        aktualisEgyenleg += (int) (aktualisEgyenleg* kamat);
    }
    @Override
    public boolean kivesz(int osszeg) {
        if (aktualisEgyenleg - osszeg >= 0) {
            aktualisEgyenleg =- osszeg;
            return true;
        } else {
            return false;
        }

    }
}
