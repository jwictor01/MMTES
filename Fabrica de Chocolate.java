class CaldeiraChocolate {
    private boolean vazia;
    private boolean fervida;
    private static CaldeiraChocolate instancia;

    private CaldeiraChocolate() {
        this.vazia = true;
        this.fervida = false;
    }

    public static CaldeiraChocolate getInstancia() {
        if (instancia == null) {
            instancia = new CaldeiraChocolate();
        }
        return instancia;
    }

    public void encher() {
        if (vazia) {
            System.out.println("Preenchendo a caldeira com leite e chocolate");
            vazia = false;
            fervida = false;
        } else {
            System.out.println("A caldeira já está cheia. Não é possível preencher.");
        }
    }

    public void ferver() {
        if (!vazia && !fervida) {
            System.out.println("Aquecendo a mistura");
            fervida = true;
        } else if (vazia) {
            System.out.println("A caldeira está vazia. Não é possível ferver.");
        } else if (fervida) {
            System.out.println("A mistura já foi fervida. Não é necessário ferver novamente.");
        }
    }

    public void drenar() {
        if (!vazia && fervida) {
            System.out.println("Drenando a mistura fervida...");
            vazia = true;
        } else if (vazia) {
            System.out.println("A caldeira está vazia. Não há nada para drenar.");
        } else if (!fervida) {
            System.out.println("A mistura ainda não foi fervida. Não é possível drenar.");
        }
    }

    public boolean isVazia() {
        return vazia;
    }

    public boolean isFervida() {
        return fervida;
    }
}

class FabricaDeChocolate {
    public static void main(String[] args) {

        CaldeiraChocolate caldeira = CaldeiraChocolate.getInstancia();

        caldeira.encher();
        caldeira.ferver();
        caldeira.drenar();

        caldeira.drenar();
        caldeira.ferver();
        caldeira.encher();
        caldeira.ferver();
        caldeira.drenar();
    }
}