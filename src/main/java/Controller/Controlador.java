package Controller;

//------------------------------------------------
// NETBEANS
import DAO_Controller.DAOSQL;
import static DAO_Controller.DAOSQL.*;
// PROYECTO
import Model.*;
import Excepcion.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para controlar HashSet
 *
 * @author Usuario
 */
public class Controlador {

    /**
     * Funcion para crear planetas
     *
     * @param p De entrada tiene un objeto tipo Planeta p
     * @throws PlanetaExcepcion Si hay un error lo lanza
     */
    public static void createplaneta(Planeta p) throws PlanetaExcepcion {

        DAOSQL daoPla = new DAOSQL();

        int registeredPlanets;
        try {
            registeredPlanets = daoPla.insertpla(p);

        } catch (DAO_Excep ex) {
            throw new PlanetaExcepcion(p.getName() + " ya esta registrado, inserta otro nombre.");
        }

    }

    public static void getValidPlanet(Ser s, Planeta p) throws SerExcepcion, DAO_Excep {
        DAOSQL d = new DAOSQL();

        System.out.println("Entrando al if");
        if (d.getpoblacion(p)) { //return boolean de ser y planeta
            System.out.println("Hola");
            if (d.noRepeatNombreSer(s) == null) {
//                Si s es Specie Andoriano
                if (s instanceof Vulcaniano) {
                    if (d.searchAndoriano(p)) {
                        //coincide en el mismo lugar que un vulcaniano
                        throw new SerExcepcion(" En el " + p.getName() + " existe un Andoriano");
                    }
//        Si s es tipo Andoriano
                } else if (s instanceof Andoriano) {
                    if (d.searchVulcaniano(p)) {
                        //coincide en el mismo lugar que un vulcaniano
                        throw new SerExcepcion(" En el " + p.getName() + " existe un Vulcaniano");
                    }
                    //            Si es tipo klingon
                } else if (s instanceof Klingon) {
//            Si el clima es de tipo Calido
                    if (p.getClime().equalsIgnoreCase("Calido")) {
                        throw new SerExcepcion("No puede vivir en este planeta porque es de clima " + p.getClime() + ".");
                    }
//            Si s es tipo Nibirianos
                } else if (s instanceof Nibiriano) {
                    Nibiriano n = (Nibiriano) s;
                    // Si es vegetariano, necesita flora roja
                    if (n.esVegetariano() && !p.isFlora()) {
                        throw new SerExcepcion("No puede vivir en este planeta porque es no tiene flora.");
                        // Si es carnivoro, necesita fauna marina
                    } else if (n.esCarnivoro() && !p.isAquatic()) {
                        throw new SerExcepcion("No puede vivir en este planeta porque es no tiene fauna marina.");
                    }
//            Si s es tipo Ferengi
                } else if (s instanceof Ferengi) {
//            Si el clima es tipo Frio
                    if (p.getClime().contains("Frio")) {
                        System.out.println(s.toString());
                        throw new SerExcepcion("No puede vivir en este planeta porque es de clima " + p.getClime() + ".");
                    }
                }
            } else {
                throw new SerExcepcion("El nombre:  " + s.getName() + " ya esta en uso.");
            }
        } else {
            throw new SerExcepcion("[!] El planeta " + p.getName() + " ha llegado a su capacidad máxima .");
        }
    }

    public static Planeta getPlanet(Planeta p) throws DAO_Excep {
        DAOSQL d = new DAOSQL();
        return d.getPlanet(p);
    }

    public static void createser(Ser o, Planeta p) throws SerExcepcion, DAO_Excep {
        DAOSQL d = new DAOSQL();
        getValidPlanet(o, p);
        switch (o) {
            case Andoriano a ->
                d.insertand(a, p);
            case Ferengi a ->
                d.insertfer(a, p);
            case Humano a ->
                d.inserthum(a, p);
            case Klingon a ->
                d.insertkli(a, p);
            case Nibiriano a ->
                d.insertnib(a, p);
            case Vulcaniano a ->
                d.insertvul(a, p);
            default -> {
            }
        }
    }

    public static void deleteser(Ser o) throws SerExcepcion, DAO_Excep {
        DAOSQL d = new DAOSQL();
        switch (o) {
            case Andoriano a ->
                d.deleteand(a);
            case Ferengi a ->
                d.deletefer(a);
            case Humano a ->
                d.deletehum(a);
            case Klingon a ->
                d.deletekli(a);
            case Nibiriano a ->
                d.deletenib(a);
            case Vulcaniano a ->
                d.deletevul(a);
            default -> {
            }
        }
    }

}
