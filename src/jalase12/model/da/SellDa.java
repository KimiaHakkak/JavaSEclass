package jalase12.model.da;

import jalase12.model.entity.Sell;
import jalase12.model.utils.JdbcProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SellDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private JdbcProvider jdbcProvider = new JdbcProvider();

    public SellDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Sell sell) throws SQLException {
        sell.setId(jdbcProvider.getNextId("SELL_TBL_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO SELL_TBL VALUES(?,?,?,?,?)"
        );
        preparedStatement.setInt(1, sell.getId());
        preparedStatement.setInt(2, sell.getPrice());
        preparedStatement.setDate(3, Date.valueOf(sell.getSellTime()));
        //preparedStatement.setString(4, ); Person person
        //preparedStatement.setString(5, ); Product product
        preparedStatement.execute();
    }

    public void edit(Sell sell) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE SELL_TBL SET PRICE=?, SELL_TIME=?, OWNER_ID=?, PRODUCT_ID=? WHERE ID=?"
        );
        preparedStatement.setInt(1, sell.getPrice());
        preparedStatement.setDate(2, Date.valueOf(sell.getSellTime()));
        //preparedStatement.setString(3, ); Person person
        //preparedStatement.setString(4, ); Product product
        preparedStatement.setInt(5, sell.getId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM SELL_TBL WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Sell> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM SELL_TBL ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Sell> sellList = new ArrayList<>();

        while (resultSet.next()) {
            Sell sell =
                    Sell
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .price(resultSet.getInt("PRICE"))
                            .sellTime(resultSet.getDate("SELL_TIME").toLocalDate())
                            //.owner id
                            //.product id
                            .build();
            sellList.add(sell);
        }
        return sellList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
