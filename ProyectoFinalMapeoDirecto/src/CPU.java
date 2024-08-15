public class CPU {
    Registros registro;
    UnidadLogicaAritmetica alu;
    UnidadDeControl uc;
    MemoriaRam ram = MemoriaRam.getInstance();
    MemoriaCache cache = MemoriaCache.getInstance();
    MemoriaSecundaria ssd = MemoriaSecundaria.getInstance();

    public CPU(){
        registro = new Registros();
        alu = new UnidadLogicaAritmetica();
        uc = new UnidadDeControl();
    }

    public void guardarEnMemoriaSecundaria(int aux) {
        ssd.guardarDato(aux);
    }

    public void mostrarDatosDeMemoriaSecundaria() {
        ssd.imprimirDatosGuardados();
    }

    public void realizarOperación(int númeroDeOperaciónARealizar) {
        int PCDEOperación = ram.seleccionarPC(númeroDeOperaciónARealizar);
        uc.empezarOperaciónConPC(PCDEOperación);
    }
}
