public class CPU {
    Registros registro;
    UnidadLogicaAritmetica alu;
    UnidadDeControl uc;
    MemoriaRam ram = MemoriaRam.getInstance();
    MemoriaCache cache = MemoriaCache.getInstance();
    MemoriaSecundaria ssd = MemoriaSecundaria.getInstance();

    public CPU(){
        registro = Registros.getInstance();
        alu = new UnidadLogicaAritmetica();
        uc = new UnidadDeControl();
    }

    public void guardarEnMemoriaSecundaria(int aux) {
        ssd.guardarDato(aux);

    }

    public void mostrarDatosDeMemoriaSecundaria() {
        ssd.imprimirDatosGuardados();
    }

    public void guardarOperación(int númeroDeOperaciónARealizar) {
            int PCDEOperación = ram.seleccionarPC(númeroDeOperaciónARealizar-1);
            uc.cargarPCDeOperación(PCDEOperación);
    }

    public void cargarEnMemoriaPrincipal() {
        for (int i =0; i < ssd.getNúmeroDeValoresCargados(); i++){
            ram.agregarValor(ssd.getValor(i));
        }
    }
    public int getCantidadDeValoresEnMemoriaSecundaria() {
        return ssd.getNúmeroDeValoresCargados();
    }

    public void mostrarDatosDeMemoriaPrinciapal() {
        ram.mostrarValoresCargados();
    }

    public void empezarOperación(int valor1, int valor2) {
        uc.empezarOperación(valor1, valor2);
    }

    public void mostrarDatosDeMemoriacache() {
        cache.mostrarValoresCargados();
    }
}
