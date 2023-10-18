package com.example.oop;

import com.example.oop.controller.AccountController;
import com.example.oop.controller.CustomerController;
import com.example.oop.model.Account;
import com.example.oop.model.Customer;
import com.example.oop.utils.AlertMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class AppController implements Initializable {
    @FXML
    private TableColumn<Account, Void> accCalCol;

    @FXML
    private AnchorPane accLayout;

    @FXML
    private TableColumn<Account, String> accNumCol;

    @FXML
    private TableColumn<Account, String> accStsCol;

    @FXML
    private TableView<Account> accTable;

    @FXML
    private TableColumn<Account, String> accTitCol;

    @FXML
    private TableColumn<Account, Void> accViewCol;
    @FXML
    private TableColumn<Account, Void> accRemoveCol;

    @FXML
    private Button accountBtn;

    @FXML
    private Button addAccBtn;

    @FXML
    private Button addCustomerBtn;

    @FXML
    private Button customerBtn;

    @FXML
    private TableColumn<Customer, Void> customerEditCol;

    @FXML
    private TableColumn<Customer, Integer> customerIdCol;

    @FXML
    private TableColumn<Customer, String> customerNameCol;

    @FXML
    private TableColumn<Customer, String> customerPhoneCol;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, Void> customerViewCol;
    @FXML
    private TableColumn<Customer, Void> customerRemoveBtn;

    @FXML
    private AnchorPane custumerLayout;

    @FXML
    private Button transactionBtn;

    @FXML
    private Button searchCusBtn;

    @FXML
    private TextField searchCusInput;

    @FXML
    private Button searchAccBtn;

    @FXML
    private TextField searchAccInput;

    private CustomerController customerController = new CustomerController();
    private AccountController accountController = new AccountController();
    private AlertMessage alert = new AlertMessage();

    @FXML
    private TextField transAccInput;

    @FXML
    private TextField transAmtInput;

    @FXML
    private Button transBtn;

    @FXML
    private ComboBox<String> transTypeInput;
    @FXML
    private AnchorPane transLayout;
    private ObservableList<String> transType = FXCollections.observableArrayList("deposit", "withdraw");

    public void switchForm(ActionEvent event) {
        if (event.getSource() == customerBtn) {
            custumerLayout.setVisible(true);
            accLayout.setVisible(false);
            transLayout.setVisible(false);
        } else if (event.getSource() == accountBtn) {
            custumerLayout.setVisible(false);
            accLayout.setVisible(true);
            transLayout.setVisible(false);
        } else if (event.getSource() == transactionBtn) {
            custumerLayout.setVisible(false);
            accLayout.setVisible(false);
            transLayout.setVisible(true);
        }
    }

    public void showAddCustomerLayout() {
        try {
            Parent root = FXMLLoader.load(App.class.getResource("AddCustomer.fxml"));
            Stage stage = new Stage();
            stage.setTitle("AddCustomer");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAddAccountLayout() {
        try {
            Parent root = FXMLLoader.load(App.class.getResource("AddAccount.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Account");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onSearchCustomer() {
        System.out.println("Customer list: ");
        for (Customer cus : CustomerController.CustomerList) {
            System.out.println(cus.toString());
        }
        String username = searchCusInput.getText();
        System.out.println("search: " + username);
        Customer customer = null;
        for (Customer cus : CustomerController.CustomerList) {
            if (cus.getUsername().equals(username)) {
                customer = cus;
            }
        }

        if (customer == null) {
            State.searchCustomer = null;
        } else {
            State.searchCustomer = customer;
        }
        try {
            Parent root = FXMLLoader.load(App.class.getResource("ViewCustomer.fxml"));
            Stage stage = new Stage();
            stage.setTitle("AddCustomer");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchCusInput.setText("");
    }

    public void onSearchAcc() {
        String accNum = searchAccInput.getText();
        Account account = null;
        for (Account acc : AccountController.accountList) {
            if (acc.getNumber().equals(accNum)) {
                account = acc;
            }
        }

        if (account == null) {
            State.searchAcc = null;
        } else {
            State.searchAcc = account;
        }
        try {
            Parent root = FXMLLoader.load(App.class.getResource("ViewAccount.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Account");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        searchAccInput.setText("");
    }

    public void displayCustomerTable() {
        customerIdCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        customerNameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        customerViewCol.setCellFactory(new Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>>() {
            @Override
            public TableCell<Customer, Void> call(TableColumn<Customer, Void> managerVoidTableColumn) {
                return new TableCell<>() {
                    private final Button button = new Button("View");
                    {
                        button.setOnAction(event -> {
                            Customer customer = getTableView().getItems().get(getIndex());
                            State.searchCustomer = customer;
                            try {
                                Parent root = FXMLLoader.load(App.class.getResource("ViewCustomer.fxml"));
                                Stage stage = new Stage();
                                stage.setTitle("View Customer");
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });
        customerRemoveBtn.setCellFactory(new Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>>() {
            @Override
            public TableCell<Customer, Void> call(TableColumn<Customer, Void> managerVoidTableColumn) {
                return new TableCell<>() {
                    private final Button button = new Button("Remove");
                    {
                        button.setOnAction(event -> {
                            Customer customer = getTableView().getItems().get(getIndex());
                            if (alert.confirmationMessage("Do you want to remove this customer ?")) {
                                customerController.removeCustomer(customer.getId());
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });
        customerEditCol.setCellFactory(new Callback<TableColumn<Customer, Void>, TableCell<Customer, Void>>() {
            @Override
            public TableCell<Customer, Void> call(TableColumn<Customer, Void> managerVoidTableColumn) {
                return new TableCell<>() {
                    private final Button button = new Button("Edit");
                    {
                        button.setOnAction(event -> {
                            Customer customer = getTableView().getItems().get(getIndex());
                            State.searchCustomer = customer;
                            try {
                                Parent root = FXMLLoader.load(App.class.getResource("EditCustomer.fxml"));
                                Stage stage = new Stage();
                                stage.setTitle("Edit customer");
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });
    }

    private Thread customerThread = new Thread() {
        public void run() {
            try {
                while (true) {
                        ObservableList<Customer> customersList = FXCollections.observableArrayList(CustomerController.CustomerList);
                        customerTable.setItems(customersList);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private Thread accountThread = new Thread() {
        public void run() {
            try {
                while (true) {
                    ObservableList<Account> accountsList = FXCollections.observableArrayList(AccountController.accountList);
                    accTable.setItems(accountsList);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public void displayAccountTable() {
        accNumCol.setCellValueFactory(new PropertyValueFactory<Account, String>("number"));
        accTitCol.setCellValueFactory(new PropertyValueFactory<Account, String>("account_title"));
        accViewCol.setCellFactory(new Callback<TableColumn<Account, Void>, TableCell<Account, Void>>() {
            @Override
            public TableCell<Account, Void> call(TableColumn<Account, Void> managerVoidTableColumn) {
                return new TableCell<>() {
                    private final Button button = new Button("View");
                    {
                        button.setOnAction(event -> {
                            Account account = getTableView().getItems().get(getIndex());
                            State.searchAcc = account;
                            try {
                                Parent root = FXMLLoader.load(App.class.getResource("ViewAccount.fxml"));
                                Stage stage = new Stage();
                                stage.setTitle("View Account");
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });
        accRemoveCol.setCellFactory(new Callback<TableColumn<Account, Void>, TableCell<Account, Void>>() {
            @Override
            public TableCell<Account, Void> call(TableColumn<Account, Void> managerVoidTableColumn) {
                return new TableCell<>() {
                    private final Button button = new Button("Remove");
                    {
                        button.setOnAction(event -> {
                            Account account = getTableView().getItems().get(getIndex());
                            if (alert.confirmationMessage("Do you want to remove this account ?")) {
                                accountController.removeAccount(account.getNumber());
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });
        accCalCol.setCellFactory(new Callback<TableColumn<Account, Void>, TableCell<Account, Void>>() {
            @Override
            public TableCell<Account, Void> call(TableColumn<Account, Void> managerVoidTableColumn) {
                return new TableCell<>() {
                    private final Button button = new Button("Cal");
                    {
                        button.setOnAction(event -> {
                            Account account = getTableView().getItems().get(getIndex());
                            State.searchAcc = account;
                            try {
                                Parent root = FXMLLoader.load(App.class.getResource("CalInterest.fxml"));
                                Stage stage = new Stage();
                                stage.setTitle("Cal Interest");
                                stage.setScene(new Scene(root));
                                stage.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });
    }

    public void transfer() {
        float amount = Float.parseFloat(transAmtInput.getText());
        String number = transAccInput.getText();
        String type = transTypeInput.getValue();
        if (type.equals("withdraw")) {
            int rs = accountController.withdraw(number, amount);
            if (rs == -1) {
                alert.errorMessage("Account is not available");
            } else if (rs == 0) {
                alert.errorMessage("Account's balance is less than the amount need to withdraw");
            } else {
                alert.successMessage("Successful transaction!");
            }
        } else {
            int rs = accountController.deposit(number, amount);
            if (rs == -1) {
                alert.errorMessage("Account is not available");
            } else {
                alert.successMessage("Successful transaction!");
            }
        }
        transAccInput.setText("");
        transAmtInput.setText("");
    }
    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        transTypeInput.setItems(transType);
        customerThread.start();
        accountThread.start();
        displayCustomerTable();
        displayAccountTable();
    }
}