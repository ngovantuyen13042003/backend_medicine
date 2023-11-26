package nvt.medicine_be.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pagination<T> {
    private Integer page;
    private Integer limit;
    private Integer totalPage;
    private Integer totalItem;
    private List<T> listResult = new ArrayList<>();
}
