package com.absa.bookapi.controllers;

import com.absa.bookapi.models.Book;
import com.absa.bookapi.models.CreateOrder;
import com.absa.bookapi.models.GuiOrder;
import com.absa.bookapi.models.RetrieveOrder;
import com.absa.bookapi.services.BookService;
import com.absa.bookapi.services.OrderService;
import com.absa.bookapi.services.RetrieveOrdersService;
import com.google.gson.Gson;
import com.nimbusds.jose.shaded.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RetrieveOrdersService retrieveOrdersService;

    @GetMapping("/home")
    public String homePage(Model model) {

        List<Book> bookList = bookService.getBooks();
        String bookJson = JSONArray.toJSONString(bookList);
        model.addAttribute("books", bookJson);

        List<RetrieveOrder> retrieveOrderList = retrieveOrdersService.getAllOrders();
        String ordersJson = JSONArray.toJSONString(retrieveOrderList);
        model.addAttribute("orders", ordersJson);

        model.addAttribute("orderForm", new GuiOrder());

        return "home";
    }

    @PostMapping("/home")
    public String placeOrder(@ModelAttribute("orderForm") GuiOrder order, Model model) {

        String data = order.getOrder();

        Gson gson = new Gson();
        CreateOrder createOrder = gson.fromJson(data, CreateOrder.class);
        ResponseEntity<CreateOrder> createOrderResponseEntity = orderService.createOrder(createOrder);

        if (createOrderResponseEntity != null)
            model.addAttribute("orderResponse", "Success!");
        else
            model.addAttribute("orderResponse", "Failed!");

        homePage(model);

        return "home";
    }
}
