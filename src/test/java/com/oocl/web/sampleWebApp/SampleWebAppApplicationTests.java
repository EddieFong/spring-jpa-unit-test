package com.oocl.web.sampleWebApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static com.oocl.web.sampleWebApp.AssertHelper.assertThrows;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SampleWebAppApplicationTests {
    @Autowired
    private SingleEntityRepository singleEntityReposity;
    @Autowired
    private EntityManager entityManager;
    @Test
    public void should_fetch_entity(){
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "Name1";
        singleEntityReposity.save(singleEntity);
        entityManager.flush();

        final SingleEntity fetched = singleEntityReposity.getOne(1L);
        entityManager.clear();

        assertEquals("Name1",fetched.name);
    }

    @Test
    public void should_throw_when_longer(){
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "Name1Name1Name1";

//        singleEntityReposity.saveAndFlush(singleEntity);
        assertThrows(Exception.class,()->{
            singleEntityReposity.saveAndFlush(singleEntity);
        });

    }

}
