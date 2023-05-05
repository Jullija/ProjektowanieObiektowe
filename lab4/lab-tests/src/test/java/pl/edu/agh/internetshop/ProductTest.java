package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(1);
    private static final BigDecimal DISCOUNT = BigDecimal.valueOf(0);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE, DISCOUNT);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE, DISCOUNT);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }


    //self-written tests
    @Test
    public void checkDiscountValue(){
        //given
        BigDecimal discount = BigDecimal.valueOf(0.1);

        //when
        Product product = new Product(NAME, PRICE, discount);

        //then
        assertBigDecimalCompareValue(product.getDiscount(), discount);
    }


    @Test
    public void checkPriceAfterDiscount(){
        //given
        BigDecimal discount = BigDecimal.valueOf(0.1);

        //when
        Product product = new Product(NAME, PRICE, discount);

        //then
        assertBigDecimalCompareValue(product.getPriceWithDiscount(), BigDecimal.valueOf(0.9));
    }
}