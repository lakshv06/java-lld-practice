public interface PaymentStrategy {
    public Double calculateAmount(Ticket ticket, Long exitTime);
}
