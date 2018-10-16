package soccer.org.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/teams")
public class ServletTeam extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Document doc = null;
        try {
            System.out.println("before");
            doc = Jsoup.connect("http://soccer365.ru/competitions/12/2017-2018/results/").get();
            System.out.println("after");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------");
        //System.out.println(doc.body().toString());
        Elements newsHeadlines = doc.getElementsByClass("game_team");//getElementsByTag("div");//select("#mp-itn b a");

        for (Element e :newsHeadlines) {
            System.out.println(e.text());
        }

    }
}
