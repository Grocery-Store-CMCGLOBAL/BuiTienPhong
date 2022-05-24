package Controller;

import Controller.BillController;
import Model.Bill;
import Model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Product> listProduct = new ArrayList<>();
    public static List<Bill> listBill = new ArrayList<>();
    public static int indexBill = 0;

    public static void main(String[] args) {

        //add data product
        listProduct.add(new Product("A0001", "Product A", 10.00, 10, "Kg", true, 1,1));
        listProduct.add(new Product("A0002", "Product B", 12.00, 12, "Piece", true, 2, 1));
        listProduct.add(new Product("A0003", "Product C", 20.00, 5,"Piece", false, 0, 0));
        listProduct.add(new Product("B0001", "Product D", 22.00, 14,"Kg", false, 0, 0));
        listProduct.add(new Product("B0002", "Product E", 32.00, 1,"Piece", false, 0, 0));
        listProduct.add(new Product("B0003", "Product F", 0, 11,"Kg", true,2, 1));

        while (true) {
            int choice = BillController.showMenuOption();
            switch (choice) {
                case 1:
                    indexBill++;
                    BillController.addProduct(listProduct, listBill, indexBill);
                    break;
                case 2:
                    if (listBill.isEmpty()) {
                        System.out.println("There is no product in cart\n");
                    } else {
                        BillController.showBill(listBill);
                    }
                    break;
                case 3:
                    if (listBill.isEmpty()) {
                        System.out.println("There is no product in cart\n");
                    } else {
                        System.out.println("Check out success:");
                        BillController.showBill(listBill);
                        listBill.clear();
                        indexBill = 0;
                    }
                    break;
                default:
                    return;
            }
        }
    }
}
