package com.feignclients;

import com.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="${address.service.url}", value = "address-feign-client", path = "/api/address")
//feign client with eureka server to fetch microservice wuth name and not hardcoded ip
@FeignClient(value = "address-service", path = "/api/address")
public interface AddressFeignClient {

    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id);
}
