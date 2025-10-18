package ar.utn.ba.ddsi.grupo24.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
public class PaginacionHechos {
    private int current_page;
    private List<DtoOutputHecho> data;
    private String first_page_url;
    private int from;
    private int last_page;
    private String last_page_url;
    private String next_page_url;
    private String path;
    private int per_page;
    private String prev_page_url;
    private int to;
    private int total;
}
