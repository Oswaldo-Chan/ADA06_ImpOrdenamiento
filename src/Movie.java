public class Movie {
    private String title;
    private String genre;
    private int year;
    private int runtime;
    private int vote;
    private double score;
    private double metascore;
    private double revenue;

    public Movie(String t, String g, int y, int rt, int v, double s, double m, double r){
        this.title = t;
        this.genre = g;
        this.year = y;
        this.runtime = rt;
        this.vote = v;
        this.score = s;
        this.metascore = m;
        this.revenue = r;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }

    public int getVote() {
        return vote;
    }

    public double getScore() {
        return score;
    }

    public double getMetascore() {
        return metascore;
    }

    public double getRevenue() {
        return revenue;
    }
    
}
