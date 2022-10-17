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
//nao recomendado usar porque pode usar dados que nao serao utilizadas e sobrecarregar, no nosso caso, são poucos dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Entity

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private double unityValue;
    @Builder.Default
    //setado como defauld que o produto está disponível ao gerá-lo
    private Boolean isavailable = true; //porque aqui tem true e na classe bag não?
   @ManyToOne
   @JsonIgnore
    private Restaurant restaurant;

}
