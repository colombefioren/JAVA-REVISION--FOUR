package revision.exo3;

import java.time.Instant;

public class OnlineOrder extends Order {
  private final PaymentMean paymentMean;

  public OnlineOrder(int id, Instant dateDeCreation, Client client, PaymentMean paymentMean) {
    super(id, dateDeCreation, client);
    this.paymentMean = paymentMean;
  }

  public PaymentMean getPaymentMean() {
    return paymentMean;
  }
}
