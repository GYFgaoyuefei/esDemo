package com.run.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by quanyuan on 2018/2/7.
 */
public class StartUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 构造函数
     */
    public StartUpServlet(){
        super();
    }

    /**
     * 初始化方法
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        System.out.println("                       _oo0oo_\n" +
                "                      o8888888o\n" +
                "                      88\" . \"88\n" +
                "                      (| -_- |)\n" +
                "                      0\\  =  /0\n" +
                "                    ___/`---'\\___\n" +
                "                  .' \\\\|     |// '.\n" +
                "                 / \\\\|||  :  |||// \\\n" +
                "                / _||||| -:- |||||- \\\n" +
                "               |   | \\\\\\  -  /// |   |\n" +
                "               | \\_|  ''\\---/''  |_/ |\n" +
                "               \\  .-\\__  '-'  ___/-. /\n" +
                "             ___'. .'  /--.--\\  `. .'___\n" +
                "          .\"\" '<  `.___\\_<|>_/___.' >' \"\".\n" +
                "         | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n" +
                "         \\  \\ `_.   \\_ __\\ /__ _/   .-` /  /\n" +
                "     =====`-.____`.___ \\_____/___.-`___.-'=====\n" +
                "                       `=---='\n" +
                "\n" +
                "\n" +
                "     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "\n" +
                "               佛祖保佑         永无BUG");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at:").append(req.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
