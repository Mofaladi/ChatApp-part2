 public class Login {
    private String username;
    private String password;
    private String cellphone;

    public Login(String username, String password, String cellphone) {
        this.username = username;
        this.password = password;
        this.cellphone = cellphone;
    }

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && 
               password.matches(".*[A-Z].*") && 
               password.matches(".*[0-9].*") && 
               password.matches(".*[!@#$%^&*].*");
    }

    public boolean checkCellPhoneNumber(String cell) {
        return cell.length() <= 10 && cell.startsWith("+");
    }

    public String registerUser(String u, String p, String cell) {
        if (!checkUserName(u)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(p)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        this.username = u;
        this.password = p;
        this.cellphone = cell;
        return "User registered successfully.";
    }

    public boolean loginUser(String u, String p) {
        return this.username.equals(u) && this.password.equals(p);
    }

    public String returnLoginStatus(String u, String p) {
        if (loginUser(u, p)) {
            return "Welcome " + u + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
