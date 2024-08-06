package jalase9.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@NoArgsConstructor
@SuperBuilder

public class Product {
    private int id;
    private String name;
    private int count;
    private double price;
    private double total;

}
