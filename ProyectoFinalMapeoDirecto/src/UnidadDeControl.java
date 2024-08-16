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
            registros.imprimirRegistros();
            cache.mostrarValoresCargados();
            this.PC++;
        }
        RAM.mostrarValoresCargados();
    }

    private void realizarOperaciónRelacionada(int valor1, int valor2) {
        int tag;
        int index;
        switch (this.IR){
            case 1: {
                tag = (valor1 -1 )/ (cache.getNúmeroDeLíneas());
                index = (valor1-1) % (cache.getNúmeroDeLíneas());
                //Siendo cero el Primer Registro
                String valor = cache.traerDato(tag, index);
                registros.cargarEnRegistro(0, valor);
                break;
            }
            case 2: {
                tag = (valor2 -1 )/ (cache.getNúmeroDeLíneas());
                index = (valor2-1) % (cache.getNúmeroDeLíneas());
                //Siendo cero el Primer Registro
                String valor = cache.traerDato(tag, index);
                registros.cargarEnRegistro(1, valor);
                break;
            }
            case 3: {
                //aqui va Suma
                //registros.cargarEnRegistro(2,(registros.getDato(0) + registros.getDato(1)));
                registros.cargarEnRegistro(2, SumaBinaria.sumarBinarios(registros.getDato(0),registros.getDato(1)));
                break;
            }
            case 4: {
                tag = (valor1 -1 )/ (cache.getNúmeroDeLíneas());
                index = (valor1-1) % (cache.getNúmeroDeLíneas());
                //Siendo cero el Primer Registro
                String valor = registros.getDato(2);
                //registros.cargarEnRegistro(0, valor);
                cache.modificarDato(tag, index, valor);
                break;
            }
            case 5: {
                //Aqui va multiplicar
                //registros.cargarEnRegistro(2,(registros.getDato(0) * registros.getDato(1)));
                registros.cargarEnRegistro(2,MultiplicacionBinaria.multiplicarBinario(registros.getDato(0),registros.getDato(1)));
                break;
            }
            case 6:{
                //aqui va AND
                //registros.cargarEnRegistro(2,(registros.getDato(0) * registros.getDato(1)));
                registros.cargarEnRegistro(2,AND.and(registros.getDato(0),registros.getDato(1)));
            }
            default:{
                System.out.println("A ocurrido un error al realizar las operciones ");
                break;
            }
        }
    }
}
