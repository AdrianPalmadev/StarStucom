package Controller;

//------------------------------------------------
// NETBEANS
import DAO_Controller.DAOSQL;
import static DAO_Controller.DAOSQL.*;
import java.util.HashSet;

// PROYECTO
import Model.*;
import Excepcion.*;
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
            throw new PlanetaExcepcion(p.getName() + " has been registered.");
        }

    }

    public static Ser getSer(Ser s) throws DAO_Excep {
        DAOSQL d = new DAOSQL();

        for (Planeta p : d.obtainPlanets()) {
            for (Ser sp : p.getPopulation()) {
                if (sp.equals(s)) {
                    return sp;
                }
            }
        }
        return null;
    }

    public static boolean getCiudadano() throws DAO_Excep {
        DAOSQL d = new DAOSQL();
        for (Planeta p : d.obtainPlanets()) {
            for (Ser ser : p.getPopulation()) {
                if (ser instanceof Ser) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Planeta getPlanet(Planeta p) throws DAO_Excep {
        DAOSQL d = new DAOSQL();
        if (d.obtainPlanets().contains(p)) {
            for (Planeta ps : d.obtainPlanets()) {
                if (ps.equals(p)) {
                    return ps;
                }
            }
        }
        return null;
    }

    public static void createser(Ser o, Planeta p) throws SerExcepcion, DAO_Excep {
        DAOSQL d = new DAOSQL();
        if (o instanceof Andoriano) {
            Andoriano a = (Andoriano) o;
            p.getPopulation().add(o);
            d.insertand(a, p);
        } else if (o instanceof Ferengi) {
            Ferengi a = (Ferengi) o;
            p.getPopulation().add(o);
            d.insertfer(a, p);
        } else if (o instanceof Humano) {
            Humano a = (Humano) o;
            p.getPopulation().add(o);
            d.inserthum(a, p);
        } else if (o instanceof Klingon) {
            Klingon a = (Klingon) o;
            p.getPopulation().add(o);
            d.insertkli(a, p);
        } else if (o instanceof Nibiriano) {
            Nibiriano a = (Nibiriano) o;
            p.getPopulation().add(o);
            d.insertnib(a, p);
        } else if (o instanceof Vulcaniano) {
            Vulcaniano a = (Vulcaniano) o;
            p.getPopulation().add(o);
            d.insertvul(a, p);
        }
    }

}
