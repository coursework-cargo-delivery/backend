package ru.smart_transportation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smart_transportation.entity.Order;
import ru.smart_transportation.entity.Payment;
import ru.smart_transportation.entity.Station;
import ru.smart_transportation.repo.PaymentRepository;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired MapService mapService;

    public float addReceipt(Order order) {
        final float price = this.countPrice(order);
        final var payment = new Payment();

        payment.setOrder(order);
        payment.setStatus(Boolean.FALSE);
        payment.setCost(BigDecimal.valueOf(price)); //todo рассчитай стоимость перевозки

        paymentRepository.save(payment);

        return price;
    }

    private float countPrice(Order order){
        final var from = order.getStation1();
        final var to = order.getStation2();
        int pathLength = getPathLength(from, to);

        return pathLength * 20 + order.getWeight() * 10;
    }

    static int min_num_of_edges = 0, edge_count = 0;
    private void minEdgeDFSUtil(boolean[] visited,
                                int src, int des)
    {
        visited[src] = true;

        if (src == des)
        {
            if (min_num_of_edges > edge_count)
                min_num_of_edges = edge_count;
        }

        else
        {
            for (int i : adj[src])
            {
                int v = i;

                if (!visited[v])
                {
                    edge_count++;
                    minEdgeDFSUtil(visited, v, des);
                }
            }
        }

        visited[src] = false;
        edge_count--;
    }

    private int getPathLength(Station from, Station to){
        final var map = mapService.getMap();
        final var stations = map.getStations();
        final var intersections = map.getIntersections();
        final var lines = map.getTrainLines();

        int pathLength = 1;
        boolean[] visited = new boolean[to.getId()];
        Arrays.fill(visited, false);

        // To store minimum number of edges
        min_num_of_edges = Integer.MAX_VALUE;

        // To store total number of
        // edges in each path
        edge_count = 0;

        minEdgeDFSUtil(visited, from.getId(), to.getId());

        // Print the minimum number of edges
        System.out.println(min_num_of_edges);

        //todo посчитай длину пути в графе


        return pathLength;
    }

    public void pay(Order order){
        paymentRepository.updateStatusByOrder(Boolean.TRUE, order);
    }
}
