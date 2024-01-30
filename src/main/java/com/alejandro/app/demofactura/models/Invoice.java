package com.alejandro.app.demofactura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope //inyecta un proxy para que sea un componente por cada request.
@JsonIgnoreProperties({"targetSource", "advisors"}) //Se eliminan atributos residuales del proxy
public class Invoice {

    private Client client;
    @Value("${invoice.description}")
    private String description;
    private List<Item> items;

    // Inyección de dependencias a través del constructor
    public Invoice(Client client, List<Item> items) {
        this.client = client;
        this.items = items;
    }

    //Se ejecuta cuando se crea el componente, justo después del construct
    //Se debe utilizar la anotación @PostConstruct
    @PostConstruct
    public void init () {
        System.out.println("Creando el componente de la factura");
    }

    //Se ejecuta antes de la destrucción del objeto,
    //se debe utilizar la anotación @PreDestroy
    @PreDestroy
    public void finish () {
        System.out.println("Cerrando conexión con base de datos");
        System.out.println("Cerrando el componente de la factura");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal () {
        return items.stream().
                map(Item::getTotal).
                reduce(0.00, Double::sum);
    }
}
