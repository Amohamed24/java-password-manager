public class Password {

    private final String site;
    private final String sitePassword;


    public Password(String site, String sitePassword) {
        this.site = site;
        this.sitePassword = sitePassword;
    }

    public String getSitePassword(){
        return sitePassword;
    }

    @Override
    public String toString() {
        return "Site: " + site + " | password: " + sitePassword;
    }
}
