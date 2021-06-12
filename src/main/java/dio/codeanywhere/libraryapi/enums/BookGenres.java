package dio.codeanywhere.libraryapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookGenres {

    CLASSIC("Classic"),
    COMEDY("Comedy"),
    MYSTERY("Mystery"),
    FANTASY("Fantasy"),
    SCI_FI("Science Fiction"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    ACADEMIC("Academic");

    private final String description;
}