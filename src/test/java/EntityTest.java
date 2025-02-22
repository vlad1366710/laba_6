import org.example.Entity;
import org.example.Annotations.ToString;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс тестирования для метода toString() в Entity.
 */
public class EntityTest {

    /**
     * Тестируемый класс User, наследующий от Entity.
     */
    public static class User extends Entity {
        @ToString("YES")
        private String username;

        @ToString(value = "NO")
        private int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    /**
     * Тест 1: Проверка правильного отображения полей с аннотацией YES.
     */
    @Test
    public void testToStringWithYesAnnotation() {
        User user = new User("Alice", 30);
        String expected = "User{username=Alice}";
        String actual = user.toString();
        assertEquals(expected, actual, "Метод toString() должен возвращать строку с полем username.");
    }

    /**
     * Тест 2: Проверка случая, когда все поля помечены NO.
     */
    public static class UserNoFields extends Entity {
        @ToString(value = "NO")
        private String username;

        @ToString(value = "NO")
        private int age;

        public UserNoFields(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @Test
    public void testToStringWithNoFields() {
        UserNoFields user = new UserNoFields("Bob", 25);
        String expected = "UserNoFields{}";
        String actual = user.toString();
        assertEquals(expected, actual, "Метод toString() должен возвращать пустую строку, если все поля помечены NO.");
    }

    /**
     * Тест 3: Проверка работы с полями без аннотации.
     */
    public static class UserMixedFields extends Entity {
        @ToString(value = "YES")
        private String username;

        private int age; // Поле без аннотации

        public UserMixedFields(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @Test
    public void testToStringWithMixedFields() {
        UserMixedFields user = new UserMixedFields("Charlie", 40);
        String expected = "UserMixedFields{username=Charlie,age=40}";
        String actual = user.toString();
        assertEquals(expected, actual, "Метод toString() должен включать поля без аннотации и с аннотацией YES.");
    }

    /**
     * Тест 4: Проверка работы с полями, унаследованными от суперкласса.
     */
    public static class UserWithInheritedFields extends User {
        @ToString(value = "YES")
        private String email;

        public UserWithInheritedFields(String username, int age, String email) {
            super(username, age);
            this.email = email;
        }
    }

    @Test
    public void testToStringWithInheritedFields() {
        UserWithInheritedFields user = new UserWithInheritedFields("Dave", 35, "dave@example.com");
        String expected = "UserWithInheritedFields{username=Dave,email=dave@example.com}";
        String actual = user.toString();
        assertEquals(expected, actual, "Метод toString() должен включать унаследованные поля с аннотацией YES.");
    }

    /**
     * Тест 5: Проверка работы с полями, которые выбрасывают исключение при доступе.
     */
    public static class UserWithPrivateFields extends Entity {
        @ToString(value = "YES")
        private String username;

        @ToString(value = "YES")
        private int age;

        public UserWithPrivateFields(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }

    @Test
    public void testToStringWithPrivateFields() {
        UserWithPrivateFields user = new UserWithPrivateFields("Eve", 50);
        String expected = "UserWithPrivateFields{username=Eve,age=50}";
        String actual = user.toString();
        assertEquals(expected, actual, "Метод toString() должен корректно обрабатывать приватные поля.");
    }
}