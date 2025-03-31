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

//HashSet Planeta
    public static HashSet<Planeta> allplanet = new HashSet<>();

//------------------------------------------------
// Verificación del nombre Planeta
    /**
     * Funcion para conseguir objeto Planeta
     *
     * @param p Tiene un objeto entrada tipo Planeta o new Planet(nombre)
     * @return Devuelve el planeta ps del hashet que equivale a p
     */
    public static Planeta getPlanet(Planeta p) {
        if (allplanet.contains(p)) {
            for (Planeta ps : allplanet) {
                if (ps.equals(p)) {
                    return ps;
                }
            }
        }
        return null;
    }

    /**
     * Funcion para conseguir un objeto Ser s
     *
     * @param s Tiene un objeto de entrada tipo Ser o new Ser(name)
     * @return sp Devuelve el planeta del hashset que equivale a s
     */
    public static Ser getSer(Ser s) {
        for (Planeta p : allplanet) {
            for (Ser sp : p.getPopulation()) {
                if (sp.equals(s)) {
                    return sp;
                }
            }
        }
        return null;
    }

    /**
     * Funcion para evitar que el nombre de un planeta se repita en un Ser
     *
     * @param s Objeto Ser de entrada
     * @return Devuelve el planeta si el nombre ya se usa
     */
    public static Object noRepeatNombreSer(Ser s) {
        for (Planeta p : allplanet) {
            if (p.getName().contains(s.getName())) {
                return p;
            } else {
                for (Ser sp : p.getPopulation()) {
                    if (sp.equals(s)) {
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Funciona para evitar que el nombre de un ciudadano se repita en un
     * planeta
     *
     * @param pn Objeto Planeta de entrada
     * @return devuelve el Ser si el nombre ya se usa
     */
    public static Ser noRepeatNombrePlaneta(Planeta pn) {
        for (Planeta p : allplanet) {
            if (p.equals(pn)) {
                return null;
            } else {
                for (Ser sp : p.getPopulation()) {
                    if (sp.getName().contains(pn.getName())) {
                        return sp;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Funcion para crear planetas
     *
     * @param p De entrada tiene un objeto tipo Planeta p
     * @throws PlanetaExcepcion Si hay un error lo lanza
     */
    public static void createplaneta(Planeta p) throws PlanetaExcepcion {

        DAOSQL daoEst = new DAOSQL();

        int registeredStudents;
        try {
            registeredStudents = daoEst.insert(p);

        } catch (DAO_Excep ex) {
            throw new PlanetaExcepcion(p.getName() + " has been registered.");
        }

    }

    /**
     * Funcion para saber si existe un ciudadano
     *
     * @return Devuelve true if encuentra un objeto tipo Ser
     */
    public static boolean getCiudadano() {
        for (Planeta p : allplanet) {
            for (Ser ser : p.getPopulation()) {
                if (ser instanceof Ser) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Esta funcion es para conseguir el Planeta en donde vive el ciudadano
     *
     * @param s Objeto Ser s de entrada
     * @return Devuele el planeta en donde vive Ser s
     */
    public static Planeta getPlanetaSer(Ser s) {

        for (Planeta p : allplanet) {
            for (Ser sp : p.getPopulation()) {
                if (sp.equals(s)) {
                    return p;
                }
            }
        }
        return null;
    }

    public static String getSerPlaneta() {
        for (Planeta p : allplanet) {
            for (Ser sp : p.getPopulation()) {
                System.out.println(sp.getName());
                return sp.getName();
            }
        }
        return null;
//        for (Planeta p : allplanet) {
//            for (Ser s : p.getPopulation()) {
//                System.out.println(s.getName());
//                return s.getName();
//            }
//        }
//        return null;
    }

    /**
     * Funcion para conseguir un planeta valido
     *
     * @param s Objeto de entrada Ser s
     * @param p Objeto entreada Planeta p
     * @return Devuele true si consigue una planeta valido
     * @throws SerExcepcion
     */
    public static void getValidPlanet(Ser s, Planeta p) throws SerExcepcion {
        if (p.getPopulation().size() < p.getPopulationMax()) {
            if (noRepeatNombreSer(s) == null) {
//                Si s es Specie Andoriano
                if (s instanceof Vulcaniano) {
                    for (Ser existente : p.getPopulation()) {
                        //coincide en el mismo lugar que un vulcaniano
                        if (existente instanceof Andoriano) {
                            throw new SerExcepcion(" En el " + p.getName() + " existe un Andoriano");
                        }
                    }
//        Si s es tipo Andoriano
                } else if (s instanceof Andoriano) {
                    for (Ser existente : p.getPopulation()) {
                        //coincide en el mismo lugar que un vulcaniano
                        if (existente instanceof Vulcaniano) {
                            throw new SerExcepcion(" En el " + p.getName() + " existe un Vulcaniano");
                        }
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
                } else if (s instanceof Humano) {
                }
            } else {
                throw new SerExcepcion("El nombre:  " + s.getName() + " ya esta en uso.");
            }
        } else {
            throw new SerExcepcion("[!] El planeta " + p.getName() + "a llegado a su capacidad máxima .");
        }
    }

    /**
     * Funciona para añadir un Ser a un Planeta
     *
     * @param s Objeto de entrada Ser s
     * @param p Objeto de entrada Planeta p
     * @throws SerExcepcion
     */
    public static void createser(Ser s, Planeta p) throws SerExcepcion {
        getValidPlanet(s, p);
        p.getPopulation().add(s);
    }
}
