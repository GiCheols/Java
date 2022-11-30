class NewsPaper{
    private String todayNews;

    void setTodayNews(String news){
        todayNews = news;

        synchronized (this){
            notifyAll();
        }
    }

    String getTodayNews(){
        if(todayNews == null){
            synchronized (this){
                try {
                    wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        return todayNews;
    }
}

class NewsWriter extends Thread{
    private NewsPaper paper;

    NewsWriter(NewsPaper paper){
        this.paper = paper;
    }

    @Override
    public void run() {
        paper.setTodayNews("자바의 열기가 뜨겁습니다.");
    }
}

class NewsReader extends Thread{
    private NewsPaper paper;

    NewsReader(NewsPaper paper){
        this.paper = paper;
    }

    @Override
    public void run() {
        System.out.println("오늘의 뉴스: " + paper.getTodayNews());
    }
}

public class NewsPaperStory {
    public static void main(String[] args) {
        NewsPaper paper = new NewsPaper();
        NewsReader reader1 = new NewsReader(paper);
        NewsReader reader2 = new NewsReader(paper);
        NewsWriter writer = new NewsWriter(paper);

        try {
            /* writer 가 먼저 실행되어야만 reader 가 실행될 수 있음
            reader1.join();
            reader2.join();
            writer.join();
             */
            reader1.start();
            reader2.start();

            Thread.sleep(1000);
            writer.start();

            reader1.join();
            reader2.join();
            writer.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
