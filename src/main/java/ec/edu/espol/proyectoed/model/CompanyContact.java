package ec.edu.espol.proyectoed.model;

/**
 *
 * @author Matías_Collaguazo
 */
public class CompanyContact extends Contact{
    private String companyName;
    public CompanyContact(String name, String companyName, String phoneNumber, String email) {
        super(name, phoneNumber, email);
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
}
