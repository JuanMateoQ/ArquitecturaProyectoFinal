import java.util.concurrent.atomic.AtomicInteger;

public class Registros {
    private AtomicInteger AC1;
    private AtomicInteger AC2;

    public Registros() {
        AC1 = new AtomicInteger(0);
        AC2 = new AtomicInteger(0);
    }

    public AtomicInteger getAC1() {
        return AC1;
    }

    public AtomicInteger getAC2() {
        return AC2;
    }

    public void setAC1(int valor) {
        AC1.set(valor);
    }

    public void setAC2(int valor) {
        AC2.set(valor);
    }

    public void reset() {
        AC1.set(0);
        AC2.set(0);
    }
}
