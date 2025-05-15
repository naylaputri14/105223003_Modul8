package komposisi;

class Kamar {
    String tipe;

    Kamar(String tipe) {
        this.tipe = tipe;
    }

    void info() {
        System.out.println("Kamar tipe : " + tipe);
    }
}

class Rumah {
    private Kamar kamar;

    Rumah() {
        kamar = new Kamar("Mandi");
    }

    void lihatKamar() {
        kamar.info();
    }
}

public class Main {
    public static void main(String[] args) {
        Rumah rumah = new Rumah();
        rumah.lihatKamar();
    }
}
