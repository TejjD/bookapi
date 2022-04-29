package com.absa.bookapi.services;

import com.absa.bookapi.models.Book;
import com.absa.bookapi.models.CreateOrder;
import com.absa.bookapi.models.Order;
import com.absa.bookapi.models.OrderItem;
import com.absa.bookapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private BookService bookService;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Integer id) {
        return orderRepository.getById(id);
    }

    public Integer placeOrder(Order order) {
        orderRepository.save(order);
        orderRepository.flush();
        return order.getId();
    }

    public void updateOrder(int orderId, float total) {
        orderRepository.updateOrderTotal(orderId, total);
    }

    public ResponseEntity<CreateOrder> createOrder(CreateOrder createOrder) {
        float total = 0;
        Order newOrder = new Order();
        newOrder.setOrderDate(createOrder.getOrderDate());
        newOrder.setCustomerId(createOrder.getCustomerId());
        placeOrder(newOrder);

        for (Map.Entry thisBook : createOrder.getBooks().entrySet()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(newOrder);
            Book book = bookService.getBookById((Integer) thisBook.getKey());
            orderItem.setBook(book);
            orderItem.setQuantity((Integer) thisBook.getValue());
            total += book.getPrice() * (Integer) thisBook.getValue();
            orderItemService.saveOrderItem(orderItem);
        }

        updateOrder(newOrder.getId(), total);

        return new ResponseEntity<>(createOrder, HttpStatus.OK);
    }
}
