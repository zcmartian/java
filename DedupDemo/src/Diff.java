/**
 * Created by marszhou on 16/1/4.
 */
public class Diff {
    private long poiId;
    private long dianping_outer_id;
    private long meituan_outer_id;
    private String dianpingAccountNumber;
    private String meituanAccountNumber;
    private String dianpingBankAccountName;
    private String meituanBankAccountName;

    public Diff(long poiId, long dianping_outer_id, long meituan_outer_id,
            String dianpingAccountNumber, String meituanAccountNumber,
            String dianpingBankAccountName, String meituanBankAccountName) {
        this.poiId = poiId;
        this.meituan_outer_id = meituan_outer_id;
        this.dianping_outer_id = dianping_outer_id;
        this.dianpingAccountNumber = dianpingAccountNumber;
        this.meituanAccountNumber = meituanAccountNumber;
        this.dianpingBankAccountName = dianpingBankAccountName == null ? "null"
                : dianpingBankAccountName;
        this.meituanBankAccountName = meituanBankAccountName == null ? "null"
                : meituanBankAccountName;
    }

    public long getPoiId() {
        return poiId;
    }

    public void setPoiId(long poiId) {
        this.poiId = poiId;
    }

    public String getDianpingAccountNumber() {
        return dianpingAccountNumber;
    }

    public void setDianpingAccountNumber(String dianpingAccountNumber) {
        this.dianpingAccountNumber = dianpingAccountNumber;
    }

    public String getMeituanAccountNumber() {
        return meituanAccountNumber;
    }

    public void setMeituanAccountNumber(String meituanAccountNumber) {
        this.meituanAccountNumber = meituanAccountNumber;
    }

    public String getDianpingBankAccountName() {
        return dianpingBankAccountName;
    }

    public void setDianpingBankAccountName(String dianpingBankAccountName) {
        this.dianpingBankAccountName = dianpingBankAccountName;
    }

    public String getMeituanBankAccountName() {
        return meituanBankAccountName;
    }

    public void setMeituanBankAccountName(String meituanBankAccountName) {
        this.meituanBankAccountName = meituanBankAccountName;
    }

    public long getMeituan_outer_id() {
        return meituan_outer_id;
    }

    public void setMeituan_outer_id(long meituan_outer_id) {
        this.meituan_outer_id = meituan_outer_id;
    }

    public long getDianping_outer_id() {
        return dianping_outer_id;
    }

    public void setDianping_outer_id(long dianping_outer_id) {
        this.dianping_outer_id = dianping_outer_id;
    }

    @Override
    public int hashCode() {
        return new Long(this.poiId).hashCode()
                + this.dianpingAccountNumber.hashCode()
                + this.meituanAccountNumber.hashCode()
                + this.dianpingBankAccountName.hashCode()
                + this.meituanBankAccountName.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Diff)) {
            return false;
        }

        if (this.dianpingAccountNumber.equals(((Diff) object)
                .getDianpingAccountNumber())
                && this.meituanAccountNumber.equals(((Diff) object)
                        .getMeituanAccountNumber())
                && this.dianpingBankAccountName.equals(((Diff) object)
                        .getDianpingBankAccountName())
                && this.meituanBankAccountName.equals(((Diff) object)
                        .getMeituanBankAccountName())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getPoiId());
        sb.append("\t");
        sb.append(this.getDianping_outer_id());
        sb.append("\t");
        sb.append(this.getMeituan_outer_id());
        sb.append("\t");
        sb.append(this.getDianpingAccountNumber());
        sb.append("\t");
        sb.append(this.getMeituanAccountNumber());
        sb.append("\t");
        sb.append(this.getDianpingBankAccountName());
        sb.append("\t");
        sb.append(this.getMeituanBankAccountName());
        sb.append("\n");
        return sb.toString();
    }
}
