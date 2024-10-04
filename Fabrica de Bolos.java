interface Bolo {
    void preparar();
}

class BoloChocolate implements Bolo {
    @Override
    public void preparar() {
        System.out.println("Preparando bolo de chocolate");
    }
}

class BoloMorango implements Bolo {
    @Override
    public void preparar() {
        System.out.println("Preparando bolo de morango");
    }
}

class BoloCenoura implements Bolo {
    @Override
    public void preparar() {
        System.out.println("Preparando bolo de cenoura");
    }
}

class BoloAbacaxi implements Bolo {
    @Override
    public void preparar() {
        System.out.println("Preparando bolo de abacaxi");
    }
}

abstract class FabricaBolo {
    public abstract Bolo criarBolo();

    public void fazerBolo() {
        Bolo bolo = criarBolo();
        bolo.preparar();
    }
}


class FabricaBoloChocolate extends FabricaBolo {
    @Override
    public Bolo criarBolo() {
        return new BoloChocolate();
    }
}

class FabricaBoloMorango extends FabricaBolo {
    @Override
    public Bolo criarBolo() {
        return new BoloMorango();
    }
}

class FabricaBoloCenoura extends FabricaBolo {
    @Override
    public Bolo criarBolo() {
        return new BoloCenoura();
    }
}

class FabricaBoloAbacaxi extends FabricaBolo {
    @Override
    public Bolo criarBolo() {
        return new BoloAbacaxi();
    }
}

class Principal {
    public static void main(String[] args) {
        FabricaBolo fabricaBoloChocolate = new FabricaBoloChocolate();
        fabricaBoloChocolate.fazerBolo();

        FabricaBolo fabricaBoloMorango = new FabricaBoloMorango();
        fabricaBoloMorango.fazerBolo();

        FabricaBolo fabricaBoloCenoura = new FabricaBoloCenoura();
        fabricaBoloCenoura.fazerBolo();

        FabricaBolo fabricaBoloAbacaxi = new FabricaBoloAbacaxi();
        fabricaBoloAbacaxi.fazerBolo();
    }
}
