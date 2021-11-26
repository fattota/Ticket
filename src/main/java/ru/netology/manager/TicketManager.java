package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;
import java.util.Arrays;


public class TicketManager {
    private TicketRepository repository = new TicketRepository();

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {

    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public Ticket[] findAllFromTo(String from, String to) {
        Ticket[] tickets = repository.findAll();
        Ticket[] result = new Ticket[0];
        int index = 0;
        for (Ticket ticket : tickets) {
            if ((ticket.getFrom()).equals(from) && (ticket.getTo()).equals(to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);

            }
        }
        return result;
    }

    public Ticket[] getTickets() {
        Ticket[] tickets = repository.findAll();
        return tickets;
    }

}
