package nl.belastingdienst.h4;

public enum AccountState {
        ok,
        notValidated,
        lengthError, // 9 < length > 10
        proof11Error,
        numericError, // not a valid integer
        rangeError // valid int but <=0
}
