public class Teller extends Bank{
    private String TellerName;
    private int TellerID;

    public Teller(){

    }
    public Teller(String TellerName, int TellerID){
        this.TellerName = TellerName;
        this.TellerID = TellerID;
    }

    public String getTellerName() {
        return TellerName;
    }

    public void setTellerName(String tellerName) {
        TellerName = tellerName;
    }

    public int getTellerID() {
        return TellerID;
    }

    public void setTellerID(int tellerID) {
        TellerID = tellerID;
    }
    @Override
    public String toString() {
        return String.format("Your Teller's Name is:  %s\n %s 's ID is: %d\n",TellerName,TellerName,TellerID );
    }
}
