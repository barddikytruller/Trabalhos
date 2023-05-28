package empresa;

public enum Valores {
	  // INSS - Alíquotas e Deduções
    inssALIQUOTA1(0.075), inssALIQUOTA2(0.09), inssALIQUOTA3(0.12), inssALIQUOTA4(0.14), inssALIQUOTA5(0.14),

    inssDEDUCAO1(0.0), inssDEDUCAO2(19.80), inssDEDUCAO3(96.94), inssDEDUCAO4(174.08), inssDEDUCAO5(0.0),

    inssTETO1(1320.00), inssTETO2(2571.29), inssTETO3(3856.95), inssTETO4(7507.49),

    // IR - Imposto De Renda
    irALIQUOTA1(1.0), irALIQUOTA2(0.075), irALIQUOTA3(0.15), irALIQUOTA4(0.225), irALIQUOTA5(0.275),

    irDEDUCAO1(0.0), irDEDUCAO2(158.40), irDEDUCAO3(370.40), irDEDUCAO4(651.73), irDEDUCAO5(884.96),

    irTETO1(2112.00), irTETO2(2856.65), irTETO3(3751.05), irTETO4(4664.68);

    private Double valorAliquota;

    private Valores(Double valorAliquota) {
        this.valorAliquota = valorAliquota;
    }

    public Double getValor() {
        return valorAliquota;
    }

} 
