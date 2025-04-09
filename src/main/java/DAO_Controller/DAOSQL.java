package DAO_Controller;

import Excepcion.DAO_Excep;
import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fran Perez
 */
public class DAOSQL {

    //Variables para la conexión segura contra el servidor (sin especificar DDBB)
    private final String JDBC_URL = "jdbc:mysql://localhost:3306";
    private final String JDBC_COMMU_OPT = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = "";

    //Especificamos la base de Datos
    private final String JDBC_DDBB = "startstucom";
    private final String JDBC_TABLEpla = "planet";
    private final String JDBC_TABLEand = "andoriano";
    private final String JDBC_TABLEhum = "humano";
    private final String JDBC_TABLEfer = "ferengi";
    private final String JDBC_TABLEkli = "klingon";
    private final String JDBC_TABLEnib = "nibiriano";
    private final String JDBC_TABLEvul = "vulcaniano";
    private final String JDBC_DDBB_TABLEpla = JDBC_DDBB + "." + JDBC_TABLEpla;
    private final String JDBC_DDBB_TABLEand = JDBC_DDBB + "." + JDBC_TABLEand;
    private final String JDBC_DDBB_TABLEhum = JDBC_DDBB + "." + JDBC_TABLEhum;
    private final String JDBC_DDBB_TABLEfer = JDBC_DDBB + "." + JDBC_TABLEfer;
    private final String JDBC_DDBB_TABLEkli = JDBC_DDBB + "." + JDBC_TABLEkli;
    private final String JDBC_DDBB_TABLEnib = JDBC_DDBB + "." + JDBC_TABLEnib;
    private final String JDBC_DDBB_TABLEvul = JDBC_DDBB + "." + JDBC_TABLEvul;

    // SELECTS
    private final String SQL_SELECT_PLA = "SELECT * FROM " + JDBC_DDBB_TABLEpla + ";";
    private final String SQL_SELECT_AND = "SELECT * FROM " + JDBC_DDBB_TABLEand + ";";
    private final String SQL_SELECT_HUM = "SELECT * FROM " + JDBC_DDBB_TABLEhum + ";";
    private final String SQL_SELECT_FER = "SELECT * FROM " + JDBC_DDBB_TABLEfer + ";";
    private final String SQL_SELECT_KLI = "SELECT * FROM " + JDBC_DDBB_TABLEkli + ";";
    private final String SQL_SELECT_NIB = "SELECT * FROM " + JDBC_DDBB_TABLEnib + ";";
    private final String SQL_SELECT_VUL = "SELECT * FROM " + JDBC_DDBB_TABLEvul + ";";

    // INSERTS
    private final String SQL_INSERT_PLA = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEpla + " (name, galaxy, MaxPopulation, clime, flora, aquatic) VALUES (?, ?, ?, ?, ?, ?);";
    private final String SQL_INSERT_AND = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEand + " (name, rango, ice, civilization, planeta) VALUES (?, ?, ?, ?, ?);";
    private final String SQL_INSERT_HUM = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEhum + " (name, gender, age, civilization, planeta) VALUES (?, ?, ?, ?, ?);";
    private final String SQL_INSERT_FER = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEfer + " (name, gold, civilization, planeta) VALUES (?, ?, ?, ?);";
    private final String SQL_INSERT_KLI = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEkli + " (name, strength, civilization, planeta) VALUES (?, ?, ?, ?);";
    private final String SQL_INSERT_NIB = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEnib + " (name, floraorfish, civilization, planeta) VALUES (?, ?, ?, ?);";
    private final String SQL_INSERT_VUL = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLEvul + " (name, meditation, civilization, planeta) VALUES (?, ?, ?, ?);";

    //UPDATES
    private final String SQL_UPDATE_AND = "UPDATE " + JDBC_DDBB + "." + JDBC_TABLEand + " SET rango = ?, ice = ? WHERE (name = ?);";
    private final String SQL_UPDATE_HUM = "UPDATE " + JDBC_DDBB + "." + JDBC_TABLEhum + " SET gender = ?, age = ? WHERE (name = ?);";
    private final String SQL_UPDATE_FER = "UPDATE " + JDBC_DDBB + "." + JDBC_TABLEfer + " SET gold = ? WHERE (name = ?);";
    private final String SQL_UPDATE_KLI = "UPDATE " + JDBC_DDBB + "." + JDBC_TABLEkli + " SET strength = ? WHERE (name = ?);";
    private final String SQL_UPDATE_NIB = "UPDATE " + JDBC_DDBB + "." + JDBC_TABLEnib + " SET floraorfish = ? WHERE (name = ?);";
    private final String SQL_UPDATE_VUL = "UPDATE " + JDBC_DDBB + "." + JDBC_TABLEvul + " SET meditation = ? WHERE (name = ?);";

    //DELETES
    private final String SQL_DELETE_PLA = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEpla + " WHERE (name = ?);";
    private final String SQL_DELETE_AND = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEand + " WHERE (name = ?);";
    private final String SQL_DELETE_HUM = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEhum + " WHERE (name = ?);";
    private final String SQL_DELETE_FER = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEfer + " WHERE (name = ?);";
    private final String SQL_DELETE_KLI = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEkli + " WHERE (name = ?);";
    private final String SQL_DELETE_NIB = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEnib + " WHERE (name = ?);";
    private final String SQL_DELETE_VUL = "DELETE FROM " + JDBC_DDBB + "." + JDBC_TABLEvul + " WHERE (name = ?);";

    //VALIDACIONES
    private final String SQL_COUNT_ALL
            = "SELECT COUNT(*) FROM ("
            + "SELECT planet FROM " + JDBC_DDBB_TABLEand + " WHERE planet = ? UNION ALL "
            + "SELECT planet FROM " + JDBC_DDBB_TABLEhum + " WHERE planet = ? UNION ALL "
            + "SELECT planet FROM " + JDBC_DDBB_TABLEfer + " WHERE planet = ? UNION ALL "
            + "SELECT planet FROM " + JDBC_DDBB_TABLEkli + " WHERE planet = ? UNION ALL "
            + "SELECT planet FROM " + JDBC_DDBB_TABLEnib + " WHERE planet = ? UNION ALL "
            + "SELECT planet FROM " + JDBC_DDBB_TABLEvul + " WHERE planet = ?"
            + ") AS combined_results;";
    private final String SQL_SEARCH_AND = "SELECT * FROM " + JDBC_DDBB_TABLEand + " WHERE planeta = ?;";
    private final String SQL_SEARCH_VUL = "SELECT * FROM " + JDBC_DDBB_TABLEvul + " WHERE planeta = ?;";

    //    private final String SQL_DELETE_ALL = "DELETE FROM " + JDBC_DDBB_TABLE + ";";
    //    private final String SQL_RESET_AGES = "UPDATE " + JDBC_DDBB_TABLE + " SET age = 0 WHERE (name = ?);";
    public DAOSQL() {
    }

    public Connection connect() throws DAO_Excep {
        Connection conn = null;
        try {
            //Esta línea no es necesaria, excepto en algunas aplicaciones WEB
            //En aplicaciones locales como esta no sería necesaria
            //Class.forName("com.mysql.cj.jdbc.Driver");
            //getConnection necesita la BBDD, el usuario y la contraseña
            conn = DriverManager.getConnection(JDBC_URL + JDBC_COMMU_OPT, JDBC_USER, JDBC_PASSWORD);
            createDB(conn);
            createTablePla(conn);
            createTableAnd(conn);
            createTableFer(conn);
            createTableHum(conn);
            createTableKli(conn);
            createTableNib(conn);
            createTableVul(conn);

        } catch (SQLException ex) {
            //ex.printStackTrace(System.out);
            System.out.println(ex.getMessage());
            throw new DAO_Excep("Can not connect or create database with tables: " + JDBC_DDBB);
        }
        return conn;
    }

    private void createDB(Connection conn) throws SQLException {
        //Sentencia SQL que crea la BBDD si no existe en el servidor
        String instruction = "create database if not exists " + JDBC_DDBB + ";";
        Statement stmt = null;
        stmt = conn.createStatement();
        //La clase Statemen nos permite ejecutar sentencias SQL
        stmt.executeUpdate(instruction);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTablePla(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEpla + "("
                + "name varchar(50) primary key,"
                + "galaxy varchar(50),"
                + "MaxPopulation int,"
                + "clime varchar(10),"
                + "flora boolean,"
                + "aquatic boolean);";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableAnd(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEand + "("
                + "name varchar(50) primary key,"
                + "rango varchar(15),"
                + "ice boolean,"
                + "civilization int,"
                + "planeta VARCHAR(50),"
                + "FOREIGN KEY (planeta) REFERENCES planet(name)"
                + ");";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableHum(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEhum + "("
                + "name varchar(50) primary key,"
                + "gender varchar(15),"
                + "age int,"
                + "civilization int,"
                + "planeta VARCHAR(50),"
                + "FOREIGN KEY (planeta) REFERENCES planet(name)"
                + ");";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableFer(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEfer + "("
                + "name varchar(50) primary key,"
                + "gold int,"
                + "civilization int,"
                + "planeta VARCHAR(50),"
                + "FOREIGN KEY (planeta) REFERENCES planet(name)"
                + ");";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableKli(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEkli + "("
                + "name varchar(50) primary key,"
                + "strength int,"
                + "civilization int,"
                + "planeta VARCHAR(50),"
                + "FOREIGN KEY (planeta) REFERENCES planet(name)"
                + ");";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableNib(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEnib + "("
                + "name varchar(50) primary key,"
                + "floraorfish varchar(20),"
                + "civilization int,"
                + "planeta VARCHAR(50),"
                + "FOREIGN KEY (planeta) REFERENCES planet(name)"
                + ");";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableVul(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLEvul + "("
                + "name varchar(50) primary key,"
                + "meditation int,"
                + "civilization int,"
                + "planeta VARCHAR(50),"
                + "FOREIGN KEY (planeta) REFERENCES planet(name)"
                + ");";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    public void disconnect(Connection conn) throws DAO_Excep {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not disconnect from database " + JDBC_DDBB);
            }
        }
    }

    public ArrayList<Planeta> obtainPlanets() throws DAO_Excep {
        ArrayList<Planeta> planets = new ArrayList<>();
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        Planeta p = null;

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_PLA);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String galaxy = rs.getString("galaxy");
                int maxPopulation = rs.getInt("maxPopulation");
                String clime = rs.getString("clime");
                boolean flora = rs.getBoolean("flora");
                boolean aquatic = rs.getBoolean("aquatic");
                p = new Planeta(name, galaxy, maxPopulation, clime, flora, aquatic);
                planets.add(p);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {

            try {
                instruction.close();
                disconnect(conn);
                return planets;
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }

        }
    }

    public ArrayList<Ser> obtainSeres() throws DAO_Excep {
        ArrayList<Ser> ser = new ArrayList<>();
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        Humano h = null;
        Andoriano and = null;
        Ferengi fer = null;
        Klingon kli = null;
        Vulcaniano vul = null;
        Nibiriano nib = null;
        Planeta p = null;

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_HUM);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                int age = rs.getInt("age");
                String planet = rs.getString("planeta");

                for (Planeta planeta : obtainPlanets()) {
                    if (planeta.getName().equals(planet)) {
                        p = planeta;
                        break;
                    }
                }

                h = new Humano(age, gender, name, p);

                ser.add(h);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        }

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_AND);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String rango = rs.getString("rango");
                boolean ice = rs.getBoolean("ice");
                String planet = rs.getString("planeta");

                for (Planeta planeta : obtainPlanets()) {
                    if (planeta.getName().equals(planet)) {
                        p = planeta;
                        break;
                    }
                }

                and = new Andoriano(rango, ice, name, p);
                ser.add(and);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.selectAND)");
        }

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_FER);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int gold = rs.getInt("gold");
                String planet = rs.getString("planeta");

                for (Planeta planeta : obtainPlanets()) {
                    if (planeta.getName().equals(planet)) {
                        p = planeta;
                        break;
                    }
                }

                fer = new Ferengi(gold, name, p);
                ser.add(fer);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.selectFER)");
        }

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_KLI);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int strength = rs.getInt("strength");
                String planet = rs.getString("planeta");

                for (Planeta planeta : obtainPlanets()) {
                    if (planeta.getName().equals(planet)) {
                        p = planeta;
                        break;
                    }
                }

                kli = new Klingon(strength, name, p);
                ser.add(kli);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.selectKLI)");
        }

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_NIB);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String floraOrFish = rs.getString("floraorfish");
                String planet = rs.getString("planeta");

                for (Planeta planeta : obtainPlanets()) {
                    if (planeta.getName().equals(planet)) {
                        p = planeta;
                        break;
                    }
                }

                nib = new Nibiriano(floraOrFish, name, p);
                ser.add(nib);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.selectNIB)");
        }

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_VUL);
            rs = instruction.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int meditation = rs.getInt("meditation");
                String planet = rs.getString("planeta");

                for (Planeta planeta : obtainPlanets()) {
                    if (planeta.getName().equals(planet)) {
                        p = planeta;
                        break;
                    }
                }

                vul = new Vulcaniano(meditation, name, p);
                ser.add(vul);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.selectVUL)");
        }

        try {
            instruction.close();
            disconnect(conn);
            return ser;
        } catch (SQLException ex) {
            //ex.printStackTrace(System.out);
            throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
        }

    }

    public int insertpla(Planeta planet) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_PLA);
            instruction.setString(1, planet.getName());
            instruction.setString(2, planet.getGalaxy());
            instruction.setInt(3, planet.getPopulationMax());
            instruction.setString(4, planet.getClime());
            instruction.setBoolean(5, planet.isFlora());
            instruction.setBoolean(6, planet.isAquatic());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int inserthum(Humano h, Planeta p) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_HUM);
            instruction.setString(1, h.getName());
            instruction.setString(2, h.getGenero());
            instruction.setInt(3, h.getEdad());
            instruction.setInt(4, h.getCivilizationLevel());
            instruction.setString(5, p.getName());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int insertand(Andoriano a, Planeta p) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_AND);
            instruction.setString(1, a.getName());
            instruction.setString(2, a.getRange());
            instruction.setBoolean(3, a.isIceAtThePoles());
            instruction.setInt(4, a.getCivilizationLevel());
            instruction.setString(5, p.getName());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int insertfer(Ferengi f, Planeta p) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_FER);
            instruction.setString(1, f.getName());
            instruction.setInt(2, f.getGold());
            instruction.setInt(3, f.getCivilizationLevel());
            instruction.setString(4, p.getName());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int insertkli(Klingon k, Planeta p) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_KLI);
            instruction.setString(1, k.getName());
            instruction.setInt(2, k.getForce());
            instruction.setInt(3, k.getCivilizationLevel());
            instruction.setString(4, p.getName());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int insertnib(Nibiriano n, Planeta p) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_NIB);
            instruction.setString(1, n.getName());
            instruction.setString(2, n.getFloraOrFish());
            instruction.setInt(3, n.getCivilizationLevel());
            instruction.setString(4, p.getName());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int insertvul(Vulcaniano v, Planeta p) throws DAO_Excep {
        Connection conn = null;
        //La clase PreparedStatement también permite ejecutar sentencias SQL
        //pero con mayor flexibilidad
        //Mis anotaciones: PreparedStatement a diferencia de Statement, 
        //te permite dejar en ? las variables a insertar y 
        //luego añadirlas con set (ver linea 36 y 37 de ejemplo
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_VUL);
            instruction.setString(1, v.getName());
            instruction.setInt(2, v.getMeditation());
            instruction.setInt(3, v.getCivilizationLevel());
            instruction.setString(4, p.getName());
            //TODO meter resto campos
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }
        }
        //Devolvemos la cantidad de registros afectados, en nuestro caso siempre uno
        return registers;
    }

    public int modificarhum(String genero, int edad, String name) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_UPDATE_HUM);
            instruction.setString(1, genero);
            instruction.setInt(2, edad);
            instruction.setString(3, name);
            //cada vez que modificamos una base de datos llamamos a executeUpdate()
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            //ex.printStackTrace(System.out);
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.update)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.update)");
            }
        }
        //Devolvemos la cantidad de registros afectados
        return registers;
    }

    public int modificarand(String rango, boolean ice, String name) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_UPDATE_AND);
            instruction.setString(1, rango);
            instruction.setBoolean(2, ice);
            instruction.setString(3, name);
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.updateAND)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.updateAND)");
            }
        }
        return registers;
    }

    public int modificarfer(int gold, String name) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_UPDATE_FER);
            instruction.setInt(1, gold);
            instruction.setString(2, name);
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.updateFER)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.updateFER)");
            }
        }
        return registers;
    }

    public int modificarkli(int strength, String name) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_UPDATE_KLI);
            instruction.setInt(1, strength);
            instruction.setString(2, name);
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.updateKLI)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.updateKLI)");
            }
        }
        return registers;
    }

    public int modificarnib(String floraOrFish, String name) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_UPDATE_NIB);
            instruction.setString(1, floraOrFish);
            instruction.setString(2, name);
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.updateNIB)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.updateNIB)");
            }
        }
        return registers;
    }

    public int modificarvul(int meditation, String name) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registers = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_UPDATE_VUL);
            instruction.setInt(1, meditation);
            instruction.setString(2, name);
            registers = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.updateVUL)");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.updateVUL)");
            }
        }
        return registers;
    }

    public int deletepla(Planeta p) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_PLA);
            //cada vez que modificamos una base de datos llamamos a executeUpdate()
            instruccion.setString(1, p.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            //ex.printStackTrace(System.out);
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.delete)");

        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.delete)");
            }
        }
        //Devolvemos la cantidad de registros afectados
        return registers;
    }

    public int deletefer(Ferengi f) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_FER);
            instruccion.setString(1, f.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.delete)");
        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.delete)");
            }
        }
        return registers;
    }

    public int deleteand(Andoriano a) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_AND);
            instruccion.setString(1, a.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.deleteAND)");
        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.deleteAND)");
            }
        }
        return registers;
    }

    public int deletehum(Humano h) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_HUM);
            instruccion.setString(1, h.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.deleteHUM)");
        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.deleteHUM)");
            }
        }
        return registers;
    }

    public int deletekli(Klingon k) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_KLI);
            instruccion.setString(1, k.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.deleteKLI)");
        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.deleteKLI)");
            }
        }
        return registers;
    }

    public int deletenib(Nibiriano n) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_NIB);
            instruccion.setString(1, n.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.deleteNIB)");
        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.deleteNIB)");
            }
        }
        return registers;
    }

    public int deletevul(Vulcaniano v) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruccion = null;
        int registers = 0;
        try {
            conn = connect();
            instruccion = conn.prepareStatement(SQL_DELETE_VUL);
            instruccion.setString(1, v.getName());
            registers = instruccion.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_Controller.DAOSQL.deleteVUL)");
        } finally {
            try {
                instruccion.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Can not close database write process (DAO_Controller.DAOSQL.deleteVUL)");
            }
        }
        return registers;
    }

    public boolean getpoblacion(Planeta p) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        int total = 0;

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_COUNT_ALL);
            instruction.setString(1, p.getName());
            rs = instruction.executeQuery();
            while (rs.next()) {
                total += +1;
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {

            try {
                instruction.close();
                disconnect(conn);
                return p.getPopulationMax() < total;
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }

        }
    }

    public boolean searchAndoriano(Planeta p) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        boolean hayResultados = false;

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SEARCH_AND);
            instruction.setString(1, p.getName());
            rs = instruction.executeQuery();
            while (rs.next()) {
                hayResultados = true;
            }

        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {

            try {
                instruction.close();
                disconnect(conn);
                return hayResultados;
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }

        }
    }

    public boolean searchVulcaniano(Planeta p) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        boolean hayResultados = false;

        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SEARCH_VUL);
            instruction.setString(1, p.getName());
            rs = instruction.executeQuery();
            while (rs.next()) {
                hayResultados = true;
            }

        } catch (SQLException ex) {
            throw new DAO_Excep("Can not write to database (DAO_COntroller.DAOSQL.insert)");
        } finally {

            try {
                instruction.close();
                disconnect(conn);
                return hayResultados;
            } catch (SQLException ex) {
                //ex.printStackTrace(System.out);
                throw new DAO_Excep("Can not close database write process (DAO_COntroller.DAOSQL.insert)");
            }

        }
    }

}
