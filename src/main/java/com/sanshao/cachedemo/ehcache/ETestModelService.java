package com.sanshao.cachedemo.ehcache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ETestModelService {


    Map<String, ETestModel> map = new HashMap<String, ETestModel>();

    public static final String ALL_KEY = "\"all\"";
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String CACHE_NAME = "cacheDemo";


    @CacheEvict(value = CACHE_NAME, key = ALL_KEY)
    public void create(ETestModel eTestModel) {
        //创建的时候情况all的缓存
        String name = eTestModel.getName();
        map.put(name, eTestModel);
    }

    @Cacheable(value = CACHE_NAME, key = "#name")
    public ETestModel findByName(String name) {
        System.err.println("通过方法获取" + name);
        return map.get(name);
    }

    @Cacheable(value = CACHE_NAME, key = ALL_KEY)
    public List<ETestModel> findAll() {
        System.err.println("通过方法获取alldata");
        Iterator it = map.values().iterator();
        List<ETestModel> list = new ArrayList<>();
        while(it.hasNext()){
            list.add((ETestModel) it.next());
        }
        return list;
    }


    @CachePut(value = CACHE_NAME, key = "#eTestModel.name")
    @CacheEvict(value = CACHE_NAME, key = ALL_KEY)
    public ETestModel update(ETestModel eTestModel) {
        System.out.println(eTestModel);
        map.put(eTestModel.getName(),eTestModel);
        return eTestModel;
    }

    @CacheEvict(value = CACHE_NAME)
    public void delete(String name) {
        map.remove(name);
    }


}
