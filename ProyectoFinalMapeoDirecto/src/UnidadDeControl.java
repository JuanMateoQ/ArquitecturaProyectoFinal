public class UnidadDeControl {
    int PC;
    int IR;
    MemoriaRam RAM = MemoriaRam.getInstance();
    public UnidadDeControl(){
        this.PC=0;
        this.IR =0;
    }
    public void cargarPCDeOperación(int PCdeOperación) {
        this.PC = PCdeOperación;
    }
}
