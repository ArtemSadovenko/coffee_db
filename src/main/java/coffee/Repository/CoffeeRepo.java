package coffee.Repository;

import coffee.Entity.Coffee;
import coffee.Entity.Topping;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CoffeeRepo {
    private List<Coffee> coffees = new ArrayList<>();
    private long id = 0;

    public void save(Coffee top){
        ++id;

        top.setId(id);
        coffees.add(top);
    }

    public Coffee findById(long id){
        return coffees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    public List<Coffee> getAll(){
        return coffees;
    }

    public void update(Coffee coffee){
        Coffee old = findById(coffee.getId());
        old.setAmount(coffee.getAmount());
    }

    public void min(Coffee coffee){
        Coffee old = findById(coffee.getId());
        old.setAmount(old.getAmount() - coffee.getAmount());
    }
}