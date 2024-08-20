package jalase12.model.entity;

import jalase11.model.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

public class Sell {
    private int id;
    private Person person;
    private Product product;
    private int price;
    private LocalDate sellTime;
}

