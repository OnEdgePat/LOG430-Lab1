/* * ATM Example system - file CashDispenser.java * * copyright (c) 2001 - Russell C. Bjork * */ package edu.gordon.atm.physical;import edu.gordon.banking.Money;import edu.gordon.simulation.Simulation;/** Manager for the ATM's cash dispenser.  In a real ATM, this would  *  manage a physical device; in this edu.gordon.simulation,  it uses classes  *  in package edu.gordon.simulation to simulate the device. */ public class CashDispenser{    /** Constructor     *     *  @param log the log in which to record dispensing cash     */    public CashDispenser(Log log)    {        this.log = log;                cashOnHand = new Money(0);    }        /** Set the amount of cash initially on hand      *     *  @param initialCash the amount of money in the dispenser     */    public void setInitialCash(Money initialCash)    {        cashOnHand = initialCash;    }        /** See if there is enough cash on hand to satisfy a request     *     *  @param amount the amount of cash the customer wants     *  @return true if at least this amount of money is available     */    public boolean checkCashOnHand(Money amount)    {        return amount.lessEqual(cashOnHand);    }        /** Dispense cash to a customer     *     *  @param amount the amount of cash to dispense     *     *  Precondition: amount is <= cash on hand     */    public void dispenseCash(Money amount)    {        cashOnHand.subtract(amount);                Simulation.getInstance().dispenseCash(amount);                // Log cash having been dispensed                log.logCashDispensed(amount);    }    /** Log into which cash amounts dispensed will be recorded     */     private Log log;        /** Current cash on hand     */    private Money cashOnHand;}