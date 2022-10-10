package me.dio.sacolaapi.service;

import me.dio.sacolaapi.model.Item;
import me.dio.sacolaapi.model.ShoppingBag;
import me.dio.sacolaapi.resource.dto.ItemDto;

public interface ShoppingBagService {
    //3 funcionalidades:ver sacola, incluir item e fechar sacola
    //precisa retornar a sacola
    // precisa passar o id
  ShoppingBag seeBag(Long id);
  Item addItem(ItemDto itemDto);
  ShoppingBag closeBag(Long id, int FormOfPayment);
  //int porque a forma de pagamento é uma constante (0 ou 1)


}
