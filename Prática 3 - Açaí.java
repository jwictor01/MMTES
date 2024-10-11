enum Tamanho {
    PEQUENO, MEDIO, GRANDE
}

interface Adicional {
    String getDescricao();
    double custo();
}

class Acai implements Adicional {
    private Tamanho tamanho;

    public Acai(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String getDescricao() {
        return "Açaí " + tamanho;
    }

    @Override
    public double custo() {
        switch (tamanho) {
            case PEQUENO:
                return 5.00;
            case MEDIO:
                return 7.00;
            case GRANDE:
                return 9.00;
            default:
                return 0;
        }
    }

    public Tamanho getTamanho() {
        return tamanho;
    }
}

abstract class BaseDecorator implements Adicional {
    protected Adicional wrappee;

    public BaseDecorator(Adicional wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String getDescricao() {
        return wrappee.getDescricao();
    }

    @Override
    public double custo() {
        return wrappee.custo();
    }

    public Tamanho getTamanho() {
        if (wrappee instanceof Acai) {
            return ((Acai) wrappee).getTamanho();
        } else if (wrappee instanceof BaseDecorator) {
            return ((BaseDecorator) wrappee).getTamanho();
        } else {
            return Tamanho.PEQUENO;
        }
    }
}

class Morango extends BaseDecorator {
    public Morango(Adicional wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescricao() {
        return wrappee.getDescricao() + ", Morango";
    }

    @Override
    public double custo() {
        double custoAdicional = 0;
        switch (getTamanho()) {
            case PEQUENO:
                custoAdicional = 1.00;
                break;
            case MEDIO:
                custoAdicional = 1.50;
                break;
            case GRANDE:
                custoAdicional = 2.00;
                break;
        }
        return wrappee.custo() + custoAdicional;
    }
}

class Banana extends BaseDecorator {
    public Banana(Adicional wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescricao() {
        return wrappee.getDescricao() + ", Banana";
    }

    @Override
    public double custo() {
        double custoAdicional = 0;
        switch (getTamanho()) {
            case PEQUENO:
                custoAdicional = 0.80;
                break;
            case MEDIO:
                custoAdicional = 1.20;
                break;
            case GRANDE:
                custoAdicional = 1.60;
                break;
        }
        return wrappee.custo() + custoAdicional;
    }
}

class LeiteCondensado extends BaseDecorator {
    public LeiteCondensado(Adicional wrappee) {
        super(wrappee);
    }

    @Override
    public String getDescricao() {
        return wrappee.getDescricao() + ", Leite Condensado";
    }

    @Override
    public double custo() {
        double custoAdicional = 0;
        switch (getTamanho()) {
            case PEQUENO:
                custoAdicional = 1.50;
                break;
            case MEDIO:
                custoAdicional = 2.00;
                break;
            case GRANDE:
                custoAdicional = 2.50;
                break;
        }
        return wrappee.custo() + custoAdicional;
    }
}

class TestaDecorator {
    public static void main(String[] args) {

        Adicional acaiPequenoComMorango = new Morango(new Acai(Tamanho.PEQUENO));
        System.out.println(acaiPequenoComMorango.getDescricao() + " - Custo: R$" + acaiPequenoComMorango.custo());

        Adicional acaiMedioComMorangoEBanana = new Banana(new Morango(new Acai(Tamanho.MEDIO)));
        System.out.println(acaiMedioComMorangoEBanana.getDescricao() + " - Custo: R$" + acaiMedioComMorangoEBanana.custo());

        Adicional acaiGrandeCompleto = new Banana(new LeiteCondensado(new Morango(new Acai(Tamanho.GRANDE))));
        System.out.println(acaiGrandeCompleto.getDescricao() + " - Custo: R$" + acaiGrandeCompleto.custo());


    }
}
