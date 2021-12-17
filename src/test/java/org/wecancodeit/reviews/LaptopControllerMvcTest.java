package org.wecancodeit.reviews;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

@WebMvcTest(LaptopController.class)
public class LaptopControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewRepository laptopRepo;

    @Mock
    private Laptop laptopOne;

    @Mock
    private Laptop laptopTwo;


    @Test
    public void shouldBeOkForAllLaptopsInTheLaptopsTemplate() throws Exception {
        mockMvc.perform(get("/laptops")).andExpect(status().isOk())
                .andExpect(view().name("laptopsTemplate"));

    }

    @Test
    public void shouldFindAllLaptopsInModel() throws Exception{
        Collection<Laptop> allLaptopsInModel = Arrays.asList(laptopOne, laptopTwo);
        when(laptopRepo.findAll()).thenReturn(allLaptopsInModel);
        mockMvc.perform(get("/laptops")).andExpect(model().attribute("laptopsModel", allLaptopsInModel));
    }

    @Test
    public void shouldBeOkForOneLaptopInTheLaptopTemplate() throws Exception {
        Long laptopOneId = 1L;
        when(laptopRepo.findOne(laptopOneId)).thenReturn(laptopOne);
        mockMvc.perform(get("/laptop?id=1")).andExpect(status().isOk())
                .andExpect(view().name("laptopTemplate"));

    }

    @Test
    public void shoudlFindLaptopOneInModel() throws Exception {
        Long laptopOneId = 1L;
        when(laptopRepo.findOne(laptopOneId)).thenReturn(laptopOne);
        mockMvc.perform(get("/laptop?id=1"))
                .andExpect(model().attribute("laptopModel", laptopOne));
    }


    @Test
    public void shouldBeNotFoundForRequestNotInModel() throws Exception {
        Long laptopTwoId = 2L;
        when(laptopRepo.findOne(laptopTwoId)).thenReturn(laptopTwo);
        mockMvc.perform(get("/laptop?id=3")).andExpect(status().isNotFound());
    }


}
