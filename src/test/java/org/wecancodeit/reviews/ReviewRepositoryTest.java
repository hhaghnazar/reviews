package org.wecancodeit.reviews;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;

public class ReviewRepositoryTest {
    private ReviewRepository underTest;
    private Laptop laptopOne = new Laptop(1L, "artifact one name", "description", "model", "category", "img url");
    private Laptop laptopTwo = new Laptop(2L, "artifact two name", "description", "model", "category", "img url");

    @Test
    public void shouldFindLaptopOne() {
        Laptop laptopOne = new Laptop(1L, "Laptop one name", "description", "model", "category", "img url");
        ReviewRepository underTest = new ReviewRepository(laptopOne);
        Laptop foundLaptop = underTest.findOne(1L);
        assertEquals(laptopOne, foundLaptop);
    }

    @Test
    public void shouldFindLaptopOneAndLaptopTwo() {
        ReviewRepository underTest = new ReviewRepository(laptopOne, laptopTwo);
        Collection<Laptop> foundLaptops = underTest.findAll();
        assertThat(foundLaptops).contains(laptopOne);

    }
}
