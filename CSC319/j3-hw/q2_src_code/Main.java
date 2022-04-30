import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        albums.add(SampleData.aLoveSupreme);
        albums.add(SampleData.manyTrackAlbum);
        albums.add(SampleData.sampleShortAlbum);

        // Using Stream API
        Set<String> longTrackStream = findLongTracks(albums);
        printFromListString(longTrackStream);

        // Using
    }

    public static void printFromListString(Set<String> l) {
        for(String str : l) System.out.println(str);
    }

    public static Set<String> findLongTracks(List<Album> albums) {
        return albums.
                stream().
                flatMap(album -> album
                    .getTrackList()
                    .stream()
                    .filter(track -> track.getLength() > 60)
                    .map(Track::getName))
                .collect(Collectors.toSet());
    }

//    public static Set<String> findLongTracks(List<Album> albums) {
//        Set<String> trackNames = new HashSet<>();
//        for(Album album : albums) {
//            for (Track track : album.getTrackList()) {
//                if (track.getLength() > 60) {
//                    String name = track.getName();
//                    trackNames.add(name);
//                }
//            }
//        }
//        return trackNames;
//    }
}
