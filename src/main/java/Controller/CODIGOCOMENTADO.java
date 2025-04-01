/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Adrián Palma
 */
public class CODIGOCOMENTADO { 
//    public static Planeta getPlanetaSer(Ser s) {
//
//        for (Planeta p : allplanet) {
//            for (Ser sp : p.getPopulation()) {
//                if (sp.equals(s)) {
//                    return p;
//                }
//            }
//        }
//        return null;
//    }
//    public static String getSerPlaneta() {
//        for (Planeta p : allplanet) {
//            for (Ser sp : p.getPopulation()) {
//                System.out.println(sp.getName());
//                return sp.getName();
//            }
//        }
//        return null;
//    }
//    public static void getValidPlanet(Ser s, Planeta p) throws SerExcepcion {
//        if (p.getPopulation().size() < p.getPopulationMax()) {
//            if (noRepeatNombreSer(s) == null) {
////                Si s es Specie Andoriano
//                if (s instanceof Vulcaniano) {
//                    for (Ser existente : p.getPopulation()) {
//                        //coincide en el mismo lugar que un vulcaniano
//                        if (existente instanceof Andoriano) {
//                            throw new SerExcepcion(" En el " + p.getName() + " existe un Andoriano");
//                        }
//                    }
////        Si s es tipo Andoriano
//                } else if (s instanceof Andoriano) {
//                    for (Ser existente : p.getPopulation()) {
//                        //coincide en el mismo lugar que un vulcaniano
//                        if (existente instanceof Vulcaniano) {
//                            throw new SerExcepcion(" En el " + p.getName() + " existe un Vulcaniano");
//                        }
//                    }
////            Si es tipo klingon
//                } else if (s instanceof Klingon) {
////            Si el clima es de tipo Calido
//                    if (p.getClime().equalsIgnoreCase("Calido")) {
//                        throw new SerExcepcion("No puede vivir en este planeta porque es de clima " + p.getClime() + ".");
//                    }
////            Si s es tipo Nibirianos
//                } else if (s instanceof Nibiriano) {
//                    Nibiriano n = (Nibiriano) s;
//                    // Si es vegetariano, necesita flora roja
//                    if (n.esVegetariano() && !p.isFlora()) {
//                        throw new SerExcepcion("No puede vivir en este planeta porque es no tiene flora.");
//                        // Si es carnivoro, necesita fauna marina
//                    } else if (n.esCarnivoro() && !p.isAquatic()) {
//                        throw new SerExcepcion("No puede vivir en este planeta porque es no tiene fauna marina.");
//                    }
////            Si s es tipo Ferengi
//                } else if (s instanceof Ferengi) {
////            Si el clima es tipo Frio
//                    if (p.getClime().contains("Frio")) {
//                        System.out.println(s.toString());
//                        throw new SerExcepcion("No puede vivir en este planeta porque es de clima " + p.getClime() + ".");
//                    }
//                } else if (s instanceof Humano) {
//                }
//            } else {
//                throw new SerExcepcion("El nombre:  " + s.getName() + " ya esta en uso.");
//            }
//        } else {
//            throw new SerExcepcion("[!] El planeta " + p.getName() + "a llegado a su capacidad máxima .");
//        }
//    }
//
//    /**
//     * Funcion para evitar que el nombre de un planeta se repita en un Ser
//     *
//     * @param s Objeto Ser de entrada
//     * @return Devuelve el planeta si el nombre ya se usa
//     */
//    public static Object noRepeatNombreSer(Ser s) {
//        for (Planeta p : allplanet) {
//            if (p.getName().contains(s.getName())) {
//                return p;
//            } else {
//                for (Ser sp : p.getPopulation()) {
//                    if (sp.equals(s)) {
//                        return s;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * Funciona para evitar que el nombre de un ciudadano se repita en un
//     * planeta
//     *
//     * @param pn Objeto Planeta de entrada
//     * @return devuelve el Ser si el nombre ya se usa
//     */
//    public static Ser noRepeatNombrePlaneta(Planeta pn) {
//        for (Planeta p : allplanet) {
//            if (p.equals(pn)) {
//                return null;
//            } else {
//                for (Ser sp : p.getPopulation()) {
//                    if (sp.getName().contains(pn.getName())) {
//                        return sp;
//                    }
//                }
//            }
//        }
//        return null;
//    }
}
