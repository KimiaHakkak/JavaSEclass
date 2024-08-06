package jalase9.da;

import jalase9.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDa {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public void connect()throws Exception {
        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "kimia",
                "java123"
        );
    }

    public void close()throws Exception{
        preparedStatement.close();
        connection.close();
    }

    public void save(Product product)throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PRODUCT(ID,NAME,COUNT,PRICE,TOTAL)VALUES(PRODUCT_SEQ.NEXTVAL,?,?,?,?)"
        );

        preparedStatement.setString(1,product.getName());
        preparedStatement.setInt(2,product.getCount());
        preparedStatement.setDouble(3,product.getPrice());
        double sum = (product.getPrice()*product.getCount());
        preparedStatement.setDouble(4,sum);
        preparedStatement.execute();

        close();
    }

    public void edit(Product product)throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "UPDATE PRODUCT SET NAME=?,COUNT=?,PRICE=?,TOTAL=? WHERE ID=?"
        );
        preparedStatement.setString(1,product.getName());
        preparedStatement.setInt(2,product.getCount());
        preparedStatement.setDouble(3,product.getPrice());
        double sum = (product.getPrice()*product.getCount());
        preparedStatement.setDouble(4,sum);
        preparedStatement.setInt(5,product.getId());
        preparedStatement.execute();
        close();
    }

    public void remove(int id)throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PRODUCT WHERE ID=?"
        );
        preparedStatement.setInt(1,id);
        preparedStatement.execute();

        close();
    }

    public List<Product> findAll()throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Product> productList = new ArrayList<Product>();
        while(resultSet.next()){
            Product product = Product
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .count(resultSet.getInt("count"))
                    .price(resultSet.getDouble("price"))
                    .total(resultSet.getDouble("total"))
                    .build();
            productList.add(product);
        }
        close();
        return productList;
    }

    public Product findByName(String name)throws Exception{
        connect();
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PRODUCT WHERE NAME=?"
        );
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Product product = null;
        if(resultSet.next()){
            product = Product
                    .builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .count(resultSet.getInt("count"))
                    .price(resultSet.getDouble("price"))
                    .total(resultSet.getDouble("total"))
                    .build();
        }
        close();
        return product;
    }



}
