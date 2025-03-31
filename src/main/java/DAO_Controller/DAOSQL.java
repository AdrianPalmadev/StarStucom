package DAO_Controller;

import Excepcion.DAO_Excep;
import Model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final String JDBC_TABLE = "planet";
    private final String JDBC_DDBB_TABLE = JDBC_DDBB + "." + JDBC_TABLE;

    // SELECTS
    private final String SQL_SELECT_ALL = "SELECT * FROM " + JDBC_DDBB_TABLE + ";";
    private final String SQL_SELECT = "SELECT * FROM " + JDBC_DDBB_TABLE + " WHERE (name = ";
    private final String SQL_SELECT2 = "SELECT * FROM " + JDBC_DDBB_TABLE + " WHERE (age = ";

    // INSERTS
    private final String SQL_INSERT_PLA = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, galaxy, MaxPopulation, clime, flora, aquatic) VALUES (?, ?, ?, ?, ?, ?);";
    private final String SQL_INSERT_AND = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, range, ice, civilization) VALUES (?, ?, ?, ?);";
    private final String SQL_INSERT_HUM = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, gender, age, civilization) VALUES (?, ?, ?, ?);";
    private final String SQL_INSERT_FER = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, gold, civilization) VALUES (?, ?, ?);";
    private final String SQL_INSERT_KLI = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, force, civilization) VALUES (?, ?, ?);";
    private final String SQL_INSERT_NIB = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, floraorfish, civilization) VALUES (?, ?, ?);";
    private final String SQL_INSERT_VUL = "INSERT INTO " + JDBC_DDBB + "." + JDBC_TABLE + " (name, meditation, civilization) VALUES (?, ?, ?);";

    private final String SQL_UPDATE = "UPDATE " + JDBC_DDBB_TABLE + " SET age = ? WHERE (name = ?);";
    private final String SQL_DELETE = "DELETE FROM " + JDBC_DDBB_TABLE + " WHERE (name = ";
    private final String SQL_DELETE_ALL = "DELETE FROM " + JDBC_DDBB_TABLE + ";";
    private final String SQL_RESET_AGES = "UPDATE " + JDBC_DDBB_TABLE + " SET age = 0 WHERE (name = ?);";

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
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "galaxy varchar(50),"
                + "MaxPopulation int,"
                + "clime varchar(10),"
                + "flora boolean,"
                + "aquatic boolean);";
        System.out.println(query);
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableAnd(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "range varchar(15),"
                + "ice boolean,"
                + "civilization int);";
        System.out.println(query);
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableHum(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "gender varchar(15),"
                + "age int,"
                + "civilization int);";
        System.out.println(query);
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableFer(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "gold int,"
                + "civilization int);";
        System.out.println(query);
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableKli(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "force int,"
                + "civilization int);";
        System.out.println(query);
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableNib(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "floraorfish varchar(20),"
                + "civilization int);";
        System.out.println(query);
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTableVul(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE + "("
                + "name varchar(50) primary key,"
                + "meditation int,"
                + "civilization int);";
        System.out.println(query);
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

    public int inserthum(Humano h) throws DAO_Excep {
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

    public int insertand(Andoriano a) throws DAO_Excep {
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
            instruction.setString(1, a.getName());
            instruction.setString(2, a.getRange());
            instruction.setBoolean(3, a.isIceAtThePoles());
            instruction.setInt(4, a.getCivilizationLevel());
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

    public int insertfer(Ferengi f) throws DAO_Excep {
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
            instruction.setString(1, f.getName());
            instruction.setInt(2, f.getGold());
            instruction.setInt(3, f.getCivilizationLevel());
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

    public int insertkli(Klingon k) throws DAO_Excep {
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
            instruction.setString(1, k.getName());
            instruction.setInt(2, k.getForce());
            instruction.setInt(3, k.getCivilizationLevel());
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

    public int insertnib(Nibiriano n) throws DAO_Excep {
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
            instruction.setString(1, n.getName());
            instruction.setString(2, n.getFloraOrFish());
            instruction.setInt(3, n.getCivilizationLevel());
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

    public int insertvul(Vulcaniano v) throws DAO_Excep {
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
            instruction.setString(1, v.getName());
            instruction.setInt(2, v.getMeditation());
            instruction.setInt(3, v.getCivilizationLevel());
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

}
