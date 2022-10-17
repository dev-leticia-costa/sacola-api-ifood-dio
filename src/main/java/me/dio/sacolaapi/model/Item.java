package me.dio.sacolaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Entity
public class Item {
    //relacionada com a tabela de produto e com a tabela de sacola
    //1 item só tem 1 produto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Product product;

    public Item(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;
    @ManyToOne
    //uma sacola tem varios itens
    @JsonIgnore
    private ShoppingBag sacolaItem;
}

