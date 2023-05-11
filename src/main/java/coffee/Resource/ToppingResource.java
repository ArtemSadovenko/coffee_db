package coffee.Resource;

import coffee.Entity.Coffee;
import coffee.Entity.Topping;
import coffee.Repository.ToppingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topping")
public class ToppingResource {
    @Autowired
    private ToppingRepo toppingRepo;

    @PostMapping("/add")
    public void add(@RequestBody Topping topping){
        toppingRepo.save(topping);
    }

    @GetMapping("/{id}")
    public Topping findById(@PathVariable long id){
        return toppingRepo.findById(id);
    }

    @GetMapping("/all")
    public List<Topping> getAll(){
        return toppingRepo.getAll();
    }

//    @GetMapping("/test")
//    public Topping coffee(){
//        Topping coffee = new Topping(1, "late", 12);
//        return coffee;
//    }
}
