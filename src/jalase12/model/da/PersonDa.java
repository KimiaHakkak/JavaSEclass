package jalase12.model.da;

import jalase12.model.entity.Gender;
import jalase12.model.entity.Person;
import jalase12.model.utils.JdbcProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDa implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;
    JdbcProvider jdbcProvider = new JdbcProvider();


    public PersonDa() throws SQLException {
        connection = jdbcProvider.getConnection();
    }

    public void save(Person person) throws SQLException {
        person.setId(jdbcProvider.getNextId("PERSON_SEQ"));
        preparedStatement = connection.prepareStatement(
                "INSERT INTO PERSON VALUES(?,?,?,?,?,?)"
        );
        preparedStatement.setInt(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setDate(4, Date.valueOf(person.getBirthDate()));
        preparedStatement.setString(5, person.getNationalId());
        preparedStatement.setString(6, person.getGender().name());
        preparedStatement.execute();
    }

    public void edit(Person person) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "UPDATE PERSON SET NAME=?, FAMILY=?, BIRTH_DATE=?, NATIONAL_ID=?, GENDER=? WHERE ID=?"
        );
        preparedStatement.setString(1, person.getName());
        preparedStatement.setString(2, person.getFamily());
        preparedStatement.setDate(3, Date.valueOf(person.getBirthDate()));
        preparedStatement.setString(4, person.getNationalId());
        preparedStatement.setString(5, person.getGender().name());
        preparedStatement.setInt(6, person.getId());
        preparedStatement.execute();
    }

    public void remove(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(
                "DELETE FROM PERSON WHERE ID=?"
        );
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public List<Person> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement(
                "SELECT * FROM PERSON ORDER BY ID"
        );
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Person> personList = new ArrayList<>();

        while (resultSet.next()) {
            Person person =
                    Person
                            .builder()
                            .id(resultSet.getInt("ID"))
                            .name(resultSet.getString("NAME"))
                            .family(resultSet.getString("FAMILY"))
                            .birthDate(resultSet.getDate("BIRTH_DATE").toLocalDate())
                            .nationalId(resultSet.getString("NATIONAL_ID"))
                            .gender(Gender.valueOf(resultSet.getString("GENDER")))
                            .build();
            personList.add(person);
        }
        return personList;
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}


