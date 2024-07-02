package africa.semicolon.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testAddProduct() {

    }
}