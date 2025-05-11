package com.naboo.primera_fase.service;

import java.util.List;
import java.util.stream.Collectors;

import com.naboo.primera_fase.entity.Cart;
import com.naboo.primera_fase.entity.CartItem;
import com.naboo.primera_fase.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.naboo.primera_fase.entity.Order;
import com.naboo.primera_fase.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Integer id, Order newOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatOrder'");
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id).get();
    }

    public Order createOrder(int userId) {
        // Buscar el carrito del usuario
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("El carrito está vacío o no existe.");
        }

        // Crear el pedido
        Order order = new Order();
        order.setUserId(userId);

        // Crear una copia de los ítems para evitar referencias compartidas
        List<CartItem> orderItems = cart.getItems().stream()
                .map(item -> {
                    CartItem newItem = new CartItem();
                    newItem.setProduct(item.getProduct());
                    newItem.setQuantity(item.getQuantity());
                    return newItem;
                })
                .collect(Collectors.toList());

        order.setItems(orderItems);
        order.setTotalAmount(orderItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum());

        // Guardar el pedido
        order = orderRepository.save(order);

        // Vaciar el carrito
        cart.setItems(null); // O también puedes usar cart.getItems().clear();
        cartRepository.save(cart);

        return order;
    }
}
