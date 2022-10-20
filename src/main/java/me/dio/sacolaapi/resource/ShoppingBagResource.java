package me.dio.sacolaapi.resource;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import me.dio.sacolaapi.model.Item;
import me.dio.sacolaapi.model.ShoppingBag;
import me.dio.sacolaapi.resource.dto.ItemDto;
import me.dio.sacolaapi.service.ShoppingBagService;
import org.springframework.web.bind.annotation.*;

@Api(value="/ifood-devweek/shoppingbag")
@RestController
//essa é a classe que contem os endpoints - resource (maperar as urls)
@RequestMapping("/ifood-devweek/shoppingbag")
//definir como serão escritos os endpoints - endereço relativo (localhost)
@RequiredArgsConstructor
//com essa notação, nao precisa adicionar o construtor
public class ShoppingBagResource {
    //colocar como atributo do resource a classe service para incluir os eventos
    private final ShoppingBagService sacolaService;
    //  final; obrigatorio o construtor

//    //construtor
//    public ShoppingBagResource(ShoppingBagService service) {
//        this.sacolaService = service;
//    }

    @GetMapping("/{id}") // ver sacola, quando chegar uma requsição com o id
    public ShoppingBag seeBag(@PathVariable("id") Long id) {
        return sacolaService.seeBag(id);
    }

    @PostMapping //incluir item - passa o item e o retorna
    public  Item addItem(@RequestBody ItemDto itemDto){
      return sacolaService.addItem(itemDto);
    }

    @PatchMapping("/fecharsacola/{id}")
    public ShoppingBag closeBag( @PathVariable ("id") Long id,
                         @RequestParam("payment") int payment){
     return sacolaService.closeBag(id, payment);
    }
//a sacola já existe, o dado é atualizado (patch ou put)






}
