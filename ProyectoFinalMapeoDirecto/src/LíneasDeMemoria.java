public class LíneasDeMemoria {
    int tag;
    int index;
    int offset;
    String datoAlmacenado;
    public LíneasDeMemoria(){
        this.tag = -1;
        this.index = -1;
        this.offset =-1;
    }

    public int getTag() {
        return this.tag;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDatoAlamcenado() {
        return datoAlmacenado;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setTag(int i) {
        this.tag = i;
    }

    public void setValor(String valorAAgregar) {
        this.datoAlmacenado = valorAAgregar;
    }
}
