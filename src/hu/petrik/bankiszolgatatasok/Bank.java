package hu.petrik.bankiszolgatatasok;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Szamla> szamlaLista;

    public Bank() {
        this.szamlaLista = new ArrayList<>();
    }
    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret) {
        if (hitelKeret > 0) {
            HitelSzamla h1 = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(h1);
            return h1;
        } else if (hitelKeret == 0) {
            MegtakaritasiSzamla megtakaritasiSzamla = new MegtakaritasiSzamla(tulajdonos);
            szamlaLista.add(megtakaritasiSzamla);
            return megtakaritasiSzamla;
        } else {
            throw new IllegalArgumentException("A hitelkeret nem lehet negatív");
        }
    }
    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
        Szamla max = null;
        for (int i = 0; i < szamlaLista.size()- 1; i++) {
            if (tulajdonos == szamlaLista.get(i).tulajdonos) {
                max = szamlaLista.get(i);
            }
        }
        for (Szamla sz : szamlaLista ) {
            if (sz.tulajdonos == tulajdonos) {
                if (sz.getAktualisEgyenleg() >= max.getAktualisEgyenleg()) {
                    max = sz;
                }
            }
        }
        return max;
    }
    public int getOsszEgyenleg(Tulajdonos tulajdonos) {
        int ossz = 0;
        for (Szamla sz : szamlaLista ) {
            if (sz.tulajdonos == tulajdonos) {
                ossz+= sz.getAktualisEgyenleg();
            }
        }
        return ossz;
    }
    public long getOsszHitelkeret() {
        long ossz = 0;
        for (Szamla sz : szamlaLista ) {
            if (sz instanceof HitelSzamla) {
                ossz+= ((HitelSzamla) sz).getHitelKeret();
            }
        }
        return ossz;
    }
}
