package bugmakers.club.dp.structural.seq3.composite.practice;

/**
 * @Description:
 * @Author: Bruce
 * @Datetime: 2018/3/13 13:33
 */
public class CompositePracticeClient {

    /**
     * 程序启动入口
     */
    public static void main(String[] args) {

        AbstractUIComponent unameTxt, pwdTxt, loginBtn = null;

        AbstractUIComponentContainer loginWindow, loginPanel = null;

        loginWindow = new Window("Login Window");
        loginPanel = new Panel("Login Panel");

        unameTxt = new Text("Username");
        pwdTxt = new Text("Password");
        loginBtn = new Button("Submit");

        loginPanel.add(unameTxt);
        loginPanel.add(pwdTxt);
        loginPanel.add(loginBtn);

        loginWindow.add(loginPanel);

        loginWindow.show();
    }
}
