package org.tmdb.api.genre;

/**
 * Created by flora on 6/15/2017.
 */
public enum Genre {
//,{"id":878,"name":""},{"id":10770,"name":""},{"id":53,"name":""},{"id":10752,"name":""},{"id":37,"name":""}]}
    ACTION(28, "Action", "Action", "액션"),
    ADVENTURE(12, "Adventure", "Aventure", "모험"),
    ANIMATION(16, "Animation", "Animation", "애니메이션"),
    COMEDY(35, "Comedy", "Comédie", "코미디"),
    CRIME(80, "Crime", "Crime", "범죄"),
    DOCUMENTARY(99, "Documentary", "Documentaire", "다큐멘터리"),
    DRAMA(18, "Drama", "Drame", "드라마"),
    FAMILY(10751, "Family", "Familial", "가족"),
    FANTASY(14, "Fantasy", "Fantastique", "판타지"),
    HISTORY(36, "History", "Histoire", "역사"),
    HORROR(27, "Horror", "Horreur", "공포"),
    MUSIC(10402, "Music", "Musique", "음악"),
    MYSTERY(9648, "Mystery", "Mystère", "미스터리"),
    ROMANCE(10749, "Romance", "Romance", "로맨스"),
    SCIENCE_FICTION(878, "Science Fiction", "Science-Fiction", "SF"),
    TV_MOVIE(10770, "TV Movie", "Téléfilm", "TV 영화"),
    THRILLER(53, "Thriller", "Thriller", "스릴러"),
    WAR(10752, "War", "Guerre", "전쟁"),
    WESTERN(37, "Western", "Western", "서부");

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
    public String getFrench() {
        return french;
    }
    public String getKorean() {
        return korean;
    }

    public int getId() {
        return id;
    }

}

