package coffee.Resource;

import coffee.Entity.Coffee;
import coffee.Entity.Topping;
import coffee.Repository.RepoTopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topping")
public class ToppingResource {
    @Autowired
    private RepoTopping repoTopping;

    @PostMapping("/add")
    public void add(@RequestBody Topping topping){
        repoTopping.save(topping);
    }

    @GetMapping("/{id}")
    public Topping findById(@PathVariable long id){
        return repoTopping.findById(id).get();
    }

    @GetMapping("/all")
    public List<Topping> getAll(){
        return repoTopping.findAll();
    }

}
