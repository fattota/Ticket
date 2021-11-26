package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;


class TicketManagerTest {
    private TicketManager manager = new TicketManager();
    private Ticket ticket1 = new Ticket(1, 10, "SVO", "SDG", 300);
    private Ticket ticket2 = new Ticket(2, 15, "SVO", "SDG", 350);
    private Ticket ticket3 = new Ticket(3, 20, "SVO", "SDG", 400);
    private Ticket ticket4 = new Ticket(4, 25, "LHR", "JFK", 800);
    private Ticket ticket5 = new Ticket(5, 30, "LHR", "JFK", 850);
    private Ticket ticket6 = new Ticket(6, 30, "LHR", "JFK", 850);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
    }


    @Test
    void shouldSortByPrice() {
        Ticket[] actual = manager.findAllFromTo("SVO", "SDG");
        Ticket[] expected = new Ticket[]{ticket1, ticket2, ticket3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSortByPriceWithDifferentAirports() {
        Ticket[] actual = manager.findAllFromTo("SVO", "JFK");
        Ticket[] expected = new Ticket[]{};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSortByEqualPrice() {
        Ticket[] actual = manager.findAllFromTo("LHR", "JFK");
        Ticket[] expected = new Ticket[]{ticket4, ticket5, ticket6};

        assertArrayEquals(expected, actual);
    }
}