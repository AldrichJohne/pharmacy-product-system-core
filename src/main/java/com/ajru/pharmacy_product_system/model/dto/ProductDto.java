package com.ajru.pharmacy_product_system.model.dto;

import com.ajru.pharmacy_product_system.model.Product;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private long remainingStock;
    private long totalStock;
    private long sold;
    private double pricePerPc;
    private double srpPerPc;
    private double totalPriceRemaining;
    private double totalPriceSold;
    private double profit;
    private LocalDate expiryDate;
    private PlainClassificationDto plainClassificationDto;
    private List<ProductTrxnJournalDto> productTrxnJournalDtos = new ArrayList<>();

    //transform product to productDto
    public static ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setRemainingStock(product.getRemainingStock());
        productDto.setTotalStock(product.getTotalStock());
        productDto.setSold(product.getSold());
        productDto.setPricePerPc(product.getPricePerPc());
        productDto.setSrpPerPc(product.getSrpPerPc());
        productDto.setTotalPriceRemaining(product.getTotalPriceRemaining());
        productDto.setTotalPriceSold(product.getTotalPriceSold());
        productDto.setProfit(product.getProfit());
        productDto.setExpiryDate(product.getExpiryDate());
        productDto.setProductTrxnJournalDtos(product.getProductTrxnJournals().stream().map(ProductTrxnJournalDto::from).collect(Collectors.toList()));

        if(Objects.nonNull(product.getClassification())) {
            productDto.setPlainClassificationDto(PlainClassificationDto.from(product.getClassification()));
        }
        return productDto;
    }
}
