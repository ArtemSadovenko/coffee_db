package coffee.Repository;

import coffee.Entity.Coffee;
import coffee.Entity.Topping;
import coffee.Entity.Topping;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToppingRepo {
    private List<Topping> toppings = new ArrayList<>();
    private long id = 0;

    public void save(Topping top){
        ++id;

        top.setId(id);
        toppings.add(top);
    }

    public Topping findById(long id){
        return toppings.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    public List<Topping> getAll(){
        return toppings;
    }

    public void update(Topping topping){
        Topping old = toppings.stream()
                .filter(e -> e.getId() == topping.getId())
                .findFirst()
                .get();

        old.setAmount(topping.getAmount());
    }

    public void min(Topping topping){
        Topping old = findById(topping.getId());
        old.setAmount(old.getAmount() - topping.getAmount());
    }
}
