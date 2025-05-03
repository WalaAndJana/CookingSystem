package all;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class MyApplication {

    private List<CustomerProfile> customerProfiles = new ArrayList<>();

    public void addCustomerProfile(String name, String preference, String allergy) {
        CustomerProfile customer = new CustomerProfile(name, preference, allergy); // null = لم يُطلب بعد
        if (customer.isValid()) {
            customerProfiles.add(customer);
            System.out.println("✅ Customer added: " + name);
        } else {
            System.out.println("❌ Invalid customer data.");
        }
    }

    public List<CustomerProfile> getCustomerProfiles() {
        return customerProfiles;
    }
    public void addCustomer(CustomerProfile c)
    {



    }


}
