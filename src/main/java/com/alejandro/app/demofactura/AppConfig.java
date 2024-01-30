package com.alejandro.app.demofactura;

import com.alejandro.app.demofactura.models.Item;
import com.alejandro.app.demofactura.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean
    //@Primary
    List<Item> itemsInvoice () {
        Product p1 = new Product("Computadora", 10000.00);
        Product p2 = new Product("Teclado", 1000.00);
        Product p3 = new Product("Mouse", 800.00);

        return Arrays.asList(
                new Item(p1, 1),
                new Item(p2, 2),
                new Item(p3, 1)
        );
    }

    @Bean
    @Primary
    List<Item> itemsInvoice2 () {
        Product p1 = new Product("Macbook", 12000.00);
        Product p2 = new Product("Airpods", 1500.00);
        Product p3 = new Product("Airtag", 100.00);

        return Arrays.asList(
                new Item(p1, 1),
                new Item(p2, 1),
                new Item(p3, 5)
        );
    }

}
