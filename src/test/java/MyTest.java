
import edu.gordon.logic.*;
import edu.gordon.sidecar.Simulation;
import edu.gordon.data.Card;
import edu.gordon.view.SimKeyboard;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class MyTest {

    static ATM theATM;
    static Simulation theSimulation;
    static Session theSession;

    @BeforeClass
    public static void initialise(){
        theATM = new ATM(42, "Gordon College", "First National Bank of Podunk",
                null /* We're not really talking to a bank! */);
        theSimulation = new Simulation(theATM);
        theSession = new Session(theATM);
        //start the run() in the ATM
        new Thread(theATM).start();
        theATM.switchOn();
    }

    @Test
    public void depositTest() throws CustomerConsole.Cancelled, Transaction.CardRetained {
        Deposit currentTransaction = new Deposit(theATM, theSession, new Card(123456), 123);
        currentTransaction.performTransaction();
    }

    @Test
    public void withdrawalTest() throws CustomerConsole.Cancelled, Transaction.CardRetained {

        // MyClass is tested
        Withdrawal currentTransaction = new Withdrawal(theATM, theSession, new Card(123456), 123);
        currentTransaction.performTransaction();

        assertEquals("ATM id must be 42", 42, theATM.getID());

    }

    @Test
    public void transferTest() throws CustomerConsole.Cancelled, Transaction.CardRetained {
        Transfer currentTransaction = new Transfer(theATM, theSession, new Card(123456), 123);
        currentTransaction.performTransaction();
    }

    @Test
    public void inquiryTest() throws CustomerConsole.Cancelled, Transaction.CardRetained {
        Inquiry currentTransaction = new Inquiry(theATM, theSession, new Card(123456), 123);
        currentTransaction.performTransaction();
    }

}
