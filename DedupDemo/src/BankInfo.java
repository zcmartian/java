/**
 * Created by marszhou on 16/1/4.
 */
public class BankInfo {
    private String cardNumber;
    private long poi_id;
    private String accountName;
    private long outerId;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(long poi_id) {
        this.poi_id = poi_id;
    }

    public long getOuterId() {
        return outerId;
    }

    public void setOuterId(long outerId) {
        this.outerId = outerId;
    }

    @Override
    public boolean equals(Object obj){
        boolean ret = false;

        if (!(obj instanceof BankInfo))
            return ret;

        if (this.getCardNumber().equals(((BankInfo) obj).getCardNumber())) {
            ret = true;
        }

        return ret;
    }
}
