package me.dio.sacolaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.dio.sacolaapi.enumeration.FormOfPayment;
//importar as classes que estao em outro pacote

import javax.persistence.*;
import java.util.List;
// a sacola vai ser uma tabela no banco de dados - @entity
@AllArgsConstructor
@Builder
@Data
//nao recomendado usar porque pode usar dados que nao serao utilizadas e sobrecarregar, no nosso caso, são poucos dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Entity //quando estamos trabahando com o banco de dados relacional, é obrigatorio usarmos pk (identificador único @id)
public class ShoppingBag {
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//forma de gerar o id, autoincrement
    private Long id;
    //tabela do banco de dadosa chamada cliente, relacionada a tabela client e por isso deve usar a notação
    // de relacinamento de entidades - um cliente pode ter varias sacolas
    //fetchtype: apresentação do item da tabela, nao vai ver o cliente
    //json: comunicação client e api - json ignore para ignorar caso tenha algum erro
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Customer client;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> itens;
    private double valueTotal;
    @Enumerated
    private FormOfPayment payment;
    private boolean isclosed;
}
//    //a classe sacola é um molde, precisamos de um construtor
//    public ShoppingBag(Long id, Customer client, List<Item> itens, double valueTotal, FormOfPayment payment, boolean isclosed) {
//        this.id = id;
//        this.client = client;
//        this.itens = itens;
//        this.valueTotal = valueTotal;
//        this.payment = payment;
//        this.isclosed = isclosed;
//    }
//    //hibernate exige um construtor vazio
//    //public ShoppingBag() {
//    }
    //retornar o id: get id
    //alterar id: setId
//   // public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Customer getClient() {
//        return client;
//    }
//
//    public void setClient(Customer client) {
//        this.client = client;
//    }
//
//    public List<Item> getItens() {
//        return itens;
//    }
//
//    public void setItens(List<Item> itens) {
//        this.itens = itens;
//    }
//
//    public double getValueTotal() {
//        return valueTotal;
//    }
//
//    public void setValueTotal(double valueTotal) {
//        this.valueTotal = valueTotal;
//    }
//
//    public FormOfPayment getPayment() {
//        return payment;
//    }
//
//    public void setPayment(FormOfPayment payment) {
//        this.payment = payment;
//    }
//
//    public boolean isIsclosed() {
//        return isclosed;
//    }
//
//    public void setIsclosed(boolean isclosed) {
//        this.isclosed = isclosed;
//    }
//}



