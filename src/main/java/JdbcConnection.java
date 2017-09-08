import java.sql.*;

/**
 * Created by Chufan Zhu on 2017/2/28.
 */
public class JdbcConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "ma3undlw77");
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM new_schema.cards");
            ResultSet resultSet = preparedStatement.executeQuery();
//            System.out.println(resultSet.getInt(0));
            resultSet.next();
            System.out.println(resultSet.getInt("CardNumber"));
            System.out.println(resultSet.getString("CardType"));

            PreparedStatement preparedInsertStatement = connection.prepareStatement("INSERT INTO new_schema.cards (CardNumber, CardType) VALUES (2,'Bug')");
            preparedInsertStatement.executeUpdate();

            if (!connection.isClosed()) {
                System.out.println("connected");
            } else {
                System.out.println("not connected");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void selectFrom() {

    }
}
