package me.dio.sacolaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@Builder
@Data
//nao recomendado usar porque pode usar dados que nao serao utilizadas e sobrecarregar, no nosso caso, são poucos dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nome;
    @OneToMany (cascade = CascadeType.ALL)
    //list sempre será many. CascadeType: se excluir um restaranute, excluirá todos os seus atributos ex produtos
    private List<Product> cardapio;
    @Embedded //
    private Address endereco;
}
