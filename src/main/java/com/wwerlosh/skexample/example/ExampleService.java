package com.wwerlosh.skexample.example;

import com.wwerlosh.skexample.example.dto.ModifyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleDao dao;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public ExampleEntity.ExampleObject modifyCurrentField(ModifyRequest modifyRequest) {
        ExampleEntity entity = dao.findById(modifyRequest.id())
                .orElseThrow(() ->
                        new RuntimeException("Error occurred with getting entity by ID: " + modifyRequest.id()));

        ExampleEntity.ExampleObject obj = entity.getObj();
        obj.setCurrent(obj.getCurrent() + modifyRequest.add());
        entity.setObj(obj);
        return entity.getObj();
    }
}
