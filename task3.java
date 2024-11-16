import java.util.HashMap;

class ShoppingBasket {
    private HashMap<String, Integer> basket = new HashMap<>();

    public void addProduct(String product, Integer quantity) {
        basket.put(product, basket.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(String product) {
        basket.remove(product);
    }

    public void updateQuantity(String product, Integer quantity) {
        if (basket.containsKey(product)) {
            basket.put(product, quantity);
        }
    }

    public int checkProduct(String product) {
        return basket.getOrDefault(product, 0);
    }

    public void showBasket() {
        System.out.println(basket);
    }
}


// Не удаляйте и не меняйте метод Main!
public class task3 {
    public static void main(String[] args) {
        String product1, product2, product3;
        Integer quantity1, quantity2, quantity3;

        if (args.length == 0) {
            product1 = "apple";
            quantity1 = 3;
            product2 = "banana";
            quantity2 = 2;
            product3 = "apple";
            quantity3 = 5;
        } else {
            product1 = args[0];
            quantity1 = Integer.parseInt(args[1]);
            product2 = args[2];
            quantity2 = Integer.parseInt(args[3]);
            product3 = args[4];
            quantity3 = Integer.parseInt(args[5]);
        }

        ShoppingBasket basket = new ShoppingBasket();

        basket.addProduct(product1, quantity1);
        basket.addProduct(product2, quantity2);
        basket.addProduct(product3, quantity3);

        System.out.println("Basket after adding products:");
        basket.showBasket();

        basket.removeProduct("banana");
        System.out.println("Basket after removing 'banana':");
        basket.showBasket();
        System.out.println("Quantity of 'apple':" + basket.checkProduct("apple"));
        System.out.println("Quantity of 'banana':" + basket.checkProduct("banana"));
    }
}
