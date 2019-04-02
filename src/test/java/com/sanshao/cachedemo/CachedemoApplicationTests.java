package com.sanshao.cachedemo;

import com.sanshao.cachedemo.ehcache.ETestModel;
import com.sanshao.cachedemo.ehcache.ETestModelService;
import com.sanshao.cachedemo.simplecache.TestModel;
import com.sanshao.cachedemo.simplecache.TestModelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CachedemoApplicationTests {

    @Autowired
    TestModelService testModelService;

    @Autowired
    ETestModelService eTestModelService;

    @Test
    public void testSimpleCache() throws InterruptedException {
        TestModel testModel = testModelService.getTestModel("sanshao", "shanghai");
        System.out.println(testModel);


        TestModel testModel1 = testModelService.getTestModel("sanshao", "");
        System.out.println(testModel1);

        testModelService.deleteCache("sanshao");

        TestModel testModel2 = testModelService.getTestModel("sanshao", "");
        System.out.println(testModel2);


        testModelService.deleteAllCache();

        testModelService.saveCache("sanshao","beijing");

        TestModel testModel3 = testModelService.getTestModel("sanshao", "");
        System.out.println(testModel3);

    }

    @Test
    public void testEhCache(){
        eTestModelService.create(new ETestModel("sanshao","shanghai"));
        eTestModelService.create(new ETestModel("zhangsan","shanghai"));




        System.out.println(eTestModelService.findByName("sanshao"));
        System.out.println(eTestModelService.findByName("sanshao"));


        List<ETestModel> list = eTestModelService.findAll();
        System.out.println(list);

        list = eTestModelService.findAll();
        System.out.println(list);

        eTestModelService.update(new ETestModel("sanshao","shanghai"));

        list = eTestModelService.findAll();
        System.out.println(list);

    }




}
