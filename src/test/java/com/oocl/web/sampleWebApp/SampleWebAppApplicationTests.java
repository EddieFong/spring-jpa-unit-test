package com.oocl.web.sampleWebApp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SampleWebAppApplicationTests {
    @Autowired
    private SingleEntityRepository singleEntityReposity;

    @Test
    public void should_fetch_edtity(){
        final SingleEntity singleEntity = new SingleEntity();
        singleEntity.id = 1L;
        singleEntity.name = "Name1";
        singleEntityReposity.save(singleEntity);

        final SingleEntity fetched = singleEntityReposity.getOne(1L);

        assertEquals("Name1",fetched.name);
    }

}
