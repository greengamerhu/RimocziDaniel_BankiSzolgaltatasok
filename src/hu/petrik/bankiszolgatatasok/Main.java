package hu.petrik.bankiszolgatatasok;

public class Main {
    public static void main(String[] args) {
        Tulajdonos t1 = new Tulajdonos("Teszt elek");
        Tulajdonos t2 = new Tulajdonos("Gipsz jakab");
        Tulajdonos t3 = new Tulajdonos("Retek Jozsef");

        Bank b1 = new Bank();
        b1.szamlaNyitas(t1, 400).befizet(1500);
        b1.szamlaNyitas(t2,300);
        b1.szamlaNyitas(t1, 0).befizet(6000);

        System.out.println(b1.getOsszHitelkeret());
        System.out.println(b1.getLegnagyobbEgyenleguSzamla(t1).getAktualisEgyenleg());
        System.out.println(b1.getOsszEgyenleg(t1));

    }
}
