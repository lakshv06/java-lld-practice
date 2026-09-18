public class StaticPayment implements PaymentStrategy{
    public Double calculateAmount(Ticket ticket, Long exitTime){
        Long entryTime = ticket.getEntryTime();

        return Math.floor((exitTime-entryTime))*10;
    }
}
