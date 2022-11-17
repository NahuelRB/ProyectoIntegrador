package com.dh.ProyectoIntegrador.repository.impl;

import com.dh.ProyectoIntegrador.repository.IRepository;
import com.dh.ProyectoIntegrador.model.Patient;
import com.dh.ProyectoIntegrador.repository.configuracion.ConfiguracionJDBC;
import com.dh.ProyectoIntegrador.util.Util;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class PatientRepositoryH2 implements IRepository<Patient> {

    final static Logger log = Logger.getLogger(PatientRepositoryH2.class);
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/h2-database-odontology;INIT=RUNSCRIPT FROM 'createOdontology.sql'";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "1234";
    private ConfiguracionJDBC configuracionJDBC;

    public PatientRepositoryH2(){
        this.configuracionJDBC =new ConfiguracionJDBC();
    }

    @Override
    public Patient save(Patient patient) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        try{
            Class.forName(DB_JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

            preparedStatement = con.prepareStatement("INSERT INTO patient(name,lastname,address,dni,highdate)" +
                    "values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, patient.getSName());
            preparedStatement.setString(2,patient.getSLastname());
            preparedStatement.setString(3, patient.getSAddress());
            preparedStatement.setString(4,patient.getSDni());
            preparedStatement.setString(5, patient.getSHighdate());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if(keys.next()){
                patient.setId(keys.getInt(1));
            }
            preparedStatement.close();
        }catch(Exception e){
           e.printStackTrace();
        }
        return patient;
    }

    @Override
    public Patient getId(int id){
            Connection con = configuracionJDBC.conexion();
            Statement stmt = null;
            String query = String.format("SELECT * FROM PATIENT WHERE ID= '&s'", id);
            Patient patient = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int idPatient = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String dni = rs.getString("dni");
                String date = rs.getString("highdate");
                patient = new Patient(idPatient,name,lastname,address,dni,date);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public Boolean delete(int id) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            ps = con.prepareStatement("DELETE FROM patient WHERE ID = ?");
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Patient> getAll() {
        Connection con = null;
        PreparedStatement ps = null;
        List<Patient> patients = new ArrayList<>();
        Patient patient = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            ps = con.prepareStatement("SELECT * FROM PATIENT");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
             int IIdPatient = rs.getInt("id");
             String SName = rs.getString("name");
             String SLastname = rs.getString("lastname");
             String SAddress = rs.getString("address");
             String SDni = rs.getString("dni");
                String Dhighdate = rs.getString("highdate");

             patient = new Patient(IIdPatient,SName,SLastname,SAddress,SDni,Dhighdate);
             patients.add(patient);
            }

            ps.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return null;
    }

    @Override
    public Patient update(Patient patient) {
        return null;
    }
}
