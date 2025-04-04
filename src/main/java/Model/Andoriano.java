package Model;

public class Andoriano extends Ser {

//-------------------------------------
//Variable de instancia (v.i)
//-------------------------------------
    private String range; //puede ser: entrenador, defensor, luchador o caballero
    private boolean iceAtThePoles; //andorianos que habitan bajo el hielo de los polos
    //en caso afirmativo se les pasará a llamar "Aenar"
    private static int civilizationLevel = 2; //el nivel de civilización de cada especie
    //(será única para cada una de ellas)
    //le pondremos "static", para que TODOS 
    //tengan estos atributos

//-------------------------------------
//Sobrecarga de constructores:
//-------------------------------------
    public Andoriano(String range, boolean iceAtThePoles, String name) {
        super(name);
        this.range = range;
        this.iceAtThePoles = iceAtThePoles;
    }

    public Andoriano(String name) {
        super(name);

    }

    public Andoriano(String range, boolean iceAtThePoles, String name, Planeta p) {
        super(name, p);
        this.range = range;
        this.iceAtThePoles = iceAtThePoles;
    }

    public Andoriano(String name, Planeta p) {
        super(name, p);

    }

//-------------------------------------
//Variable de clase (v.c)
//-------------------------------------
//GETTER:
    public String getRange() {
        return range;
    }

    public boolean isIceAtThePoles() {
        return iceAtThePoles;
    }

    public int getCivilizationLevel() {
        return civilizationLevel;
    }

//SETTER:
    public void setRange(String range) {
        this.range = range;
    }

    public void setIceAtThePoles(boolean iceAtThePoles) {
        this.iceAtThePoles = iceAtThePoles;
    }

//-------------------------------------
//OVERRIDE
//-------------------------------------
    /**
     * Devuelve datos sobrescribiendo el metodo del padre
     *
     * Incluye información específica de los Andorianos, como su rango y si
     * habitan bajo el hielo de los polos
     *
     * @return
     */
    @Override
    public String toString() {
        //con super.toSrting() llamamos al padre (Ser)
        return super.toString() + "Especie: Andoriano: " + "\n"
                + "Rango - " + range + "\n"
                + iceAtThePoles;
    }
}
