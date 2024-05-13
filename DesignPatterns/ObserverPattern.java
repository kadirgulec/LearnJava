import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Observable (Subject)
class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }
}

// Observer
interface Channel {
    void update(String news);
}

// NewsChannel displays news in a separate window
class NewsChannel implements Channel {
    private JFrame frame;
    private JTextArea newsTextArea;

    public NewsChannel() {
        frame = new JFrame("News Channel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        newsTextArea = new JTextArea();
        newsTextArea.setEditable(false);
        frame.add(new JScrollPane(newsTextArea));

        frame.setVisible(true);
    }
    public void closeWindow() {
        frame.dispose();
    }

    @Override
    public void update(String news) {
        newsTextArea.setText(news);
    }
}

// Example usage
public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency observable = new NewsAgency();
        NewsChannel observer = new NewsChannel();
        Scanner scanner = new Scanner(System.in);
        
        String showUser = "";
        String news = "Hallo Benutzer, schreiben Sie bitte exit, um die App zu beenden." + System.lineSeparator() + "Geben Sie eine Zahl für den Countdown ein";
        while (!news.equals("exit")){
            showUser = showUser + news + System.lineSeparator();
            observable.addObserver(observer);
            observable.setNews(showUser);
            news = scanner.nextLine();
            try{
                Integer newsInt = Integer.parseInt(news);
                for(Integer i=newsInt; i > 0 ; i--){
                    showUser = showUser + i + System.lineSeparator();
                    observable.setNews(showUser);
                }
                showUser = showUser + "Countdown von diese Nummer ist fertig ";
            }catch(NumberFormatException e){
                continue;
            }

        }
        observable.removeObserver(observer);
        observer.closeWindow();
        scanner.close();
    }
}
