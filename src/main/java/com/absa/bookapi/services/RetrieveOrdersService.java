package com.absa.bookapi.services;

import com.absa.bookapi.models.Book;
import com.absa.bookapi.models.Order;
import com.absa.bookapi.models.RetrieveOrder;
import com.absa.bookapi.repositories.BookRepository;
import com.absa.bookapi.repositories.OrderItemRepository;
import com.absa.bookapi.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class RetrieveOrdersService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<RetrieveOrder> getAllOrders() {

        List<RetrieveOrder> ordersList = new ArrayList<>();
        List<Order> orderIds = orderRepository.getOrders();
        List<Integer> bookIds;
        List<Book> bookList = new ArrayList<>();

        for (Order order : orderIds) {
            RetrieveOrder currentOrder = new RetrieveOrder();
            bookList.clear();
            bookIds = orderItemRepository.getBooksForOrderId(order.getId());

            for (int bookId : bookIds) {
                bookList.add(bookRepository.getBooksByBookId(bookId));
            }

            currentOrder.setId(order.getId());
            currentOrder.setOrderDate(order.getOrderDate());
            currentOrder.setCustomerId(order.getCustomerId());
            currentOrder.setBooks(bookList);

            if (order.getTotal() != null)
                currentOrder.setTotal(order.getTotal());
            ordersList.add(currentOrder);
        }
        return ordersList;
    }
}
