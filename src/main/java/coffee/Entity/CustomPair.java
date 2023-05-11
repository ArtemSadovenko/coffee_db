package coffee.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomPair {
    private List<Coffee> coffees = new ArrayList<>();
    private List<Topping> toppings  = new ArrayList<>();

}
