package com.exam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.exam.model.Product;
import com.exam.repository.ProductRepository;
import com.exam.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ExamApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Mock
	private ProductRepository prodRepo;
	
	@InjectMocks
	private ProductService prodServ;
	
	private List<Product> prod = new ArrayList<Product>();
	
	@BeforeEach
	public void setup() {
		 prod.add(new Product("Apple", "100"));
		 prod.add(new Product("LG", "90"));
	}
	
	@Test
	@DisplayName("test1")
	public void test1() {
		given(prodRepo.findByNameContaining("Macbook")).willReturn(prod);
		List<Product> expected = prodRepo.findAll();
		assertEquals(prod, expected);
	}
}
