package com.petstore.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import com.petstore.model.Order;

import reactor.core.publisher.Mono;

@Service
public class PetstoreImpl implements V2ApiDelegate {

    public PetstoreImpl() {
        
    }

    @Override
    public Mono<ResponseEntity<Order>> getOrderById(Long orderId,
            ServerWebExchange exchange) {
            Mono<Void> result = Mono.empty();
        
            for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 0, \"petId\" : 6, \"quantity\" : 1, \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"placed\", \"complete\" : true }";
                    result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                    break;
                }
        
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>123456789</id> <petId>123456789</petId> <quantity>123</quantity> <shipDate>2000-01-23T04:56:07.000Z</shipDate> <status>aeiou</status> <complete>true</complete> </Order>";
                    result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/xml"), exampleString);
                    break;
                }
        
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 0, \"petId\" : 6, \"quantity\" : 1, \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"placed\", \"complete\" : true }";
                    result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                    break;
                }
        
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>123456789</id> <petId>123456789</petId> <quantity>123</quantity> <shipDate>2000-01-23T04:56:07.000Z</shipDate> <status>aeiou</status> <complete>true</complete> </Order>";
                    result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/xml"), exampleString);
                    break;
                }
        
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : 0, \"petId\" : 6, \"quantity\" : 1, \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\", \"status\" : \"placed\", \"complete\" : true }";
                    result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                    break;
                }
        
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<Order> <id>123456789</id> <petId>123456789</petId> <quantity>123</quantity> <shipDate>2000-01-23T04:56:07.000Z</shipDate> <status>aeiou</status> <complete>true</complete> </Order>";
                    result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/xml"), exampleString);
                    break;
                }
            }
        

            return result.then(Mono.empty());

        }
}
