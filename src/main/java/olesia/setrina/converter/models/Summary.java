package olesia.setrina.converter.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement
public class Summary {
    private String name;
    private String surname;
    private Integer age;
    private List<String> knowledge;
    private List<String> positions;
    private List<Project> projects;
}
