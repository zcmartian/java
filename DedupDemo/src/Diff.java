/**
 * Created by marszhou on 16/1/4.
 */
public class Diff {
    private long poiid;
    private String dianpingAccount;
    private String meituanAccount;

    public Diff(long poiid, String dianpingAccount, String meituanAccount){
        this.poiid = poiid;
        this.dianpingAccount = dianpingAccount;
        this.meituanAccount = meituanAccount == null ? "null" : meituanAccount;
    }

    public long getPoiid() {
        return poiid;
    }

    public void setPoiid(long poiid) {
        this.poiid = poiid;
    }

    public String getDianpingAccount() {
        return dianpingAccount;
    }

    public void setDianpingAccount(String dianpingAccount) {
        this.dianpingAccount = dianpingAccount;
    }

    public String getMeituanAccount() {
        return meituanAccount;
    }

    public void setMeituanAccount(String meituanAccount) {
        this.meituanAccount = meituanAccount;
    }

    @Override
    public int hashCode() {
        return new Long(this.poiid).hashCode() +
                this.dianpingAccount.hashCode() +
                this.meituanAccount.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Diff)) {
            return false;
        }

        if (this.dianpingAccount.equals(((Diff) object).getDianpingAccount()) &&
                this.meituanAccount.equals(((Diff) object).getMeituanAccount())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getPoiid());
        sb.append("\t");
        sb.append(this.getDianpingAccount());
        sb.append("\t");
        sb.append(this.getMeituanAccount());
        sb.append("\n");
        return sb.toString();
    }
}
