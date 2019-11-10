import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(name = "Servlet", urlPatterns = {"/"})
public class Servlet extends HttpServlet {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/game_shop";
    private static final String DATABASE_USER = "nikittosii";
    private static final String DATABASE_PASSWORD = "111261";
    private static final String TABLE_GAMES = "games";
    private static final String GET_ALL_GAMES = "SELECT * FROM games";
    private Connection connection = null;
    Statement statement = null;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.setAttribute("resultSet", select_all());
        request.getRequestDispatcher("/start.jsp").forward(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch(request.getParameter("button")){
            case "delete":
                delete(request.getParameter("id"));
                break;
            case "change":
                change(request.getParameter("id"), request.getParameter("nameOfGame"), request.getParameter("studioOfGame"), request.getParameter("costOfGame"));
                break;
            case "add":
                add(request.getParameter("nameOfGame"), request.getParameter("studioOfGame"), request.getParameter("costOfGame"));
                break;
            default:
                break;
        }
        request.setAttribute("resultSet", select_all());
        request.getRequestDispatcher("/start.jsp").forward(request, response);
    }

    private ArrayList<String[]> select_all(){
        ArrayList<String[]> resultForReq = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_GAMES);
            while(resultSet.next()){
                String[] tmp = new String[4];
                tmp[0] = resultSet.getString("name");
                tmp[1] = resultSet.getString("studio_name");
                tmp[2] = resultSet.getString("cost");
                tmp[3] = resultSet.getString("id");
                resultForReq.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultForReq;
    }

    private void add(String name, String studio, String cost) throws ServletException, IOException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String query = String.format(
                    "INSERT INTO %1$s VALUES (DEFAULT, '%2$s', '%3$s', '%4$s', null, null); ",
                    TABLE_GAMES, name, studio, cost);
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void change(String id, String name, String studio, String cost){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String query = String.format(
                    "UPDATE %1$s SET (id, name, studio_name, cost) = (%5$s, '%2$s', '%3$s', '%4$s') WHERE id=%5$s;",
                    TABLE_GAMES, name, studio, cost, id);
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete(String id){
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            statement = connection.createStatement();
            String query = String.format(
                    "DELETE FROM %1$s WHERE id = %2$s;",
                    TABLE_GAMES, id);
            statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}