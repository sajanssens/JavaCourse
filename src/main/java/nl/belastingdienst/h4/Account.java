package nl.belastingdienst.h4;

public class Account {

    private String accountNo;
    // todo use enum for status
    private int state = -1;

    public boolean validate() {

        // reset to 'not validated yet'
        this.state = -1;

        // length ok?
        // @see https://nl.wikipedia.org/wiki/Elfproef
        if(this.accountNo.length() < 9 || this.accountNo.length() > 10){
            this.state = 3;
            return false;
        }

        // is it a number?
        try{
            Integer.parseInt(this.accountNo);
        }
        catch(Exception e){
            this.state = 1;
            return false;
        }

        // does it pass 11-proof?
        ElevenProof ep = new ElevenProof(this.accountNo);
        if(ep.execute()){
            this.state = 0;
            return true;
        }
        else{
            this.state = 2;
            return false;
        }


    }

    public int getState(){
        return this.state;
    }

    public void setNumber(String accountNo){
        this.accountNo = accountNo;
    }

    public String getStateText() {

        String stateText;

        switch (this.state) {
            case -1:
                stateText = "Not yet validated";
                break;
            case 0:
                stateText = "Ok";
                break;
            case 1:
                stateText = "Account number is not numeric";
                break;
            case 2:
                stateText = "Account number not 11-proof";
                break;
            case 3:
                stateText = "Length should be 9 or 10";
                break;

            default:
                stateText = "Unknown state";
        }

        return stateText;
    }

}
