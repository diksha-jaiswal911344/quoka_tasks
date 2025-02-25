class Movie{
    static String language="English";
    int duration;
    String movieName;

    void setDuration(int newDuration){
        duration=newDuration;
    }
    void setNewName(String newName){
        movieName=newName;
    }
    int getDuration(){return duration; }
    String getNewName(){return movieName; }

}
public class staticKeyword {
    public static void main(String [] args){
        Movie m= new Movie();
        m.setDuration(5);
        m.setNewName("lifeOfpets");

        int n=m.getDuration();
        String l=m.getNewName();
        System.out.println(n+l+ m.language);
        System.out.println(Movie.language);
    }
}
