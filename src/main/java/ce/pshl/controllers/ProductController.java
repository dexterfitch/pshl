package ce.pshl.controllers;

import ce.pshl.domain.ProductService;

import ce.pshl.domain.Result;
import ce.pshl.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    };

    @GetMapping("/id/{id}")
    public Product findById(@PathVariable int id) {
        return service.findById(id);
    };

    @GetMapping("/name/{name}")
    public List<Product> filterByNameLike(@PathVariable String name) {
        return service.filterByNameLike(name);
    };

    @GetMapping("/category/{category}")
    public List<Product> filterByCategory(@PathVariable String category) {
        return service.filterByCategory(category);
    };

    @GetMapping("/rating/{rating}")
    public List<Product> filterByRating(@PathVariable int rating) {
        return service.filterByRating(rating);
    };

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Product product) {
        Result<Product> result = service.create(product);

        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }

        return ErrorResponse.build(result);
    };

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Product product) {
        if (id != product.getId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Product> result = service.update(product);

        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        if (service.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    };
}
