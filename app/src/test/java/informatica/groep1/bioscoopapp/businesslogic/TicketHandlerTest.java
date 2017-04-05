package informatica.groep1.bioscoopapp.businesslogic;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by twanv on 5-4-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class TicketHandlerTest {

    private TicketHandler ticketHandler;

    @Mock TextView mMockTVTicketCount;
    @Mock TextView mMockTVAdultTicketCount;
    @Mock TextView mMockTVChildTicketCount;
    @Mock TextView mMockTVPrice;
    @Mock Button mMocBTReservation;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();


    @Before
    public void setUp() throws Exception {
        ticketHandler = new TicketHandler(mMockTVTicketCount, mMockTVAdultTicketCount,
                mMockTVChildTicketCount, mMockTVPrice, mMocBTReservation);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getPrice() throws Exception {

        // try to remove tickets while tickets are already 0
        ticketHandler.removeChildrenTicket();
        ticketHandler.removeTicket();
        ticketHandler.removeAdultTicket();

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 0.0, ticketHandler.getPrice(), 0.001);

        // add one ticket. Should be a adult ticket.
        ticketHandler.addTicket();

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 8.0, ticketHandler.getPrice(), 0.001);

        // add one child ticket. This should change the adult ticket to
        // a child ticket. Total ticket count should still be 1.
        ticketHandler.addChildrenTicket();

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 6.0, ticketHandler.getPrice(), 0.001);

        // remove the total of 1 tickets again
        ticketHandler.removeTicket();

        for (int i = 0; i < 99; i++) {
            ticketHandler.addTicket(); // make 50 adult tickets and 49 child tickets
        }

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 694.0, ticketHandler.getPrice(), 0.001);

        // add one ticket to make total ticket count 100
        ticketHandler.addTicket();

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 700.0, ticketHandler.getPrice(), 0.001);

        // add 1 tickets so total ticket count = 101
        ticketHandler.addTicket();

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 700.0, ticketHandler.getPrice(), 0.001);

        // add another ticket to make total ticket count 102
        ticketHandler.addTicket();

        // child ticket = €6.0  &&  adult ticket = €8.0
        assertEquals("Ticket price is not correct", 700.0, ticketHandler.getPrice(), 0.001);

    }

}