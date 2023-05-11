package coffee.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coffee")
public class Coffee {
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
