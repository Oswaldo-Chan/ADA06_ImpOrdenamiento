public class Movie {
    private String title;
    private String genre;
    private String director;
    private int year;
    private int runtime;
    private int vote;
    private double score;
    private int metascore;
    private double revenue;

    public Movie(String t, String g, String d, int y, int rt, int v, double s, int m, double r){
        this.title = t;
        this.genre = g;
        this.director = d;
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

    public String getDirector() {
        return director;
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

    public int getMetascore() {
        return metascore;
    }

    public double getRevenue() {
        return revenue;
    }
    
}
