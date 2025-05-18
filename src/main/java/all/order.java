package all;

public class order {


        private CustomerProfile customer;
        private meal meal;
        private double price;



        public CustomerProfile getCustomer() {
            return customer;
        }

        public meal getMeal() {
            return meal;
        }



        public double getPrice() {
        return price;
        }


    @Override
        public String toString() {
            return "🧑 " + customer.getName() + " ordered 🍽 " + meal.getName();
        }


}
