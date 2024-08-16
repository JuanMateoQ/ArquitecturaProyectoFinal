public class UnidadDeControl {
    int PC;
    int IR;
    MemoriaRam RAM = MemoriaRam.getInstance();
    MemoriaCache cache = MemoriaCache.getInstance();
    Registros registros = Registros.getInstance();
    public UnidadDeControl(){
        this.PC=0;
        this.IR =0;
    }
    public void cargarPCDeOperación(int PCdeOperación) {
        this.PC = PCdeOperación;
    }

    public void empezarOperación(int valor1, int valor2) {
        while(this.IR != 4){
            this.IR = RAM.cargarOperación(this.PC);
            realizarOperaciónRelacionada(valor1, valor2);
        }
    }

    private void realizarOperaciónRelacionada(int valor1, int valor2) {
        int tag;
        int index;
        switch (this.IR){
            case 1: {
                //valor1--;
                tag = (valor1 -1 )/ (cache.getNúmeroDeLíneas()-1);
                index = (valor1-1) % (cache.getNúmeroDeLíneas()-1);
                registros.cargarEnRegistro(1, cache.traerDato(tag, index));
                break;
            }
            case 2: {

                break;
            }
            case 3: {

                break;
            }
            case 4: {

                break;
            }
            case 5: {

                break;
            }
        }
    }
}
