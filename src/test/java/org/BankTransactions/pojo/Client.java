package org.BankTransactions.pojo;

/**
 * this is the class client that will be used in the tests
 */
public class Client {
    private int id;
    private String name;
    private String lastName;
    private int accountNumber;
    private float amount;
    private String transactionType;
    private String email;
    private boolean active;
    private String country;
    private String telephone;

    /**
     * is the empty constructor
     */
    public Client() {
    }
    /**
     * is the constructor to create clients
     * @param name is the name of the client
     * @param lastName is the last name of the client
     * @param accountNumber is the account number of the client
     * @param amount is the amount of the transaction done
     * @param transactionType is the type of transaction done
     * @param email is the email of the client
     * @param active is if the account is active or not
     * @param country the country of the client
     * @param telephone is the telephonr of the client
     */
    public Client(String name, String lastName, int accountNumber, float amount, String transactionType, String email, boolean active, String country, String telephone) {
        this.name = name;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.email = email;
        this.active = active;
        this.country = country;
        this.telephone = telephone;

    }

    /**
     * getter for the id of the client
     * @return the id of the client
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id of the client
     * @param id is the id to be assigned
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the name of the client
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name of the client
     * @param name is the name to be assigned
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the last name of the client
     * @return the last name of the client
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the client
     * @param lastName the last name to be assigned to the client
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * get the account number of the client
     * @return the account number of the client
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * sets the account number of the client
     * @param accountNumber the account number to be given to the client
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * gets the amount of the transaction
     * @return the amount of the transaction
     */
    public float getAmount() {
        return amount;
    }

    /**
     * sets the amount of the transaction
     * @param amount is the amount to be set in the transaction
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * gets the type of transaction realized
     * @return the type of transaction realized
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * sets the type of transaction
     * @param transactionType the type of transaction to be assigned
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * gets the email of the client
     * @return the email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email of the client
     * @param email is the email to be assigned
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets if the account is active or not
     * @return the status of the account, true or false
     */
    public boolean isActive() {
        return active;
    }

    /**
     * sets the status of the account, true or false
     * @param active the status to be assigned
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * gets the country of the client
     * @return the country of the client
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets the country of the client
     * @param country the country to be assigned to the client
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * gets the telephone of the client
     * @return the telephone of the client
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * sets the telephone of the client
     * @param telephone the telephone to be assigned
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
