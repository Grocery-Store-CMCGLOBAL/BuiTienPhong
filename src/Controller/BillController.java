package Controller;

import Model.Bill;
import Model.Product;
import Validation.Validation;

import java.util.List;

public class BillController {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    //show menu option
    public static int showMenuOption() {
        System.out.println("1.Add product to bill");
        System.out.println("2.Show detail bill");
        System.out.println("3.Check out");
        System.out.print("Enter your choice: ");
        return Validation.checkInputIntLimit(1, 3);
    }

    //show current bill
    public static void showBill(List<Bill> bills) {
        double totalPrice = 0;
        System.out.println("---------------***---------------");
        System.out.println("Bill of customer:\n");
        System.out.println("Id" + "\t" + "Name of product" + "\t\t" + "Quantity product" + "\t" + "Bonus" + "\t\t\t" + "Price");
        for (Bill bill: bills) {
            totalPrice = totalPrice + bill.getPrice();
            System.out.println(bill);
        }
        System.out.println("The total price is: "+totalPrice);
        System.out.println("---------------------------------\n");
    }

    //add product
    public static void addProduct(List<Product> products, List<Bill> bills, int indexBill) {
        System.out.print("Enter product id: ");
        String idProduct = Validation.checkInputString();
        int indexProduct = -1;
        int i = -1;
        //check existing product
        for (Product product: products) {
            i++;
            if (product.getId().equals(idProduct)) {
                indexProduct = i;
                break;
            }
        }
        Product curProduct;
        if (indexProduct != -1) {
            curProduct = products.get(indexProduct);
        } else {
            System.out.println("Wrong product id.\n");
            return;
        }
        //check total in the warehouse of product to give a bonus to the customer
        if (curProduct.getTotal() != 0) {
            System.out.println("\nThe total \""+curProduct.getName()+"\" in warehouse is "+curProduct.getTotal() +"("+ curProduct.getUnit()+")");
            if (curProduct.isSale()) {
                System.out.println("The product now is promotion, buy "+curProduct.getBuy()+ " get "+curProduct.getBonus());
            }
            System.out.print("Enter total product which sell: ");
            double totalSellProduct = Validation.checkInputQuantityLimit(curProduct);
            double bonus = 0;
            if (curProduct.isSale()) {
                bonus = totalSellProduct/curProduct.getBuy()* curProduct.getBonus();
            }
            //check if the product is existed in bill
            for (Bill bill: bills) {
                if (bill.getName().equals(curProduct.getName())) {
                    bill.setTotalProduct(bill.getTotalProduct()+totalSellProduct);
                    bill.setTotalBonus(bill.getTotalBonus()+bonus);
                    bills.set(bill.getId()-1, bill);
                    Main.indexBill--;
                    curProduct.setTotal(curProduct.getTotal()-totalSellProduct-bonus);
                    products.set(indexProduct, curProduct);
                    return;
                }
            }
            curProduct.setTotal(curProduct.getTotal()-totalSellProduct-bonus);
            products.set(indexProduct, curProduct);
            Bill newBill = new Bill(indexBill, curProduct.getName(), totalSellProduct, bonus, totalSellProduct * curProduct.getPrice(), curProduct.getUnit());
            bills.add(newBill);
            System.out.println("Add success.\n");
        } else {
            System.out.println(ANSI_RED+"This is no \""+curProduct.getName()+"\" in warehouse\n"+ANSI_RESET);
        }
    }

}
