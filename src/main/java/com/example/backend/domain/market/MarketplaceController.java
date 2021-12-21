package com.example.backend.domain.market;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер по работе с маркетплейсом.
 */
@RestController
@RequestMapping("/api/v1/marketplace")
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
}
