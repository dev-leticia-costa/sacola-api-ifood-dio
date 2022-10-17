package me.dio.sacolaapi.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.sacolaapi.enumeration.FormOfPayment;
import me.dio.sacolaapi.model.Item;
import me.dio.sacolaapi.model.ShoppingBag;
import me.dio.sacolaapi.model.Restaurant;
import me.dio.sacolaapi.repository.ItemRepository;
import me.dio.sacolaapi.repository.ProductRepository;
import me.dio.sacolaapi.repository.ShoppingBagRepository;
import me.dio.sacolaapi.resource.dto.ItemDto;
import me.dio.sacolaapi.service.ShoppingBagService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ShoppingBagImplements implements ShoppingBagService {


    //classe que vai implementar os metodos definidos no service - override here
    //api vai no bd, pega o id e retorna para o frontend
    //ir no bd: repository

    private final ShoppingBagRepository sacolaRepository;
    private final ProductRepository productRepository;



//    //private final necessita construtor
//    public ShoppingBagImplements(ShoppingBagRepository sacolaRepository) {
//        this.sacolaRepository = sacolaRepository;
//    }
//    //mas como boa prática -> anotaçao RequiredArgsConstructor


    @Override
    public ShoppingBag seeBag(Long id) {

        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException(" not found");
    }
    );
}

        //para ter acesso ao metodo findByid, ele retorna um Optional caso nao exista
        //functional interface : elseThrow -> se nao consegir encontrar, run time exception
        //mensagem: sacola nao existe



//~~~~ADD ITEM~~~~//
    @Override
    public Item addItem(ItemDto itemDto) {
        //qual sacola vai ser inserido
        //parametros: itemDto + id sacola
        //somente insere itens se estiver aberta
        ShoppingBag sacola = seeBag(itemDto.getSacolaId());

        if(sacola.isIsclosed())
        {
            throw new RuntimeException("Esta sacola está fechada");
        }
        Item insertItem = Item.builder()
                .quantity(ItemDto.getQuantity())
                .sacolaItem(sacola)
                .product(productRepository.findById(itemDto.getProductId()).orElseThrow(
                () -> {
                    throw new RuntimeException(" not found");
                }
        ))
        .build();

        List<Item> itemBag = sacola.getItens();
        if (itemBag.isEmpty()) {
            itemBag.add(insertItem);
        }
        //caso contrario, verificar se é do mesmo restaurante; se nao for,exceçao
        else {
            Restaurant restaurantCurrent = itemBag.get(0).getProduct().getRestaurant();
            Restaurant restaurantInsertItem = insertItem.getProduct().getRestaurant();
            //get(0) ->funcao de list (pegar o primeiro item da scola)
            //comparar restanrante com restauranteatual

            if (restaurantCurrent.equals(restaurantInsertItem)) {
                itemBag.add(insertItem);
            } else {
                throw new RuntimeException(" Can´t add product: different restaurants");
            }
        }
    sacolaRepository.save(sacola);

                //anotaçao @builder (design pattern) -. construir objeto com esse metodo e fechar com o build
        //para construir o objeto: id (gerado automaticamente), saber qual produto, quantidade e em qual sacola será inserido
        //.quantidade-> itemDtio
        //somente itens do mesmo restaurante podem ser adicionado, casop já tenha um item.
        return null;
    }
    //~~~~CLOSE BAG~~~~//
    @Override
    public ShoppingBag closeBag(Long id, int numeroFormPayment) {
        ShoppingBag sacola = seeBag(id);
        if (sacola.getItens().isEmpty()) {
            throw new RuntimeException("Por favor, inclua itens na sacola!");
        }
        FormOfPayment formadePagamento =
                numeroFormPayment == 0 ? FormOfPayment.MONEY : FormOfPayment.CARD;

        sacola.setPayment(formadePagamento);
        sacola.setIsclosed(true);
        return sacolaRepository.save(sacola);
    }


        //1º qual sacola -> ver sacola (porque já passou pela exceção)
        //2º sacola vazia nao pode ser fechada
        //pegar metodo get itens pra saber se tem itens = retorna lista de item
        //isEmpty: ver se a lista tem itens ou nao -> se não -> RuntimeException

        //se tiver itens -> forma de pagamento


}
