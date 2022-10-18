package ch.fhnw;

public class Konto {
    private int kontostand;
    public void initalisiere(int einlage) {
        kontostand = einlage;
    }

    public int stand() {
        return kontostand;
    }

    public void anpassen(int neuerBetrag){
        kontostand = neuerBetrag;
    }
}
