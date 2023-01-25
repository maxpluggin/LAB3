
public enum Symbol {
    CROSS("X",10), ZERO("O",1), EMPTY(" ",-100);
    String symbol;
    int value;
    Symbol(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    Symbol() {
    }
}