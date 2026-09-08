package com.petstore.api;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;

import com.petstore.jpa.PetRepository;
import com.petstore.model.Order;
import com.petstore.model.Pet;

import reactor.core.publisher.Mono;

@Service
public class PetstoreImpl implements V2ApiDelegate {

    private final PetRepository petRepo;
    public PetstoreImpl(PetRepository petRepo) {
        this.petRepo = petRepo;
    }

    @Override
    public Mono<ResponseEntity<Pet>> getPetById(Long petId,
                                               ServerWebExchange exchange) {
    Mono<Void> result = Mono.empty();

    Pet pet = this.petRepo.findById(petId).get();
    return Mono.just(ResponseEntity.ok(pet));

    /*
    exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
    for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString =
            "{ \"id\" : 0, \"category\" : \"\", \"name\" : \"doggie\", " +
            "\"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ], \"tags\" : [ " +
            "{ \"id\" : 6, \"name\" : \"name\" }, { \"id\" : 6, \"name\" : " +
            "\"name\" } ], \"status\" : \"available\" }";
        result = ApiUtil.getExampleResponse(
            exchange, MediaType.valueOf("application/json"), exampleString);
        break;
      }

      if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
        String exampleString =
            "<Pet> <id>123456789</id> " +
            "<category>UNDEFINED_EXAMPLE_VALUE</category> " +
            "<name>doggie</name> <photoUrls>aeiou</photoUrls> <null> " +
            "<id>123456789</id> <name>aeiou</name> </null> " +
            "<status>aeiou</status> </Pet>";
        result = ApiUtil.getExampleResponse(
            exchange, MediaType.valueOf("application/xml"), exampleString);
        break;
      }

      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString =
            "{ \"id\" : 0, \"category\" : \"\", \"name\" : \"doggie\", " +
            "\"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ], \"tags\" : [ " +
            "{ \"id\" : 6, \"name\" : \"name\" }, { \"id\" : 6, \"name\" : " +
            "\"name\" } ], \"status\" : \"available\" }";
        result = ApiUtil.getExampleResponse(
            exchange, MediaType.valueOf("application/json"), exampleString);
        break;
      }

      if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
        String exampleString =
            "<Pet> <id>123456789</id> " +
            "<category>UNDEFINED_EXAMPLE_VALUE</category> " +
            "<name>doggie</name> <photoUrls>aeiou</photoUrls> <null> " +
            "<id>123456789</id> <name>aeiou</name> </null> " +
            "<status>aeiou</status> </Pet>";
        result = ApiUtil.getExampleResponse(
            exchange, MediaType.valueOf("application/xml"), exampleString);
        break;
      }

      if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
        String exampleString =
            "{ \"id\" : 0, \"category\" : \"\", \"name\" : \"doggie\", " +
            "\"photoUrls\" : [ \"photoUrls\", \"photoUrls\" ], \"tags\" : [ " +
            "{ \"id\" : 6, \"name\" : \"name\" }, { \"id\" : 6, \"name\" : " +
            "\"name\" } ], \"status\" : \"available\" }";
        result = ApiUtil.getExampleResponse(
            exchange, MediaType.valueOf("application/json"), exampleString);
        break;
      }

      if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
        String exampleString =
            "<Pet> <id>123456789</id> " +
            "<category>UNDEFINED_EXAMPLE_VALUE</category> " +
            "<name>doggie</name> <photoUrls>aeiou</photoUrls> <null> " +
            "<id>123456789</id> <name>aeiou</name> </null> " +
            "<status>aeiou</status> </Pet>";
        result = ApiUtil.getExampleResponse(
            exchange, MediaType.valueOf("application/xml"), exampleString);
        break;
      }
    }

    return result.then(Mono.empty());
    */
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
