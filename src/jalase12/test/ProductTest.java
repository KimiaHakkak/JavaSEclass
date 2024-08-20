package jalase12.test;

import jalase11.model.da.ProductDa;

import java.sql.SQLException;

public class ProductTest {
    public static void main(String[] args) throws Exception {
//        try with resource
        try(ProductDa productDa = new ProductDa()){
            productDa.save(null);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}