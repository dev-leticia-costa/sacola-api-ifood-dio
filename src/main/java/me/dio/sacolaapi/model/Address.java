package me.dio.sacolaapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@AllArgsConstructor
@Builder
@Data
//nao recomendado usar porque pode usar dados que nao serao utilizadas e sobrecarregar, no nosso caso, são poucos dados
@Embeddable //essa classe nao será uma tabela no banco de dados, o endereco ficara dentro da tabela restaurante
//mas porque então nao colocar os atributos dentro de restaurante? Porque endereco será usado também em customer
//para faciliar o reuso de codigo, ex, se tiver fornecedor
@NoArgsConstructor
public class Address
  {
  private String cep;
  private String additionalInformation;
}
