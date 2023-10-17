package com.example.oop;

import com.example.oop.controller.CustomerController;
import com.example.oop.model.Customer;
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
    private TableColumn<?, ?> accCalCol;

    @FXML
    private AnchorPane accLayout;

    @FXML
    private TableColumn<?, ?> accNumCol;

    @FXML
    private TableColumn<?, ?> accStsCol;

    @FXML
    private TableView<?> accTable;

    @FXML
    private TableColumn<?, ?> accTitCol;

    @FXML
    private TableColumn<?, ?> accViewCol;

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

    public void switchForm(ActionEvent event) {
        if (event.getSource() == customerBtn) {
            custumerLayout.setVisible(true);
            accLayout.setVisible(false);
        } else if (event.getSource() == accountBtn) {
            custumerLayout.setVisible(false);
            accLayout.setVisible(true);
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
//        accDelCol.setCellFactory(new Callback<TableColumn<Manager, Void>, TableCell<Manager, Void>>() {
//            @Override
//            public TableCell<Manager, Void> call(TableColumn<Manager, Void> managerVoidTableColumn) {
//                return new TableCell<>() {
//                    private final Button button = new Button("Xóa");
//                    {
//                        button.setOnAction(event -> {
//                            Manager manager = getTableView().getItems().get(getIndex());
//                            alert.confirmationMessage("Bạn có muốn xóa tài khoản này ?");
//                            try {
//                                managerDao.deleteManager(manager.getId());
//                            } catch (SQLException e) {
//                                e.printStackTrace();
//                            }
//                        });
//                    }
//
//                    @Override
//                    protected void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(button);
//                        }
//                    }
//                };
//            }
//        });
//        accUpdateCol.setCellFactory(new Callback<TableColumn<Manager, Void>, TableCell<Manager, Void>>() {
//            @Override
//            public TableCell<Manager, Void> call(TableColumn<Manager, Void> managerVoidTableColumn) {
//                return new TableCell<>() {
//                    private final Button button = new Button("Cập nhật");
//                    {
//                        button.setOnAction(event -> {
//                            Manager manager = getTableView().getItems().get(getIndex());
//                            try {
//                                GlobalState.selectedManager = managerDao.getManagerByPhone(manager.getPhone());
//                            } catch (SQLException e) {
//                                e.printStackTrace();
//                            }
//                            try {
//                                Parent root = FXMLLoader.load(OOADApplication.class.getResource("UpdateManagerForm.fxml"));
//                                Stage stage = new Stage();
//                                stage.setTitle("Cập nhật quản lý");
//                                stage.setScene(new Scene(root));
//                                stage.show();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        });
//                    }
//
//                    @Override
//                    protected void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(button);
//                        }
//                    }
//                };
//            }
//        });
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

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        customerThread.start();
        displayCustomerTable();
    }
}