package Controller;

//------------------------------------------------
// NETBEANS
import DAO_Controller.DAOSQL;
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

    public static void createser(Object o) {
        if (o instanceof Andoriano) {
        } else if (o instanceof Ferengi) {
        } else if (o instanceof Humano) {
        } else if (o instanceof Klingon) {
        } else if (o instanceof Nibiriano) {
        } else if (o instanceof Vulcaniano) {
        }
    }

}
