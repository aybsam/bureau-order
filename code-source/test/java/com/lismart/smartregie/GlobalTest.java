package com.lismart.smartregie;

import com.lismart.smartregie.domain.Taxe;
import com.lismart.smartregie.service.TaxeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GlobalTest {

    @Autowired
    private TaxeService taxeService;

    @Test
    public void deleteObjectFromList() {
        Taxe taxe = taxeService.findById(1L);
    }
}
