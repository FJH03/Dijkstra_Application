package nuc.ss.entry;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042612-温绍卿
 * @ClassName: User
 * @Date: 2022/12/12
 * @Time: 9:31
 * @Description:用户实体
 */
public class User {
    private String id,name,idcard,phone,password;
    private char sex;

    /**
     * 用户基本信息
     * @param id 用户名
     * @param name 姓名
     * @param idcard 身份证号
     * @param phone 电话号码
     * @param password 密码
     * @param sex 性别
     */
    public User(String id, String name, String idcard, String phone, String password, char sex) {
        this.id = id;
        this.name = name;
        this.idcard = idcard;
        this.phone = phone;
        this.password = password;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public char getSex() {
        return sex;
    }
}