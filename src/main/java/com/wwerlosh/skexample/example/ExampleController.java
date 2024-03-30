package com.wwerlosh.skexample.example;

import com.wwerlosh.skexample.example.dto.ModifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService service;

    @PostMapping("/modify")
    public ExampleEntity.ExampleObject modify(@RequestBody ModifyRequest modifyRequest) {
        return service.modifyCurrentField(modifyRequest);
    }

}
