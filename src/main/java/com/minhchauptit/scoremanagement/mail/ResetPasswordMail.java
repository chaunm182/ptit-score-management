package com.minhchauptit.scoremanagement.mail;

public class ResetPasswordMail extends MyMail {
    private String firstName;
    private String lastName;
    private String resetPasswordLink;

    public ResetPasswordMail(String resetPasswordLink) {
        this.resetPasswordLink = resetPasswordLink;
        this.subject = "Yêu cầu reset mật khẩu";
    }

    public String getResetPasswordLink() {
        return resetPasswordLink;
    }

    public void setResetPasswordLink(String resetPasswordLink) {
        this.resetPasswordLink = resetPasswordLink;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
