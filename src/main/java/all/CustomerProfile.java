package all;

public class CustomerProfile{


    private String name;
    private String dietaryPreference;
    private String allergy;

    public CustomerProfile(String name, String dietaryPreference, String allergy) {
        this.name = name;
        this.dietaryPreference = dietaryPreference;
        this.allergy = allergy;
    }

    public String getName() {
        return name;
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public String getAllergy() {
        return allergy;
    }

    public boolean isValid() {
        return name != null && dietaryPreference != null && allergy != null;
    }

    public boolean isMealValid() {
        return !dietaryPreference.toLowerCase().contains(allergy.toLowerCase());
    }

}
