package sk.fiit.controllers;

import sk.fiit.models.*;
import javax.enterprise.context.ApplicationScoped;
import java.sql.*;
import java.util.ArrayList;

@ApplicationScoped
public class DatabaseController {
    private final int CUSTOMER = 1;
    private Connection db;
    private final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/backend";

    public DatabaseController(){
        try {
            this.db = DriverManager.getConnection(CONNECTION_URL,"postgres", "pg-heslo");
            System.out.println("Database connection established.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserCustomer login(String username, String password){
        BackendQueries loginQuery = BackendQueries.LOGIN_USER;
        PreparedStatement statement;
        try {
            statement = db.prepareStatement(loginQuery.getQuery());
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            UserCustomer loggedIn = null;
            if(resultSet.next()){
                User user = new User(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4));
                loggedIn = new UserCustomer(user, null, false);
                if(user.getType() == CUSTOMER) {
                    Customer customer = new Customer(resultSet.getLong(5), resultSet.getString(6),
                            resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), user.getId());
                    loggedIn.setCustomer(customer);
                    loggedIn.setCustomer(true);
                }
            }
            return loggedIn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private long getUserId(String username){
        BackendQueries registerUserQuery = BackendQueries.GET_USER_ID;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(registerUserQuery.getQuery());
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getLong(1);
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
    }

    public long registerAccount(RegisterForm registerForm){
        User toRegister = new User(registerForm.getUsername(), registerForm.getPassword(), registerForm.getType());
        Customer newCustomer = new Customer(registerForm.getName(), registerForm.getSurname(),
                registerForm.getPhoneNumber(), registerForm.getOpNumber());
        UserCustomer loggedInId = login(registerForm.getUsername(), registerForm.getPassword());
        long registeredId = -1;
        if(loggedInId == null){
            registeredId = registerUser(toRegister);
        }
        else if(loggedInId.getCustomer() == null){
            registeredId = loggedInId.getUser().getId();
        }
        else if(loggedInId.getCustomer() != null){
            return -1;
        }
        newCustomer.setAccount_id(registeredId);
        BackendQueries registerCustomer = BackendQueries.INSERT_CUSTOMER;
        try{
            //NAME, SURNAME, PHONE_NUMBER, OP_NUMBER
            PreparedStatement preparedStatement = db.prepareStatement(registerCustomer.getQuery(),
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, newCustomer.getName());
            preparedStatement.setString(2, newCustomer.getSurname());
            preparedStatement.setString(3, newCustomer.getPhoneNumber());
            preparedStatement.setString(4, newCustomer.getOpNumber());
            preparedStatement.setLong(5, newCustomer.getAccount_id());

            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0) {
                return affectedRows;
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                newCustomer.setId(generatedKeys.getLong(1));
                return newCustomer.getId();
            }
            else return registeredId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredId;
    }

    public long registerUser(User user){
        BackendQueries registerUserQuery = BackendQueries.INSERT_USER;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(registerUserQuery.getQuery(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getType());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0) {
                return affectedRows;
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                user.setId(generatedKeys.getLong(1));
                return user.getId();
            }
            else return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
    }

    public ArrayList<Car> getUsersCarList(long id){
        ArrayList<Car> cars = new ArrayList<>();
        BackendQueries getUsersCarsQuery = BackendQueries.GET_CAR_LIST;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(getUsersCarsQuery.getQuery());
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Car car = new Car(resultSet.getLong(1),
                                resultSet.getString(2),
                                resultSet.getInt(3),
                                resultSet.getString(4),
                                resultSet.getInt(5));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Car> getCarList(String spz){
        ArrayList<Car> cars = new ArrayList<>();
        BackendQueries getUsersCarsQuery = BackendQueries.GET_CARS_FILTER;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(getUsersCarsQuery.getQuery());
            preparedStatement.setString(1, spz);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Car car = new Car(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Car> getCars(){
        ArrayList<Car> cars = new ArrayList<>();
        BackendQueries getUsersCarsQuery = BackendQueries.GET_CARS;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(getUsersCarsQuery.getQuery());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Car car = new Car(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long registerCar(Car car){
        BackendQueries insertCarQuery = BackendQueries.INSERT_CAR;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(insertCarQuery.getQuery(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, car.getSpz());
            preparedStatement.setInt(2, car.getYearOfManufacture());
            preparedStatement.setString(3, car.getBrand());
            preparedStatement.setLong(4, car.getIdOwner());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0) {
                return affectedRows;
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                car.setId(generatedKeys.getLong(1));
                return  car.getId();
            }
            else return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
    }

    public ArrayList<Repair> getCarsRepairs(long car_id){
        ArrayList<Repair> repairs = new ArrayList<>();
        BackendQueries getRepairsQuery = BackendQueries.GET_CARS_REPAIRS;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(getRepairsQuery.getQuery());
            preparedStatement.setLong(1, car_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Repair repair = new Repair(resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4),
                        resultSet.getInt(5));
                repairs.add(repair);
            }
            return repairs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public long insertCarRepair(Repair repair){
        BackendQueries insertCarQuery = BackendQueries.INSERT_CARS_REPAIRS;
        PreparedStatement preparedStatement;

        try {
            preparedStatement = db.prepareStatement(insertCarQuery.getQuery(), Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, repair.getDescription());
            preparedStatement.setInt(2, repair.getState());
            preparedStatement.setDouble(3, repair.getCost());
            preparedStatement.setLong(4, repair.getIdCar());
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows == 0) {
                return affectedRows;
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                repair.setId(generatedKeys.getLong(1));
                return  repair.getId();
            }
            else return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return e.getErrorCode();
        }
    }

    public ArrayList<Customer> getFilteredCustomers(String surname){
        ArrayList<Customer> customers = new ArrayList<>();
        BackendQueries filterCustomers = BackendQueries.FILTER_CUSTOMER;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = db.prepareStatement(filterCustomers.getQuery());
            preparedStatement.setString(1, surname);
            ResultSet results = preparedStatement.executeQuery();

            while(results.next()){
                Customer customer = new Customer(results.getLong(1),
                        results.getString(2),
                        results.getString(3),
                        results.getString(4),
                        results.getString(5));
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
