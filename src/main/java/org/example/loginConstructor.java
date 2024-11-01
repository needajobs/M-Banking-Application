package org.example;

class loginConstructor{

    private String userID;
    private String userCode;

    public loginConstructor(String userCode) {
        this.userCode= userCode;
    }

    public loginConstructor(){}

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }
}
