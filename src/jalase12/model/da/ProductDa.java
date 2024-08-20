package jalase12.model.da;

import jalase12.model.entity.Brand;
import jalase12.model.entity.Product;
import jalase12.model.utils.JdbcProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDa implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;
    private JdbcProvider jdbcProvider = new JdbcProvider();


    public ProductDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Product product) throws SQLException {
        product.setId(jdbcProvider.getNextId("PRODUCT_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setString(3, product.getBrand().name());
        preparedStatement.setInt(4, product.getPrice());
        preparedStatement.setInt(5, product.getCount());
        preparedStatement.setInt(6, product.getOwner().getId());
        preparedStatement.execute();
    }

    public void edit(Product product) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE PRODUCT SET NAME=?, BRAND=?, PRICE=?, COUNT=?, OWNER_ID=? WHERE ID=?"
        );
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getBrand().name());
        preparedStatement.setInt(3, product.getPrice());
        preparedStatement.setInt(4, product.getCount());
        preparedStatement.setInt(5, product.getOwner().getId());
        preparedStatement.setInt(6, product.getId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PRODUCT WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Product> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Product> productList = new ArrayList<>();

        while (resultSet.next()) {
            Product product =
                    Product
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .brand(Brand.valueOf(resultSet.getString("BRAND")))
                            .price(resultSet.getInt("PRICE"))
                            .count(resultSet.getInt("COUNT"))
                            //.owner
                            .build();
            productList.add(product);
        }
        return productList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }

}
