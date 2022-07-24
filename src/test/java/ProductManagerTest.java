import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.prodManager.task.*;

public class ProductManagerTest {

    ProductRepository repo=new ProductRepository();

    ProductManager manager = new ProductManager(repo);



    Product item1 = new Book(23, "Сказки", 3000, "Лермонтов");
    Product item2 = new Book(42, "Басни", 800, "Пушкин");
    Product item3 = new Book(43, "Басни", 800, "Пушкин");
    Product item4 = new Smartphone(98, "Iphone", 1000, "Apple");
    Product item5 = new Smartphone(56, "Galaxy S", 10_000, "Samsung");
    @BeforeEach
    public  void setup () {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

    }
    @Test
    public void shouldSearchByName() {

        Product[] expected = {item2, item3};
        Product[] actual = manager.searchBy("Басни");
        Assertions.assertArrayEquals(expected, actual);
}
        }
