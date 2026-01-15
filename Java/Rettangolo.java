public class Rettangolo {
    private float base;
    private float altezza;
    private float area;
    private float perimentro;

    public Rettangolo() {

    }

    public Rettangolo(float base,float altezza) {
        this.base=base;
        this.altezza=altezza;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAltezza() {
        return altezza;
    }

    public void setAltezza(float altezza) {
        this.altezza = altezza;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getPerimentro() {
        return perimentro;
    }

    public void setPerimentro(float perimentro) {
        this.perimentro = perimentro;
    }

    public float caloloPerimentro(){
        perimentro=2*(base+altezza);
        return perimentro;
    }

    public float calcoloArea(){
        area=base*altezza;
        return  area;
    }
}
