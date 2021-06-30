/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author phamv
 */
public class UserError {
    private String userIDError;
    private String userNameError, passwordError, addressError, phoneError;

    public UserError() {
    }

    public UserError(String userIDError, String userNameError, String passwordError, String addressError, String phoneError) {
        this.userIDError = userIDError;
        this.userNameError = userNameError;
        this.passwordError = passwordError;
        this.addressError = addressError;
        this.phoneError = phoneError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    @Override
    public String toString() {
        return "UserError{" + "userIDError=" + userIDError + ", userNameError=" + userNameError + ", passwordError=" + passwordError + ", addressError=" + addressError + ", phoneError=" + phoneError + '}';
    }
    
}
