package nl.belastingdienst.h4;

public class Account {

    private String accountNo;

    private AccountState state = AccountState.notValidated;

    public boolean validate() {

        // reset to 'not validated yet'
        this.state = AccountState.notValidated;

        // length ok?
        // @see https://nl.wikipedia.org/wiki/Elfproef
        if (this.accountNo.length() < 9 || this.accountNo.length() > 10) {
            this.state = AccountState.lengthError;
            return false;
        }

        // is it a number?
        try {
            Integer.parseInt(this.accountNo);
        } catch (Exception e) {
            this.state = AccountState.numericError;
            return false;
        }

        // range Ok?
        if (Integer.parseInt(this.accountNo) <= 0) {
            this.state = AccountState.rangeError;
            return false;
        }

        // does it pass 11-proof?
        ElevenProof ep = new ElevenProof(this.accountNo);
        if (ep.execute()) {
            this.state = AccountState.ok;
            return true;
        } else {
            this.state = AccountState.proof11Error;
            return false;
        }
    }

    public AccountState getState() {
        return this.state;
    }

    public void setNumber(String accountNo) {
        this.accountNo = accountNo;
    }


}
