package com.example.backend.domain.market;

import com.example.backend.domain.market.exceptions.CarNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер по работе с маркетплейсом.
 */
@RestController
@RequestMapping("/api/v2/marketplace")
public class MarketplaceController {
    MarketplaceService marketplaceService;

    @Autowired
    public MarketplaceController(MarketplaceService marketplaceService) {
        this.marketplaceService = marketplaceService;
    }

    @Operation(summary = "Get all cars from marketplace")
    @GetMapping
    public List<Car> getCars() {
        return marketplaceService.getMarketplaceCars();
    }

    @Operation(summary = "Get cars from marketplace by brand")
    @GetMapping("/brands/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {
        return marketplaceService.getCarsByBrand(brand);
    }

    @Operation(summary = "Get cars from marketplace by brand and model")
    @GetMapping("/brands/{brand}/models/{model}")
    public List<Car> getCarsByBrandAndModel(@PathVariable String brand, @PathVariable String model) {
        return marketplaceService.getCarsByBrandAndModel(brand, model);
    }

    @Operation(summary = "Get car by id")
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable String id) {
        return marketplaceService.getCarById(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(CarNotFoundException.class)
    public void illegalArgument() {
    }
}
