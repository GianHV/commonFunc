
import java.util.List;

public class App {
    public static void main(String[] args) {

          App m = new App();
        List<User> users = m.getUsers();

        // lọc để lấy ra các element có gender là femal in ra tất cả các phần tử
        users.stream().filter(
                u -> u.getGender().equals(Gender.female)
        ).forEach(System.out::println);

        // lấy địa chỉ của 2 user
        var address = users.stream().map(u -> u.address).limit(2).toList();
        System.out.println(address);

        // lấy username và address theo filter
        var result = users.stream()
                .filter(u -> u.gender.equals(Gender.female))
                .map(u -> Map.entry(u.username, u.address))
                .toList();
        System.out.println(result);
    }

    List<User> getUsers() {

        // cách viết tối ưu thay vì add từng phần tử
        return List.of(
                new User(1L, "username-1", "password", Gender.female, "Sai Gon"),
                new User(2L, "username-2", "password", Gender.female, "Quy Nhon"),
                new User(3L, "username-3", "password", Gender.male, "Ha Tinh")
        );
    }

    class User {


        Long id;
        String username;
        String password;
        Gender gender;
        String address;

        public User() {
        }

        public User(Long id, String username, String password, Gender gender, String address) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.gender = gender;
            this.address = address;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", gender=" + gender +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    enum Gender {
        male, female, other;
    }
}
