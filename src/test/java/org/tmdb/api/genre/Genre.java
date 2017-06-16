package org.tmdb.api.genre;

/**
 * Created by flora on 6/15/2017.
 */
public enum Genre {

    ACTION(28, "Action", "", ""),
    ADVENTURE(12, "Adventure", "", ""),
    ANIMATION(16, "Animation", "", ""),
    COMEDY(35, "Comedy", "", ""),
    CRIME(80, "Crime", "", ""),
    DOCUMENTARY(99, "Documentary", "", ""),
    DRAMA(18, "Drama", "", ""),
    FAMILY(10751, "Family", "", ""),
    FANTASY(14, "Fantasy", "", ""),
    HISTORY(36, "History", "", ""),
    HORROR(27, "Horror", "", ""),
    MUSIC(10402, "Music", "", ""),
    MYSTERY(9648, "Mystery", "", ""),
    ROMANCE(10749, "Romance", "", ""),
    SCIENCE_FICTION(878, "Science Fiction", "", ""),
    TV_MOVIE(10770, "TV Movie", "", ""),
    THRILLER(53, "Thriller", "", ""),
    WAR(10752, "War", "", ""),
    WESTERN(37, "Western", "", "");

    String english;
    String french;
    String korean;
    int id;

    Genre(int idIn, String englishName, String frenchName, String koreanName) {
        english = englishName;
        french = frenchName;
        korean = koreanName;
        id = idIn;
    }

    public String getEnglish() {
        return english;
    }

    public int getId() {
        return id;
    }

//{"genres":[{"id":28,"name":"Action"},{"id":12,"name":"Aventure"},{"id":16,"name":"Animation"},{"id":35,"name":"Comédie"},{"id":80,"name":"Crime"},{"id":99,"name":"Documentaire"},{"id":18,"name":"Drame"},{"id":10751,"name":"Familial"},{"id":14,"name":"Fantastique"},{"id":36,"name":"Histoire"},{"id":27,"name":"Horreur"},{"id":10402,"name":"Musique"},{"id":9648,"name":"Mystère"},{"id":10749,"name":"Romance"},{"id":878,"name":"Science-Fiction"},{"id":10770,"name":"Téléfilm"},{"id":53,"name":"Thriller"},{"id":10752,"name":"Guerre"},{"id":37,"name":"Western"}]}

}

