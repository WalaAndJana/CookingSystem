package all;

public class order {


        private CustomerProfile customer;
        private meal meal;

        public order(CustomerProfile customer, meal meal) {
            this.customer = customer;
            this.meal = meal;
        }

        public CustomerProfile getCustomer() {
            return customer;
        }

        public meal getMeal() {
            return meal;
        }

        @Override
        public String toString() {
            return "🧑 " + customer.getName() + " ordered 🍽 " + meal.getName();
        }


}
