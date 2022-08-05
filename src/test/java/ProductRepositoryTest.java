import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.prodManager.task.*;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    @BeforeEach
    public void setup() {

        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
    }

    Product item1 = new Book(23, "Сказки", 3000, "Лермонтов");
    Product item2 = new Book(42, "Басни", 800, "Пушкин");
    Product item3 = new Book(43, "Басни", 800, "Пушкин");
    Product item4 = new Smartphone(98, "Iphone", 1000, "Apple");
    Product item5 = new Smartphone(56, "Galaxy S", 10_000, "Samsung");

    @Test
    public void shouldSaveItems() {


        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindById() {

        Product expected = item3;
        Product actual = repo.findById(43);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldDelItem() {

        repo.removeById(item2.getId());
        Product[] expected = {item1, item3, item4, item5};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveItem() {


        Assertions.assertThrows(NotFoundException.class, ()-> {repo.removeById(123);});

    }
}
