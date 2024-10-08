package jalase11.model.entity;

import com.google.gson.Gson;
import jalase11.model.entity.Brand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

public class Product {
    private int id;
    private String name;
    private Brand brand;
    private int price;
    private int count;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
