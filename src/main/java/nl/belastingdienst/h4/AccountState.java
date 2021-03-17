package nl.belastingdienst.h4;

public enum AccountState {
        ok("Ok"),
        notValidated("Not yet validated"),
        lengthError("Length should be 9 or 10"), // 9 < length > 10
        proof11Error("Account number not 11-proof"),
        numericError("Account number is not numeric"), // not a valid integer
        rangeError("Cannot be 0 or negative"); // valid int but <=0

        private String description;

        AccountState(String description){
                this.description = description;
        }

        public String getDescription() {
                return description;
        }
}
