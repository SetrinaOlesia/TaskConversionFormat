package olesia.setrina.converter.controller;

import olesia.setrina.converter.models.Summary;
import olesia.setrina.converter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterController {

    private final ConverterService converterService;

    @Autowired
    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> convertJsonToXml(@RequestBody Summary summary) {
        String responseBody;
        try {
            responseBody = converterService.convertToXml(summary);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Can not convert summary to Xml");
        }
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_XML).body(responseBody);
    }
}
