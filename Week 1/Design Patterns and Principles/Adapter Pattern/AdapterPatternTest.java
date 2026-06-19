public class AdapterPatternTest {

    public static void main(String[] args) {

        PaymentProcessor paypalProcessor =
                new PayPalAdapter(new PayPalGateway());

        PaymentProcessor stripeProcessor =
                new StripeAdapter(new StripeGateway());

        paypalProcessor.processPayment(1000);

        stripeProcessor.processPayment(2000);
    }
}