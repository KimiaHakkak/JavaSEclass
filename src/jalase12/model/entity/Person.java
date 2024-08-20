package jalase12.model.entity;

import com.google.gson.Gson;
import jalase11.model.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder


public class Person {
    private int id;
    private String name;
    private String family;
    private LocalDate birthDate;
    private String nationalId;
    private Gender gender;
    private List<Product> productList;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

