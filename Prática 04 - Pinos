interface PinoRedondo {
    double getRaio();
}

class PinoRedondoConcreto implements PinoRedondo {
    private double raio;

    public PinoRedondoConcreto(double raio) {
        this.raio = raio;
    }

    @Override
    public double getRaio() {
        return this.raio;
    }
}

class PinoQuadrado {
    private double largura;

    public PinoQuadrado(double largura) {
        this.largura = largura;
    }

    public double getLargura() {
        return this.largura;
    }
}

class AdaptadorPinoQuadrado implements PinoRedondo {
    private PinoQuadrado pinoQuadrado;

    public AdaptadorPinoQuadrado(PinoQuadrado pinoQuadrado) {
        this.pinoQuadrado = pinoQuadrado;
    }

    @Override
    public double getRaio() {
        return (pinoQuadrado.getLargura() * Math.sqrt(2)) / 2;
    }
}

class BuracoRedondo {
    private double raio;

    public BuracoRedondo(double raio) {
        this.raio = raio;
    }

    public boolean encaixa(PinoRedondo pino) {
        return pino.getRaio() <= this.raio;
    }
}

class Principal {
    public static void main(String[] args) {
        BuracoRedondo buracoRedondo = new BuracoRedondo(5);

        PinoRedondoConcreto pinoRedondoPequeno = new PinoRedondoConcreto(4);
        System.out.println("Pino redondo pequeno encaixa: " + buracoRedondo.encaixa(pinoRedondoPequeno));

        PinoRedondoConcreto pinoRedondoGrande = new PinoRedondoConcreto(6);
        System.out.println("Pino redondo grande encaixa: " + buracoRedondo.encaixa(pinoRedondoGrande));

        PinoQuadrado pinoQuadrado = new PinoQuadrado(5);
        AdaptadorPinoQuadrado adaptadorPinoQuadrado = new AdaptadorPinoQuadrado(pinoQuadrado);
        System.out.println("Pino quadrado adaptado encaixa: " + buracoRedondo.encaixa(adaptadorPinoQuadrado));
    }
}
