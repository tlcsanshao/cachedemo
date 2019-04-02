package com.sanshao.cachedemo.simplecache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class TestModelService {

    @Cacheable(value = "models", key = "#name")
    public TestModel getTestModel(String name, String address) throws InterruptedException {
        System.out.println("new a testmodel");
        TestModel testModel = new TestModel(name, address);
        return testModel;
    }


    @CacheEvict(value = "models", key = "#name")
    public void deleteCache(String name) {

    }


    @CacheEvict(value = "models", allEntries = true)
    public void deleteAllCache() {

    }


    @CachePut(value = "models", key = "#name")
    public TestModel saveCache(String name, String address) {
        return new TestModel(name, address);
    }
}
