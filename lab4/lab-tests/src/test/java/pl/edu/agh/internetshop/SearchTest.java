package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class SearchTest {

    private Order getMockedOrder() {
        Order order = mock(Order.class);
        given(order.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(20));
        given(order.getClientName()).willReturn("Kowalski");
        Product prod1 = new Product("Banana", BigDecimal.valueOf(10), BigDecimal.valueOf(0.0));
        Product prod2 = new Product("Apple", BigDecimal.valueOf(100), BigDecimal.valueOf(0.9));
        List<Product> products = Arrays.asList(prod1, prod2);
        given(order.getProducts()).willReturn(products);

        return order;
    }


    @Test
    public void priceSearch(){
        //given
        Order order = getMockedOrder();

        //when
        Search search1 = new OrderPriceSearch(BigDecimal.valueOf(20));
        Search search2 = new OrderPriceSearch(BigDecimal.valueOf(100));

        //then
        assertTrue(search1.filter(order));
        assertFalse(search2.filter(order));

    }

    @Test
    public void clientNameSearch(){
        //given
        Order order = getMockedOrder();

        //when
        Search search1 = new ClientNameSearch("Kowalski");
        Search search2 = new ClientNameSearch("Nowak");

        //then
        assertTrue(search1.filter(order));
        assertFalse(search2.filter(order));

    }

    @Test
    public void productNameSearch(){
        //given
        Order order = getMockedOrder();

        //when
        Search search1 = new ProductNameSearch("Banana");
        Search search2 = new ProductNameSearch("Avocado");

        //then
        assertTrue(search1.filter(order));
        assertFalse(search2.filter(order));

    }

    @Test
    public void multipleSearches(){
        //given
        Order order = getMockedOrder();
        Search search1 = new ProductNameSearch("Banana");
        Search search2 = new ProductNameSearch("Avocado");
        Search search3 = new ClientNameSearch("Kowalski");
        Search search4 = new ClientNameSearch("Nowak");
        Search search5 = new OrderPriceSearch(BigDecimal.valueOf(20));
        Search search6 = new OrderPriceSearch(BigDecimal.valueOf(200));

        //when
        MultipleSearch multi1 = new MultipleSearch(Arrays.asList(search1, search3, search5));
        MultipleSearch multi2 = new MultipleSearch(Arrays.asList(search1, search3, search6));
        MultipleSearch multi3 = new MultipleSearch(Arrays.asList(search1, search4, search5));
        MultipleSearch multi4 = new MultipleSearch(Arrays.asList(search2, search3, search5));

        //then
        assertTrue(multi1.filter(order));
        assertFalse(multi2.filter(order));
        assertFalse(multi3.filter(order));
        assertFalse(multi4.filter(order));
    }


    @Test
    public void multipleOrders(){
        //given
        List<Order> orders = Arrays.asList(mock(Order.class), mock(Order.class));

        //when
        History history = new History(orders);

        //then
        assertEquals(orders.get(0), history.getPastOrders().get(0));
        assertEquals(orders.get(1), history.getPastOrders().get(1));

    }

    @Test
    public void multipleOrdersSearch(){
        //given
        Product prod1 = new Product("Banana", BigDecimal.valueOf(10.0), BigDecimal.valueOf(0.0));
        Product prod2 = new Product("Apple", BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.9));
        Product prod3 = new Product("Avocado", BigDecimal.valueOf(200.0), BigDecimal.valueOf(0.5));

        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        Order order3 = mock(Order.class);

        given(order1.getClientName()).willReturn("Kowalski");
        given(order2.getClientName()).willReturn("Nowak");
        given(order3.getClientName()).willReturn("Brzęczyszczykiewicz");

        given(order1.getProducts()).willReturn(Arrays.asList(prod1, prod2, prod3));
        given(order2.getProducts()).willReturn(Arrays.asList(prod1, prod3));
        given(order3.getProducts()).willReturn(Arrays.asList(prod2, prod3));

        given(order1.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(120));
        given(order2.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(110));
        given(order3.getPriceWithTaxes()).willReturn(BigDecimal.valueOf(110));

        Search search1 = new ProductNameSearch("Banana");
        Search search2 = new ProductNameSearch("Soap");
        Search search3 = new ClientNameSearch("Kowalski");
        Search search4 = new ClientNameSearch("Brzęczyszkiewicz");
        Search search5 = new OrderPriceSearch(BigDecimal.valueOf(120));
        Search search6 = new OrderPriceSearch(BigDecimal.valueOf(2000));

        Search multi1 = new MultipleSearch(Arrays.asList(search1, search3, search5));
        Search multi2 = new MultipleSearch(Arrays.asList(search2, search4, search6));
        Search multi3 = new MultipleSearch(Arrays.asList(search1, search3));
        Search multi4 = new MultipleSearch(Arrays.asList(search1, search4, search5));



        //when
        History history = new History(Arrays.asList(order1, order2, order3));

        //then
        assertSame(order1, history.getFilteredOrders(multi1).get(0));
        assertSame(0, history.getFilteredOrders(multi2).size());
        assertSame(order1, history.getFilteredOrders(multi3).get(0));
        assertSame(0, history.getFilteredOrders(multi4).size());

    }



    }
