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
    
    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setMetascore(int metascore) {
        this.metascore = metascore;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getByID(int id) {
        switch(id) {
            case 0:
                return getTitle();
            case 1:
                return getGenre();
            case 2:
                return getDirector();
            case 3:
                return String.valueOf(getYear());
            case 4:
                return String.valueOf(getRuntime());
            case 5:
                return String.valueOf(getVote());
            case 6:
                return String.valueOf(getScore());
            case 7:
                return String.valueOf(getMetascore());
            case 8:
                return String.valueOf(getRevenue());
            default:
                return null;
        }
    }

    public void setByID(int id, Object value) {
        switch(id) {
            case 0:
                setTitle((String) value);
                break;
            case 1:
                setGenre((String) value);
                break;
            case 2:
                setDirector((String) value);
                break;
            case 3:
                setYear((int) value);
                break;
            case 4:
                setRuntime((int) value);
                break;
            case 5:
                setVote((int) value);
                break;
            case 6:
                setScore((double) value);
                break;
            case 7:
                setMetascore((int) value);
                break;
            case 8:
                setRevenue((double) value);
                break;
            default:
                break;
        }
    }
    
    
}
