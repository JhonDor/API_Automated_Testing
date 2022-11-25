package org.BankTransactions.test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.BankTransactions.pojo.Client;
import org.BankTransactions.reporting.Reporter;


import java.util.*;

import static io.restassured.RestAssured.given;


/**
 * base class for all test classes
 */
public class BaseTest {
    /**
     * this method gets all the clients
     *
     * @param endpoint the endpoint to do execute the  get request
     * @return a list of all clients
     */
    public List<Client> getAllClients(String endpoint) {
        RestAssured.baseURI = endpoint;
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<Client> allClients = new ArrayList<>();

        try {
            allClients = jsonPathEvaluator.getList(".", Client.class);
        } catch (Exception e) {
            Reporter.error(String.valueOf(e));
        }

        return allClients;
    }

    /**
     * this method does the delete request
     *
     * @param endpoint is the endpoint to execute the delete request
     * @param client   is the client to delete
     * @return the status code obtained after doing the request
     */
    public int deleteClient(String endpoint, Client client) {
        Response response = given()
                .contentType("application/json")
                .when()
                .delete(endpoint + "/" + client.getId());

        return response.getStatusCode();
    }

    /**
     * this method gets a list of all clients if there is any client in the list all
     * the clients found are deleted
     *
     * @param endpoint is the end point to execute the delete request
     * @return the status code obtained after the  request
     */
    public boolean verifyEmptyEndpoint(String endpoint) {
        List<Boolean> deletedUserStatus = new ArrayList<>();
        List<Integer> status = new ArrayList<>();
        List<Client> clients = getAllClients(endpoint);
        if (clients.size() > 0) {
            for (int i = 0; i < clients.size(); i++) {
                status.add(deleteClient(endpoint, clients.get(i)));
                deletedUserStatus.add(status.get(i) == 200);
                if (status.get(i) != 200) {
                    return false;
                }
            }
        }
        return deletedUserStatus.contains(true);
    }

    /**
     * this method executes the post request to create a client
     *
     * @param endpoint is the end point to execute the request
     * @param client   is the client to be created
     * @return the status code obtained after the request
     */
    public int createClient(String endpoint, Client client) {
        Response response = given()
                .contentType("application/json")
                .body(client)
                .when()
                .post(endpoint);

        return response.getStatusCode();
    }

    /**
     * creates 10 clients, then verifies if one of them has a repeated email, if one client with a
     * repeated email is found this client won't be created
     *
     * @param endpoint the endpoint to send the post request
     * @return the status after the post request was done
     */
    public boolean createClients(String endpoint) {
        List<Client> clients = new ArrayList<>();
        List<Boolean> clientsStatus = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 11; i++) {
            clients.add(new Client(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.number().numberBetween(1000000, 999999999),
                    faker.number().numberBetween(1000, 999999999),
                    randomTransactionType(),
                    faker.internet().emailAddress(),
                    faker.random().nextBoolean(),
                    faker.country().name(),
                    faker.phoneNumber().cellPhone()
            ));
        }
/**
 * since all the data is generated randomly, in this part of the method one email is created and
 * is assigned manually to 2 clients to simulate the creation of a client with an email
 * already registered
 */
        String duplicatedEmailTest = faker.internet().emailAddress();

        clients.get(8).setEmail(duplicatedEmailTest);
        clients.get(9).setEmail(duplicatedEmailTest);
/**
 * in this part of the method is verified that there are no duplicated emails
 * if an email is duplicated the creation of that client is not sent in the post request
 */
        for (int i = 0; i < clients.size(); i++) {
            boolean emailAlreadyRegistered = false;
            for (int j = 0; j < clients.size() && !emailAlreadyRegistered; j++) {
                if (clients.get(i).getEmail().equals(clients.get(j).getEmail()) && i < j) {
                    emailAlreadyRegistered = true;
                }
            }
            if (!emailAlreadyRegistered) {
                clientsStatus.add(createClient(endpoint, clients.get(i)) != 200);
            }
        }

        return clientsStatus.contains(true);
    }

    /**
     * Since java.Faker doesn't have an option to randomize transaction types this method
     * creates a list of transactions and selects one randomly
     *
     * @return a random type of transaction
     */
    public String randomTransactionType() {
        List<String> transactions = Arrays.asList("withdrawal", "deposit", "transfer");
        Random random = new Random();
        return transactions.get(random.nextInt(transactions.size()));
    }

    /**
     * this method verifies if there are duplicated emails, after obtaining all the clients in the API the
     * emails are stored in a hashset, since hashset only stores unique values the amount of clients is
     * compared with the amount of emails, if the numbers are different that means at least one email is
     * duplicated
     *
     * @param endpoint id the endpoint to do de get request
     * @return true if the amount of clients and emails are the same,
     * meaning there are no duplicated emails, false otherwise
     */
    public boolean verifyDuplicateEmails(String endpoint) {
        final List<String> clientsEmails = new ArrayList<>();
        getAllClients(endpoint).forEach(client -> {
            clientsEmails.add(client.getEmail());
        });

        Set<String> clients = new HashSet<>(clientsEmails);

        return clients.size() == getAllClients(endpoint).size();
    }

    /**
     * this method does the put request to update a client
     *
     * @param endpoint is the endpoint to do the put request
     * @param client   is the client we want to update
     * @return the status code obtained after doing the put request
     */

    public int updateClient(String endpoint, Client client) {
        Response response = given()
                .contentType("application/json")
                .body(client)
                .when()
                .put(endpoint + "/" + client.getId());

        return response.getStatusCode();
    }


    /**
     * this method finds a client to update
     *
     * @param endpoint is the endpoint to do the put request
     * @return the client which account number will be updated, in this case the first client
     */
    public int updateAccountNumber(String endpoint) {
        List<Client> clients = getAllClients(endpoint);
        Client client = clients.get(0);
        client.setAccountNumber(1111111);

        return updateClient(endpoint, client);
    }

}


