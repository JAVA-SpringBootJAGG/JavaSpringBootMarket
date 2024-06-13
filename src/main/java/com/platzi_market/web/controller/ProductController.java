package com.platzi_market.web.controller;

import com.platzi_market.domain.Product;
import com.platzi_market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }
//    @GetMapping("/{productId}")
//    public Optional<Product> getProduct(@PathVariable("productId") int productId){
//        return productService.getProduct(productId);
//    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
//        return productService.getProduct(productId)
//                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        //desde spring 5 se puede usar la linea de abajo en vez las tres de arriba
          return ResponseEntity.of(productService.getProduct(productId));
    }
//    @GetMapping("/category/{categoryId}")
//    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId")int categoryId){
//        return productService.getByCategory(categoryId)
//                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
    //en el codigo de debajo se consigue que no devuelva un 200 y una lista vacia  , usando un filter si la lista no esta vacia
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId) {
        return productService.getByCategory(categoryId).filter(Predicate.not(List::isEmpty))
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED) ;
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if(productService.delete(productId)){
            return  new ResponseEntity(HttpStatus.OK);
        }else{
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }
}
